package main.java.com.app.vehiculo;

// Clase Vehiculo: representa a cada vehículo que se vende en la concesionaria
public class Vehiculo {
    // Atributos:
    private String marca;
    private String modelo;
    private int año;
    private int km;
    private double precio;
  
    // Constructor:
    public Vehiculo(String marca, String modelo, int año, int km, double precio) {
      this.marca = marca;
      this.modelo = modelo;
      this.año = año;
      this.km = km;
      this.precio = precio;
    }

    // Métodos:
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAño() { return año; }
    public int getKm() { return km; }
    public double getPrecio() { return precio; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAño(int año) { this.año = año; }
    public void setKm(int km) { this.km = año; }
    public void setPrecio(double precio) { this.precio = precio; }

    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + año);
        System.out.println("Km: " + km);
        System.out.println("Precio: $" + precio);
        System.out.println();
    }
}
