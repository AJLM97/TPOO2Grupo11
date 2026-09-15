package test;

import datos.Plato;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class Vogt_TraerPlatoEstrellaUnidadDeVenta {

	public static void main(String[] args) {
		System.out.println("=== Vogt_TraerPlatoEstrellaUnidadDeVenta ===");

		UnidadVentaABM unidadABM = UnidadVentaABM.getInstancia();

		try {
			UnidadVenta unidadVenta = unidadABM.traer(2L);
			Plato platoEstrella = unidadABM.platoEstrellaDeUnidadVenta(unidadVenta);
			System.out.println("Plato estrella: " + platoEstrella.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}