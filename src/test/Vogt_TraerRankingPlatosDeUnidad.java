package test;

import java.time.LocalDateTime;
import java.util.List;

import datos.Plato;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class Vogt_TraerRankingPlatosDeUnidad {

	public static void main(String[] args) {
		try {
			UnidadVentaABM unidadABM = UnidadVentaABM.getInstancia();
			UnidadVenta unidadVenta = unidadABM.traer(2L);
			List<Plato> platos = unidadABM.traerRankingPlatos(unidadVenta,
					LocalDateTime.of(2026, 12, 15, 0, 0),
					LocalDateTime.of(2026, 12, 21, 23, 59));
			if (platos == null || platos.isEmpty()) {
				throw new Exception("No se encontraron platos para el ranking");
			}
			for (Plato plato : platos) {
				System.out.println("Plato del ranking: " + plato.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
