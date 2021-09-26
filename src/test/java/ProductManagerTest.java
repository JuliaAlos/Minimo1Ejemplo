import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductManagerTest {
    HashMap<String,Cliente> clientes;
    ProductManagerImpl manager;

    @After


    @Before
    public void settup() {
        //Añadir productos a la carta
        this.manager = new ProductManagerImpl();
        this.manager.añadirProductos("Bocadillo",2.99);
        this.manager.añadirProductos("Ensalada",2.50);

        //Crear clientes
        this.clientes = new HashMap<>();
        this.clientes.put("Julia",new Cliente("Julia"));
        this.clientes.put("Paco",new Cliente("Paco"));
        this.clientes.put("Lorena",new Cliente("Lorena"));
    }

    @Test
    public void testRealizarPedido(){
        //Primer pedido
        Assert.assertEquals(0,manager.numPedidos(),0);
        String[] pedido= {"Bocadillo/2","Ensalada/1"};
        this.manager.realizarPedido(new Pedido(this.clientes.get("Julia"),pedido));
        Assert.assertEquals(1,manager.numPedidos(),0);

        //Segundo pedido
        String[] pedido2= {"Bocadillo/3"};
        this.manager.realizarPedido(new Pedido(this.clientes.get("Lorena"),pedido2));
        Assert.assertEquals(2,manager.numPedidos(),0);
    }

    @Test
    public void testServirPedido(){
        //Realizar pedido
        String[] pedido= {"Bocadillo/2","Ensalada/1"};
        this.manager.realizarPedido(new Pedido(this.clientes.get("Julia"),pedido));

        String[] pedido2= {"Bocadillo/3"};
        this.manager.realizarPedido(new Pedido(this.clientes.get("Lorena"),pedido2));

        //Servir pedido
        Assert.assertEquals(2,manager.numPedidos(),0);
        this.manager.servirPedido();
        Assert.assertEquals(1,manager.numPedidos(),0);
        this.manager.servirPedido();
        Assert.assertEquals(0,manager.numPedidos(),0);
    }

    @Test
    public void testListarProductosOrdenados(){
        Assert.assertEquals(2,this.manager.listarProductosOrdenados().size());
        Assert.assertEquals("Ensalada",this.manager.listarProductosOrdenados().get(0).getNombre());
    }

    @Test
    public void testListarProductosVendas(){
        //Realizar pedido
        String[] pedido= {"Bocadillo/2","Ensalada/1"};
        this.manager.realizarPedido(new Pedido(this.clientes.get("Julia"),pedido));

        String[] pedido2= {"Bocadillo/3"};
        this.manager.realizarPedido(new Pedido(this.clientes.get("Lorena"),pedido2));

        //Servir pedido
        this.manager.servirPedido();
        this.manager.servirPedido();

        //Comprobar lista
        ArrayList<Producto> vendas= this.manager.listarProductosVendas();
        Assert.assertEquals(2,vendas.size());
        Assert.assertEquals("Bocadillo",vendas.get(0).getNombre());
        Assert.assertEquals(5,vendas.get(0).getNumVendas());
    }

    @Test
    public void testListadoPedidosClientes(){
        //Realizar pedido
        String[] pedido= {"Bocadillo/2","Ensalada/1"};
        this.manager.realizarPedido(new Pedido(this.clientes.get("Julia"),pedido));

        String[] pedido2= {"Bocadillo/3"};
        this.manager.realizarPedido(new Pedido(this.clientes.get("Lorena"),pedido2));

        //Servir pedido
        this.manager.servirPedido();
        this.manager.servirPedido();

        //Comprobar lista
        ArrayList<String> pedidos= this.manager.listadoPedidosCliente(this.clientes.get("Julia"));
        Assert.assertEquals(1,pedidos.size());
        System.out.println(pedidos.get(0));
    }

}
