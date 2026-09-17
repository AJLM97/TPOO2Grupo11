package negocio;

import java.util.List;
import java.time.LocalDateTime;

import dao.UnidadVentaDao;
import datos.Empleado;
import datos.Festival;
import datos.FoodTruck;
import datos.Plato;
import datos.PuestoDesarmable;
import datos.UnidadVenta;

public class UnidadVentaABM {

	private static UnidadVentaABM abm = null;
	private UnidadVentaDao dao = UnidadVentaDao.getInstance();

	private UnidadVentaABM() {}

	public static UnidadVentaABM getInstancia() {
		if(abm == null) {
			abm = new UnidadVentaABM();
		}
		return abm;
	}

	public int agregarFoodTruck(String nombreComercial, String codigo, double superficie, Festival festival,
			String patente, boolean conexionElectrica) throws Exception {
		if(dao.existeUnidadVentaEnFestival(codigo, festival)) {
			throw new Exception("Ya existe una Unidad de Venta con el código " + codigo + " en el festival " + festival.getNombre());
		}
		FoodTruck aux = new FoodTruck(nombreComercial, codigo, superficie, festival, patente, conexionElectrica);
		return dao.agregar(aux);
	}
	
	public int agregarPuestoDesarmable(String nombreComercial, String codigo, double superficie,
			Festival festival, long cantidadDeCarpas, long tiempoMontaje) throws Exception {
		if(dao.existeUnidadVentaEnFestival(codigo, festival)) {
			throw new Exception("Ya existe una Unidad de Venta con el código " + codigo + " en el festival " + festival.getNombre());
		}
		PuestoDesarmable aux = new PuestoDesarmable(nombreComercial, codigo, superficie,
				festival, cantidadDeCarpas, tiempoMontaje);
		return dao.agregar(aux);
	}

	public void modificar(UnidadVenta unidadVenta) {
		dao.actualizar(unidadVenta);
	}

	public void eliminar(long idUnidadVenta) {
		UnidadVenta aux = dao.traer(idUnidadVenta);
		dao.eliminar(aux);
	}
	
	public UnidadVenta traer(long idUnidadVenta) {
		UnidadVenta aux = dao.traer(idUnidadVenta);
		return aux;
	}
	
	public UnidadVenta traerUnidadVentaYStaff(long idUnidadVenta) {
		UnidadVenta aux = dao.traerUnidadVentaYStaff(idUnidadVenta);
		return aux;
	}
	
	public UnidadVenta traerUnidadVentaYPlatos(long idUnidadVenta) {
		UnidadVenta aux = dao.traerUnidadVentaYPlatos(idUnidadVenta);
		return aux;
	}

	public void asignarResponsable(UnidadVenta unidadVenta, Empleado responsable) throws Exception {
		if (!dao.esEmpleadoDeUnidadVenta(unidadVenta, responsable)) {
			throw new Exception("El responsable no pertenece a la unidad de venta");
		}
		unidadVenta.setResponsable(responsable);
		dao.actualizar(unidadVenta);
	}

	public Plato traerPlatoEstrella(UnidadVenta unidadVenta) throws Exception {
		if (unidadVenta == null) {
			throw new IllegalArgumentException("La unidad de venta no puede ser null");
		}
		Plato plato = dao.traerPlatoEstrella(unidadVenta.getIdUnidadVenta());
		if (plato == null) {
			throw new Exception("La unidad de venta no tiene un plato estrella");
		}
		return plato;
	}

	public Plato traerPlatoEstrella(UnidadVenta unidadVenta, LocalDateTime fechaDesde, LocalDateTime fechaHasta) throws Exception {
		if (unidadVenta == null) {
			throw new Exception("La unidad de venta no puede ser null");
		}
		Plato plato = dao.traerPlatoEstrella(unidadVenta.getIdUnidadVenta(), fechaDesde, fechaHasta);
		if (plato == null) {
			throw new Exception("No se encontro el plato estrella entre fechas");
		}
		return plato;
	}

	public Plato traerPlatoEstrellaPorRecaudacion(UnidadVenta unidadVenta,
			LocalDateTime fechaDesde, LocalDateTime fechaHasta) throws Exception {
		if (unidadVenta == null) {
			throw new Exception("La unidad de venta no puede ser null");
		}
		Plato plato = dao.traerPlatoEstrellaPorRecaudacion(unidadVenta.getIdUnidadVenta(), fechaDesde, fechaHasta);
		if (plato == null) {
			throw new Exception("No se encontro el plato estrella por recaudacion");
		}
		return plato;
	}

	public List<UnidadVenta> traerUnidadVenta() {
		return dao.traer();
	}
	
	public UnidadVenta traerUnidadVentaConResponsable(long idUnidadVenta) {
		return dao.traerUnidadVentaConResponsable(idUnidadVenta);
	}
	
	public List<UnidadVenta> traerUnidadVentaConResponsable() {
		return dao.traerUnidadVentaConResponsable();
	}
	
	public Empleado traerEmpleadoMasAntiguo(UnidadVenta unidadVenta) {
		return dao.traerEmpleadoMasAntiguoPorUnidadVenta(unidadVenta);
	}

	public double calcularRecaudacion(UnidadVenta unidadVenta) {
		return dao.calcularRecaudacion(unidadVenta);
	}

	public Plato traerPlatoMasRentable(UnidadVenta unidadVenta) {
		return dao.traerPlatoMasRentable(unidadVenta);
	}
	
}