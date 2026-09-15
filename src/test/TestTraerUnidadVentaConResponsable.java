package test;

import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestTraerUnidadVentaConResponsable {

	public static void main(String[] args) {
		System.out.println("=== TestTraerUnidadVentaConResponsable ===");
				
		try {
			UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
			UnidadVenta unidad = uABM.traerUnidadVentaConResponsable(1L);
			
			System.out.println(unidad.getNombreComercial() + " - Responsable: " + unidad.getResponsable().getNombre() + " " + unidad.getResponsable().getApellido());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

}
