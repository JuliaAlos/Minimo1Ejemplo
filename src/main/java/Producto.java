public class Producto {
    private String nombre;
    private int numVendas;
    private double precio;

    public Producto(String nombre, double precio){
        this.nombre=nombre;
        this.numVendas=0;
        this.precio = precio;
    }

    public int getNumVendas(){
        return numVendas;
    }
    public double getPrecio(){
        return precio;
    }
    public void incrementarNumVendas(int cantidad){
        numVendas+=cantidad;
    }
    public int compareTo(Producto p){
        if(p.getNumVendas()>this.numVendas) {
            return -1;
        }
        else if (p.getNumVendas()==this.numVendas){
            return 0;
        }
        else{
            return 1;
        }

    }
}
