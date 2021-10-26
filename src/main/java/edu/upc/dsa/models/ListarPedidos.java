package edu.upc.dsa.models;

public class ListarPedidos {
    private int cantidad;
    private String nombreProducto;

    public ListarPedidos(){}

    public ListarPedidos(int cantidad,String nombre){
        this();
        this.cantidad=cantidad;
        this.nombreProducto=nombre;
    }

    public int getCantidad(){
        return cantidad;
    }
    public String getNombre(){
        return nombreProducto;
    }
}
