package com.airport.roles;

import java.util.Scanner;

import com.airport.airport.adapters.in.AirportConsoleAdapter;
import com.airport.airport.adapters.out.AirportMySQLRepository;
import com.airport.airport.application.AirportService;
import com.airport.customer.adapters.in.CustomerConsoleAdapter;
import com.airport.customer.adapters.out.CustomerMySQLRepository;
import com.airport.customer.application.CustomerService;
import com.airport.documenttype.adapters.in.DocumentTypeConsoleAdapter;
import com.airport.documenttype.adapters.out.DocumentTypeMySQLRepository;
import com.airport.documenttype.application.DocumentTypeService;
import com.airport.flightconnection.adapters.in.FlightConnectionConsoleAdapter;
import com.airport.flightconnection.adapters.out.FlightConnectionMySQLRepository;
import com.airport.flightconnection.application.FlightConnectionService;
import com.airport.flightfare.adapters.in.FlightFareConsoleAdapter;
import com.airport.flightfare.adapters.out.FlightFareMySQLRepository;
import com.airport.flightfare.application.FlightFareService;
import com.airport.plane.adapters.in.PlaneConsoleAdapter;
import com.airport.plane.adapters.out.PlaneMySQLRepository;
import com.airport.plane.application.PlaneService;
import com.airport.trip.adapters.in.TripConsoleAdapter;
import com.airport.trip.adapters.out.TripMySQLRepository;
import com.airport.trip.application.TripService;

public class Admin {

    public static void admin() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("¿Qué desea realizar?:");
            System.out.println("1. Gestionar Aviones");
            System.out.println("2. Gestionar Aeropuertos");
            System.out.println("3. Gestionar Vuelos");
            System.out.println("4. Gestionar Pasajeros");
            System.out.println("5. Gestionar Tarifas");
            System.out.println("6. Gestionar Tipos de Documentos");
            System.out.println("7. Gestionar Escalas");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            String url = "jdbc:mysql://localhost:3306/airport";
            String user = "campus2023";
            String password = "campus2023";

            switch (option) {
                case 1 -> {
                    PlaneMySQLRepository planeRepository = new PlaneMySQLRepository(url, user, password);
                    PlaneService planeService = new PlaneService(planeRepository);
                    PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planeService);

                    planeConsoleAdapter.start();
                }
                case 2 -> {
                    AirportMySQLRepository airportRepository = new AirportMySQLRepository(url, user, password);
                    AirportService airportService = new AirportService(airportRepository);
                    AirportConsoleAdapter airportConsoleAdapter = new AirportConsoleAdapter(airportService);

                    airportConsoleAdapter.start();
                }
                case 3 -> {
                    TripMySQLRepository tripRepository = new TripMySQLRepository(url, user, password);
                    TripService tripService = new TripService(tripRepository);
                    TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);

                    tripConsoleAdapter.start();
                }
                case 4 -> {
                    CustomerMySQLRepository customerRepository = new CustomerMySQLRepository(url, user, password);
                    CustomerService customerService = new CustomerService(customerRepository);
                    CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);

                    customerConsoleAdapter.start();
                }

                case 5 -> {
                    FlightFareMySQLRepository flightRepository = new FlightFareMySQLRepository(url, user, password);
                    FlightFareService flightFareService = new FlightFareService(flightRepository);
                    FlightFareConsoleAdapter flightFareConsoleAdapter = new FlightFareConsoleAdapter(flightFareService);

                    flightFareConsoleAdapter.start();
                }

                case 6 -> {
                    DocumentTypeMySQLRepository documentTypeRepository = new DocumentTypeMySQLRepository(url, user, password);
                    DocumentTypeService documentTypeService = new DocumentTypeService(documentTypeRepository);
                    DocumentTypeConsoleAdapter documentTypeConsoleAdapter = new DocumentTypeConsoleAdapter(documentTypeService);

                    documentTypeConsoleAdapter.start();
                }

                case 7 -> {
                    FlightConnectionMySQLRepository flightConnectionRepository = new FlightConnectionMySQLRepository(url, user, password);
                    FlightConnectionService flightConnectionService = new FlightConnectionService(flightConnectionRepository);
                    FlightConnectionConsoleAdapter flightConnectionConsoleAdapter = new FlightConnectionConsoleAdapter(flightConnectionService);

                    flightConnectionConsoleAdapter.start();
                }

                case 8 -> System.out.println("Saliendo...");

                default -> System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
}
