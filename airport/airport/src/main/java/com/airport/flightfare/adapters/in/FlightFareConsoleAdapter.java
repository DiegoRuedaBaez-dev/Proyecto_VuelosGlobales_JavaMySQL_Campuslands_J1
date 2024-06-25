package com.airport.flightfare.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.flightfare.application.FlightFareService;
import com.airport.flightfare.domain.models.FlightFare;

public class FlightFareConsoleAdapter {
    private final FlightFareService flightFareService;

    public FlightFareConsoleAdapter(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Tarifa de Vuelo");
            System.out.println("2. Actualizar Tarifa de Vuelo");
            System.out.println("3. Buscar Tarifa de Vuelo por ID");
            System.out.println("4. Eliminar Tarifa de Vuelo");
            System.out.println("5. Listar todas las Tarifas de Vuelo");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la descripción de la tarifa: ");
                    String createDescription = scanner.nextLine();
                    System.out.print("Ingrese los detalles de la tarifa: ");
                    String createDetails = scanner.nextLine();
                    System.out.print("Ingrese el valor de la tarifa: ");
                    double createValue = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    FlightFare newFlightFare = new FlightFare(createDescription, createDetails, createValue);
                    flightFareService.createFlightFare(newFlightFare);
                    break;

                case 2:
                    System.out.print("Ingrese el ID de la tarifa a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese la nueva descripción de la tarifa: ");
                    String updateDescription = scanner.nextLine();
                    System.out.print("Ingrese los nuevos detalles de la tarifa: ");
                    String updateDetails = scanner.nextLine();
                    System.out.print("Ingrese el nuevo valor de la tarifa: ");
                    double updateValue = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    FlightFare updatedFlightFare = new FlightFare(updateId, updateDescription, updateDetails, updateValue);
                    flightFareService.updateFlightFare(updatedFlightFare);
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la tarifa a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<FlightFare> flightFare = flightFareService.getFlightFareById(findId);
                    flightFare.ifPresentOrElse(
                        ff -> System.out.println("ID: " + ff.getId() + ", Descripción: " + ff.getDescription() + ", Detalles: " + ff.getDetails() + ", Valor: " + ff.getValue()),
                        () -> System.out.println("Tarifa de vuelo no encontrada")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la tarifa a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    flightFareService.deleteFlightFare(deleteId);
                    break;

                case 5:
                    flightFareService.getAllFlightFares().forEach(ff -> {
                        System.out.println("ID: " + ff.getId() + ", Descripción: " + ff.getDescription() + ", Detalles: " + ff.getDetails() + ", Valor: " + ff.getValue());
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
