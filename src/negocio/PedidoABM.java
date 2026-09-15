package negocio;

import java.time.LocalDateTime;
import java.util.List;

import dao.PedidoDao;
import datos.ItemPedido;
import datos.Pedido;
import datos.Plato;
import datos.UnidadVenta;

public class PedidoABM {

	private static PedidoABM abm = null;
	private PedidoDao dao = PedidoDao.getInstance();

	private PedidoABM() {}

	public static PedidoABM getInstancia() {
		if(abm == null) {
			abm = new PedidoABM();
		}
		return abm;
	}

	public int agregar(LocalDateTime fechaTransaccion, UnidadVenta unidad) throws Exception {
		if(dao.existePedidoEnUnidadVenta(fechaTransaccion, unidad)) {
			throw new Exception("Ya existe un Pedido con fecha " + fechaTransaccion + " en la unidad de venta " + unidad.getNombreComercial());
		}
		Pedido aux = new Pedido(fechaTransaccion, unidad);
		return dao.agregar(aux);
	}

	public void modificar(Pedido pedido) throws Exception {
		dao.actualizar(pedido);
	}

	public void eliminar(Pedido pedido) throws Exception {
		Pedido aux = dao.traer(pedido.getIdPedido());
		dao.eliminar(aux);
	}
	
	public Pedido traer(long idPedido) {
		return dao.traer(idPedido);
	}

	public List<Pedido> traerPedido() {
		return dao.traer();
	}
	
	public Pedido traerPedidoYItemPedidos(long idPedido) {
		return dao.traerPedidoYItems(idPedido);
	}
	
	public ItemPedido agregarItemPedido(Pedido pedido, Plato plato, long cantidad) throws Exception {
		if (pedido == null) {
			throw new Exception("No se pueden agregar items a un pedido inexistente");
		}
		if (pedido.isCerrado()) {
			throw new Exception("No se pueden agregar items a un pedido cerrado");
		}
		Pedido pedidoPersistido = dao.traerPedidoYItems(pedido);
		ItemPedido itemPedido = pedidoPersistido.traerItemPedidoPorPlato(plato);
		if (itemPedido == null) {
			itemPedido = new ItemPedido(plato, cantidad);
			pedidoPersistido.agregarItemPedido(itemPedido);
		} else {
			itemPedido.setCantidad(itemPedido.getCantidad() + cantidad);
			dao.actualizar(pedidoPersistido);
		}
		dao.actualizar(pedidoPersistido);
		return itemPedido;
	}
	
	public void cerrarPedido(Pedido pedido) throws Exception {
		if (pedido != null) {
			pedido.setCerrado(true);
			dao.actualizar(pedido);
		}
	}

	public double calcularRecaudacionTotalEntreFechas(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
		return dao.calcularRecaudacionTotalEntreFechas(fechaDesde, fechaHasta);
	}
	
}