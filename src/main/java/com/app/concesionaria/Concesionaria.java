package main.java.com.app.concesionaria;

import java.io.IOException;
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
  public void menuPrincipal() throws IOException {
    int opcion;
    do {
      System.out.println("");
      System.out.println("Bienvenido a la concesionaria " + nombre);
      System.out.println("Seleccione una opción:");
      System.out.println("1. Registrar un vehículo");
      System.out.println("2. Mostrar todos los vehículos disponibles");
      System.out.println("3. Buscar vehiculos");
      System.out.println("4. Vender un vehículo");
      System.out.println("5. Mostrar las ventas realizadas y el total recaudado");
      System.out.println("0. Salir");
      opcion = sc.nextInt();
      switch (opcion) {
      case 1:
        registrarVehiculo();
        break;
      case 2:
        mostrarStock();
        break;
      case 3:
        menuBusqueda();
        break;
      case 4:
        venderVehiculo();
        break;
      case 5:
        mostrarVentas();
        break;
      case 0:
        System.out.println("Gracias por usar la concesionaria " + nombre);
        break;
      default:
        System.out.println("Opción inválida");
      }
    } while (opcion != 0);
  }

  // Pide al usuario los datos de un vehículo y lo agrega al stock
  public void registrarVehiculo() {
    String marca, modelo;
    int año, km;
    double precio;

    sc.nextLine(); // limpiar el buffer del teclado
    System.out.print("Ingrese la marca del vehículo: ");
    marca = sc.nextLine();

    System.out.print("Ingrese el modelo del vehículo: ");
    modelo = sc.nextLine();

    System.out.print("Ingrese el año del vehículo: ");
    año = sc.nextInt();

    System.out.print("Ingrese el kilometraje del vehículo: ");
    km = sc.nextInt();

    System.out.print("Ingrese el precio del vehículo: ");
    precio = sc.nextDouble();

    // Crear un objeto de la clase Vehiculo con los datos ingresados
    Vehiculo v = new Vehiculo(marca, modelo, año, km, precio);

    // Agregar el objeto a la lista de stock
    stock.add(v);

    System.out.println("Vehículo registrado con éxito");
  }

  // Muestra el listado de vehículos disponibles en el stock
  public void mostrarStock() throws IOException {
    System.out.println("");
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
    System.out.println("Presiona ENTER para volver al menú principal");
    System.in.read();
  }

  public void menuBusqueda() throws IOException {
    int opcion;
    // La variable criterio se utilizará como 'flag' para saber si el usuario ya ha ingresado algún criterio de búsqueda,
    // en tal caso se mostrará el resumen de todos los criterios ingresados y la opción de 'Buscar' en el menú                            
    boolean criterio = false;
    // Se inicializan todas las variables con valores que se utilizarán para determinar si el usuario 
    String marca = "";
    int añoMin = -1, añoMax = -1, kmMax = -1;
    double precioMin = -1, precioMax = -1;
    do {
      System.out.println("");
      // Si criterio == true se muestra el resumen de criterios de búsqueda ingresados
      if(criterio) {
        System.out.println("Criterios de búsqueda definidos:");
        // Si 'marca' tiene un valor distinto al de inicialización, se muestra
        if(marca != "") {
          System.out.println("Marca: " + marca);
        }
        // Si 'añoMin'/'añoMax' tienen valores distintos al de inicialización, se muestran
        if(añoMin != -1 && añoMax != -1) {
          System.out.println("Año: Entre " + añoMin + " y " + añoMax);
        }
        // Si 'kmMax' tiene un valor distinto al de inicialización, se muestra
        if(kmMax != -1) {
          System.out.println("KM: Menor a " + kmMax);
        }
        // Si 'precioMin'/'precioMax' tienen valores distintos al de inicialización, se muestran
        if(precioMin != -1 && precioMax != -1) {
          System.out.println("Precio: Entre $" + precioMin + " y $" + precioMax);
        }
        System.out.println("");
        System.out.println("Puedes agregar más criterios, o buscar en base a los criterios actuales.");
      } else {
        System.out.println("¿Qué criterio deseas utilizar para buscar?");
      }

      System.out.println("Seleccione una opción:");
      System.out.println("1. Marca");
      System.out.println("2. Rango de años");
      System.out.println("3. Kilometraje menor a X");
      System.out.println("4. Rango de precio");
      if (criterio) {
        System.out.println("5. Buscar vehículos");;
      }
      System.out.println("0. Volver al menú principal");
      opcion = sc.nextInt();
      switch (opcion) {
      case 1:
        sc.nextLine(); // limpiar el buffer del teclado
        System.out.print("Ingrese la marca que desea buscar: ");
        marca = sc.nextLine();
        criterio = true;
        break;
      case 2:
        System.out.print("Ingrese el año mínimo que desea buscar: ");
        añoMin = sc.nextInt();
        System.out.print("Ingrese el año máximo que desea buscar: ");
        añoMax = sc.nextInt();
        criterio = true;
        break;
      case 3:
        System.out.print("Ingrese el kilometraje máximo que desea aceptar: ");
        kmMax = sc.nextInt();
        criterio = true;
        break;
      case 4:
        System.out.print("Ingrese el precio mínimo que desea buscar: ");
        precioMin = sc.nextDouble();
        System.out.print("Ingrese el precio máximo que desea buscar: ");
        precioMax = sc.nextDouble();
        criterio = true;
        break;
      case 5:
        if(criterio) {
          buscarVehiculos(marca, añoMin, añoMax, kmMax, precioMin, precioMax);
        } else {
          System.out.println("Opción inválida");
        }
        break;
      default:
        if(opcion != 0) {
          System.out.println("Opción inválida");
        }
      }
    } while (opcion != 0);
  }

  public void buscarVehiculos(String marca, int añoMin, int añoMax, int kmMax, double precioMin, double precioMax) throws IOException {
    boolean encontrado = false;
    for (Vehiculo v: stock) {
      boolean cumpleCriterio = true;
      if (marca != "") {
        if (!v.getMarca().equalsIgnoreCase(marca)) {
          cumpleCriterio = false;
        }
      }
      if (añoMin != -1 && añoMax != -1) {
        if (v.getAño() < añoMin || v.getAño() > añoMax) {
          cumpleCriterio = false;
        }
      }
      if (kmMax != -1) {
        if(v.getKm() > kmMax) {
          cumpleCriterio = false;
        }
      }
      if (precioMin != -1 && precioMax != -1) {
        if (v.getPrecio() < precioMin || v.getPrecio() > precioMax) {
          cumpleCriterio = false;
        }
      }
      if (cumpleCriterio) {
        v.mostrarDatos();
        encontrado = true;
      }
      cumpleCriterio = true;
    }
    if (!encontrado) {
      System.out.println("No se encontraron vehículos que cumplan los criterios de búsqueda");
    }
    System.out.println("Presiona ENTER para volver al menú de búsqueda");
    System.in.read();
  }

  // Pide al usuario el índice de un vehículo en el stock y lo elimina del stock y lo agrega a las ventas
  public void venderVehiculo() throws IOException {
    System.out.println("");
    int id;
    // Verificar si hay vehículos en el stock
    if (stock.isEmpty()) {
      System.out.println("No hay vehículos disponibles para vender");
    } else {
      // Mostrar el listado de vehículos disponibles con sus índices
      System.out.println("Listado de vehículos disponibles:");
      for (int i = 1; i-1 < stock.size(); i++) {
        System.out.println("ID: " + i);
        stock.get(i-1).mostrarDatos();
      }

      System.out.print("Ingrese el índice del vehículo que desea vender: ");
      id = sc.nextInt();

      // Verificar si el índice es válido
      if (id >= 1 && id-1 < stock.size()) {
        // Obtener el vehículo correspondiente al índice ingresado
        Vehiculo v = stock.get(id-1);

        // Eliminar el vehículo del stock y agregarlo a las ventas
        stock.remove(id-1);
        ventas.add(v);

        System.out.println("Vehículo vendido con éxito");
      } else {
        System.out.println("Índice inválido");
      }
    }
    System.out.println("");
    System.out.println("Presiona ENTER para volver al menú principal");
    System.in.read();
  }

  // Muestra el listado de los vehículos vendidos y el total recaudado por la concesionaria
  public void mostrarVentas() throws IOException {
    System.out.println("");
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
      System.out.println("");
      System.out.println("Presiona ENTER para volver al menú principal");
      System.in.read();
  }
}