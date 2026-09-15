package datos;

import java.time.LocalDate;

public abstract class Empleado {
	protected long idEmpleado;
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected LocalDate fechNacimiento;
	protected LocalDate fechaIngreso;
	protected double sueldoBase;
	protected UnidadVenta unidad;
	
	public Empleado() {}

	public Empleado(String nombre, String apellido, long dni, LocalDate fechNacimiento,
			LocalDate fechaIngreso, double sueldoBase, UnidadVenta unidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechNacimiento = fechNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.sueldoBase = sueldoBase;
		this.unidad = unidad;
	}

	public long getIdEmpleado() {
		return idEmpleado;
	}

	protected void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public LocalDate getFechNacimiento() {
		return fechNacimiento;
	}

	public void setFechNacimiento(LocalDate fechNacimiento) {
		this.fechNacimiento = fechNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public UnidadVenta getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadVenta unidad) {
		this.unidad = unidad;
	}

	@Override
	public String toString() {
		return "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechNacimiento=" + fechNacimiento + ", fechaIngreso=" + fechaIngreso + ", sueldoBase=" + sueldoBase;
	}
	
}
