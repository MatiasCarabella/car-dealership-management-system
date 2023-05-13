package main.java.com.app.cliente;

import java.util.ArrayList; // importación para usar la clase ArrayList

import main.java.com.app.vehiculo.Vehiculo; // importación para usar la clase Vehiculo

// Clase Cliente: representa a cada cliente que compre vehículos en la concesionaria
public class Cliente {
    // Atributos:
    private String nombre;
    private int documento;
    private ArrayList < Vehiculo > vehiculos; // lista de vehículos vendidos

    // Constructor:
    public Cliente(String nombre, int documento) {
        this.nombre = nombre;
        this.documento = documento;
        vehiculos = new ArrayList < Vehiculo > ();
    }

     // Métodos:
     public String getNombre() { return nombre; }
     public int getDocumento() { return documento; }

     public void setNombre(String nombre) { this.nombre = nombre; }
     public void setDocumento(int documento) { this.documento = documento; }
     public void addVehiculo (Vehiculo v) { vehiculos.add(v); }

     public void mostrarDatos() {
        System.out.println("Nombre completo: " + nombre);
        System.out.println("Documento: " + documento);
        // Verificar si hay vehículos en el stock
        if (vehiculos.isEmpty()) {
            System.out.println("No tiene vehículos");
        } else {
            System.out.println("Vehículos:");
            // Recorrer la lista de stock y mostrar los datos de cada vehículo
            for (Vehiculo v: vehiculos) {
                v.mostrarDatos();
            }
        }
        System.out.println();
    }
}
