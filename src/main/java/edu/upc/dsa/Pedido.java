package edu.upc.dsa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ListarPedidos> comanda= new ArrayList<>();
    private String pedido;
    private Double factura;

    Pedido(Cliente cliente){
        this.cliente=cliente;
        this.pedido="edu.upc.dsa.Pedido realizado -> "+ LocalDateTime.now()+"\n";
        this.factura=0.0;
    }

    public void addLP(int cantidad,String nombreProducto){
        ListarPedidos producto = new ListarPedidos(cantidad,nombreProducto);
        this.comanda.add(producto);
    }

    public void servirPedido(HashMap<String,Producto> catalogoProductos){
        for (int i=0;i< comanda.size();i++){
            ListarPedidos elemento= comanda.get(i);
            Producto producto = catalogoProductos.get(elemento.getNombre());
            producto.incrementarNumVendas(elemento.getCantidad());
            this.pedido+=elemento.getNombre() + " x "+elemento.getCantidad()+"\n";
            this.factura+= elemento.getCantidad()*producto.getPrecio();
        }
        this.pedido+="Precio total: "+ factura+"\nEntrega realizada -> "+LocalDateTime.now();
        cliente.añadirPedido(pedido,comanda);

    }
}
