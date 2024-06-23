package com.airport.tripBookingDetail.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.tripBookingDetail.application.TripBookingDetailService;
import com.airport.tripBookingDetail.domain.models.TripBookingDetail;

public class TripBookingDetailConsoleAdapter {
    private final TripBookingDetailService tripBookingDetailService;

    public TripBookingDetailConsoleAdapter(TripBookingDetailService tripBookingDetailService) {
        this.tripBookingDetailService = tripBookingDetailService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Detalle de Reserva de Viaje");
            System.out.println("2. Actualizar Detalle de Reserva de Viaje");
            System.out.println("3. Buscar Detalle de Reserva de Viaje por ID");
            System.out.println("4. Eliminar Detalle de Reserva de Viaje");
            System.out.println("5. Listar todos los Detalles de Reserva de Viaje");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID de la reserva de viaje: ");
                    int createTripBookingId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el ID del cliente: ");
                    String createCustomerId = scanner.nextLine();
                    System.out.print("Ingrese el ID de la tarifa: ");
                    int createFareId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    TripBookingDetail newTripBookingDetail = new TripBookingDetail(createTripBookingId, createCustomerId, createFareId);
                    tripBookingDetailService.createTripBookingDetail(newTripBookingDetail);
                    break;

                case 2:
                    System.out.print("Ingrese ID del detalle de reserva a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo ID de la reserva de viaje: ");
                    int updateTripBookingId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo ID del cliente: ");
                    String updateCustomerId = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID de la tarifa: ");
                    int updateFareId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    TripBookingDetail updatedTripBookingDetail = new TripBookingDetail(updateId, updateTripBookingId, updateCustomerId, updateFareId);
                    tripBookingDetailService.updateTripBookingDetail(updatedTripBookingDetail);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del detalle de reserva a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<TripBookingDetail> tripBookingDetail = tripBookingDetailService.getTripBookingDetailById(findId);
                    tripBookingDetail.ifPresentOrElse(
                        tbd -> System.out.println("ID: " + tbd.getId() + ", ID Reserva Viaje: " + tbd.getIdTripBooking() + ", ID Cliente: " + tbd.getIdCustomers() + ", ID Tarifa: " + tbd.getIdFares()),
                        () -> System.out.println("Detalle de reserva de viaje no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del detalle de reserva a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    tripBookingDetailService.deleteTripBookingDetail(deleteId);
                    break;

                case 5:
                    tripBookingDetailService.getAllTripBookingDetails().forEach(tbd -> {
                        System.out.println("ID: " + tbd.getId() + ", ID Reserva Viaje: " + tbd.getIdTripBooking() + ", ID Cliente: " + tbd.getIdCustomers() + ", ID Tarifa: " + tbd.getIdFares());
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
