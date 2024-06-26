package com.airport.roles;
import java.util.Scanner;

import com.airport.plane.adapters.in.PlaneConsoleAdapter;
import com.airport.plane.adapters.out.PlaneMySQLRepository;
import com.airport.plane.application.PlaneService;
public class Admin {
    public static void admin() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("¿Qué desea realizar?:");
            System.out.println("1. Gestionar Aviones");
            System.out.println("2. Gestionar Vuelos");
            System.out.println("3. Gestionar Aeropuertos");
            System.out.println("4. Ingresar como Cliente");
            System.out.println("5. Salir");
            
            System.out.print("Opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (option) {
                case 1:     // Configuración de la conexión a la base de datos
                    String url = "jdbc:mysql://localhost:3306/airport"; // Reemplaza con la URL de tu base de datos
                    String user = "campus2023"; // Reemplaza con tu usuario de base de datos
                    String password = "campus2023"; // Reemplaza con tu contraseña de base de datos
                    
                    // Crear el repositorio y el servicio
                    PlaneMySQLRepository planeRepository = new PlaneMySQLRepository(url, user, password);
                    PlaneService planeService = new PlaneService(planeRepository);
                    
                    // Crear el adaptador de consola y empezar el menú
                    PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planeService);
                    planeConsoleAdapter.start();
                    break;
                case 2:
                    // Lógica para gestionar vuelos
                    break;
                case 3:
                    // Lógica para gestionar aeropuertos
                    break;
                case 4:
                    // Lógica para ingresar como cliente
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
}
