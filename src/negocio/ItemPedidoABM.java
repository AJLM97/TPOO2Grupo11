package negocio;

import java.util.List;

import dao.ItemPedidoDao;
import datos.ItemPedido;
import datos.Pedido;
import datos.Plato;

public class ItemPedidoABM {

	private static ItemPedidoABM abm = null;
	private ItemPedidoDao dao = ItemPedidoDao.getInstance();

	private ItemPedidoABM() {}

	public static ItemPedidoABM getInstancia() {
		if(abm == null) {
			abm = new ItemPedidoABM();
		}
		return abm;
	}

	public int agregar(Plato plato, long cantidad) throws Exception {
		ItemPedido aux = new ItemPedido(plato, cantidad);
		return dao.agregar(aux);
	}

	public ItemPedido agregar(Pedido pedido, Plato plato, long cantidad) throws Exception {
		return PedidoABM.getInstancia().agregarItemPedido(pedido, plato, cantidad);
	}
	
	public int agregar(ItemPedido itemPedido) throws Exception {
		return dao.agregar(itemPedido);
	}

	public void modificar(ItemPedido itemPedido) throws Exception {
		dao.actualizar(itemPedido);
	}

	public void eliminar(ItemPedido itemPedido) throws Exception {
		ItemPedido aux = dao.traer(itemPedido);
		dao.eliminar(aux);
	}
	
	public ItemPedido traerItemPedido(ItemPedido itemPedido) {
		ItemPedido aux = dao.traer(itemPedido);
		return aux;
	}

	public List<ItemPedido> traerItemPedido() {
		return dao.traer();
	}
	
}