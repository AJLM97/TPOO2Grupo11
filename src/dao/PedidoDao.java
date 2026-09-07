package dao;

import java.time.LocalDate;
import java.util.List;

import java.util.HashSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemPedido;
import datos.Pedido;

public class PedidoDao {
	private static Session session;
	private Transaction tx;
	
	private static PedidoDao instancia = null;
	
	protected PedidoDao() {}

	public static PedidoDao getInstance() {
		if (instancia == null)
			instancia = new PedidoDao();
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(Pedido objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Pedido objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Pedido objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public Pedido traer(Pedido pedido) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (Pedido) session.createQuery("from Pedido c where c.idPedido=:idPedido")
						.setParameter("idPedido", pedido.getIdPedido()).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Pedido> traer() throws HibernateException {
		List<Pedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Pedido", Pedido.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public Pedido traerPedidoYItems(Pedido pedido) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (Pedido) session.createQuery(
					"select distinct p from Pedido p " +
					"left join fetch p.items i " +
					"left join fetch i.plato pl " +
					"where p.idPedido=:idPedido",
					Pedido.class)
				.setParameter("idPedido", pedido.getIdPedido())
				.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public void agregarItemPedido(Pedido pedido, ItemPedido itemPedido) {
		try {
			iniciaOperacion();
			Pedido pedidoPersistido = (Pedido) session.get(Pedido.class, pedido.getIdPedido());
			if (pedidoPersistido == null) {
				throw new IllegalArgumentException("No existe el pedido con id: " + pedido.getIdPedido());
			}
			itemPedido.setPedido(pedidoPersistido);
			if (pedidoPersistido.getItems() == null) {
				pedidoPersistido.setItems(new HashSet<>());
			}
			pedidoPersistido.getItems().add(itemPedido);
			session.save(itemPedido);
			session.update(pedidoPersistido);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public double calcularRecaudacionTotalEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta) {
		try {
			iniciaOperacion();
			Number resultado = (Number) session.createQuery(
					"select sum(i.cantidad * i.plato.precioVenta) "
					+ "from Pedido p join p.items i "
					+ "where p.fechaTransaccion between :fechaDesde and :fechaHasta")
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta)
					.uniqueResult();
			return resultado != null ? resultado.doubleValue() : 0.0;
		} finally {
			session.close();
		}
	}

}
