package main.java.com.app.concesionaria;

import java.io.IOException;
import java.util.ArrayList; // importación para usar la clase ArrayList
import java.util.Scanner; // importación para usar la clase Scanner

import main.java.com.app.vehiculo.auto.Auto; // importación para usar la clase Auto, sublcase de Vehiculo
import main.java.com.app.vehiculo.camioneta.Camioneta; // importación para usar la clase Camioneta, sublcase de Vehiculo
import main.java.com.app.vehiculo.moto.Moto; // importación para usar la clase Moto, sublcase de Vehiculo
import main.java.com.app.cliente.Cliente; // importación para usar la clase Cliente
import main.java.com.app.venta.Venta; // importación para usar la clase Cliente

// Clase Concesionaria: representa al negocio que vende los vehículos
public class Concesionaria {

  // Atributos:
  private String nombre;
  private ArrayList < Auto > autos; // lista de autos disponibles
  private ArrayList < Camioneta > camionetas; // lista de camionetas disponibles
  private ArrayList < Moto > motos; // lista de motos disponibles
  private ArrayList < Cliente > clientes; // Lista de clientes
  private ArrayList < Venta > ventas; // lista de ventas realizadas
  private Scanner sc; // objeto para leer datos por teclado

  // Constantes asociadas al número de opción en los menúes de selección de 'Tipo de vehículo'
  final int OPCION_AUTO = 1;
  final int OPCION_CAMIONETA = 2;
  final int OPCION_MOTO = 3;


  // Constructor:
  public Concesionaria(String nombre) {
    this.nombre = nombre;

    autos = new ArrayList < Auto > ();
    camionetas = new ArrayList < Camioneta > ();
    motos = new ArrayList < Moto > ();
    // Se pre-cargan un Vehículos de prueba
    autos.add(new Auto("Ford", "Fiesta", "Delantera", 2011, 75000, 10000));
    camionetas.add(new Camioneta("Toyota", "Hilux", 1000, 2002, 200000, 5000));
    motos.add(new Moto("Kawasaki", "Ninja", "296cc", 2012, 50000, 40000));

    clientes = new ArrayList < Cliente > ();
    // Se pre-cargan algunos Clientes de prueba
    clientes.add(new Cliente("Matias Carabella", 40676324));
    clientes.add(new Cliente("Pedro Pascal", 31918472));
    clientes.add(new Cliente("Sofía Ramirez", 21921582));

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
    int opcion;
    do {
      System.out.println("");
      System.out.println("¿Qué tipo de Vehículo deseas registrar?");
      System.out.println("Seleccione una opción:");
      System.out.println("1. Auto");
      System.out.println("2. Camioneta");
      System.out.println("3. Moto");
      
      // Validación del input del usuario
      while (!sc.hasNextInt()) {
        System.out.println("Opción inválida, por favor inténtalo nuevamente.");
        sc.next();
      }
      opcion = sc.nextInt();

        if(opcion != OPCION_AUTO && opcion != OPCION_CAMIONETA && opcion != OPCION_MOTO) {
          System.out.println("Opción inválida, por favor inténtalo nuevamente.");
        }
    } while (opcion != OPCION_AUTO && opcion != OPCION_CAMIONETA && opcion != OPCION_MOTO);

    String marca, modelo, traccion = "", cilindrada = "";
    int volumenDeCarga = 0, año, km;
    double precio;

    sc.nextLine(); // limpiar el buffer del teclado
    System.out.print("Ingrese la marca del vehículo: ");
    marca = sc.nextLine();

    System.out.print("Ingrese el modelo del vehículo: ");
    modelo = sc.nextLine();

    switch (opcion) {
      case OPCION_AUTO:
        System.out.print("Ingrese el tipo de tracción del auto: ");
        traccion = sc.nextLine();
        break;
      case OPCION_CAMIONETA:
        System.out.print("Ingrese el volumen de carga de la camioneta: ");
        volumenDeCarga = sc.nextInt();
        break;
      case OPCION_MOTO:
        System.out.print("Ingrese la cilindrada de la moto: ");
        cilindrada = sc.nextLine();
        break;
    }

    System.out.print("Ingrese el año del vehículo: ");
    año = sc.nextInt();

    System.out.print("Ingrese el kilometraje del vehículo: ");
    km = sc.nextInt();

    System.out.print("Ingrese el precio del vehículo: ");
    precio = sc.nextDouble();

    switch (opcion) {
      case OPCION_AUTO:
        autos.add(new Auto(marca, modelo, traccion, año, km, precio));
        break;
      case OPCION_CAMIONETA:
        camionetas.add(new Camioneta(marca, modelo, volumenDeCarga, año, km, precio));
        break;
      case OPCION_MOTO:
        motos.add(new Moto(marca, modelo, cilindrada, año, km, precio));
        break;
    }

    System.out.println("Vehículo registrado con éxito");
  }

