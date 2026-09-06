package datos;

public class Plato {
	private long idPlato;
	private String nombre;
	private double precioVenta;
	private double costoProduccion;
	private UnidadVenta unidad;

	public Plato() {}

	public Plato(String nombre, double precioVenta, double costoProduccion) {
		super();
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.costoProduccion = costoProduccion;
	}

	public Plato(String nombre, double precioVenta, double costoProduccion, UnidadVenta unidad) {
		super();
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.costoProduccion = costoProduccion;
		this.unidad = unidad;
	}

	public long getIdPlato() {
		return idPlato;
	}

	protected void setIdPlato(long idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(double costoProduccion) {
		this.costoProduccion = costoProduccion;
	}
	
	public UnidadVenta getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadVenta unidad) {
		this.unidad = unidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPlato);
	}

	@Override
	public boolean equals(Object obj) {
		//Ver si apunta a la misma referencia
		if (this == obj) return true;
		//Verificar si es de otra clase o si es null
		if (obj == null || getClass() != obj.getClass()) return false;
		//Convertir el Object a Plato
		Plato other = (Plato) obj;

		return this.idPlato == other.getIdPlato();
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precioVenta=" + precioVenta
				+ ", costoProduccion=" + costoProduccion + "]";
	}

}
