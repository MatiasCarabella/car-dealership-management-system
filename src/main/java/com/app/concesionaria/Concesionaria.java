package main.java.com.app.concesionaria;

import java.util.ArrayList; // importación para usar la clase ArrayList
import java.util.Scanner; // importación para usar la clase Scanner
import main.java.com.app.vehiculo.Vehiculo; // importación para usar la clase Vehiculo

// Clase Concesionaria: representa al negocio que vende los vehículos
public class Concesionaria {

  // Atributos:
  private String nombre;
  private ArrayList < Vehiculo > stock; // lista de vehículos disponibles
  private ArrayList < Vehiculo > ventas; // lista de vehículos vendidos
  private Scanner sc; // objeto para leer datos por teclado

  // Constructor:
  public Concesionaria(String nombre) {
    this.nombre = nombre;
    stock = new ArrayList < Vehiculo > ();
    ventas = new ArrayList < Vehiculo > ();
    sc = new Scanner(System.in);
  }

  // Métodos:

  // Muestra un menú de opciones al usuario y ejecuta la opción elegida
  public void menu() {
    int opcion;
    do {
      System.out.println("Bienvenido a la concesionaria " + nombre);
      System.out.println("Seleccione una opción:");
      System.out.println("1. Registrar un vehículo");
      System.out.println("2. Mostrar el listado de vehículos disponibles");
      System.out.println("3. Buscar un vehículo por marca");
      System.out.println("4. Buscar un vehículo por rango de precio");
      System.out.println("5. Vender un vehículo");
      System.out.println("6. Mostrar las ventas realizadas y el total recaudado");
      System.out.println("7. Salir");
      opcion = sc.nextInt();
      switch (opcion) {
      case 1:
        registrarVehiculo();
        break;
      case 2:
        mostrarStock();
        break;
      case 3:
        buscarPorMarca();
        break;
      case 4:
        buscarPorPrecio();
        break;
      case 5:
        venderVehiculo();
        break;
      case 6:
        mostrarVentas();
        break;
      case 7:
        System.out.println("Gracias por usar la concesionaria " + nombre);
        break;
      default:
        System.out.println("Opción inválida");
      }
    } while (opcion != 7);
  }

  // Pide al usuario los datos de un vehículo y lo agrega al stock
  public void registrarVehiculo() {
    String marca, modelo;
    int año;
    double precio;

    sc.nextLine(); // limpiar el buffer del teclado
    System.out.print("Ingrese la marca del vehículo: ");
    marca = sc.nextLine();

    System.out.print("Ingrese el modelo del vehículo: ");
    modelo = sc.nextLine();

    System.out.print("Ingrese el año del vehículo: ");
    año = sc.nextInt();

    System.out.print("Ingrese el precio del vehículo: ");
    precio = sc.nextDouble();

    // Crear un objeto de la clase Vehiculo con los datos ingresados
    Vehiculo v = new Vehiculo(marca, modelo, año, precio);

    // Agregar el objeto a la lista de stock
    stock.add(v);

    System.out.println("Vehículo registrado con éxito");
  }

  // Muestra el listado de vehículos disponibles en el stock
  public void mostrarStock() {

    // Verificar si hay vehículos en el stock
    if (stock.isEmpty()) {
      System.out.println("No hay vehículos disponibles");
    } else {
      System.out.println("Listado de vehículos disponibles:");
      // Recorrer la lista de stock y mostrar los datos de cada vehículo
      for (Vehiculo v: stock) {
        v.mostrarDatos();
      }
    }
  }

  // Pide al usuario una marca y muestra los vehículos que coinciden con esa marca
  public void buscarPorMarca() {

    String marca;
    boolean encontrado = false; // variable para indicar si se encontró algún vehículo

    sc.nextLine(); // limpiar el buffer del teclado
    System.out.print("Ingrese la marca que desea buscar: ");
    marca = sc.nextLine();

    // Recorrer la lista de stock y comparar la marca de cada vehículo con la ingresada por el usuario
    for (Vehiculo v: stock) {
      if (v.getMarca().equalsIgnoreCase(marca)) { // ignorar las mayúsculas y minúsculas en la comparación
        // Si se encuentra una coincidencia, mostrar los datos del vehículo y cambiar el valor de encontrado a true
        v.mostrarDatos();
        encontrado = true;
      }
    }

    // Si no se encontró ningún vehículo con esa marca, mostrar un mensaje al usuario
    if (!encontrado) {
      System.out.println("No hay ningún vehículo con esa marca");
    }
  }

  // Pide al usuario un rango de precio mínimo y máximo y muestra los vehículos que se encuentran dentro de ese rango
  public void buscarPorPrecio() {

    double minimo, maximo;
    boolean encontrado = false; // variable para indicar si se encontró algún vehículo

    System.out.print("Ingrese el precio mínimo que desea buscar: ");
    minimo = sc.nextDouble();

    System.out.print("Ingrese el precio máximo que desea buscar: ");
    maximo = sc.nextDouble();

    // Recorrer la lista de stock y verificar si el precio de cada vehículo está entre el mínimo y el máximo ingresados por el usuario
    for (Vehiculo v: stock) {
      if (v.getPrecio() >= minimo && v.getPrecio() <= maximo) {
        // Si se encuentra un vehículo dentro del rango, mostrar sus datos y cambiar el valor de encontrado a true 
        v.mostrarDatos();
        encontrado = true;
      }
    }

    // Si no se encontró ningún vehículo dentro del rango, mostrar un mensaje al usuario
    if (!encontrado) {
      System.out.println("No hay ningún vehículo dentro de ese rango de precio");
    }
  }

  // Pide al usuario el índice de un vehículo en el stock y lo elimina del stock y lo agrega a las ventas
  public void venderVehiculo() {

    int indice;

    // Verificar si hay vehículos en el stock
    if (stock.isEmpty()) {
      System.out.println("No hay vehículos disponibles para vender");
    } else {
      // Mostrar el listado de vehículos disponibles con sus índices
      System.out.println("Listado de vehículos disponibles:");
      for (int i = 0; i < stock.size(); i++) {
        System.out.print("Índice: " + i + " - ");
        stock.get(i).mostrarDatos();
      }

      // Pedir al usuario que ingrese el índice del vehículo que quiere vender
      System.out.print("Ingrese el índice del vehículo que quiere vender: ");
      indice = sc.nextInt();

      // Verificar si el índice es válido
      if (indice >= 0 && indice < stock.size()) {
        // Obtener el vehículo correspondiente al índice ingresado
        Vehiculo v = stock.get(indice);

        // Eliminar el vehículo del stock y agregarlo a las ventas
        stock.remove(indice);
        ventas.add(v);

        System.out.println("Vehículo vendido con éxito");
      } else {
        System.out.println("Índice inválido");
      }
    }
  }

  // Muestra el listado de los vehículos vendidos y el total recaudado por la concesionaria
  public void mostrarVentas() {

    double total = 0; // variable para acumular el total recaudado

    // Verificar si hay ventas realizadas
    if (ventas.isEmpty()) {
      System.out.println("No hay ventas realizadas");
    } else {
      System.out.println("Listado de ventas realizadas:");

      // Recorrer la lista de ventas y mostrar los datos de cada vehículo vendido y sumar su precio al total
      for (Vehiculo v: ventas) {
        v.mostrarDatos();
        total += v.getPrecio();
      }

      // Mostrar el total recaudado por la concesionaria
      System.out.println("Total recaudado: $" + total);
    }
  }
}