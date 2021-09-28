public class Producto implements Comparable<Producto>{
    private String nombre;
    private int numVendas;
    private double precio;

    public Producto(String nombre, double precio){
        this.nombre=nombre;
        this.numVendas=0;
        this.precio = precio;
    }
    public String getNombre(){
        return this.nombre;
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
        if(p.getPrecio()>this.precio) {
            return -1;
        }
        else if (p.getPrecio()==this.precio){
            return 0;
        }
        else{
            return 1;
        }
        /*return (int) p.getPrecio()-this.precio;*/

    }

}
