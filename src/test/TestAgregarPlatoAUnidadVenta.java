package test;

import datos.FoodTruck;
import datos.Plato;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestAgregarPlatoAUnidadVenta {
	
	public static void main(String[] args) {
		System.out.println("=== TestAgregarPlatoAUnidadVenta ===");

		UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
		PlatoABM pABM = PlatoABM.getInstancia();

		FoodTruck foodTruckA = (FoodTruck) uABM.traerUnidadVenta(2L); // Pizzas Ledesma
		FoodTruck foodTruckB = (FoodTruck) uABM.traerUnidadVenta(3L); // Sushi Express

		Plato platoA = pABM.traerPlato(7L); // Pizza fugazzeta
		Plato platoB = pABM.traerPlato(12L); // Pizza margarita
		Plato platoC = pABM.traerPlato(14L); // Pizza napolitana
		Plato platoD = pABM.traerPlato(15L); // Nigiri
		Plato platoE = pABM.traerPlato(16L); // Tempura
		
		try {
			uABM.agregarPlatoAUnidadVenta(foodTruckA, platoA);
			uABM.agregarPlatoAUnidadVenta(foodTruckA, platoB);
			uABM.agregarPlatoAUnidadVenta(foodTruckA, platoC);

		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			uABM.agregarPlatoAUnidadVenta(foodTruckB, platoD);
			uABM.agregarPlatoAUnidadVenta(foodTruckB, platoE);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
