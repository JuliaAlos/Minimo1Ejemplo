import java.util.ArrayList;

public class Cliente {
    String nombre;
    ArrayList<Pedido> pedidosRealizados;
    public void cliente(String nombre){
        this.nombre=nombre;
    }

    public ArrayList<Pedido> listarPedidos(){
        return pedidosRealizados;
    }
}
