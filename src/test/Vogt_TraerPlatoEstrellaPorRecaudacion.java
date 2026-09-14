package test;

import java.time.LocalDateTime;

import datos.Plato;
import negocio.UnidadVentaABM;

public class Vogt_TraerPlatoEstrellaPorRecaudacion {

	public static void main(String[] args) {
		try {
			UnidadVentaABM unidadABM = UnidadVentaABM.getInstancia();
			Plato plato = unidadABM.traerPlatoEstrellaPorRecaudacion(2L,
					LocalDateTime.of(2026, 1, 1, 0, 0),
					LocalDateTime.of(2026, 12, 31, 23, 59, 59));
			if (plato == null) {
				throw new Exception("No se encontro el plato estrella por recaudacion");
			}
			if (!"Pizza de calabresa".equals(plato.getNombre())) {
				throw new Exception("Se esperaba Pizza de calabresa, pero se obtuvo: "
						+ plato.getNombre());
			}
			System.out.println("Plato estrella por recaudacion: " + plato.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
