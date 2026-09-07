package datos;

import java.util.Objects;

public class ItemPedido {
	private long idItemPedido;
	private Plato plato;
	private Pedido pedido;
	private long cantidad;

	public ItemPedido() {}

	public ItemPedido(Plato plato, long cantidad) {
		super();
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public long getIdItemPedido() {
		return idItemPedido;
	}

	protected void setIdItemPedido(long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	
	public Pedido getPedido() {
	    return pedido;
	}

	public void setPedido(Pedido pedido) {
	    this.pedido = pedido;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemPedido [idItemPedido=" + idItemPedido + ", cantidad=" + cantidad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(plato, pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemPedido)) {
			return false;
		}
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(plato, other.plato) && Objects.equals(pedido, other.pedido);
	}

}
