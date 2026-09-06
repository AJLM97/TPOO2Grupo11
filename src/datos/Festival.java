package datos;

import java.time.LocalDate;
import java.util.Set;

public class Festival {
	private long idFestival;
	private String nombre;
	private String temporada;
	private LocalDate fechInicio;
	private LocalDate fechaFin;
	private Set<UnidadVenta> unidades;
	private double costoSuperficie;
	private double costoMontaje;
	private double plusElectricidad;

	public Festival() {}

	public Festival(String nombre, String temporada, LocalDate fechInicio, LocalDate fechaFin,
			double costoSuperficie, double costoMontaje, double plusElectricidad) {
		super();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechInicio = fechInicio;
		this.fechaFin = fechaFin;
		this.costoSuperficie = costoSuperficie;
		this.costoMontaje = costoMontaje;
		this.plusElectricidad = plusElectricidad;
	}

	public long getIdFestival() {
		return idFestival;
	}

	protected void setIdFestival(long idFestival) {
		this.idFestival = idFestival;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechInicio() {
		return fechInicio;
	}

	public void setFechInicio(LocalDate fechInicio) {
		this.fechInicio = fechInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Set<UnidadVenta> getUnidades() {
		return unidades;
	}

	public void setUnidades(Set<UnidadVenta> unidades) {
		this.unidades = unidades;
	}

	public double getCostoSuperficie() {
		return costoSuperficie;
	}

	public void setCostoSuperficie(double costoSuperficie) {
		this.costoSuperficie = costoSuperficie;
	}

	public double getCostoMontaje() {
		return costoMontaje;
	}

	public void setCostoMontaje(double costoMontaje) {
		this.costoMontaje = costoMontaje;
	}

	public double getPlusElectricidad() {
		return plusElectricidad;
	}

	public void setPlusElectricidad(double plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFestival);
	}

	@Override
	public boolean equals(Object obj) {
		//Ver si apunta a la misma referencia
		if (this == obj) return true;
		//Verificar si es de otra clase o si es null
		if (obj == null || getClass() != obj.getClass()) return false;
		//Convertir el Object a Festival
		Festival other = (Festival) obj;

		return this.idFestival == other.getIdFestival();
	}

	@Override
	public String toString() {
		return "Festival [idFestival=" + idFestival + ", nombre=" + nombre + ", temporada=" + temporada
				+ ", fechInicio=" + fechInicio + ", fechaFin=" + fechaFin + ", costoSuperficie=" + costoSuperficie
				+ ", costoMontaje=" + costoMontaje + ", plusElectricidad=" + plusElectricidad + "]";
	}

}
