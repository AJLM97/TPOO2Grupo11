package test;

import datos.Plato;
import negocio.UnidadVentaABM;

public class Vogt_TraerPlatoEstrellaUnidadDeVenta {

	public static void main(String[] args) {
		System.out.println("=== Vogt_TraerPlatoEstrellaUnidadDeVenta ===");

		UnidadVentaABM unidadABM = UnidadVentaABM.getInstancia();

		try {
			Plato platoEstrella = unidadABM.platoEstrellaDeUnidadVenta(2L);
			if (platoEstrella == null) {
				throw new Exception("La unidad de venta no tiene un plato estrella");
			}

			System.out.println("Plato estrella: " + platoEstrella.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}