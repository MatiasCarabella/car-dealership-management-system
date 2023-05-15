package main.java.com.app.venta;

import main.java.com.app.vehiculo.Vehiculo; // importación para usar la clase Vehiculo
import main.java.com.app.cliente.Cliente; // importación para usar la clase Cliente

// Clase Venta: relaciona un Vehículo con el Cliente comprador
public class Venta {
    // Atributos:
    private Vehiculo vehiculo;
    private Cliente cliente;

    // Constructor:
    public Venta(Vehiculo vehiculo, Cliente cliente) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    public double getPrecio() { return vehiculo.getPrecio(); }

    public void mostrarDatos() {
        System.out.println("Vehículo vendido:");
        vehiculo.mostrarDatos();
        System.out.println("Cliente comprador: ");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Documento: " + cliente.getDocumento());
        System.out.println();
    }
}