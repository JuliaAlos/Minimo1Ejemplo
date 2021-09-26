import java.util.ArrayList;

public interface ProductManager {

    public ArrayList<Producto> listarProductosOrdenados();
    public void realizarPedido(Pedido pedido);
    public void servirPedido();
    public ArrayList<String> listadoPedidosCliente(Cliente cliente);
    public ArrayList<Producto> listarProductosVendas();

}
