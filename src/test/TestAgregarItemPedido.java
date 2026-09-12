package test;

import java.time.LocalDate;

import datos.FoodTruck;
import datos.Pedido;
import datos.Plato;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class TestAgregarItemPedido {

	public static void main(String[] args) {
		System.out.println("=== TestAgregarItemPedido ===");

		PedidoABM peABM = PedidoABM.getInstancia();
		ItemPedidoABM ipeABM = ItemPedidoABM.getInstancia();
		PlatoABM pABM = PlatoABM.getInstancia();
		UnidadVentaABM uABM = UnidadVentaABM.getInstancia();

		try {
			FoodTruck foodTruckA = (FoodTruck) uABM.traerUnidadVenta(2L);
			long idPedidoA = peABM.agregar(LocalDate.now(), foodTruckA);
			Pedido pedidoA = peABM.traerPedido(idPedidoA);
			Plato platoA = pABM.traerPlato(7L); // Pizza fugazzeta
			Plato platoB = pABM.traerPlato(12L); // Pizza margarita
			Plato platoC = pABM.traerPlato(14L); // Pizza napolitana

			ipeABM.agregar(pedidoA, platoA, 2);
			ipeABM.agregar(pedidoA, platoB, 3);
			ipeABM.agregar(pedidoA, platoC, 1);
			ipeABM.agregar(pedidoA, platoA, 5);

			System.out.println("Se agregaron 3 items al pedido con id: " + pedidoA.getIdPedido());
			peABM.cerrarPedido(pedidoA);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			FoodTruck foodTruckB = (FoodTruck) uABM.traerUnidadVenta(3L);
			long idPedidoB = peABM.agregar(LocalDate.now(), foodTruckB);
			Pedido pedidoB = peABM.traerPedido(idPedidoB);
			Plato platoA = pABM.traerPlato(15L); // Nigiri
			Plato platoB = pABM.traerPlato(16L); // Tempura

			ipeABM.agregar(pedidoB, platoA, 2);
			ipeABM.agregar(pedidoB, platoB, 3);

			System.out.println("Se agregaron 2 items al pedido con id: " + pedidoB.getIdPedido());
			peABM.cerrarPedido(pedidoB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
