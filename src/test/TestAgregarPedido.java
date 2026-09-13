package test;

import java.time.LocalDateTime;

import datos.FoodTruck;
import negocio.PedidoABM;
import negocio.UnidadVentaABM;

public class TestAgregarPedido {

	public static void main(String[] args) {
		System.out.println("=== TestAgregarPedido ===");

		UnidadVentaABM uABM = UnidadVentaABM.getInstancia();
		PedidoABM peABM = PedidoABM.getInstancia();

		long idFoodTruckA = 2L; // Pizzas Ledesma
		long idFoodTruckB = 3L; // Sushi Express

		try {
			FoodTruck foodTruck = (FoodTruck) uABM.traerUnidadVenta(idFoodTruckA);
			long idPedido = peABM.agregar(LocalDateTime.of(2026, 9, 5, 10, 30), foodTruck);
			System.out.printf("Id Pedido: %d%n", idPedido);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
        	FoodTruck foodTruck = (FoodTruck) uABM.traerUnidadVenta(idFoodTruckB);
            long idPedido = peABM.agregar(LocalDateTime.of(2026, 9, 5, 13, 45), foodTruck);
            System.out.printf("Id Pedido: %d", idPedido);
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
}
