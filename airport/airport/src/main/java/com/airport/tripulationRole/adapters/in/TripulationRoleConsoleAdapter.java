package com.airport.tripulationRole.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.tripulationRole.application.TripulationRoleService;
import com.airport.tripulationRole.domain.models.TripulationRole;

public class TripulationRoleConsoleAdapter {
    private final TripulationRoleService tripulationRoleService;

    public TripulationRoleConsoleAdapter(TripulationRoleService tripulationRoleService) {
        this.tripulationRoleService = tripulationRoleService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Rol de Tripulación");
            System.out.println("2. Actualizar Rol de Tripulación");
            System.out.println("3. Buscar Rol de Tripulación por ID");
            System.out.println("4. Eliminar Rol de Tripulación");
            System.out.println("5. Listar todos los Roles de Tripulación");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del rol: ");
                    String createName = scanner.nextLine();

                    TripulationRole newTripulationRole = new TripulationRole(createName);
                    tripulationRoleService.createTripulationRole(newTripulationRole);
                    break;

                case 2:
                    System.out.print("Ingrese ID del rol a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo nombre del rol: ");
                    String updateName = scanner.nextLine();

                    TripulationRole updatedTripulationRole = new TripulationRole(updateId, updateName);
                    tripulationRoleService.updateTripulationRole(updatedTripulationRole);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del rol a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<TripulationRole> tripulationRole = tripulationRoleService.getTripulationRoleById(findId);
                    tripulationRole.ifPresentOrElse(
                        tr -> System.out.println("ID: " + tr.getId() + ", Nombre: " + tr.getName()),
                        () -> System.out.println("Rol de tripulación no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del rol a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    tripulationRoleService.deleteTripulationRole(deleteId);
                    break;

                case 5:
                    tripulationRoleService.getAllTripulationRoles().forEach(tr -> {
                        System.out.println("ID: " + tr.getId() + ", Nombre: " + tr.getName());
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
