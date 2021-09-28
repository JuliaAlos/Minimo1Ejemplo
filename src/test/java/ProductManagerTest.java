import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductManagerTest {
    ProductManagerImpl manager;

    @After
    public void tearDown() {
        this.manager=null;
    }


    @Before
    public void setUp() {
        //Añadir productos a la carta
        this.manager = new ProductManagerImpl();
        this.manager.añadirProductos("Bocadillo",2.99);
        this.manager.añadirProductos("Ensalada",2.50);

        //Crear clientes
        this.manager.addCliente("Julia");
        this.manager.addCliente("Paco");
        this.manager.addCliente("Lorena");
    }

    @Test
    public void testRealizarPedido(){
        //Primer pedido
        Assert.assertEquals(0,manager.numPedidos(),0);
        Pedido p = new Pedido(manager.buscarCliente("Julia"));
        p.addLP(3, "Bocadillo");
        p.addLP(1, "Ensalada");
        this.manager.realizarPedido(p);
        Assert.assertEquals(1,manager.numPedidos(),0);

        //Segundo pedido
        Pedido p2 = new Pedido(manager.buscarCliente("Julia"));
        p2.addLP(2, "Bocadillo");
        this.manager.realizarPedido(p2);
        Assert.assertEquals(2,manager.numPedidos(),0);
    }

    @Test
    public void testServirPedido(){
        //Realizar pedido
        Pedido p = new Pedido(manager.buscarCliente("Julia"));
        p.addLP(3, "Bocadillo");
        p.addLP(1, "Ensalada");
        this.manager.realizarPedido(p);

        Pedido p2 = new Pedido(manager.buscarCliente("Julia"));
        p2.addLP(2, "Bocadillo");
        this.manager.realizarPedido(p2);

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
        Pedido p = new Pedido(manager.buscarCliente("Julia"));
        p.addLP(3, "Bocadillo");
        p.addLP(1, "Ensalada");
        this.manager.realizarPedido(p);

        Pedido p2 = new Pedido(manager.buscarCliente("Julia"));
        p2.addLP(2, "Bocadillo");
        this.manager.realizarPedido(p2);

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
        Pedido p = new Pedido(manager.buscarCliente("Julia"));
        p.addLP(3, "Bocadillo");
        p.addLP(1, "Ensalada");
        this.manager.realizarPedido(p);

        Pedido p2 = new Pedido(manager.buscarCliente("Lorena"));
        p2.addLP(2, "Bocadillo");
        this.manager.realizarPedido(p2);

        //Servir pedido
        this.manager.servirPedido();
        this.manager.servirPedido();

        //Comprobar lista
        List<String> pedidos= this.manager.listadoPedidosCliente("Julia");
        Assert.assertEquals(1,pedidos.size());
        System.out.println(pedidos.get(0));
    }

}
