package edu.upc.dsa.models;

public class Producto implements Comparable<Producto>{
    private String nombre;
    private int numVendas;
    private double precio;

    public Producto(){};

    public Producto(String nombre, double precio){
        this();
        this.nombre=nombre;
        this.numVendas=0;
        this.precio = precio;
    }

    public void incrementarNumVendas(int cantidad){
        numVendas+=cantidad;
    }
    public int compareTo(Producto p){
        return Double.compare(this.precio, p.getPrecio());
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

    public void setNumVendas(int numVendas) {this.numVendas = numVendas;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPrecio(double precio) {this.precio = precio;}

}
