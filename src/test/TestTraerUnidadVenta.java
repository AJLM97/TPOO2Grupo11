package test;

import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestTraerUnidadVenta {

	public static void main(String[] args) {
		System.out.println("=== TestTraerUnidadVenta ===");
		
		try {
			UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
			
			UnidadVenta unidad = uABM.traer(1L);
			
			System.out.println("Unidad Venta ID " + unidad.getIdUnidadVenta());
			System.out.println(unidad);
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}

}
