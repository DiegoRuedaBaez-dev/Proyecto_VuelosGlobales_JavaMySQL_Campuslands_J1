package com.airport.tripcrew.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.tripcrew.application.TripCrewService;
import com.airport.tripcrew.domain.models.TripCrew;

public class TripCrewConsoleAdapter {
    private final TripCrewService tripCrewService;

    public TripCrewConsoleAdapter(TripCrewService tripCrewService) {
        this.tripCrewService = tripCrewService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        /*FIXME: 
            paso1: gaurdar un array con los ids de los empleados a asignar con el id de la conexion 
            pedir que ingrese todas las ids separadas por ","
            leerlo como string, separar el string por ","
            iterar por el array de partes, intentar convertir cada uno a un int
            si se puede convertir en 
            paso2: guardar en la bdd
           
         * 
        */

        while (true) {
            System.out.println("1. Crear Tripulación de Viaje");
            System.out.println("2. Actualizar Tripulación de Viaje");
            System.out.println("3. Buscar Tripulación de Viaje por ID");
            System.out.println("4. Eliminar Tripulación de Viaje");
            System.out.println("5. Listar todas las Tripulaciones de Viaje");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del empleado: ");
                    String createEmployeeId = scanner.nextLine();
                    System.out.print("Ingrese el ID de la conexión: ");
                    int createConnectionId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    TripCrew newTripCrew = new TripCrew(createEmployeeId, createConnectionId);
                    tripCrewService.createTripCrew(newTripCrew);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del empleado a actualizar: ");
                    String updateEmployeeId = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID de la conexión: ");
                    int updateConnectionId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    TripCrew updatedTripCrew = new TripCrew(updateEmployeeId, updateConnectionId);
                    tripCrewService.updateTripCrew(updatedTripCrew);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del empleado a buscar: ");
                    String findEmployeeId = scanner.nextLine();
                    System.out.print("Ingrese el ID de la conexión a buscar: ");
                    int findConnectionId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<TripCrew> tripCrew = tripCrewService.getTripCrewById(findEmployeeId, findConnectionId);
                    tripCrew.ifPresentOrElse(
                        tc -> System.out.println("ID Empleado: " + tc.getIdEmployees() + ", ID Conexión: " + tc.getIdConnection()),
                        () -> System.out.println("Tripulación de viaje no encontrada")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del empleado a borrar: ");
                    String deleteEmployeeId = scanner.nextLine();
                    System.out.print("Ingrese el ID de la conexión a borrar: ");
                    int deleteConnectionId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    tripCrewService.deleteTripCrew(deleteEmployeeId, deleteConnectionId);
                    break;

                case 5:
                    tripCrewService.getAllTripCrews().forEach(tc -> {
                        System.out.println("ID Empleado: " + tc.getIdEmployees() + ", ID Conexión: " + tc.getIdConnection());
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
