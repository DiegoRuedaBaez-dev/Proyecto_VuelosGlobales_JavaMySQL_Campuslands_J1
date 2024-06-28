package com.airport.flight.adapters.in;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.airport.flight.domain.models.Flight;
import com.airport.flight.infrastructure.FlightService;

public class FlightSearchConsoleAdapter {
    private final FlightService flightService;

    public FlightSearchConsoleAdapter(FlightService flightService) {
        this.flightService = flightService;
    }

    public List<Flight> start() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Buscar Vuelos");

        System.out.print("Ingrese la ciudad de origen: ");
        String originCity = scanner.nextLine();

        System.out.print("Ingrese la ciudad de destino: ");
        String destinationCity = scanner.nextLine();

        System.out.print("Ingrese la fecha de salida (yyyy-MM-dd): ");
        String departureDateStr = scanner.nextLine();
        LocalDate departureDate = LocalDate.parse(departureDateStr, dateFormatter);

        System.out.print("Ingrese la fecha de regreso (opcional, yyyy-MM-dd): ");
        String returnDateStr = scanner.nextLine();
        LocalDate returnDate = returnDateStr.isEmpty() ? null : LocalDate.parse(returnDateStr, dateFormatter);

        List<Flight> availableFlights = flightService.searchFlights(originCity, destinationCity, departureDate, returnDate);

        if (availableFlights.isEmpty()) {
            System.out.println("No se encontraron vuelos disponibles.");
        } else {
            System.out.println("Vuelos disponibles:");
            availableFlights.forEach(flight -> {
                System.out.println("ID: " + flight.getId() + ", Número de Conexión: " + flight.getConnectionNumber() + 
                                   ", ID Viaje: " + flight.getIdTrip() + ", ID Avión: " + flight.getIdPlane() + 
                                   ", ID Aeropuerto: " + flight.getIdAirport() + ", ID Estado del Viaje: " + flight.getIdTripStatus());
            });
        }
        return availableFlights;
    }
}
