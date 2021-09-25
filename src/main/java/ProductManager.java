import java.util.ArrayList;

public interface ProductManager {
    /*
    public void push(E v) throws FullStackException;
    public E pop() throws EmptyStackException;
    */

    public ArrayList<Producto> listarProductosOrdenados(ArrayList<Producto> lista);
    public void realizarPedido(Cliente cliente,Pedido pedido);
    public void servirPedido();
    public ArrayList<Pedido> listadoPedidosCliente(Cliente cliente);
    public ArrayList<Producto> listarProductosVendas(ArrayList<Producto> lista);

}
