package com.airport.roles;

import java.util.Scanner;

import com.airport.airport.adapters.in.AirportConsoleAdapter;
import com.airport.airport.adapters.out.AirportMySQLRepository;
import com.airport.airport.application.AirportService;
import com.airport.customer.adapters.in.CustomerConsoleAdapter;
import com.airport.customer.adapters.out.CustomerMySQLRepository;
import com.airport.customer.application.CustomerService;
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
    public static void admin(Scanner scanner) {
        boolean validInput = false;
        int option = 0;

            validInput = false;
            while (!validInput) {
                System.out.println("¿Qué desea realizar?:");
                System.out.println("1. Gestionar Aviones");
                System.out.println("2. Gestionar Aeropuertos");
                System.out.println("3. Gestionar Vuelos");
                System.out.println("4. Gestionar Pasajeros");
                System.out.println("5. Gestionar Tarifas");
                System.out.println("6. Salir");
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
                    PlaneMySQLRepository planeRepository = new PlaneMySQLRepository(url, user, password);
                    PlaneService planeService = new PlaneService(planeRepository);
                    PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planeService);

                    planeConsoleAdapter.start();
                    break;
                case 2:
                    AirportMySQLRepository airportRepository = new AirportMySQLRepository(url, user, password);
                    AirportService airportService = new AirportService(airportRepository);
                    AirportConsoleAdapter airportConsoleAdapter = new AirportConsoleAdapter(airportService);

                    airportConsoleAdapter.start();
                    break;
                case 3:
                    TripMySQLRepository tripRepository = new TripMySQLRepository(url, user, password);
                    TripService tripService = new TripService(tripRepository);
                    TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);

                    tripConsoleAdapter.start();
                    break;
                case 4:
                    CustomerMySQLRepository customerRepository = new CustomerMySQLRepository(url, user, password);
                    CustomerService customerService = new CustomerService(customerRepository);
                    CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);

                    customerConsoleAdapter.start();
                    break;

                case 5:
                    FlightFareMySQLRepository flightRepository = new FlightFareMySQLRepository(url, user, password);
                    FlightFareService flightFareService = new FlightFareService(flightRepository);
                    FlightFareConsoleAdapter flightFareConsoleAdapter = new FlightFareConsoleAdapter(flightFareService);

                    flightFareConsoleAdapter.start();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        
    }
}