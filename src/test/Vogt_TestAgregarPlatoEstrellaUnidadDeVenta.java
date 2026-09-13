package test;

import java.time.LocalDateTime;

import datos.FoodTruck;
import datos.Plato;
import datos.Pedido;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;

public class Vogt_TestAgregarPlatoEstrellaUnidadDeVenta {

	public static void main(String[] args) {
		System.out.println("=== Vogt_TestAgregarPlatoEstrellaUnidadDeVenta ===");

		UnidadVentaABM unidadABM = UnidadVentaABM.getInstancia();
		PedidoABM pedidoABM = PedidoABM.getInstancia();
		ItemPedidoABM itemPedidoABM = ItemPedidoABM.getInstancia();
		PlatoABM platoABM = PlatoABM.getInstancia();

		try {
			FoodTruck unidad = (FoodTruck) unidadABM.traerUnidadVenta(2L);
			Plato platoEsperado = platoABM.traerPlato(7L);
			Plato otroPlato = platoABM.traerPlato(12L);
			Pedido pedido = pedidoABM.traerPedido(pedidoABM.agregar(LocalDateTime.now(), unidad));

			itemPedidoABM.agregar(pedido, platoEsperado, 100);
			itemPedidoABM.agregar(pedido, otroPlato, 1);

			Plato platoEstrella = unidadABM.platoEstrellaDeUnidadVenta(unidad);
			if (platoEstrella == null || platoEstrella.getIdPlato() != platoEsperado.getIdPlato()) {
				throw new AssertionError("El plato estrella no es el plato mas vendido");
			}

			System.out.println("Plato estrella: " + platoEstrella.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("No se pudo probar platoEstrellaDeUnidadVenta", e);
		}
	}
}