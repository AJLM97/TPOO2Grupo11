package test;

import java.util.Set;

import datos.ItemPedido;
import datos.Pedido;
import negocio.PedidoABM;

public class TestTraerPedidoYItemPedido {

	public static void main(String[] args) {
		System.out.println("=== TestTraerPedidoYItemPedido ===");

		PedidoABM peABM = PedidoABM.getInstancia();

		try {
			Pedido pedidoBase = peABM.traerPedido().get(0);
			Pedido pedido = peABM.traerPedidoYItemPedidos(pedidoBase);
			System.out.println("Pedido ID " + pedido.getIdPedido());
			System.out.println(pedido);

			Set<ItemPedido> items = pedido.getItems();
			if (items != null && !items.isEmpty()) {
				System.out.println("Cantidad de items: " + items.size());
				for (ItemPedido item : items) {
					System.out.println("  " + item);
				}
			} else {
				System.out.println("El pedido no tiene items");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
