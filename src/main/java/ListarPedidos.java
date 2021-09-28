public class ListarPedidos {
    private int cantidad;
    private String nombre;
    ListarPedidos(int cantidad,String nombre){
        this.cantidad=cantidad;
        this.nombre=nombre;
    }

    public int getCantidad(){
        return cantidad;
    }
    public String getNombre(){
        return nombre;
    }
}
