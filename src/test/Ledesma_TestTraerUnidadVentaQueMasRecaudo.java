package test;

import datos.Festival;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;

public class Ledesma_TestTraerUnidadVentaQueMasRecaudo {
	public static void main(String[] args) {
		System.out.println("=== TEST DE LEDESMA MIÑO, ALEJANDRO JAVIER ===");
		System.out.println("=== TRAER UNIDAD DE VENTA QUE MAS RECAUDO ===");
		try {
			
			FestivalABM fABM = FestivalABM.getInstancia();
			UnidadVentaABM uABM = UnidadVentaABM.getInstancia();

			Festival festivalA = fABM.traerFestival(1L);
			UnidadVenta unidadA = fABM.traerUnidadVentaQueMasRecaudo(festivalA);
			double recaudacion = uABM.calcularRecaudacion(unidadA);
	
	        System.out.println("=== Unidad que más recaudó ===");
	        System.out.println("Del Festival: " + festivalA.getNombre());
	        System.out.println("Unidad: " + unidadA.getNombreComercial());
			System.out.println("ID Unidad: " + unidadA.getIdUnidadVenta());
	        System.out.println("Recaudación: " + recaudacion);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

}
