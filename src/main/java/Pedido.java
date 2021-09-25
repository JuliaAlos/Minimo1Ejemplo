import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {
    Cliente cliente;
    String comanda[][];//poducto, cantidad
    String pedido;
    Double factura;

    Pedido(Cliente cliente,String comanda[][]){
        this.cliente=cliente;
        this.comanda=comanda;
        this.pedido="Pedido realizado -> "+ LocalDateTime.now()+"\n";
        this.factura=0.0;
    }
    public void servirPedido(HashMap<String,Producto> catalogoProductos){

        for (int i=0;i< comanda.length;i++){
            Producto producto = catalogoProductos.get(comanda[0][i]);
            producto.incrementarNumVendas(Integer.parseInt (comanda[1][i]));
            this.pedido+=comanda[0][i] + " x "+comanda[1][i]+"\n";
            this.factura+= Double.parseDouble(comanda[1][i])*producto.getPrecio();
        }
        this.pedido+="Precio total: "+ factura+"\nEntrega realizada -> "+LocalDateTime.now();
        cliente.añadirPedido(pedido);

    }
}
