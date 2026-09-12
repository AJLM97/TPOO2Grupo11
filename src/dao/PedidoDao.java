package dao;

import java.time.LocalDate;
import java.util.List;

import java.util.HashSet;

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
	
	protected void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(Exception e) throws Exception {
		tx.rollback();
		throw new Exception("ERROR en la capa de acceso a datos", e);
	}
	
	public int agregar(Pedido objeto) throws Exception {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (Exception e) {
			manejaExcepcion(e);
		} finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Pedido objeto) throws Exception {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (Exception e) {
			manejaExcepcion(e);
		} finally {
			session.close();
		}
	}

	public void eliminar(Pedido objeto) throws Exception {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (Exception e) {
			manejaExcepcion(e);
		} finally {
			session.close();
		}
	}
	
	public Pedido traer(long idPedido) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (Pedido) session.createQuery("from Pedido p join fetch p.unidad where p.idPedido=:idPedido")
						.setParameter("idPedido", idPedido).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Pedido> traer() {
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
	
	public void agregarItemPedido(Pedido pedido, ItemPedido itemPedido) throws Exception {
		try {
			iniciaOperacion();
			Pedido pedidoPersistido = (Pedido) session.get(Pedido.class, pedido.getIdPedido());
			if (pedidoPersistido == null) {
				throw new Exception("No existe el pedido con id: " + pedido.getIdPedido());
			}
			itemPedido.setPedido(pedidoPersistido);
			if (pedidoPersistido.getItems() == null) {
				pedidoPersistido.setItems(new HashSet<>());
			}
			if (!pedidoPersistido.getItems().add(itemPedido)) {
				throw new Exception("El item del plato ya existe en el pedido");
			}
			session.save(itemPedido);
			session.update(pedidoPersistido);
			tx.commit();
		} catch (Exception e) {
			manejaExcepcion(e);
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
