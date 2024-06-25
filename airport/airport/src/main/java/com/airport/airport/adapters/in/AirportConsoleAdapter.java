package com.airport.airport.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.airport.application.AirportService;
import com.airport.airport.domain.models.Airport;

public class AirportConsoleAdapter {
    private final AirportService airportService;

    public AirportConsoleAdapter(AirportService airportService) {
        this.airportService = airportService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Aeropuerto");
            System.out.println("2. Actualizar Aeropuerto");
            System.out.println("3. Buscar Aeropuerto por ID");
            System.out.println("4. Eliminar Aeropuerto");
            System.out.println("5. Listar todos los Aeropuertos");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del aeropuerto: ");
                    String createId = scanner.nextLine();
                    System.out.print("Ingrese el nombre del aeropuerto: ");
                    String createName = scanner.nextLine();
                    System.out.print("Ingrese el ID de la ciudad: ");
                    String createIdCity = scanner.nextLine();
                    Airport newAirport = new Airport(createId, createName, createIdCity);
                    airportService.createAirport(newAirport);
                    break;

                case 2:
                    System.out.print("Ingrese ID del aeropuerto a actualizar: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID de la ciudad: ");
                    String updateIdCity = scanner.nextLine();
                    Airport updatedAirport = new Airport(updateId, updateName, updateIdCity);
                    airportService.updateAirport(updatedAirport);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del aeropuerto a buscar: ");
                    String findId = scanner.nextLine();

                    Optional<Airport> airport = airportService.getAirportById(findId);
                    airport.ifPresentOrElse(
                        a -> System.out.println("ID: " + a.getId() + ", Nombre: " + a.getName() + ", ID Ciudad: " + a.getIdCity()),
                        () -> System.out.println("Aeropuerto no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del aeropuerto a borrar: ");
                    String deleteId = scanner.nextLine();
                    airportService.deleteAirport(deleteId);
                    break;

                case 5:
                    airportService.getAllAirports().forEach(a -> {
                        System.out.println("ID: " + a.getId() + ", Nombre: " + a.getName() + ", ID Ciudad: " + a.getIdCity());
                    });
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }
}
