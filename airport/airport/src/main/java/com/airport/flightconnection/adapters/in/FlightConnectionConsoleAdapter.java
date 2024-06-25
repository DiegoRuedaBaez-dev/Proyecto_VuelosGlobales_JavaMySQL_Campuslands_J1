package com.airport.flightconnection.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.flightconnection.application.FlightConnectionService;
import com.airport.flightconnection.domain.models.FlightConnection;

public class FlightConnectionConsoleAdapter {
    private final FlightConnectionService flightConnectionService;

    public FlightConnectionConsoleAdapter(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Conexión de Vuelo");
            System.out.println("2. Actualizar Conexión de Vuelo");
            System.out.println("3. Buscar Conexión de Vuelo por ID");
            System.out.println("4. Eliminar Conexión de Vuelo");
            System.out.println("5. Listar todas las Conexiones de Vuelo");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el número de conexión: ");
                    String createConnectionNumber = scanner.nextLine();
                    System.out.print("Ingrese el ID del viaje: ");
                    int createTripId = scanner.nextInt();
                    System.out.print("Ingrese el ID del avión: ");
                    int createPlaneId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el ID del aeropuerto: ");
                    String createAirportId = scanner.nextLine();
                    System.out.print("Ingrese el ID del estado del viaje: ");
                    int createTripStatusId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    FlightConnection newFlightConnection = new FlightConnection(createConnectionNumber, createTripId, createPlaneId, createAirportId, createTripStatusId);
                    flightConnectionService.createFlightConnection(newFlightConnection);
                    break;

                case 2:
                    System.out.print("Ingrese el ID de la conexión de vuelo a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo número de conexión: ");
                    String updateConnectionNumber = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del viaje: ");
                    int updateTripId = scanner.nextInt();
                    System.out.print("Ingrese el nuevo ID del avión: ");
                    int updatePlaneId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo ID del aeropuerto: ");
                    String updateAirportId = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del estado del viaje: ");
                    int updateTripStatusId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    FlightConnection updatedFlightConnection = new FlightConnection(updateId, updateConnectionNumber, updateTripId, updatePlaneId, updateAirportId, updateTripStatusId);
                    flightConnectionService.updateFlightConnection(updatedFlightConnection);
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la conexión de vuelo a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<FlightConnection> flightConnection = flightConnectionService.getFlightConnectionById(findId);
                    flightConnection.ifPresentOrElse(
                        fc -> System.out.println("ID: " + fc.getId() + ", Número de Conexión: " + fc.getConnectionNumber() + ", ID Viaje: " + fc.getIdTrip() + ", ID Avión: " + fc.getIdPlane() + ", ID Aeropuerto: " + fc.getIdAirport() + ", ID Estado del Viaje: " + fc.getIdTripStatus()),
                        () -> System.out.println("Conexión de vuelo no encontrada")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la conexión de vuelo a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    flightConnectionService.deleteFlightConnection(deleteId);
                    break;

                case 5:
                    flightConnectionService.getAllFlightConnections().forEach(fc -> {
                        System.out.println("ID: " + fc.getId() + ", Número de Conexión: " + fc.getConnectionNumber() + ", ID Viaje: " + fc.getIdTrip() + ", ID Avión: " + fc.getIdPlane() + ", ID Aeropuerto: " + fc.getIdAirport() + ", ID Estado del Viaje: " + fc.getIdTripStatus());
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

