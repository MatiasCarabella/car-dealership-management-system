package main.java.com.app.venta;

import main.java.com.app.vehiculo.auto.Auto;
import main.java.com.app.vehiculo.camioneta.Camioneta;
import main.java.com.app.vehiculo.moto.Moto;
import main.java.com.app.cliente.Cliente; // importación para usar la clase Cliente

// Clase Venta: relaciona un Vehículo con el Cliente comprador
public class Venta {
    // Atributos:
    private Auto auto;
    private Camioneta camioneta;
    private Moto moto;
    private Cliente cliente;

    public static int totalVentas; // Atributo estático/de Clase, cuenta el importe total de las Ventas

    // Constructores:
    public Venta(Auto auto, Cliente cliente) {
        this.auto = auto;
        this.cliente = cliente;
        totalVentas += auto.getPrecio();
    }
    public Venta(Camioneta camioneta, Cliente cliente) {
        this.camioneta = camioneta;
        this.cliente = cliente;
        totalVentas += camioneta.getPrecio();
    }
    public Venta(Moto moto, Cliente cliente) {
        this.moto = moto;
        this.cliente = cliente;
        totalVentas += moto.getPrecio();
    }

    public double getPrecio() {
        double precio = 0;

        if (!(auto == null)) {
            precio = auto.getPrecio();
        }
        if (!(camioneta == null)) {
            precio = camioneta.getPrecio();
        }
        if (!(moto == null)) {
            precio = moto.getPrecio();
        }
        return precio;
    }

    public void mostrarDatos() {
        if (!(auto == null)) {
            System.out.println("Vehículo vendido:");
            auto.mostrarDatos();
        }
        if (!(camioneta == null)) {
            System.out.println("Vehículo vendido:");
            camioneta.mostrarDatos();
        }
        if (!(moto == null)) {
            System.out.println("Vehículo vendido:");
            moto.mostrarDatos();
        }
        
        System.out.println("Cliente comprador: ");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Documento: " + cliente.getDocumento());
        System.out.println();
    }
}