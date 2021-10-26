package edu.upc.dsa;
import edu.upc.dsa.models.Pedido;
import edu.upc.dsa.models.Producto;
import edu.upc.dsa.util.ProductManagerImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerTest {

    @After
    public void tearDown() {    }


    @Before
    public void setUp() {
        //Añadir productos a la carta
        ProductManagerImpl.getInstance().añadirProductos("Bocadillo",2.99);
        ProductManagerImpl.getInstance().añadirProductos("Ensalada",2.50);

        //Crear clientes
        ProductManagerImpl.getInstance().addCliente("Julia");
        ProductManagerImpl.getInstance().addCliente("Paco");
        ProductManagerImpl.getInstance().addCliente("Lorena");
    }

    @Test
    public void testRealizarPedido(){
        //Primer pedido
        Assert.assertEquals(0,ProductManagerImpl.getInstance().numPedidos());
        Pedido p = new Pedido(ProductManagerImpl.getInstance().buscarCliente("Julia"));
        p.addLP(3, "Bocadillo");
        p.addLP(1, "Ensalada");
        ProductManagerImpl.getInstance().realizarPedido(p);
        Assert.assertEquals(1,ProductManagerImpl.getInstance().numPedidos(),0);

        //Segundo pedido
        Pedido p2 = new Pedido(ProductManagerImpl.getInstance().buscarCliente("Julia"));
        p2.addLP(2, "Bocadillo");
        ProductManagerImpl.getInstance().realizarPedido(p2);
        Assert.assertEquals(2,ProductManagerImpl.getInstance().numPedidos(),0);
    }

    @Test
    public void testServirPedido(){
        //Realizar pedido
        Pedido p = new Pedido(ProductManagerImpl.getInstance().buscarCliente("Julia"));
        p.addLP(3, "Bocadillo");
        p.addLP(1, "Ensalada");
        ProductManagerImpl.getInstance().realizarPedido(p);

        Pedido p2 = new Pedido(ProductManagerImpl.getInstance().buscarCliente("Julia"));
        p2.addLP(2, "Bocadillo");
        ProductManagerImpl.getInstance().realizarPedido(p2);

        //Servir pedido
        Assert.assertEquals(2,ProductManagerImpl.getInstance().numPedidos(),0);
        ProductManagerImpl.getInstance().servirPedido();
        Assert.assertEquals(1,ProductManagerImpl.getInstance().numPedidos(),0);
        ProductManagerImpl.getInstance().servirPedido();
        Assert.assertEquals(0,ProductManagerImpl.getInstance().numPedidos(),0);
    }

    @Test
    public void testListarProductosOrdenados(){
        Assert.assertEquals(2,ProductManagerImpl.getInstance().listarProductosOrdenados().size());
        Assert.assertEquals("Ensalada",ProductManagerImpl.getInstance().listarProductosOrdenados().get(0).getNombre());
    }

    @Test
    public void testListarProductosVendas(){
        //Realizar pedido
        Pedido p = new Pedido(ProductManagerImpl.getInstance().buscarCliente("Julia"));
        p.addLP(3, "Bocadillo");
        p.addLP(1, "Ensalada");
        ProductManagerImpl.getInstance().realizarPedido(p);

        Pedido p2 = new Pedido(ProductManagerImpl.getInstance().buscarCliente("Julia"));
        p2.addLP(2, "Bocadillo");
        ProductManagerImpl.getInstance().realizarPedido(p2);

        //Servir pedido
        ProductManagerImpl.getInstance().servirPedido();
        ProductManagerImpl.getInstance().servirPedido();

        //Comprobar lista
        ArrayList<Producto> vendas= ProductManagerImpl.getInstance().listarProductosVendas();
        Assert.assertEquals(2,vendas.size());
        Assert.assertEquals("Bocadillo",vendas.get(0).getNombre());
        Assert.assertEquals(5,vendas.get(0).getNumVendas());
    }

    @Test
    public void testListadoPedidosClientes(){
        //Realizar pedido
        Pedido p = new Pedido(ProductManagerImpl.getInstance().buscarCliente("Julia"));
        p.addLP(3, "Bocadillo");
        p.addLP(1, "Ensalada");
        ProductManagerImpl.getInstance().realizarPedido(p);

        Pedido p2 = new Pedido(ProductManagerImpl.getInstance().buscarCliente("Lorena"));
        p2.addLP(2, "Bocadillo");
        ProductManagerImpl.getInstance().realizarPedido(p2);

        //Servir pedido
        ProductManagerImpl.getInstance().servirPedido();
        ProductManagerImpl.getInstance().servirPedido();

        //Comprobar lista
        List<String> pedidos= ProductManagerImpl.getInstance().listadoPedidosClienteString("Julia");
        Assert.assertEquals(1,pedidos.size());
        System.out.println(pedidos.get(0));
    }

}
