package edu.upc.dsa;

import java.util.List;

public interface ProductManager {

    public List<Producto> listarProductosOrdenados();
    public void realizarPedido(Pedido pedido);
    public void servirPedido();
    public List<String> listadoPedidosCliente(String cliente);
    public List<Producto> listarProductosVendas();

    public int numPedidos();
    public void añadirProductos(String nombre,double precio);
    public void addCliente(String nombre);

}
