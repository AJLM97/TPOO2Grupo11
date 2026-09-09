package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemPedido;

public class ItemPedidoDao {
	private static Session session;
	private Transaction tx;
	
	private static ItemPedidoDao instancia = null;
	
	protected ItemPedidoDao() {}

	public static ItemPedidoDao getInstance() {
		if (instancia == null)
			instancia = new ItemPedidoDao();
		return instancia;
	}
	
	protected void iniciaOperacion() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(Exception e) throws Exception {
		tx.rollback();
		throw new Exception("ERROR en la capa de acceso a datos", e);
	}
	
	public int agregar(ItemPedido objeto) throws Exception {
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
	
	public void actualizar(ItemPedido objeto) throws Exception {
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

	public void eliminar(ItemPedido objeto) throws Exception {
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
	
	public ItemPedido traer(ItemPedido itemPedido) {
		ItemPedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (ItemPedido) session.createQuery("from ItemPedido c where c.idItemPedido=:idItemPedido")
						.setParameter("idItemPedido", itemPedido.getIdItemPedido()).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<ItemPedido> traer() {
		List<ItemPedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from ItemPedido", ItemPedido.class).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
}
