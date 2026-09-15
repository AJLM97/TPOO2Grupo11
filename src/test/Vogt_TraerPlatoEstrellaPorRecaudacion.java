package test;

import java.time.LocalDateTime;

import datos.Plato;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class Vogt_TraerPlatoEstrellaPorRecaudacion {

	public static void main(String[] args) {
		try {
			UnidadVentaABM unidadABM = UnidadVentaABM.getInstancia();
			UnidadVenta unidadVenta = unidadABM.traer(2L);
			Plato plato = unidadABM.traerPlatoEstrellaPorRecaudacion(unidadVenta,
					LocalDateTime.of(2026, 1, 1, 0, 0),
					LocalDateTime.of(2026, 12, 31, 23, 59, 59));
			System.out.println("Plato estrella por recaudacion: " + plato.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
