public class Producto {
    private String nombre;
    private int numVendas;
    private double precio;

    public void crearProducto(String nombre, double precio){
        this.nombre=nombre;
        this.numVendas=0;
        this.precio = precio;
    }

    public int getNumVendas(){
        return numVendas;
    }
    public void incrementarNumVendas(int cantidad){
        numVendas+=cantidad;
    }
    public int compareTo(Figura f){
        if(f.area()>this.area()) {
            return -1;
        }
        else if (f.area()==this.area()){
            return 0;
        }
        else{
            return 1;
        }

    }
}
