package datos;

import java.time.LocalDate;

public class Cocinero extends Empleado {
	private long categoria;
	private String especialidad;
	private long porcentaje;

	public Cocinero() {}

	public Cocinero(String nombre, String apellido, long dni, LocalDate fechNacimiento, LocalDate fechaIngreso,
			double sueldoBase, UnidadVenta unidad, long categoria, String especialidad, long porcentaje) {
		super(nombre, apellido, dni, fechNacimiento, fechaIngreso, sueldoBase, unidad);
		this.categoria = categoria;
		this.especialidad = especialidad;
		this.porcentaje = porcentaje;
	}

	public long getCategoria() {
		return categoria;
	}

	public void setCategoria(long categoria) {
		this.categoria = categoria;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public long getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(long porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return "Cocinero [" + super.toString() + ", categoria=" + categoria + ", especialidad=" + especialidad + ", porcentaje=" + porcentaje
				+ "]";
	}

}
