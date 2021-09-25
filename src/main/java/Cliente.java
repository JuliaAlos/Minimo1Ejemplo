import java.util.ArrayList;

public class Cliente {
    String nombre;
    ArrayList<String> pedidosRealizados=new ArrayList<>();

    Cliente(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> listarPedidos() {
        return pedidosRealizados;
    }

    public void añadirPedido(String pedidoRealizado) {
        pedidosRealizados.add(pedidoRealizado);
    }
}
