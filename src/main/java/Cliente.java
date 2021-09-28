import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private ArrayList<String> pedidosRealizados=new ArrayList<>();
    private List<List<ListarPedidos>> comandasRealizadas= new ArrayList<>();

    Cliente(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> listarPedidos() {
        return pedidosRealizados;
    }

    public void añadirPedido(String pedidoRealizado,List<ListarPedidos> lista) {
        comandasRealizadas.add(lista);
        pedidosRealizados.add(pedidoRealizado);
    }
}
