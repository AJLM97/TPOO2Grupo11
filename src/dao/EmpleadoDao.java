package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.UnidadVenta;

public class EmpleadoDao {
	private static Session session;
	private Transaction tx;
	
	private static EmpleadoDao instancia = null;
	
	protected EmpleadoDao() {}

	public static EmpleadoDao getInstance() {
		if (instancia == null)
			instancia = new EmpleadoDao();
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
	
	public int agregar(Empleado objeto) {
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
	
	public void actualizar(Empleado objeto) {
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

	public void eliminar(Empleado objeto) {
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
	
	public Empleado traer(long idEmpleado) {
		Empleado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Empleado) session.createQuery("from Empleado c where c.idEmpleado=:idEmpleado")
						.setParameter("idEmpleado", idEmpleado).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Empleado> traer() throws HibernateException {
		List<Empleado> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Empleado", Empleado.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public boolean existeEmpleadoEnUnidadVenta(long dni, UnidadVenta unidad) throws HibernateException {
		boolean resultado = false;
		try {
			iniciaOperacion();
			Long count = (Long) session.createQuery("select count(e) from Empleado e where e.unidad.idUnidadVenta = :idUnidadVenta and e.dni = :dni")
					.setParameter("idUnidadVenta", unidad.getIdUnidadVenta())
					.setParameter("dni", dni)
					.uniqueResult();
			resultado = (count != null && count > 0);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return resultado;
	}
	
}
