package datos;

public class PuestoDesarmable extends UnidadVenta {
	private long cantidadDeCarpas;
	private long tiempoMontaje;

	public PuestoDesarmable() {}

	public PuestoDesarmable(String nombreComercial, String codigo, double superficie, Empleado responsable,
			Festival festival, long cantidadDeCarpas, long tiempoMontaje) {
		super(nombreComercial, codigo, superficie, responsable, festival);
		this.cantidadDeCarpas = cantidadDeCarpas;
		this.tiempoMontaje = tiempoMontaje;
	}

	public long getCantidadDeCarpas() {
		return cantidadDeCarpas;
	}

	public void setCantidadDeCarpas(long cantidadDeCarpas) {
		this.cantidadDeCarpas = cantidadDeCarpas;
	}

	public long getTiempoMontaje() {
		return tiempoMontaje;
	}

	public void setTiempoMontaje(long tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}

	@Override
	public String toString() {
		return "PuestoDesarmable [" + super.toString() + ", antidadDeCarpas=" + cantidadDeCarpas + ", tiempoMontaje=" + tiempoMontaje + "]";
	}

}
