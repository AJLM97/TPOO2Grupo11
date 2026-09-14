package test;

import java.time.LocalDateTime;

import datos.Plato;
import negocio.UnidadVentaABM;

public class Vogt_TraerPlatoEstrellaUnidadEntreFechas {

	public static void main(String[] args) {
		UnidadVentaABM unidadABM = UnidadVentaABM.getInstancia();
		Plato plato = unidadABM.traerPlatoEstrella(2L,
				LocalDateTime.of(2026, 1, 1, 0, 0),
				LocalDateTime.of(2026, 12, 31, 23, 59, 59));
		verificarResultado(plato, "plato estrella entre fechas");
	}

	private static void verificarResultado(Plato plato, String descripcion) {
		if (plato == null) {
			throw new AssertionError("No se encontro " + descripcion);
		}
		System.out.println("Plato estrella entre fechas: " + plato.getNombre());
	}
}
