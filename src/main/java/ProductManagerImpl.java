import java.util.*;

public class ProductManagerImpl implements ProductManager {
    Queue<Pedido> servicio= new LinkedList<Pedido>();
    HashMap<String,Producto> catalogoProductos = new HashMap<>();

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
        //!!!! añadir pedido a la lista de la person i modificar contadores de los productos
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

    public static void main(String[] args) {
        ProductManagerImpl manager = new ProductManagerImpl();
        manager.añadirProductos("Bocadillo",2.99);
        manager.añadirProductos("Ensalada",2.50);
        HashMap<String,Cliente> clientes = new HashMap<>();
        clientes.put("Julia",new Cliente("Julia"));


        System.out.println(manager.numPedidos());
        String[] pedido= {"Bocadillo/2","Ensalada/1"};
        manager.realizarPedido(new Pedido(clientes.get("Julia"),pedido));
        System.out.println(manager.numPedidos());
        manager.servirPedido();
        System.out.println(manager.numPedidos());
        Cliente client=clientes.get("Julia");
        System.out.println(manager.listadoPedidosCliente(client));

        String[] pedido2= {"Bocadillo/3"};
        manager.realizarPedido(new Pedido(client,pedido2));
        System.out.println(manager.numPedidos());
        manager.servirPedido();
        System.out.println(manager.numPedidos());
        System.out.println(client.listarPedidos());
        ArrayList<Producto> precios= manager.listarProductosOrdenados();
        for (Producto p : precios) {
            System.out.println(p.getNombre()+" Precio "+p.getPrecio()+" Vendas "+p.getNumVendas());
        }
        ArrayList<Producto> vendas = manager.listarProductosVendas();
        for (Producto p : vendas) {
            System.out.println(p.getNombre()+" Precio "+p.getPrecio()+" Vendas "+p.getNumVendas());
        }




    }
}
