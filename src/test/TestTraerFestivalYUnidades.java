package test;

import datos.Festival;
import datos.UnidadVenta;
import negocio.FestivalABM;

public class TestTraerFestivalYUnidades {

	public static void main(String[] args) {
		System.out.println("=== TestTraerFestivalYUnidades ===");
		
		try {
			FestivalABM fABM = FestivalABM.getInstancia();
			
			Festival festival = fABM.traerFestivalYUnidades(1L);
	        System.out.println(festival);
	
	        for(UnidadVenta uv : festival.getUnidades()) {
				System.out.println(uv);
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}

}