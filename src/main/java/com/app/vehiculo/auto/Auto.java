package main.java.com.app.vehiculo.auto;

import main.java.com.app.vehiculo.Vehiculo;

public class Auto extends Vehiculo {
    // Atributos:
    private String traccion;
    public static int cantidadDeAutos; // Atributo estático/de Clase, cuenta el total de Vehículos de este tipo

    // Constructor:
    public Auto(String marca, String modelo, String traccion, int año, int km, double precio) {
        super(marca, modelo, año, km, precio);
        this.traccion = traccion;
        cantidadDeAutos++;
    }

    // Métodos:
    public String getTraccion() { return traccion; }
    public void setTraccion(String traccion) { this.traccion = traccion; }

    public void mostrarDatos() {
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Tracción: " + traccion);
        System.out.println("Año: " + this.getAño());
        System.out.println("Km: " + this.getKm());
        System.out.println("Precio: $" + this.getPrecio());
        System.out.println(); 
    }

    
}
