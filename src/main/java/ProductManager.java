import java.util.ArrayList;

public interface ProductManager {

    public ArrayList<Producto> listarProductosOrdenados(ArrayList<Producto> lista);
    public void realizarPedido(Pedido pedido);
    public void servirPedido();
    public ArrayList<Pedido> listadoPedidosCliente(Cliente cliente);
    public ArrayList<Producto> listarProductosVendas(ArrayList<Producto> lista);

}
