package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FestivalDao;
import datos.Festival;
import datos.UnidadVenta;

public class FestivalABM {

	private static FestivalABM abm = null;
	private FestivalDao dao = FestivalDao.getInstance();

	private FestivalABM() {}

	public static FestivalABM getInstancia() {
		if(abm == null) {
			abm = new FestivalABM();
		}
		return abm;
	}

	public int agregar(String nombre, String temporada, LocalDate fechInicio, LocalDate fechaFin,
			double costoSuperficie, double costoMontaje, double plusElectricidad) throws Exception {
		if(!temporada.equalsIgnoreCase("primavera") && !temporada.equalsIgnoreCase("otoño") && !temporada.equalsIgnoreCase("verano") && !temporada.equalsIgnoreCase("invierno")) {
			throw new Exception("El valor de temporada no es válido. Debe ser primavera, verano, otoño o invierno");
		}
		Festival aux = new Festival(nombre, temporada, fechInicio, fechaFin,
				costoSuperficie, costoMontaje, plusElectricidad);
		return dao.agregar(aux);
	}

	public void modificar(Festival festival) {
		dao.actualizar(festival);
	}

	public void eliminar(long idFestival) {
		Festival aux = dao.traer(idFestival);
		dao.eliminar(aux);
	}
	
	public Festival traerFestival(long idFestival) {
		Festival aux = dao.traer(idFestival);
		return aux;
	}

	public Festival traerFestivalYUnidades(long idFestival) {
		Festival aux = dao.traerFestivalYUnidades(idFestival);
		return aux;
	}

	public List<Festival> traerFestival() {
		return dao.traer();
	}

	public void agregarUnidadVenta(Festival festival, UnidadVenta unidad) throws Exception {
		if(festival.existeUnidadVenta(unidad)) {
			throw new Exception("La unidad de venta ya existe en el festival");
		}
		festival.agregarUnidadVenta(unidad);
		dao.actualizar(festival);
	}
	
}