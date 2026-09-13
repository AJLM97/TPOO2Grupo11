package negocio;

import java.util.List;

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
	
	public UnidadVenta traerUnidadVenta(long idUnidadVenta) {
		UnidadVenta aux = dao.traer(idUnidadVenta);
		return aux;
	}

	public Plato platoEstrellaDeUnidadVenta(long idUnidadVenta) {
		return dao.platoEstrellaDeUnidadVenta(idUnidadVenta);
	}

	public Plato platoEstrellaDeUnidadVenta(UnidadVenta unidadVenta) {
		if (unidadVenta == null) {
			throw new IllegalArgumentException("La unidad de venta no puede ser null");
		}
		return platoEstrellaDeUnidadVenta(unidadVenta.getIdUnidadVenta());
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
}