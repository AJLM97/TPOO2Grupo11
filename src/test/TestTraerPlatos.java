package test;

import java.util.List;

import datos.Plato;
import negocio.PlatoABM;

public class TestTraerPlatos {

	public static void main(String[] args) {
		System.out.println("=== TestTraerPlato ===");
				
		try {
			PlatoABM pABM = PlatoABM.getInstancia();
			
			List<Plato> lista = pABM.traerPlato();
			
			for(Plato p : lista) {
				System.out.println(p);
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
}
