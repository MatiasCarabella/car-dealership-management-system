package proyecto_concesionaria;

// Clase Vehiculo: representa a cada vehículo que se vende en la concesionaria
public class Vehiculo {
    // Atributos:
    private String marca;
    private String modelo;
    private int año;
    private double precio;
  
    // Constructor:
    public Vehiculo(String marca, String modelo, int año, double precio) {
      this.marca = marca;
      this.modelo = modelo;
      this.año = año;
      this.precio = precio;
    }

    // Métodos:
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAño() { return año; }
    public double getPrecio() { return precio; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAño(int año) { this.año = año; }
    public void setPrecio(double precio) { this.precio = precio; }

    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + año);
        System.out.println("Precio: $" + precio);
        System.out.println();
    }
}