  // Muestra el listado de vehículos disponibles en el stock
  private void mostrarStock() throws IOException {
    System.out.println("");
    // Verificar si hay vehículos en el stock
    if (autos.isEmpty() && camionetas.isEmpty() && motos.isEmpty()) {
      System.out.println("No hay vehículos disponibles");
    } else {
      System.out.println("Listado de vehículos disponibles:");
      if(!autos.isEmpty()) {
        System.out.println("AUTOS (" + Auto.cantidadDeAutos + "):");
        // Recorrer la lista de autos y mostrar los datos de cada Auto
        for (Auto a: autos) {
          a.mostrarDatos();
        }
      }
      if(!camionetas.isEmpty()) {
        System.out.println("CAMIONETAS (" + Camioneta.cantidadDeCamionetas + "):");
        // Recorrer la lista de camionetas y mostrar los datos de cada Camioneta
        for (Camioneta c: camionetas) {
          c.mostrarDatos();
        }
      }
      if(!motos.isEmpty()) {
        System.out.println("MOTOS (" + Moto.cantidadDeMotos + "):");
        // Recorrer la lista de motos y mostrar los datos de cada Moto
        for (Moto m: motos) {
          m.mostrarDatos();
        }
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
    int tipoVehiculo = 0, añoMin = -1, añoMax = -1, kmMax = -1;
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
        // Si 'tipoVehiculo' tiene un valor distinto al de inicialización, se muestra
        if (tipoVehiculo != 0) {
          switch (tipoVehiculo) {
            case 1:
              System.out.println("Tipo de vehículo: Auto");
              break;
            case 2:
              System.out.println("Tipo de vehículo: Camioneta");
              break;
            case 3:
              System.out.println("Tipo de vehículo: Moto");
              break;
          }
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
      System.out.println("2. Tipo de vehículo");
      System.out.println("3. Rango de años");
      System.out.println("4. Kilometraje menor a X");
      System.out.println("5. Rango de precio");
      if (criterio) {
        System.out.println("6. Buscar vehículos");
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
        do {
          System.out.println("");
          System.out.println("¿Qué tipo de Vehículo deseas buscar?");
          System.out.println("Seleccione una opción:");
          System.out.println("1. Auto");
          System.out.println("2. Camioneta");
          System.out.println("3. Moto");
          
          // Validación del input del usuario
          while (!sc.hasNextInt()) {
            System.out.println("Opción inválida, por favor inténtalo nuevamente.");
            sc.next();
          }
          tipoVehiculo = sc.nextInt();
    
            if(tipoVehiculo != OPCION_AUTO && tipoVehiculo != OPCION_CAMIONETA && tipoVehiculo != OPCION_MOTO) {
              System.out.println("Opción inválida, por favor inténtalo nuevamente.");
            }
        } while (tipoVehiculo != OPCION_AUTO && tipoVehiculo != OPCION_CAMIONETA && tipoVehiculo != OPCION_MOTO);
        criterio = true;
        break;
      case 3:
        System.out.print("Ingrese el AÑO MÍNIMO que desea buscar: ");
        añoMin = sc.nextInt();
        System.out.print("Ingrese el AÑO MÁXIMO que desea buscar: ");
        añoMax = sc.nextInt();
        criterio = true;
        break;
      case 4:
        System.out.print("Ingrese el KILOMETRAJE MÁXIMO que desea aceptar: ");
        kmMax = sc.nextInt();
        criterio = true;
        break;
      case 5:
        System.out.print("Ingrese el PRECIO MÍNIMO que desea buscar: ");
        precioMin = sc.nextDouble();
        System.out.print("Ingrese el PRECIO MÁXIMO que desea buscar: ");
        precioMax = sc.nextDouble();
        criterio = true;
        break;
      case 6:
        if(criterio) {
          buscarVehiculos(marca, tipoVehiculo, añoMin, añoMax, kmMax, precioMin, precioMax);
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

  private void buscarVehiculos(String marca, int tipoVehiculo, int añoMin, int añoMax, int kmMax, double precioMin, double precioMax) throws IOException {
    // Se crean ArrayLists para almacenar los vehículos que cumplan con los criterios de búsqueda
    ArrayList < Auto > autosEncontrados = new ArrayList < Auto > ();
    ArrayList < Camioneta > camionetasEncontradas = new ArrayList < Camioneta > ();
    ArrayList < Moto > motosEncontradas = new ArrayList < Moto > ();

    if(tipoVehiculo == 0 || tipoVehiculo == OPCION_AUTO) {
      // Se recorre el stock de autos para buscar los que cumplan con los criterios de búsqueda
      for (Auto a : autos) {
        // Comprobamos si el vehículo cumple con el criterio de marca (si se ha especificado uno)
        if (!marca.isEmpty() && !a.getMarca().equalsIgnoreCase(marca)) {
            continue;
        }
        // Comprobamos si el vehículo cumple con el criterio de año (si se han especificado año mínimo y máximo)
        if (añoMin != -1 && añoMax != -1 && (a.getAño() < añoMin || a.getAño() > añoMax)) {
            continue;
        }
        // Comprobamos si el vehículo cumple con el criterio de kilometraje (si se ha especificado un máximo)
        if (kmMax != -1 && a.getKm() > kmMax) {
            continue;
        }
        // Comprobamos si el vehículo cumple con el criterio de precio (si se han especificado precio mínimo y máximo)
        if (precioMin != -1 && precioMax != -1 && (a.getPrecio() < precioMin || a.getPrecio() > precioMax)) {
            continue;
        }
        // Si llegamos hasta aquí el vehículo cumple con todos los criterios, entonces lo añadimos a la lista de vehículos encontrados
        autosEncontrados.add(a);
      }
    }
    
    if(tipoVehiculo == 0 || tipoVehiculo == OPCION_CAMIONETA) {
      // Se recorre el stock de camionetas para buscar los que cumplan con los criterios de búsqueda
      for (Camioneta c : camionetas) {
        // Comprobamos si el vehículo cumple con el criterio de marca (si se ha especificado uno)
        if (!marca.isEmpty() && !c.getMarca().equalsIgnoreCase(marca)) {
            continue;
        }
        // Comprobamos si el vehículo cumple con el criterio de año (si se han especificado año mínimo y máximo)
        if (añoMin != -1 && añoMax != -1 && (c.getAño() < añoMin || c.getAño() > añoMax)) {
            continue;
        }
        // Comprobamos si el vehículo cumple con el criterio de kilometraje (si se ha especificado un máximo)
        if (kmMax != -1 && c.getKm() > kmMax) {
            continue;
        }
        // Comprobamos si el vehículo cumple con el criterio de precio (si se han especificado precio mínimo y máximo)
        if (precioMin != -1 && precioMax != -1 && (c.getPrecio() < precioMin || c.getPrecio() > precioMax)) {
            continue;
        }
        // Si llegamos hasta aquí el vehículo cumple con todos los criterios, entonces lo añadimos a la lista de vehículos encontrados
        camionetasEncontradas.add(c);
      }
    }
    

  
  if(tipoVehiculo == 0 || tipoVehiculo == OPCION_MOTO) {
    // Se recorre el stock de motos para buscar los que cumplan con los criterios de búsqueda
    for (Moto m : motos) {
      // Comprobamos si el vehículo cumple con el criterio de marca (si se ha especificado uno)
      if (!marca.isEmpty() && !m.getMarca().equalsIgnoreCase(marca)) {
          continue;
      }
      // Comprobamos si el vehículo cumple con el criterio de año (si se han especificado año mínimo y máximo)
      if (añoMin != -1 && añoMax != -1 && (m.getAño() < añoMin || m.getAño() > añoMax)) {
          continue;
      }
      // Comprobamos si el vehículo cumple con el criterio de kilometraje (si se ha especificado un máximo)
      if (kmMax != -1 && m.getKm() > kmMax) {
          continue;
      }
      // Comprobamos si el vehículo cumple con el criterio de precio (si se han especificado precio mínimo y máximo)
      if (precioMin != -1 && precioMax != -1 && (m.getPrecio() < precioMin || m.getPrecio() > precioMax)) {
          continue;
      }
      // Si llegamos hasta aquí el vehículo cumple con todos los criterios, entonces lo añadimos a la lista de vehículos encontrados
      motosEncontradas.add(m);
    }
  }

    if (!autosEncontrados.isEmpty() || !camionetasEncontradas.isEmpty() || !motosEncontradas.isEmpty()) {
      if (!autosEncontrados.isEmpty() ) {
        System.out.println("Autos:");
        for (Auto a : autosEncontrados) {
          a.mostrarDatos();
        }
      }

      if (!camionetasEncontradas.isEmpty() ) {
        System.out.println("Camionetas:");
        for (Camioneta c : camionetasEncontradas) {
          c.mostrarDatos();
        }
      }

      if (!motosEncontradas.isEmpty() ) {
        System.out.println("Motos:");
        for (Moto m : motosEncontradas) {
          m.mostrarDatos();
        }
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
    if (autos.isEmpty() && camionetas.isEmpty() && motos.isEmpty()) {
      System.out.println("No hay vehículos disponibles para vender");
    } else if (clientes.isEmpty()) {
      System.out.println("No hay clientes registrados para comprar");
    } else {
      int opcion;
      do {
        System.out.println("");
        System.out.println("¿Qué tipo de Vehículo deseas vender?");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Auto");
        System.out.println("2. Camioneta");
        System.out.println("3. Moto");
        
        // Validación del input del usuario
        while (!sc.hasNextInt()) {
          System.out.println("Opción inválida, por favor inténtalo nuevamente.");
          sc.next();
        }
        opcion = sc.nextInt();

          if(opcion != OPCION_AUTO && opcion != OPCION_CAMIONETA && opcion != OPCION_MOTO) {
            System.out.println("Opción inválida, por favor inténtalo nuevamente.");
          }
      } while (opcion != OPCION_AUTO && opcion != OPCION_CAMIONETA && opcion != OPCION_MOTO);

      switch (opcion) {
        case OPCION_AUTO:
          // Mostrar el listado de vehículos disponibles con sus IDs
          System.out.println("Listado de autos disponibles:");
          for (int i = 1; i-1 < autos.size(); i++) {
            System.out.println("ID: " + i);
            autos.get(i-1).mostrarDatos();
          }

          System.out.print("Ingrese el ID del auto que desea vender: ");
          idVehiculo = sc.nextInt();

          // Verificar si el índice del vehículo es válido
          if (idVehiculo >= 1 && idVehiculo-1 < autos.size()) {
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
              Auto a = autos.get(idVehiculo-1);
              // Obtener el cliente correspondiente al ID ingresado
              Cliente c = clientes.get(idCliente-1);
              // Generar la Venta
              Venta venta = new Venta(a, c);
              // Agregar la Venta a la lista de ventas
              ventas.add(venta);
              // Eliminar el vehículo del stock y agregarlo a las ventas
              autos.remove(idVehiculo-1);
              Auto.cantidadDeAutos--;
              // Agregar el vehículo a la lista de vehículos del cliente
              c.addAuto(a);

              System.out.println("Auto vendido con éxito");
            } else {
              System.out.println("ID de cliente inválido");
            }        
          } else {
            System.out.println("ID de vehículo inválido");
          }
          break;
        case OPCION_CAMIONETA:
          // Mostrar el listado de vehículos disponibles con sus IDs
          System.out.println("Listado de autos disponibles:");
          for (int i = 1; i-1 < camionetas.size(); i++) {
            System.out.println("ID: " + i);
            camionetas.get(i-1).mostrarDatos();
          }

          System.out.print("Ingrese el ID de la camioneta que desea vender: ");
          idVehiculo = sc.nextInt();

          // Verificar si el índice del vehículo es válido
          if (idVehiculo >= 1 && idVehiculo-1 < camionetas.size()) {
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
              Camioneta v = camionetas.get(idVehiculo-1);
              // Obtener el cliente correspondiente al ID ingresado
              Cliente c = clientes.get(idCliente-1);
              // Generar la Venta
              Venta venta = new Venta(v, c);
              // Agregar la Venta a la lista de ventas
              ventas.add(venta);
              // Eliminar el vehículo del stock y agregarlo a las ventas
              camionetas.remove(idVehiculo-1);
              Camioneta.cantidadDeCamionetas--;
              // Agregar el vehículo a la lista de vehículos del cliente
              c.addCamioneta(v);

              System.out.println("Camioneta vendida con éxito");
            } else {
              System.out.println("ID de cliente inválido");
            }        
          } else {
            System.out.println("ID de vehículo inválido");
          }
          break;
        case OPCION_MOTO:
          // Mostrar el listado de vehículos disponibles con sus IDs
          System.out.println("Listado de motos disponibles:");
          for (int i = 1; i-1 < motos.size(); i++) {
            System.out.println("ID: " + i);
            motos.get(i-1).mostrarDatos();
          }

          System.out.print("Ingrese el ID de la moto que desea vender: ");
          idVehiculo = sc.nextInt();

          // Verificar si el índice del vehículo es válido
          if (idVehiculo >= 1 && idVehiculo-1 < motos.size()) {
            System.out.println("");
            // Mostrar el listado de clientes registrados con sus IDs
            System.out.println("Listado de clientes registrados:");
            for (int i = 1; i-1 < motos.size(); i++) {
              System.out.println("ID: " + i);
              motos.get(i-1).mostrarDatos();
            }

            System.out.print("Ingrese el ID del cliente que realizará la compra: ");
            idCliente = sc.nextInt();

            // Verificar si el índice del vehículo es válido
            if (idCliente >= 1 && idCliente-1 < clientes.size()) {
              // Obtener el vehículo correspondiente al ID ingresado
              Moto m = motos.get(idVehiculo-1);
              // Obtener el cliente correspondiente al ID ingresado
              Cliente c = clientes.get(idCliente-1);
              // Generar la Venta
              Venta venta = new Venta(m, c);
              // Agregar la Venta a la lista de ventas
              ventas.add(venta);
              // Eliminar el vehículo del stock y agregarlo a las ventas
              motos.remove(idVehiculo-1);
              Moto.cantidadDeMotos--;
              // Agregar el vehículo a la lista de vehículos del cliente
              c.addMoto(m);

              System.out.println("Moto vendida con éxito");
            } else {
              System.out.println("ID de cliente inválido");
            }        
          } else {
            System.out.println("ID de vehículo inválido");
          }
          break;
        }
        
    }
      
    System.out.println("");
    System.out.println("Presiona ENTER para volver al menú principal");
    System.in.read();
  }

  // Muestra el listado de los vehículos vendidos y el total recaudado por la concesionaria
  private void mostrarVentas() throws IOException {
    System.out.println("");
    // Verificar si hay ventas realizadas
    if (ventas.isEmpty()) {
      System.out.println("No hay ventas realizadas");
    } else {
      System.out.println("Listado de ventas realizadas:");

      // Recorrer la lista de ventas y mostrar los datos de cada vehículo vendido y sumar su precio al total
      for (Venta v: ventas) {
        v.mostrarDatos();
        System.out.println("------------");
      }

      // Mostrar el total recaudado por la concesionaria (variable estática de la Clase Venta)
      System.out.println("Total recaudado: $" + Venta.totalVentas);
    }
      System.out.println("");
      System.out.println("Presiona ENTER para volver al menú principal");
      System.in.read();
  }
}