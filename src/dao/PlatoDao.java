package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Plato;

public class PlatoDao {
	private static Session session;
	private Transaction tx;
	
	private static PlatoDao instancia = null;
	
	protected PlatoDao() {}

	public static PlatoDao getInstance() {
		if (instancia == null)
			instancia = new PlatoDao();
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		if (tx != null && tx.isActive()) {
			tx.rollback();
		}
		throw new HibernateException("ERROR en la capa de acceso a datos" + he.getMessage());
	}
	
	public int agregar(Plato objeto) throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return id;
	}
	
	public void actualizar(Plato objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void eliminar(Plato objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public Plato traer(long idPlato) {
		Plato objeto = null;
		try {
			iniciaOperacion();
			objeto = (Plato) session.createQuery("from Plato c where c.idPlato=:idPlato")
						.setParameter("idPlato", idPlato).uniqueResult();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objeto;
	}
	
	public List<Plato> traer() throws HibernateException {
		List<Plato> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Plato", Plato.class).list();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return lista;
	}

	public boolean existePlatoSinUnaUnidadAsignada(String nombre) throws HibernateException {
		boolean resultado = false;
		try {
			iniciaOperacion();
			Long count = (Long) session.createQuery("select count(p) from Plato p where p.unidad.idUnidadVenta is null and p.nombre = :nombre")
					.setParameter("nombre", nombre).uniqueResult();
			resultado = (count != null && count > 0);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return resultado;
	}
	
}
