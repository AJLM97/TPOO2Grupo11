package test;

import datos.Plato;
import negocio.PlatoABM;

public class TestTraerPlato {

	public static void main(String[] args) {
		System.out.println("=== TestTraerPlato ===");
				
			try {
				PlatoABM pABM = PlatoABM.getInstancia();
				
				Plato plato = pABM.traer(1L);
				
				System.out.println("Plato ID " + plato.getIdPlato());
				System.out.println(plato);
			} catch (Exception e) {
			    e.printStackTrace();
			}
	
		}
}
