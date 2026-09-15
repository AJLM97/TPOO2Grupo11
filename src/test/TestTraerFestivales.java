package test;

import java.util.List;

import datos.Festival;
import negocio.FestivalABM;

public class TestTraerFestivales {

	public static void main(String[] args) {
		System.out.println("=== TestTraerFestivales ===");
		
		try {
			FestivalABM fABM = FestivalABM.getInstancia();
			
			List<Festival> lista = fABM.traerFestival();
			
			for(Festival f : lista) {
				System.out.println(f);
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
}
