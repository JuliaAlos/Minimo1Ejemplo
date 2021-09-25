import java.util.Queue;

public class Restauracion {
    Queue<Pedido> servicio;
    //Queue<Pedido> servicio= new LinkedList<Pedido>();

    public void realizarPedido(Pedido pedido){
        servicio.add(pedido);   //add-> retona exepcio si cua plena
                                //offer-> retona false
    }
    public int numPedidos(){
        return servicio.size();
    }
    public void servirPedido(){
        Pedido servido = servicio.poll();   //poll-> retorna null si cua buida
                                            //remove-> salta exepcio
        //!!!! añadir pedido a la lista de la person i modificar contadores de los productos
        servido.servirPedido();
    }
}
