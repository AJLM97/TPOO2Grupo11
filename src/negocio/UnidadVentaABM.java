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

	public void existePlatoEnUnidadVenta(long idPlato, long idUnidadVenta) {
		dao.existePlatoEnUnidadVenta(idPlato, idUnidadVenta);
	}
	
	public void agregarPlatoAUnidadVenta(long idPlato, long idUnidadVenta) {
		try {
			if(dao.existePlatoEnUnidadVenta(idPlato, idUnidadVenta)) {
				throw new IllegalArgumentException("El plato ya existe en la unidad de venta");
			}
			if(!dao.existePlatoSinUnidadVenta(idPlato)) {
				throw new IllegalArgumentException("El plato ya está asignado a otra unidad de venta");
			}
			dao.agregarPlato(idPlato, idUnidadVenta);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	public List<UnidadVenta> traerUnidadVentaConResponsable() {
		UnidadVentaDao dao = UnidadVentaDao.getInstance();
		return dao.traerUnidadVentaConResponsable();
	}
	
}