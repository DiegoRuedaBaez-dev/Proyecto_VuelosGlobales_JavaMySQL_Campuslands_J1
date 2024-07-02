package com.airport.roles;

import java.util.Scanner;

import com.airport.customer.adapters.in.CustomerConsoleAdapter;
import com.airport.customer.adapters.out.CustomerMySQLRepository;
import com.airport.customer.application.CustomerService;
import com.airport.documenttype.adapters.in.DocumentTypeConsoleAdapter;
import com.airport.documenttype.adapters.out.DocumentTypeMySQLRepository;
import com.airport.documenttype.application.DocumentTypeService;
import com.airport.trip.adapters.in.TripConsoleAdapter;
import com.airport.trip.adapters.out.TripMySQLRepository;
import com.airport.trip.application.TripService;
import com.airport.tripBooking.adapters.in.TripBookingConsoleAdapter;
import com.airport.tripBooking.adapters.out.TripBookingMySQLRepository;
import com.airport.tripBooking.application.TripBookingService;

public class Sales {
    public static void sales(Scanner scanner) {
        int option = 0;
        boolean validInput;

        validInput = false;
        while (!validInput) {
            System.out.println("¿Qué desea realizar?:");
            System.out.println("1. Gestionar Pasajeros");
            System.out.println("2. Gestionar Trayectos");
            System.out.println("3. Gestionar Reservas");
            System.out.println("4. Gestionar Documentos");
            System.out.println("5. Salir");

            System.out.print("Opción: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                validInput = false;
            }
        }

        String url = "jdbc:mysql://localhost:3306/airport";
        String user = "campus2023";
        String password = "campus2023";

        switch (option) {
            case 1:
                CustomerMySQLRepository customerRepository = new CustomerMySQLRepository(url, user, password);
                CustomerService customerService = new CustomerService(customerRepository);
                CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);

                customerConsoleAdapter.start();
                break;
            case 3:
                TripBookingMySQLRepository tripBookingMySQLRepository = new TripBookingMySQLRepository(url, user,
                        password);
                TripBookingService tripBookingService = new TripBookingService(tripBookingMySQLRepository);
                TripBookingConsoleAdapter tripBookingConsoleAdapter = new TripBookingConsoleAdapter(tripBookingService);

                tripBookingConsoleAdapter.start();
                break;
            case 2:
                TripMySQLRepository tripRepository = new TripMySQLRepository(url, user, password);
                TripService tripService = new TripService(tripRepository);
                TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);

                tripConsoleAdapter.start();
                break;
            case 4:
                DocumentTypeMySQLRepository documentTypeRepository = new DocumentTypeMySQLRepository(url, user,
                        password);
                DocumentTypeService documentTypeService = new DocumentTypeService(documentTypeRepository);
                DocumentTypeConsoleAdapter documentTypeConsoleAdapter = new DocumentTypeConsoleAdapter(
                        documentTypeService);

                documentTypeConsoleAdapter.start();
                break;
            case 5:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, intenta de nuevo.");
        }
    }
}