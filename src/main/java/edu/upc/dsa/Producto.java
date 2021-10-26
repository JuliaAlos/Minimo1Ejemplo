package edu.upc.dsa;

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
        return Double.compare(this.precio, p.getPrecio());

    }

}
