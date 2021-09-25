import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
    public ArrayList<Producto> listarProductosOrdenados(ArrayList<Producto> lista) {
        return null;
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
    public ArrayList<Pedido> listadoPedidosCliente(Cliente cliente) {
        return null;
    }

    @Override
    public ArrayList<Producto> listarProductosVendas(ArrayList<Producto> lista) {
        return null;
    }

    public static void main(String[] args) {
        ProductManagerImpl manager = new ProductManagerImpl();
        manager.añadirProductos("Bocadillo",2.99);
        manager.añadirProductos("Ensalada",2.50);
        HashMap<String,Cliente> clientes = new HashMap<>();
        clientes.put("Julia",new Cliente("Julia"));


        System.out.println(manager.numPedidos());
        String[][] pedido= {{"Bocadillo","Ensalada"},{"2","1"}};
        manager.realizarPedido(new Pedido(clientes.get("Julia"),pedido));
        System.out.println(manager.numPedidos());
        manager.servirPedido();
        System.out.println(manager.numPedidos());
        Cliente client=clientes.get("Julia");
        System.out.println(client.listarPedidos());

        String[][] pedido2= {{"Bocadillo","Ensalada"},{"2","3"}};
        manager.realizarPedido(new Pedido(client,pedido2));
        System.out.println(manager.numPedidos());
        manager.servirPedido();
        System.out.println(manager.numPedidos());
        System.out.println(client.listarPedidos());



    }
}
