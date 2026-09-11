package negocio;

import java.time.LocalDate;
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

	public int agregar(LocalDate fechaTransaccion, UnidadVenta unidad) throws Exception {
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
	
	public Pedido traerPedido(long idPedido) {
		return dao.traer(idPedido);
	}

	public List<Pedido> traerPedido() {
		return dao.traer();
	}
	
	public Pedido traerPedidoYItemPedidos(Pedido pedido) {
		return dao.traerPedidoYItems(pedido);
	}
	
	public ItemPedido agregarItemPedido(Pedido pedido, Plato plato, long cantidad) throws Exception {
		if (pedido == null) {
			throw new Exception("No se pueden agregar items a un pedido inexistente");
		}
		if (pedido.isCerrado()) {
			throw new Exception("No se pueden agregar items a un pedido cerrado");
		}
		ItemPedido itemPedido = pedido.traerItemPedidoPorPlato(plato);
		if (itemPedido == null) {
			itemPedido = new ItemPedido(plato, cantidad);
			pedido.agregarItemPedido(itemPedido);
		} else {
			itemPedido.setCantidad(itemPedido.getCantidad() + cantidad);
		}
		dao.actualizar(pedido);
		return itemPedido;
	}
	
	public void cerrarPedido(Pedido pedido) throws Exception {
		if (pedido != null) {
			pedido.setCerrado(true);
			dao.actualizar(pedido);
		}
	}

	public double calcularRecaudacionTotalEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta) {
		return dao.calcularRecaudacionTotalEntreFechas(fechaDesde, fechaHasta);
	}
	
}