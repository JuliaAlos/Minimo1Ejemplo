import java.util.*;

public class ProductManagerImpl implements ProductManager {
    private Queue<Pedido> servicio= new LinkedList<Pedido>();
    private HashMap<String,Producto> catalogoProductos = new HashMap<>();
    private HashMap<String,Cliente> clientes = new HashMap<>();

    public int numPedidos(){
        return servicio.size();
    }
    public void añadirProductos(String nombre,double precio){
        catalogoProductos.put(nombre,new Producto(nombre,precio));
    }
    public void addCliente(String nombre){
        clientes.put(nombre, new Cliente(nombre));
    }
    public Cliente buscarCliente(String nombre){
        return clientes.get(nombre);
    }

    @Override
    public List<Producto> listarProductosOrdenados() {
        List<Producto> productosPrecio = new ArrayList<Producto>(catalogoProductos.values());
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
    public List<String> listadoPedidosCliente(String cliente) {
        return clientes.get(cliente).listarPedidos();
    }

    @Override
    public ArrayList<Producto> listarProductosVendas() {
        ArrayList<Producto> productosVendas = new ArrayList<Producto>(catalogoProductos.values());
        Collections.sort(productosVendas,
                (Producto o1, Producto o2)->Integer.compare(o2.getNumVendas(), o1.getNumVendas()));

        return productosVendas;
    }

}
