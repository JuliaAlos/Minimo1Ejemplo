import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProductManagerImpl implements ProductManager {
    Queue<Pedido> servicio= new LinkedList<Pedido>();

    public int numPedidos(){
        return servicio.size();
    }

    @Override
    public ArrayList<Producto> listarProductosOrdenados(ArrayList<Producto> lista) {
        return null;
    }

    @Override
    public void realizarPedido(Cliente cliente, Pedido pedido) {
        servicio.add(pedido);   //add-> retona exepcio si cua plena
        //offer-> retona false

    }

    @Override
    public void servirPedido(){
        Pedido servido = servicio.poll();   //poll-> retorna null si cua buida
        //remove-> salta exepcio
        //!!!! añadir pedido a la lista de la person i modificar contadores de los productos
        servido.servirPedido();
    }

    @Override
    public ArrayList<Pedido> listadoPedidosCliente(Cliente cliente) {
        return null;
    }

    @Override
    public ArrayList<Producto> listarProductosVendas(ArrayList<Producto> lista) {
        return null;
    }
}
