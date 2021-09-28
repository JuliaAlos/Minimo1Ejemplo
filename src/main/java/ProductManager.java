import java.util.ArrayList;
import java.util.List;

public interface ProductManager {

    public List<Producto> listarProductosOrdenados();
    public void realizarPedido(Pedido pedido);
    public void servirPedido();
    public List<String> listadoPedidosCliente(String cliente);
    public List<Producto> listarProductosVendas();

}
