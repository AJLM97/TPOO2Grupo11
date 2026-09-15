package test;

import java.time.LocalDateTime;

import datos.Plato;
import datos.Festival;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;

public class Vogt_TraerPlatoEstrellaDeFestivalEntreFechas {

	public static void main(String[] args) {
		try {
			UnidadVentaABM unidadABM = UnidadVentaABM.getInstancia();
			Festival festival = FestivalABM.getInstancia().traer(1L);
			UnidadVenta unidadVenta = unidadABM.traer(2L);
			Plato plato = unidadABM.traerPlatoEstrella(festival, unidadVenta,
					LocalDateTime.of(2026, 12, 15, 0, 0),
					LocalDateTime.of(2026, 12, 21, 23, 59));
			System.out.println("Plato estrella del festival entre fechas: " + plato.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
