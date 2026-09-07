package datos;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Pedido {
	private long idPedido;
	private LocalDate fechaTransaccion;
	private UnidadVenta unidad;
	private Set<ItemPedido> items;
	private boolean cerrado;

	public Pedido() {}

	public Pedido(LocalDate fechaTransaccion, UnidadVenta unidad) {
		super();
		this.fechaTransaccion = fechaTransaccion;
		this.unidad = unidad;
		this.cerrado = false;
	}

	public long getIdPedido() {
		return idPedido;
	}

	protected void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public UnidadVenta getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadVenta unidad) {
		this.unidad = unidad;
	}

	public Set<ItemPedido> getItems() {
		return items;
	}

	public void setItems(Set<ItemPedido> items) {
		this.items = items;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaTransaccion=" + fechaTransaccion + ", cerrado=" + cerrado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaTransaccion, unidad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Pedido)) {
			return false;
		}
		Pedido other = (Pedido) obj;
		return Objects.equals(fechaTransaccion, other.fechaTransaccion)
				&& Objects.equals(unidad, other.unidad);
	}

}
