package datos;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public abstract class UnidadVenta {
	protected long idUnidadVenta;
	protected String nombreComercial;
	protected String codigo;
	protected double superficie;
	protected Empleado responsable;
	protected Festival festival;
	protected Set<Empleado> staff;
	protected Set<Plato> platos;
	
	public UnidadVenta() {}

	public UnidadVenta(String nombreComercial, String codigo, double superficie, Empleado responsable) {
		super();
		this.nombreComercial = nombreComercial;
		this.codigo = codigo;
		this.superficie = superficie;
		this.responsable = responsable;
	}

	public long getIdUnidadVenta() {
		return idUnidadVenta;
	}

	protected void setIdUnidadVenta(long idUnidadVenta) {
		this.idUnidadVenta = idUnidadVenta;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public Empleado getResponsable() {
		return responsable;
	}

	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Set<Empleado> getStaff() {
		return staff;
	}

	public void setStaff(Set<Empleado> staff) {
		this.staff = staff;
	}

	public Set<Plato> getPlatos() {
		return platos;
	}

	protected void setPlatos(Set<Plato> platos) {
		this.platos = platos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idUnidadVenta);
	}

	
	public boolean equals(UnidadVenta u) {
		boolean igual = false;
		if(u != null && this.codigo.equals(u.getCodigo())) {
			igual = true;
		}
		return igual;
	}
	
	public boolean agregar(Plato plato) {
		boolean agregar = false;
		if(!(platos.contains(plato))) {
			agregar = platos.add(plato);
		}
		return agregar;
	}
	
	public boolean eliminar(Plato plato) {
		Plato borrar = null;
		boolean eliminar = false;
		Iterator<Plato> it = platos.iterator();
		while((it.hasNext()) && (borrar==null)) {
			Plato aux = it.next();
			if(aux.equals(plato)) borrar = aux;
		}
		eliminar = platos.remove(borrar);
		return eliminar;
	}

	@Override
	public String toString() {
		return "idUnidadVenta=" + idUnidadVenta + ", nombreComercial=" + nombreComercial + ", codigo="
				+ codigo + ", superficie=" + superficie + ", responsable=" + responsable.getNombre()  + " " + responsable.getApellido();
	}

}
