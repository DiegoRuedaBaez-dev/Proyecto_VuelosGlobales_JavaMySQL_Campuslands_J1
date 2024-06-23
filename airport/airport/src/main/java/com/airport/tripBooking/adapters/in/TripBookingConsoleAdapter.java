package com.airport.tripBooking.adapters.in;

import java.util.Optional;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.airport.tripBooking.application.TripBookingService;
import com.airport.tripBooking.domain.models.TripBooking;

public class TripBookingConsoleAdapter {
    private final TripBookingService tripBookingService;

    public TripBookingConsoleAdapter(TripBookingService tripBookingService) {
        this.tripBookingService = tripBookingService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("1. Crear Reserva de Viaje");
            System.out.println("2. Actualizar Reserva de Viaje");
            System.out.println("3. Buscar Reserva de Viaje por ID");
            System.out.println("4. Eliminar Reserva de Viaje");
            System.out.println("5. Listar todas las Reservas de Viaje");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la fecha de la reserva (yyyy-MM-dd): ");
                    String createDateStr = scanner.nextLine();
                    LocalDate createDate = LocalDate.parse(createDateStr, dateFormatter);
                    System.out.print("Ingrese el ID del viaje: ");
                    int createTripId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    TripBooking newTripBooking = new TripBooking(createDate, createTripId);
                    tripBookingService.createTripBooking(newTripBooking);
                    break;

                case 2:
                    System.out.print("Ingrese ID de la reserva a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese la nueva fecha de la reserva (yyyy-MM-dd): ");
                    String updateDateStr = scanner.nextLine();
                    LocalDate updateDate = LocalDate.parse(updateDateStr, dateFormatter);
                    System.out.print("Ingrese el nuevo ID del viaje: ");
                    int updateTripId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    TripBooking updatedTripBooking = new TripBooking(updateId, updateDate, updateTripId);
                    tripBookingService.updateTripBooking(updatedTripBooking);
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la reserva a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<TripBooking> tripBooking = tripBookingService.getTripBookingById(findId);
                    tripBooking.ifPresentOrElse(
                        tb -> System.out.println("ID: " + tb.getId() + ", Fecha: " + tb.getDate() + ", ID Viaje: " + tb.getIdTrips()),
                        () -> System.out.println("Reserva de viaje no encontrada")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la reserva a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    tripBookingService.deleteTripBooking(deleteId);
                    break;

                case 5:
                    tripBookingService.getAllTripBookings().forEach(tb -> {
                        System.out.println("ID: " + tb.getId() + ", Fecha: " + tb.getDate() + ", ID Viaje: " + tb.getIdTrips());
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
