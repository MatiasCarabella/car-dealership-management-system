package main.java.com.app.vehiculo.moto;

import main.java.com.app.vehiculo.Vehiculo;

public class Moto extends Vehiculo {
    // Atributos:
    private String cilindrada;
    public static int cantidadDeMotos; // Atributo estático/de Clase, cuenta el total de Vehículos de este tipo


    // Constructor:
    public Moto(String marca, String modelo, String cilindrada, int año, int km, double precio) {
        super(marca, modelo, año, km, precio);
        this.cilindrada = cilindrada;
        cantidadDeMotos++;
    }

    // Métodos:
    public String getCilindrada() { return cilindrada; }
    public void setCilindrada(String cilindrada) { this.cilindrada = cilindrada; }

    public void mostrarDatos() {
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Cilindrada: " + cilindrada);
        System.out.println("Año: " + this.getAño());
        System.out.println("Km: " + this.getKm());
        System.out.println("Precio: $" + this.getPrecio());
        System.out.println(); 
    }
}
