package main.java.com.app.cliente;

import java.util.ArrayList; // importación para usar la clase ArrayList

import main.java.com.app.vehiculo.auto.Auto;
import main.java.com.app.vehiculo.camioneta.Camioneta;
import main.java.com.app.vehiculo.moto.Moto;

// Clase Cliente: representa a cada cliente que compre vehículos en la concesionaria
public class Cliente {
    // Atributos:
    private String nombre;
    private int documento;
    private ArrayList < Auto > autos;
    private ArrayList < Camioneta > camionetas;
    private ArrayList < Moto > motos;

    // Constructor:
    public Cliente(String nombre, int documento) {
        this.nombre = nombre;
        this.documento = documento;
        autos = new ArrayList < Auto > ();
        camionetas = new ArrayList< Camioneta >();
        motos = new ArrayList< Moto >();
    }

     // Métodos:
     public String getNombre() { return nombre; }
     public int getDocumento() { return documento; }

     public void setNombre(String nombre) { this.nombre = nombre; }
     public void setDocumento(int documento) { this.documento = documento; }

     public void addAuto(Auto a) { autos.add(a); }
     public void addCamioneta (Camioneta c) { camionetas.add(c); }
     public void addMoto (Moto m) { motos.add(m); }

     public void mostrarDatos() {
        System.out.println("Nombre completo: " + nombre);
        System.out.println("Documento: " + documento);
        // Verificar si hay vehículos en el stock
        if (autos.isEmpty() && camionetas.isEmpty() && motos.isEmpty()) {
            System.out.println("No tiene vehículos");
        } else {
            System.out.println("Vehículos:");
            if (!autos.isEmpty()) {
                System.out.println("Autos:");
                // Recorrer la lista de autos y mostrar los datos de cada vehículo
                for (Auto a: autos) {
                    a.mostrarDatos();
                }
            }
            if (!camionetas.isEmpty()) {
                System.out.println("Camionetas:");
                // Recorrer la lista de camionetas y mostrar los datos de cada vehículo
                for (Camioneta c: camionetas) {
                    c.mostrarDatos();
                }
            }
            if (!motos.isEmpty()) {
                System.out.println("Motos:");
                // Recorrer la lista de motos y mostrar los datos de cada vehículo
                for (Moto m: motos) {
                    m.mostrarDatos();
                }
            }
        }
        System.out.println();
    }
}