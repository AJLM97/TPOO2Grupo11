package test;

import datos.UnidadVenta;
import datos.Plato;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class Ledesma_TraerPlatoMasRentableDeUnidadVenta {
	public static void main(String[] args) {
		System.out.println("=== TEST DE LEDESMA MIÑO, ALEJANDRO JAVIER ===");
		System.out.println("=== TRAER PLATO MAS RENTABLE DE UNIDAD DE VENTA ===");
		try {
			
			UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
            PlatoABM pABM = PlatoABM.getInstancia();

			UnidadVenta unidadA = uABM.traer(2L);
            Plato platoA = uABM.traerPlatoMasRentable(unidadA);
            long cantidad = pABM.traerCantidadDeVecesVendido(platoA);
            double costos = platoA.getCostoProduccion() * cantidad;
            double ingresos = platoA.getPrecioVenta() * cantidad;
            double rentabilidad = ingresos - costos;

	        System.out.println("=== Plato que más rentabilidad tuvo ===");
	        System.out.println("De la Unidad: " + unidadA.getNombreComercial());
	        System.out.println("Plato: " + platoA.getNombre());
			System.out.println("ID Plato: " + platoA.getIdPlato());
	        System.out.println("U/Vendiadas: " + cantidad);
	        System.out.println("Ingresos: " + ingresos);
	        System.out.println("Costos: " + costos);
            System.out.println("Rentabilidad: " + rentabilidad);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

}