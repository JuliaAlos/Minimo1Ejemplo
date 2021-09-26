import java.util.*;

public class ProductManagerImpl implements ProductManager {
    private Queue<Pedido> servicio= new LinkedList<Pedido>();
    private HashMap<String,Producto> catalogoProductos = new HashMap<>();

    public int numPedidos(){
        return servicio.size();
    }
    public void añadirProductos(String nombre,double precio){
        catalogoProductos.put(nombre,new Producto(nombre,precio));
    }

    @Override
    public ArrayList<Producto> listarProductosOrdenados() {
        ArrayList<Producto> productosPrecio = new ArrayList<Producto>(catalogoProductos.values());
        Collections.sort(productosPrecio);
        return productosPrecio;
    }

    @Override
    public void realizarPedido(Pedido pedido) {
        servicio.add(pedido);   //add-> retona exepcio si cua plena
                                //offer-> retona false

    }

    @Override
    public void servirPedido(){
        Pedido servido = servicio.poll();   //poll-> retorna null si cua buida
                                            //remove-> salta exepcio
        servido.servirPedido(catalogoProductos);
    }

    @Override
    public ArrayList<String> listadoPedidosCliente(Cliente cliente) {
        return cliente.listarPedidos();
    }

    @Override
    public ArrayList<Producto> listarProductosVendas() {
        ArrayList<Producto> productosVendas = new ArrayList<Producto>(catalogoProductos.values());
        Collections.sort(productosVendas,new CompararProductosVendas());
        return productosVendas;
    }

}
