package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.Plato;
import datos.UnidadVenta;

public class UnidadVentaDao {
	private static Session session;
	private Transaction tx;
	
	private static UnidadVentaDao instancia = null;
	
	protected UnidadVentaDao() {}

	public static UnidadVentaDao getInstance() {
		if (instancia == null)
			instancia = new UnidadVentaDao();
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
	
	public int agregar(UnidadVenta objeto) {
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
	
	public void actualizar(UnidadVenta objeto) {
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

	public void eliminar(UnidadVenta objeto) {
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
	
	public UnidadVenta traer(long idUnidadVenta) {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			objeto = (UnidadVenta) session.createQuery("from UnidadVenta c where c.idUnidadVenta=:idUnidadVenta")
						.setParameter("idUnidadVenta", idUnidadVenta).uniqueResult();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objeto;
	}
	
	public List<UnidadVenta> traer() throws HibernateException {
		List<UnidadVenta> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from UnidadVenta", UnidadVenta.class).list();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return lista;
	}
	
	public UnidadVenta traerUnidadYPlatos(long idUnidadVenta) {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			String hql = "from UnidadVenta u where u.idUnidadVenta =:idUnidadVenta";
			objeto = (UnidadVenta) session.createQuery(hql).setParameter("idUnidadVenta", idUnidadVenta)
					.uniqueResult();
			Hibernate.initialize(objeto.getPlatos());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objeto;
	}

	public Plato platoEstrellaDeUnidadVenta(long idUnidadVenta) {
		Plato plato = null;
		try {
			iniciaOperacion();
			plato = session.createQuery(
					"select i.plato from ItemPedido i "
					+ "join i.pedido p "
					+ "where p.unidad.idUnidadVenta = :idUnidadVenta "
					+ "group by i.plato "
					+ "order by sum(i.cantidad) desc, i.plato.idPlato asc",
					Plato.class)
					.setParameter("idUnidadVenta", idUnidadVenta)
					.setMaxResults(1)
					.uniqueResult();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return plato;
	}

	public boolean existePlatoEnUnidadVenta(long idPlato, long idUnidadVenta) {
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        Long count = (Long) session.createQuery("select count(p) from Plato p where p.unidad.idUnidadVenta = :idUnidadVenta and p.idPlato = :idPlato")
			.setParameter("idUnidadVenta", idUnidadVenta)
			.setParameter("idPlato", idPlato)
			.uniqueResult();

        return count != null && count > 0;
    } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}

	public boolean existePlatoEnUnidadVenta(String nombre, long idUnidadVenta) {
		boolean resultado = false;
		try {
			iniciaOperacion();
			Long count = (Long) session.createQuery("select count(p) from Plato p where p.unidad.idUnidadVenta = :idUnidadVenta and p.nombre = :nombre")
				.setParameter("idUnidadVenta", idUnidadVenta)
				.setParameter("nombre", nombre)
				.uniqueResult();

			resultado = (count != null && count > 0);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return resultado;
	}

	public boolean existePlatoSinUnidadVenta(long idPlato) {
		boolean resultado = false;
		try {
			iniciaOperacion();
			Long count = (Long) session.createQuery("select count(p) from Plato p where p.unidad is null and p.idPlato = :idPlato")
				.setParameter("idPlato", idPlato)
				.uniqueResult();

			resultado = (count != null && count > 0);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return resultado;
	}
	
	public boolean agregarPlato(long idPlato, long idUnidadVenta) {
		boolean resultado = false;
		try {
			iniciaOperacion();
			Plato plato = (Plato) session.get(Plato.class, idPlato);
			UnidadVenta unidadVenta = (UnidadVenta) session.get(UnidadVenta.class, idUnidadVenta);
			unidadVenta.agregar(plato);
			plato.setUnidad(unidadVenta);
			session.update(plato);
			tx.commit();
			resultado = true;
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return resultado;
	}
	
	public List<UnidadVenta> traerUnidadVentaConResponsable() throws HibernateException{
		List<UnidadVenta> lst = null;
		try {
			iniciaOperacion();
			String hql = "from UnidadVenta u inner join fetch u.responsable";
			lst = session.createQuery(hql, UnidadVenta.class).getResultList();
		}finally {
			session.close();
		}
		return lst;
	}
	
	public boolean agregarStaffAUnidadVenta(UnidadVenta unidadVenta, Empleado empleado) {
		boolean agregado = false;
		try {
			iniciaOperacion();
			agregado = unidadVenta.agregar(empleado);
			if(agregado == true) {
				session.update(unidadVenta);
				tx.commit();
			}
			
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return agregado;
	}
	
}
