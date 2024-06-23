package com.airport.trip.adapters.in;

import java.util.Optional;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.airport.trip.application.TripService;
import com.airport.trip.domain.models.Trip;

public class TripConsoleAdapter {
    private final TripService tripService;

    public TripConsoleAdapter(TripService tripService) {
        this.tripService = tripService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("1. Crear Viaje");
            System.out.println("2. Actualizar Viaje");
            System.out.println("3. Buscar Viaje por ID");
            System.out.println("4. Eliminar Viaje");
            System.out.println("5. Listar todos los Viajes");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la fecha del viaje (yyyy-MM-dd): ");
                    String createDateStr = scanner.nextLine();
                    LocalDate createDate = LocalDate.parse(createDateStr, dateFormatter);
                    System.out.print("Ingrese el precio del viaje: ");
                    double createPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Trip newTrip = new Trip(createDate, createPrice);
                    tripService.createTrip(newTrip);
                    break;

                case 2:
                    System.out.print("Ingrese ID del viaje a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese la nueva fecha del viaje (yyyy-MM-dd): ");
                    String updateDateStr = scanner.nextLine();
                    LocalDate updateDate = LocalDate.parse(updateDateStr, dateFormatter);
                    System.out.print("Ingrese el nuevo precio del viaje: ");
                    double updatePrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Trip updatedTrip = new Trip(updateId, updateDate, updatePrice);
                    tripService.updateTrip(updatedTrip);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del viaje a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<Trip> trip = tripService.getTripById(findId);
                    trip.ifPresentOrElse(
                        t -> System.out.println("ID: " + t.getId() + ", Fecha: " + t.getTripDate() + ", Precio: " + t.getPriceTrip()),
                        () -> System.out.println("Viaje no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del viaje a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    tripService.deleteTrip(deleteId);
                    break;

                case 5:
                    tripService.getAllTrips().forEach(t -> {
                        System.out.println("ID: " + t.getId() + ", Fecha: " + t.getTripDate() + ", Precio: " + t.getPriceTrip());
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
