import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {
    Cliente cliente;
    String comanda[];//poducto, cantidad
    String pedido;
    Double factura;

    Pedido(Cliente cliente,String comanda[]){
        this.cliente=cliente;
        this.comanda=comanda;
        this.pedido="Pedido realizado -> "+ LocalDateTime.now()+"\n";
        this.factura=0.0;
    }
    public void servirPedido(HashMap<String,Producto> catalogoProductos){

        for (int i=0;i< comanda.length;i++){
            String[] elemento= comanda[i].split("/");
            Producto producto = catalogoProductos.get(elemento[0]);
            producto.incrementarNumVendas(Integer.parseInt (elemento[1]));
            this.pedido+=elemento[0] + " x "+elemento[1]+"\n";
            this.factura+= Double.parseDouble(elemento[1])*producto.getPrecio();
        }
        this.pedido+="Precio total: "+ factura+"\nEntrega realizada -> "+LocalDateTime.now();
        cliente.añadirPedido(pedido);

    }
}
