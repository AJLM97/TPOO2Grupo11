package dao;

import java.util.List;
import java.time.LocalDateTime;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
import datos.Festival;
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
	
	public int agregar(UnidadVenta objeto) throws HibernateException {
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
	
	public void actualizar(UnidadVenta objeto) throws HibernateException {
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

	public void eliminar(UnidadVenta objeto) throws HibernateException {
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

	public boolean existeUnidadVentaEnFestival(String codigo, Festival festival) throws HibernateException {
		boolean resultado = false;
		try {
			iniciaOperacion();
			Long count = (Long) session.createQuery("select count(u) from UnidadVenta u where u.festival.idFestival = :idFestival and u.codigo = :codigo")
					.setParameter("idFestival", festival.getIdFestival())
					.setParameter("codigo", codigo)
					.uniqueResult();
			resultado = (count != null && count > 0);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return resultado;
	}

	public boolean esEmpleadoDeUnidadVenta(UnidadVenta unidadVenta, Empleado empleado) throws HibernateException {
		boolean resultado = false;
		try {
			iniciaOperacion();
			Long count = (Long) session.createQuery("select count(e) from Empleado e where e.unidad.idUnidadVenta = :idUnidadVenta and e.idEmpleado = :idEmpleado")
					.setParameter("idUnidadVenta", unidadVenta.getIdUnidadVenta())
					.setParameter("idEmpleado", empleado.getIdEmpleado())
					.uniqueResult();
			resultado = (count != null && count > 0);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return resultado;
	}
	
	public UnidadVenta traerUnidadVentaYStaff(long idUnidadVenta) {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			String hql = "from UnidadVenta u where u.idUnidadVenta =:idUnidadVenta";
			objeto = (UnidadVenta) session.createQuery(hql).setParameter("idUnidadVenta", idUnidadVenta)
					.uniqueResult();
			Hibernate.initialize(objeto.getStaff());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objeto;
	}
	
	public UnidadVenta traerUnidadVentaYPlatos(long idUnidadVenta) {
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

	public Plato platoEstrellaDeUnidadVenta(long idUnidadVenta) throws Exception {
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

	public Plato traerPlatoEstrella(long idUnidadVenta, LocalDateTime fechaDesde, LocalDateTime fechaHasta) throws Exception {
		return traerPlatoEstrella("p.unidad.idUnidadVenta = :idUnidadVenta "
				+ "and p.fechaTransaccion between :fechaDesde and :fechaHasta",
				query -> query.setParameter("idUnidadVenta", idUnidadVenta)
						.setParameter("fechaDesde", fechaDesde)
						.setParameter("fechaHasta", fechaHasta));
	}

	private Plato traerPlatoEstrella(String filtro, java.util.function.UnaryOperator<org.hibernate.query.Query<Plato>> parametros) throws Exception {
		try {
			iniciaOperacion();
			org.hibernate.query.Query<Plato> query = session.createQuery(
					"select i.plato from ItemPedido i join i.pedido p where " + filtro
					+ " group by i.plato order by sum(i.cantidad) desc, i.plato.idPlato asc",
					Plato.class);
			return parametros.apply(query).setMaxResults(1).uniqueResult();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Plato traerPlatoEstrellaPorRecaudacion(long idUnidadVenta,
			LocalDateTime fechaDesde, LocalDateTime fechaHasta) throws Exception {
		return traerPlatoEstrellaPorImporte(idUnidadVenta, fechaDesde, fechaHasta,
				"sum(i.cantidad * i.plato.precioVenta)");
	}

	private Plato traerPlatoEstrellaPorImporte(long idUnidadVenta, LocalDateTime fechaDesde,
			LocalDateTime fechaHasta, String expresion) throws Exception {
		try {
			iniciaOperacion();
			return session.createQuery(
					"select i.plato from ItemPedido i join i.pedido p "
					+ "where p.unidad.idUnidadVenta = :idUnidadVenta "
					+ "and p.fechaTransaccion between :fechaDesde and :fechaHasta "
					+ "group by i.plato order by " + expresion + " desc, i.plato.idPlato asc",
					Plato.class)
					.setParameter("idUnidadVenta", idUnidadVenta)
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta)
					.setMaxResults(1).uniqueResult();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public UnidadVenta traerUnidadVentaConResponsable(long idUnidadVenta) throws HibernateException{
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			String hql = "from UnidadVenta u inner join fetch u.responsable where u.idUnidadVenta =:idUnidadVenta";
					objeto = (UnidadVenta) session.createQuery(hql).setParameter("idUnidadVenta", idUnidadVenta)
							.setMaxResults(1).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
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
	
	public Empleado traerEmpleadoMasAntiguoPorUnidadVenta(UnidadVenta unidadVenta)throws HibernateException {
		Empleado empleado = null;
		try {
			iniciaOperacion();
			String hql = "select e from UnidadVenta u " +
			"join u.staff e " +
			"where u.idUnidadVenta = :id " +
			"order by e.fechaIngreso asc";
			empleado = (Empleado) session.createQuery(hql).setParameter("id", unidadVenta.getIdUnidadVenta()).setMaxResults(1).uniqueResult();
		} catch(HibernateException he){
			
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return empleado;
	}

	public double calcularRecaudacion(UnidadVenta unidadVenta) throws HibernateException {
		try {
			iniciaOperacion();
			Number resultado = (Number) session.createQuery(
					"select sum(i.cantidad * i.plato.precioVenta) from Pedido p "
					+ "join p.items i "
					+ "where p.unidad.idUnidadVenta = :idUnidadVenta and p.cerrado = true")
					.setParameter("idUnidadVenta", unidadVenta.getIdUnidadVenta())
					.setMaxResults(1).uniqueResult();
			return resultado != null ? resultado.doubleValue() : 0.0;
		} finally {
			session.close();
		}
	}

	public Plato traerPlatoMasRentable(UnidadVenta unidadVenta) throws HibernateException {
		try {
			iniciaOperacion();
			Plato plato = (Plato) session.createQuery(
					"select i.plato from ItemPedido i "
					+ "join i.pedido p "
					+ "where p.unidad.idUnidadVenta = :idUnidadVenta and p.cerrado = true "
					+ "group by i.plato "
					+ "order by sum(i.cantidad * (i.plato.precioVenta - i.plato.costoProduccion)) desc, i.plato.idPlato asc")
					.setParameter("idUnidadVenta", unidadVenta.getIdUnidadVenta())
					.setMaxResults(1).uniqueResult();
			return plato;
		} finally {
			session.close();
		}
	}
	
}
