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

	public int agregarFoodTruck(String nombreComercial, String codigo, double superficie, Empleado responsable, Festival festival,
			String patente, boolean conexionElectrica) {
		FoodTruck aux = new FoodTruck(nombreComercial, codigo, superficie, responsable, festival,
				patente, conexionElectrica);
		return dao.agregar(aux);
	}
	
	public int agregarPuestoDesarmable(String nombreComercial, String codigo, double superficie, Empleado responsable,
			Festival festival, long cantidadDeCarpas, long tiempoMontaje) {
		PuestoDesarmable aux = new PuestoDesarmable(nombreComercial, codigo, superficie, responsable,
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

	public Plato platoEstrellaDeUnidadVenta(UnidadVenta unidadVenta) throws Exception {
		if (unidadVenta == null) {
			throw new IllegalArgumentException("La unidad de venta no puede ser null");
		}
		Plato plato = dao.platoEstrellaDeUnidadVenta(unidadVenta.getIdUnidadVenta());
		if (plato == null) {
			throw new Exception("La unidad de venta no tiene un plato estrella");
		}
		return plato;
	}

	public Plato traerPlatoEstrella(UnidadVenta unidadVenta, LocalDateTime fechaDesde, LocalDateTime fechaHasta) throws Exception {
		if (unidadVenta == null) {
			throw new IllegalArgumentException("La unidad de venta no puede ser null");
		}
		Plato plato = dao.traerPlatoEstrella(unidadVenta.getIdUnidadVenta(), fechaDesde, fechaHasta);
		if (plato == null) {
			throw new Exception("No se encontro el plato estrella entre fechas");
		}
		return plato;
	}

	public Plato traerPlatoEstrellaDeFestival(Festival festival, UnidadVenta unidadVenta, LocalDateTime fechaDesde) throws Exception {
		if (festival == null || unidadVenta == null) {
			throw new IllegalArgumentException("El festival y la unidad de venta no pueden ser null");
		}
		Plato plato = dao.traerPlatoEstrellaDeFestival(festival.getIdFestival(), unidadVenta.getIdUnidadVenta(), fechaDesde);
		if (plato == null) {
			throw new Exception("No se encontro el plato estrella del festival");
		}
		return plato;
	}

	public Plato traerPlatoEstrellaConCantidadMinima(UnidadVenta unidadVenta, long cantidadMinima, LocalDateTime fechaDesde) throws Exception {
		if (unidadVenta == null) {
			throw new IllegalArgumentException("La unidad de venta no puede ser null");
		}
		Plato plato = dao.traerPlatoEstrellaConCantidadMinima(unidadVenta.getIdUnidadVenta(), cantidadMinima, fechaDesde);
		if (plato == null) {
			throw new Exception("No se encontro un plato con la cantidad minima");
		}
		return plato;
	}

	public Plato traerPlatoEstrella(Festival festival, UnidadVenta unidadVenta,
			LocalDateTime fechaDesde, LocalDateTime fechaHasta) throws Exception {
		if (festival == null || unidadVenta == null) {
			throw new IllegalArgumentException("El festival y la unidad de venta no pueden ser null");
		}
		Plato plato = dao.traerPlatoEstrella(festival.getIdFestival(), unidadVenta.getIdUnidadVenta(), fechaDesde, fechaHasta);
		if (plato == null) {
			throw new Exception("No se encontro el plato estrella del festival entre fechas");
		}
		return plato;
	}

	public List<Plato> traerRankingPlatos(UnidadVenta unidadVenta, LocalDateTime fechaDesde,
			LocalDateTime fechaHasta) throws Exception {
		if (unidadVenta == null) {
			throw new IllegalArgumentException("La unidad de venta no puede ser null");
		}
		return dao.traerRankingPlatos(unidadVenta.getIdUnidadVenta(), fechaDesde, fechaHasta);
	}

	public Plato traerPlatoEstrellaPorRecaudacion(UnidadVenta unidadVenta,
			LocalDateTime fechaDesde, LocalDateTime fechaHasta) throws Exception {
		if (unidadVenta == null) {
			throw new IllegalArgumentException("La unidad de venta no puede ser null");
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

	public boolean existePlatoEnUnidadVenta(UnidadVenta unidad, Plato plato) {
		return unidad.getPlatos().contains(plato);
	}
	
	public void agregarPlatoAUnidadVenta(UnidadVenta unidad, Plato plato) throws Exception {
		if(existePlatoEnUnidadVenta(unidad, plato)) {
			throw new Exception("El plato ya existe en la unidad de venta");
		}
		unidad.agregar(plato);
		plato.setUnidad(unidad);
		dao.actualizar(unidad);
	}
	
	public List<UnidadVenta> traerUnidadVentaConResponsable() {
		UnidadVentaDao dao = UnidadVentaDao.getInstance();
		return dao.traerUnidadVentaConResponsable();
	}
	
	public boolean agregarStaff(UnidadVenta unidadVenta, Empleado empleado) {
		return dao.agregarStaffAUnidadVenta(unidadVenta, empleado);
	}
	
	public Empleado traerEmpleadoMasAntiguo(UnidadVenta unidadventa) {
		return dao.traerEmpleadoMasAntiguoPorUnidadVenta(unidadventa);
	}

	public double calcularRecaudacion(UnidadVenta unidadVenta) {
		return dao.calcularRecaudacion(unidadVenta);
	}

	public Plato traerPlatoMasRentable(UnidadVenta unidadVenta) {
		return dao.traerPlatoMasRentable(unidadVenta);
	}
	
}