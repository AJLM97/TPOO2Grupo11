package test;

import java.util.List;

import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestTraerListaUnidadVentaConResponsable {

	public static void main(String[] args) {
		System.out.println("=== TestTraerListaUnidadVentaConResponsable ===");
				
		try {
			UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
			List<UnidadVenta> lst = uABM.traerUnidadVentaConResponsable();
			
			for(UnidadVenta u : lst) {
				System.out.println(u.getNombreComercial() + " - Responsable: " + u.getResponsable().getNombre() + " " + u.getResponsable().getApellido());
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

}
