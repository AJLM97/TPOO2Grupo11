package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PedidoDao;
import datos.ItemPedido;
import datos.Pedido;
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

	public int agregar(LocalDate fechaTransaccion, UnidadVenta unidad) {
		Pedido aux = new Pedido(fechaTransaccion, unidad);
		return dao.agregar(aux);
	}

	public void modificar(Pedido pedido) {
		dao.actualizar(pedido);
	}

	public void eliminar(Pedido pedido) {
		Pedido aux = dao.traer(pedido);
		dao.eliminar(aux);
	}
	
	public Pedido traerPedido(Pedido pedido) {
		Pedido aux = dao.traer(pedido);
		return aux;
	}

	public List<Pedido> traerPedido() {
		return dao.traer();
	}
	
	public Pedido traerPedidoYItemPedidos(Pedido pedido) {
		return dao.traerPedidoYItems(pedido);
	}
	
	public void agregarItemPedido(Pedido pedido, ItemPedido itemPedido) {
		Pedido pedidoPersistido = dao.traer(pedido);
		if (pedidoPersistido != null && pedidoPersistido.isCerrado()) {
			throw new IllegalStateException("No se pueden agregar items a un pedido cerrado");
		}
		dao.agregarItemPedido(pedido, itemPedido);
	}
	
	public void cerrarPedido(Pedido pedido) {
		Pedido pedidoPersistido = dao.traer(pedido);
		if (pedidoPersistido != null) {
			pedidoPersistido.setCerrado(true);
			dao.actualizar(pedidoPersistido);
		}
	}

	public double calcularRecaudacionTotalEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta) {
		return dao.calcularRecaudacionTotalEntreFechas(fechaDesde, fechaHasta);
	}
	
}