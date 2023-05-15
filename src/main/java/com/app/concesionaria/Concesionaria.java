package main.java.com.app.concesionaria;

import java.io.IOException;
import java.util.ArrayList; // importación para usar la clase ArrayList
import java.util.Scanner; // importación para usar la clase Scanner

import main.java.com.app.vehiculo.Vehiculo; // importación para usar la clase Vehiculo
import main.java.com.app.cliente.Cliente; // importación para usar la clase Cliente
import main.java.com.app.venta.Venta; // importación para usar la clase Cliente

// Clase Concesionaria: representa al negocio que vende los vehículos
public class Concesionaria {

  // Atributos:
  private String nombre;
  private ArrayList < Vehiculo > stock; // lista de vehículos disponibles
  private ArrayList < Cliente > clientes; // Lista de clientes
  private ArrayList < Venta > ventas; // lista de ventas realizadas
  private Scanner sc; // objeto para leer datos por teclado

  // Constructor:
  public Concesionaria(String nombre) {
    this.nombre = nombre;
    stock = new ArrayList < Vehiculo > ();
    clientes = new ArrayList < Cliente > ();
    ventas = new ArrayList < Venta > ();
    sc = new Scanner(System.in);
  }

  // Métodos:

  // Muestra un menú de opciones al usuario y ejecuta la opción elegida
  public void menuPrincipal() throws IOException {
    int opcion;
    do {
      System.out.println("");
      System.out.println("¡Bienvenido a la concesionaria " + nombre +"!");
      System.out.println("Seleccione una opción:");
      System.out.println("1. Registrar un vehículo");
      System.out.println("2. Mostrar todos los vehículos disponibles");
      System.out.println("3. Buscar vehiculos");
      System.out.println("4. Registrar un cliente");
      System.out.println("5. Mostrar todos los clientes registrados");
      System.out.println("6. Registrar una venta");
      System.out.println("7. Mostrar las ventas realizadas y el total recaudado");
      System.out.println("0. Salir");
      
      // Validación del input del usuario
      while (!sc.hasNextInt()) {
        System.out.println("Opción inválida, por favor inténtalo nuevamente.");
        sc.next();
      }
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
        registrarCliente();
        break;
      case 5:
        mostrarClientes();
        break;
      case 6:
        registrarVenta();
        break;
      case 7:
        mostrarVentas();
        break;
      case 0:
        System.out.println("Gracias por utilizar el sistema de gestión de " + nombre + ". ¡Hasta pronto!");
        break;
      default:
        System.out.println("Opción inválida, por favor inténtalo nuevamente.");
      }
    } while (opcion != 0);
  }

  // Pide al usuario los datos de un vehículo y lo agrega al stock
  private void registrarVehiculo() {
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
  private void mostrarStock() throws IOException {
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

  private void menuBusqueda() throws IOException {
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
        if(!marca.isEmpty()) {
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
        System.out.println("5. Buscar vehículos");
      }
      System.out.println("0. Volver al menú principal");

      // Validación del input del usuario
      while (!sc.hasNextInt()) {
        System.out.println("Opción inválida, por favor inténtalo nuevamente.");
        sc.next();
      }
      opcion = sc.nextInt();

      switch (opcion) {
      case 1:
        sc.nextLine(); // limpiar el buffer del teclado
        System.out.print("Ingrese la MARCA que desea buscar: ");
        marca = sc.nextLine();
        criterio = true;
        break;
      case 2:
        System.out.print("Ingrese el AÑO MÍNIMO que desea buscar: ");
        añoMin = sc.nextInt();
        System.out.print("Ingrese el AÑO MÁXIMO que desea buscar: ");
        añoMax = sc.nextInt();
        criterio = true;
        break;
      case 3:
        System.out.print("Ingrese el KILOMETRAJE MÁXIMO que desea aceptar: ");
        kmMax = sc.nextInt();
        criterio = true;
        break;
      case 4:
        System.out.print("Ingrese el PRECIO MÍNIMO que desea buscar: ");
        precioMin = sc.nextDouble();
        System.out.print("Ingrese el PRECIO MÁXIMO que desea buscar: ");
        precioMax = sc.nextDouble();
        criterio = true;
        break;
      case 5:
        if(criterio) {
          buscarVehiculos(marca, añoMin, añoMax, kmMax, precioMin, precioMax);
        } else {
          System.out.println("Opción inválida, por favor inténtalo nuevamente.");
        }
        break;
      default:
        if(opcion != 0) {
          System.out.println("Opción inválida, por favor inténtalo nuevamente.");
        }
      }
    } while (opcion != 0);
  }

  private void buscarVehiculos(String marca, int añoMin, int añoMax, int kmMax, double precioMin, double precioMax) throws IOException {
    // Se crea un ArrayList para almacenar los vehículos que cumplan con los criterios de búsqueda
    ArrayList < Vehiculo > vehiculosEncontrados = new ArrayList < Vehiculo > ();

    // Se recorre el stock de vehículos para buscar los que cumplan con los criterios de búsqueda
    for (Vehiculo v : stock) {
        // Comprobamos si el vehículo cumple con el criterio de marca (si se ha especificado uno)
        if (!marca.isEmpty() && !v.getMarca().equalsIgnoreCase(marca)) {
            continue;
        }
        // Comprobamos si el vehículo cumple con el criterio de año (si se han especificado año mínimo y máximo)
        if (añoMin != -1 && añoMax != -1 && (v.getAño() < añoMin || v.getAño() > añoMax)) {
            continue;
        }
        // Comprobamos si el vehículo cumple con el criterio de kilometraje (si se ha especificado un máximo)
        if (kmMax != -1 && v.getKm() > kmMax) {
            continue;
        }
        // Comprobamos si el vehículo cumple con el criterio de precio (si se han especificado precio mínimo y máximo)
        if (precioMin != -1 && precioMax != -1 && (v.getPrecio() < precioMin || v.getPrecio() > precioMax)) {
            continue;
        }
        // Si llegamos hasta aquí el vehículo cumple con todos los criterios, entonces lo añadimos a la lista de vehículos encontrados
        vehiculosEncontrados.add(v);
    }

    if (!vehiculosEncontrados.isEmpty()) {
      for (Vehiculo v : vehiculosEncontrados) {
        v.mostrarDatos();
      }
    } else {
      System.out.println("No se encontraron vehículos que cumplan los criterios de búsqueda");
    }

    System.out.println("Presiona ENTER para volver al menú de búsqueda");
    System.in.read();
  }

  // Pide al usuario los datos de un cliente y lo agrega a la lista de clientes
  private void registrarCliente() {
    String nombre;
    int documento;

    sc.nextLine(); // limpiar el buffer del teclado
    System.out.print("Ingrese el nombre completo del cliente: ");
    nombre = sc.nextLine();

    System.out.print("Ingrese el número de documento del cliente: ");
    documento = sc.nextInt();

    // Crear un objeto de la clase Cliente con los datos ingresados
    Cliente c = new Cliente(nombre, documento);

    // Agregar el objeto a la lista de clientes
    clientes.add(c);

    System.out.println("Cliente registrado con éxito");
  }

  // Muestra el listado de clientes registrados
  private void mostrarClientes() throws IOException {
    System.out.println("");
    // Verificar si hay clientes registrados
    if (clientes.isEmpty()) {
      System.out.println("No hay clientes registrados");
    } else {
      System.out.println("Listado de clientes registrados:");
      // Recorrer la lista de clientes y mostrar los datos de cada cliente
      for (Cliente c: clientes) {
        c.mostrarDatos();
      }
    }
    System.out.println("Presiona ENTER para volver al menú principal");
    System.in.read();
  }

  // Pide al usuario el ID de un vehículo en el stock, luego lo elimina del stock y lo agrega a las ventas
  private void registrarVenta() throws IOException {
    System.out.println("");
    int idVehiculo;
    int idCliente;
    // Verificar si hay vehículos en el stock
    if (stock.isEmpty()) {
      System.out.println("No hay vehículos disponibles para vender");
    } else if (clientes.isEmpty()) {
      System.out.println("No hay clientes registrados para comprar");
    } else {
      // Mostrar el listado de vehículos disponibles con sus IDs
      System.out.println("Listado de vehículos disponibles:");
      for (int i = 1; i-1 < stock.size(); i++) {
        System.out.println("ID: " + i);
        stock.get(i-1).mostrarDatos();
      }

      System.out.print("Ingrese el ID del vehículo que desea vender: ");
      idVehiculo = sc.nextInt();

      // Verificar si el índice del vehículo es válido
      if (idVehiculo >= 1 && idVehiculo-1 < stock.size()) {
        System.out.println("");
        // Mostrar el listado de clientes registrados con sus IDs
        System.out.println("Listado de clientes registrados:");
        for (int i = 1; i-1 < clientes.size(); i++) {
          System.out.println("ID: " + i);
          clientes.get(i-1).mostrarDatos();
        }

        System.out.print("Ingrese el ID del cliente que realizará la compra: ");
        idCliente = sc.nextInt();

        // Verificar si el índice del vehículo es válido
        if (idCliente >= 1 && idCliente-1 < clientes.size()) {
          // Obtener el vehículo correspondiente al ID ingresado
          Vehiculo v = stock.get(idVehiculo-1);
          // Obtener el cliente correspondiente al ID ingresado
          Cliente c = clientes.get(idCliente-1);
          // Generar la Venta
          Venta venta = new Venta(v, c);
          // Agregar la Venta a la lista de ventas
          ventas.add(venta);
          // Eliminar el vehículo del stock y agregarlo a las ventas
          stock.remove(idVehiculo-1);
          // Agregar el vehículo a la lista de vehículos del cliente
          c.addVehiculo(v);

          System.out.println("Vehículo vendido con éxito");
        } else {
          System.out.println("ID de cliente inválido");
        }        
      } else {
        System.out.println("ID de vehículo inválido");
      }
    }
    System.out.println("");
    System.out.println("Presiona ENTER para volver al menú principal");
    System.in.read();
  }

  // Muestra el listado de los vehículos vendidos y el total recaudado por la concesionaria
  private void mostrarVentas() throws IOException {
    System.out.println("");
    double total = 0; // variable para acumular el total recaudado

    // Verificar si hay ventas realizadas
    if (ventas.isEmpty()) {
      System.out.println("No hay ventas realizadas");
    } else {
      System.out.println("Listado de ventas realizadas:");

      // Recorrer la lista de ventas y mostrar los datos de cada vehículo vendido y sumar su precio al total
      for (Venta v: ventas) {
        v.mostrarDatos();
        System.out.println("------------");
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