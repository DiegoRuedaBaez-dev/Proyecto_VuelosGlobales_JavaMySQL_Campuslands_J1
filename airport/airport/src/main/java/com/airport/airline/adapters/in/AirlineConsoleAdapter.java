package com.airport.airline.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.airline.application.AirlineService;
import com.airport.airline.domain.models.Airline;

public class AirlineConsoleAdapter {
    private final AirlineService airlineService;

    public AirlineConsoleAdapter(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Aerolínea");
            System.out.println("2. Actualizar Aerolínea");
            System.out.println("3. Buscar Aerolínea por ID");
            System.out.println("4. Eliminar Aerolínea");
            System.out.println("5. Listar todas las Aerolíneas");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre de la aerolínea: ");
                    String createName = scanner.nextLine();
                    Airline newAirline = new Airline(createName);
                    airlineService.createAirline(newAirline);
                    break;

                case 2:
                    System.out.print("Ingrese ID de la aerolínea a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo nombre: ");
                    String updateName = scanner.nextLine();
                    Airline updatedAirline = new Airline(updateId, updateName);
                    airlineService.updateAirline(updatedAirline);
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la aerolínea a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<Airline> airline = airlineService.getAirlineById(findId);
                    airline.ifPresentOrElse(
                        a -> System.out.println("ID: " + a.getId() + ", Nombre: " + a.getName()),
                        () -> System.out.println("Aerolínea no encontrada")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la aerolínea a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    airlineService.deleteAirline(deleteId);
                    break;

                case 5:
                    airlineService.getAllAirlines().forEach(a -> {
                        System.out.println("ID: " + a.getId() + ", Nombre: " + a.getName());
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
