package main.java.com.app.vehiculo.camioneta;

import main.java.com.app.vehiculo.Vehiculo;

public class Camioneta extends Vehiculo {
    // Atributos:
    private int volumenDeCarga;
    public static int cantidadDeCamionetas; // Atributo estático/de Clase, cuenta el total de Vehículos de este tipo

    // Constructor:
    public Camioneta(String marca, String modelo, int volumenDeCarga, int año, int km, double precio) {
        super(marca, modelo, año, km, precio);
        this.volumenDeCarga = volumenDeCarga;
        cantidadDeCamionetas++;
    }

    // Métodos:
    public int getVolumenDeCarga() { return volumenDeCarga; }
    public void setVolumenDeCarga(int volumenDeCarga) { this.volumenDeCarga = volumenDeCarga; }

    public void mostrarDatos() {
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Volumen de Carga: " + volumenDeCarga);
        System.out.println("Año: " + this.getAño());
        System.out.println("Km: " + this.getKm());
        System.out.println("Precio: $" + this.getPrecio());
        System.out.println(); 
    }
}
