import java.util.ArrayList;

public class Pedido {
    Cliente cliente;
    String comanda[][];
    //ArrayList<Integer> cantidades;

    public void crearPedido(Cliente cliente,String comanda[][]){
        this.cliente=cliente;
        this.comanda=comanda;
    }
    public void servirPedido(){
        this.cliente.addPedido(this.comanda,this.cantidades);
        for (Producto)

    }
}
