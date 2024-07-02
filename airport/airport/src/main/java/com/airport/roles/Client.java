package com.airport.roles;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.airport.customer.domain.models.Customer;
import com.airport.flight.adapters.in.FlightSearchConsoleAdapter;
import com.airport.flight.adapters.out.FlightServiceImpl;
import com.airport.flight.domain.models.Flight;
import com.airport.flight.infrastructure.FlightService;

public class Client {
    private static final FlightService flightService = new FlightServiceImpl();
    private static final FlightSearchConsoleAdapter flightSearchConsoleAdapter = new FlightSearchConsoleAdapter(
            flightService);
    private static List<Flight> availableFlights;
    private static Flight selectedFlight;
    private static List<Customer> passengers = new ArrayList<>();

    public static void client(Scanner scanner) {
        boolean validInput = false;
        String input;
        int choice = 0;

        while (true) {
            while (!validInput) {

                System.out.println("Seleccione una opción:");
                System.out.println("1. Buscar Vuelos");
                System.out.println("2. Seleccionar Vuelo");
                System.out.println("3. Añadir Pasajeros");
                System.out.println("4. Seleccionar Asientos");
                System.out.println("5. Realizar Pago");
                System.out.println("6. Consultar Reserva de Vuelo");
                System.out.println("7. Cancelar Reserva de Vuelo");
                System.out.println("8. Modificar Reserva de Vuelo");
                System.out.println("9. Salir");
                input = scanner.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    validInput = true;
                } catch (Exception e) {
                    validInput = false;
                }
            }

            switch (choice) {
                case 1:

                    availableFlights = flightSearchConsoleAdapter.start();
                    break;
                case 2:

                    if (availableFlights == null || availableFlights.isEmpty()) {
                        System.out.println("Debe realizar una búsqueda de vuelos antes de seleccionar uno.");
                    } else {
                        selectFlight(scanner);
                    }
                    break;
                case 3:

                    if (selectedFlight == null) {
                        System.out.println("Debe seleccionar un vuelo antes de añadir pasajeros.");
                    } else {
                        addPassengers(scanner);
                    }
                    break;
                case 4:

                    if (passengers.isEmpty()) {
                        System.out.println("Debe añadir los datos de los pasajeros antes de seleccionar asientos.");
                    } else {
                        selectSeats(scanner);
                    }
                    break;
                case 5:

                    makePayment(scanner);
                    break;
                case 6:

                    consultReservation(scanner);
                    break;
                case 7:

                    cancelReservation(scanner);
                    break;
                case 8:

                    modifyReservation(scanner);
                    break;
                case 9:
                    System.out.println("Gracias por usar el sistema de búsqueda de vuelos. ¡Adiós!");
                    return;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    private static void selectFlight(Scanner scanner) {
        System.out.println("Seleccione el ID del vuelo de la lista disponible:");

        availableFlights.forEach(flight -> {
            System.out.println("ID: " + flight.getId() + ", Número de Conexión: " + flight.getConnectionNumber() +
                    ", ID Viaje: " + flight.getIdTrip() + ", ID Avión: " + flight.getIdPlane() +
                    ", ID Aeropuerto: " + flight.getIdAirport() + ", ID Estado del Viaje: " + flight.getIdTripStatus());
        });
        boolean validInput = false;
        int in = 0;
        while (!validInput) {
            try {
                in = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                validInput = false;
            }
        }
        final int flightId = in;
        selectedFlight = availableFlights.stream()
                .filter(flight -> flight.getId() == flightId)
                .findFirst()
                .orElse(null);

        if (selectedFlight == null) {
            System.out.println("El vuelo seleccionado no está disponible. Por favor, intente de nuevo.");
        } else {
            System.out.println("Detalles del vuelo seleccionado:");
            System.out.println("ID: " + selectedFlight.getId());
            System.out.println("Número de Conexión: " + selectedFlight.getConnectionNumber());
            System.out.println("ID Viaje: " + selectedFlight.getIdTrip());
            System.out.println("ID Avión: " + selectedFlight.getIdPlane());
            System.out.println("ID Aeropuerto: " + selectedFlight.getIdAirport());
            System.out.println("ID Estado del Viaje: " + selectedFlight.getIdTripStatus());

            System.out.print("¿Desea confirmar la selección del vuelo? (S/N): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("S")) {
                System.out.println("El vuelo ha sido seleccionado y almacenado en su sesión.");
            } else {
                System.out.println("La selección del vuelo ha sido cancelada.");
            }
        }
    }

    private static void addPassengers(Scanner scanner) {
        System.out.println("Añadir Pasajeros:");
        boolean validInput = false;
        int in;
        while (true) {
            System.out.print("Ingrese un id para el pasajero: ");
            String id = scanner.nextLine();

            System.out.print("Ingrese el nombre del pasajero: ");
            String name = scanner.nextLine();

            validInput = false;
            int age = 0;
            while (!validInput) {
                System.out.print("Ingrese la edad del pasajero: ");

                try {
                    age = Integer.parseInt(scanner.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    validInput = false;
                }
            }

            int documentNumber = 0;
            validInput = false;
            while (!validInput) {
                System.out.print("Ingrese el número de documento del pasajero: ");
                try {
                    documentNumber = Integer.parseInt(scanner.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    validInput = false;
                }
            }

            if (name.isEmpty() || id.isEmpty()) {
                System.out.println("Todos los campos son obligatorios. Por favor, intente de nuevo.");
            } else {
                passengers.add(new Customer(id, name, age, documentNumber));
                System.out.println("Pasajero añadido.");

                System.out.print("¿Desea añadir otro pasajero? (S/N): ");
                String another = scanner.nextLine();

                if (!another.equalsIgnoreCase("S")) {
                    break;
                }
            }
        }

        System.out.println("Todos los pasajeros han sido añadidos y guardados en la sesión.");
    }

    private static void selectSeats(Scanner scanner) {
        System.out.println("Seleccione Asientos:");

        for (Customer passenger : passengers) {
            System.out.println("Seleccionando asiento para: " + passenger.getName());

            System.out.print("Ingrese el número de asiento: ");
            String seatNumber = scanner.nextLine();

            System.out.println("Ha seleccionado el asiento " + seatNumber);
        }

        System.out.println("Todos los asientos han sido seleccionados y guardados en la sesión.");
    }

    @SuppressWarnings("unused")
    private static void makePayment(Scanner scanner) {
        System.out.println("Realizar Pago:");

        System.out.print("Ingrese el método de pago (e.g., Tarjeta de Crédito): ");
        String paymentMethod = scanner.nextLine();

        System.out.print("Ingrese la información de la tarjeta (número, fecha de vencimiento, CVV): ");
        String cardInfo = scanner.nextLine();

        System.out.println("Procesando el pago...");

        boolean paymentSuccessful = true;

        if (paymentSuccessful) {
            System.out.println("El pago ha sido exitoso y la reserva ha sido confirmada.");
        } else {
            System.out.println("El pago no fue exitoso. Por favor, intente de nuevo.");
        }
    }

    private static void consultReservation(Scanner scanner) {
        int reservationId = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Ingrese el ID de la reserva:");

            try {
                reservationId = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                validInput = false;
            }
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT tb.id AS BookingID, tb.date AS BookingDate, t.trip_date AS TripDate, " +
                                "t.price_tripe AS TripPrice, c.name AS CustomerName, ff.description AS FareDescription, "
                                +
                                "ff.value AS FareValue " +
                                "FROM trip_booking tb " +
                                "JOIN trips t ON tb.id_trips = t.id " +
                                "JOIN trip_booking_details tbd ON tbd.id_trip_booking = tb.id " +
                                "JOIN customers c ON tbd.id_customers = c.id " +
                                "JOIN flight_fares ff ON tbd.id_fares = ff.id " +
                                "WHERE tb.id = ?")) {

            stmt.setInt(1, reservationId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Booking ID: " + rs.getInt("BookingID"));
                System.out.println("Booking Date: " + rs.getDate("BookingDate"));
                System.out.println("Trip Date: " + rs.getDate("TripDate"));
                System.out.println("Trip Price: " + rs.getDouble("TripPrice"));
                System.out.println("Customer Name: " + rs.getString("CustomerName"));
                System.out.println("Fare Description: " + rs.getString("FareDescription"));
                System.out.println("Fare Value: " + rs.getDouble("FareValue"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void cancelReservation(Scanner scanner) {
        int reservationId = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Ingrese el ID de la reserva a cancelar:");
            try {
                reservationId = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                validInput = false;
            }
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM trip_booking WHERE id = ?")) {

            stmt.setInt(1, reservationId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Reserva cancelada exitosamente.");
            } else {
                System.out.println("No se encontró la reserva con el ID proporcionado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void modifyReservation(Scanner scanner) {
        int reservationId = 0;

        boolean validInput = false;
        while (!validInput) {

            System.out.println("Ingrese el ID de la reserva a modificar:");

            try {
                reservationId = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                validInput = false;
            }
        }

        System.out.println("Ingrese la nueva fecha de la reserva (YYYY-MM-DD):");
        String newDate = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement stmt = conn.prepareStatement("UPDATE trip_booking SET date = ? WHERE id = ?")) {

            stmt.setDate(1, Date.valueOf(newDate));
            stmt.setInt(2, reservationId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Reserva modificada exitosamente.");
            } else {
                System.out.println("No se encontró la reserva con el ID proporcionado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static final String DB_URL = "jdbc:mysql://localhost:3306/airport";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";
}