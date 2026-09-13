package test;

import datos.Pedido;
import datos.Plato;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;

public class TestAgregarItemPedido {

	public static void main(String[] args) {
		System.out.println("=== TestAgregarItemPedido ===");

		PedidoABM peABM = PedidoABM.getInstancia();
		ItemPedidoABM ipeABM = ItemPedidoABM.getInstancia();
		PlatoABM pABM = PlatoABM.getInstancia();

		try {
			long idPedidoA = 1L;
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
			long idPedidoB = 2L;
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
