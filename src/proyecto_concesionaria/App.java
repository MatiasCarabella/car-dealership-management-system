package proyecto_concesionaria; // declaración de paquete

import java.util.Scanner; // importación para usar la clase Scanner

public class App {
    public static void main(String[] args) {
        // Requerimientos:
        // - Registrar vehículos con sus datos (marca, modelo, año, precio, etc.)
        // - Mostrar el listado de vehículos disponibles
        // - Buscar vehículos por marca o por rango de precio
        // - Vender vehículos y actualizar el stock
        // - Mostrar las ventas realizadas y el total recaudado
        Scanner sc = new Scanner(System.in); // objeto para leer datos por teclado
        String nombreConcesionaria; // el nombre que usaremos para crear la instancia de la clase Concesionaria

        System.out.println("Bienvenido. Por favor ingrese el nombre de su Concesionaria:");
        nombreConcesionaria = sc.nextLine();

        Concesionaria c = new Concesionaria(nombreConcesionaria); // instancia de la clase Concesionaria
        
        c.menu(); // llamada al método menu        

        sc.close(); // cerramos el scanner para liberar recursos, ya que no lo utilizaremos más en este método
    }
}
