package com.airport.roles;
import java.util.Scanner;

import com.airport.customer.adapters.in.CustomerConsoleAdapter;
import com.airport.customer.adapters.out.CustomerMySQLRepository;
import com.airport.customer.application.CustomerService;
import com.airport.documenttype.adapters.in.DocumentTypeConsoleAdapter;
import com.airport.documenttype.adapters.out.DocumentTypeMySQLRepository;
import com.airport.documenttype.application.DocumentTypeService;
import com.airport.flightfare.adapters.in.FlightFareConsoleAdapter;
import com.airport.flightfare.adapters.out.FlightFareMySQLRepository;
import com.airport.flightfare.application.FlightFareService;
import com.airport.trip.adapters.in.TripConsoleAdapter;
import com.airport.trip.adapters.out.TripMySQLRepository;
import com.airport.trip.application.TripService;
import com.airport.tripBooking.adapters.in.TripBookingConsoleAdapter;
import com.airport.tripBooking.adapters.out.TripBookingMySQLRepository;
import com.airport.tripBooking.application.TripBookingService;

public class Sales {
    public static void sales() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("¿Qué desea realizar?:");
            System.out.println("1. Gestionar Pasajeros");
            System.out.println("2. Gestionar Trayectos");
            System.out.println("3. Gestionar Reservas");
            System.out.println("4. Gestionar Documentos");
            System.out.println("5. Gestionar Tarifas");
            System.out.println("6. Salir");
            
            System.out.print("Opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 
            
            String url = "jdbc:mysql://localhost:3306/airport";
            String user = "campus2023";
            String password = "campus2023";

            switch (option) {
                case 1 -> {
                    CustomerMySQLRepository customerRepository = new CustomerMySQLRepository(url, user, password);
                    CustomerService customerService = new CustomerService(customerRepository);
                    CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);

                    customerConsoleAdapter.start();
                }
                case 3 -> {
                    TripBookingMySQLRepository tripBookingMySQLRepository = new TripBookingMySQLRepository(url, user, password);
                    TripBookingService tripBookingService = new TripBookingService(tripBookingMySQLRepository);
                    TripBookingConsoleAdapter tripBookingConsoleAdapter = new TripBookingConsoleAdapter(tripBookingService);

                    tripBookingConsoleAdapter.start();
                }
                case 2 -> {
                    TripMySQLRepository tripRepository = new TripMySQLRepository(url, user, password);
                    TripService tripService = new TripService(tripRepository);
                    TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);

                    tripConsoleAdapter.start();
                }
                case 4 -> {
                    DocumentTypeMySQLRepository documentTypeRepository = new DocumentTypeMySQLRepository(url, user, password);
                    DocumentTypeService documentTypeService = new DocumentTypeService(documentTypeRepository);
                    DocumentTypeConsoleAdapter documentTypeConsoleAdapter = new DocumentTypeConsoleAdapter(documentTypeService);
                    
                    documentTypeConsoleAdapter.start();
                }

                case 5 -> {
                    FlightFareMySQLRepository flightRepository = new FlightFareMySQLRepository(url, user, password);
                    FlightFareService flightFareService = new FlightFareService(flightRepository);
                    FlightFareConsoleAdapter flightFareConsoleAdapter = new FlightFareConsoleAdapter(flightFareService);

                    flightFareConsoleAdapter.start();
                }

                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
}
