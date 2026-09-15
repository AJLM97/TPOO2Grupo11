package test;

import java.time.LocalDateTime;

import datos.Plato;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class Vogt_TraerPlatoEstrellaConCantidadMinima {

	public static void main(String[] args) {
		try {
			UnidadVentaABM unidadABM = UnidadVentaABM.getInstancia();
			UnidadVenta unidadVenta = unidadABM.traer(2L);
			Plato plato = unidadABM.traerPlatoEstrellaConCantidadMinima(unidadVenta, 1L,
					LocalDateTime.of(2026, 12, 15, 0, 0));
			System.out.println("Plato estrella con cantidad minima: " + plato.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
