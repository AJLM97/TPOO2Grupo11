package datos;

import java.time.LocalDate;

public class Cajero extends Empleado {
	private String turnoTrabajo;
	private double plusAntiguedad;

	public Cajero() {}

	public Cajero(String nombre, String apellido, long dni, LocalDate fechNacimiento, LocalDate fechaIngreso,
			double sueldoBase, UnidadVenta unidad, String turnoTrabajo, double plusAntiguedad) {
		super(nombre, apellido, dni, fechNacimiento, fechaIngreso, sueldoBase, unidad);
		this.turnoTrabajo = turnoTrabajo;
		this.plusAntiguedad = plusAntiguedad;
	}

	public String getTurnoTrabajo() {
		return turnoTrabajo;
	}

	public void setTurnoTrabajo(String turnoTrabajo) {
		this.turnoTrabajo = turnoTrabajo;
	}

	public double getPlusAntiguedad() {
		return plusAntiguedad;
	}

	public void setPlusAntiguedad(double plusAntiguedad) {
		this.plusAntiguedad = plusAntiguedad;
	}

	@Override
	public String toString() {
		return "Cajero [" + super.toString() + ", turnoTrabajo=" + turnoTrabajo + ", plusAntiguedad=" + plusAntiguedad + "]";
	}
	
}
