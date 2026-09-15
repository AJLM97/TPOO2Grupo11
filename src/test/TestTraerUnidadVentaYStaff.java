package test;

import datos.Empleado;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestTraerUnidadVentaYStaff {

	public static void main(String[] args) {
		System.out.println("=== TestTraerUnidadVentaYStaff ===");
		
		try {
			UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
			
			UnidadVenta unidad = uABM.traerUnidadVentaYStaff(1L);
	        System.out.println("Unidad Venta: " + unidad.getNombreComercial());
	
	        for(Empleado e : unidad.getStaff()) {
				System.out.println(e);
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}

}
