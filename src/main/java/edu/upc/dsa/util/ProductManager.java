package edu.upc.dsa.util;

import edu.upc.dsa.models.Cliente;
import edu.upc.dsa.models.ListarPedidos;
import edu.upc.dsa.models.Pedido;
import edu.upc.dsa.models.Producto;

import java.util.List;

public interface ProductManager {

    public List<Producto> listarProductosOrdenados();
    public void realizarPedido(Pedido pedido);
    public void servirPedido();
    public List<String> listadoPedidosClienteString(String cliente);
    public List<Producto> listarProductosVendas();
    public List<Pedido> listadoPedidosCliente(String cliente);

    public int numPedidos();
    public void añadirProductos(String nombre, double precio);
    public void addCliente(String nombre);
    public Cliente buscarCliente(String nombre);

}
