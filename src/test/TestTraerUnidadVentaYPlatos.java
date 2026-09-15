package test;

import datos.Plato;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestTraerUnidadVentaYPlatos {
	
	public static void main(String[] args) {
		System.out.println("=== TestTraerUnidadVentaYPlatos ===");
		
		try {
			UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
			
			UnidadVenta unidad = uABM.traerUnidadVentaYPlatos(1L);
	        System.out.println("Unidad Venta: " + unidad.getNombreComercial());
	
	        for(Plato p : unidad.getPlatos()) {
				System.out.println(p);
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}

}
