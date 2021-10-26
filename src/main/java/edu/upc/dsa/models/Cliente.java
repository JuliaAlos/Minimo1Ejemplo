package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cliente {
    private String nombre;
    private ArrayList<String> pedidosRealizados=new ArrayList<>();
    private List<Pedido> comandasRealizadas= new LinkedList<>();

    public Cliente(){}

    public Cliente(String nombre) {
        this();
        this.nombre = nombre;
    }

    public ArrayList<String> listarPedidosString() {
        return pedidosRealizados;
    }
    public List<Pedido>  listarPedidos() {
        return comandasRealizadas;
    }

    public void añadirPedido(String pedidoRealizado,Pedido pedido) {
        comandasRealizadas.add(pedido);
        pedidosRealizados.add(pedidoRealizado);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
}
