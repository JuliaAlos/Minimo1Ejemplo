package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class PedidoCRUD {
    private String cliente;
    private List<ListarPedidos> comanda= new ArrayList<>();

    public PedidoCRUD(){}
    public PedidoCRUD(String cliente,List<ListarPedidos> comanda ){
        this();
        this.cliente=cliente;
        this.comanda=comanda;
    }

    public void setComanda(List<ListarPedidos> comanda) {
        this.comanda = comanda;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<ListarPedidos> getComanda() {
        return comanda;
    }

    public String getCliente() {
        return cliente;
    }
}
