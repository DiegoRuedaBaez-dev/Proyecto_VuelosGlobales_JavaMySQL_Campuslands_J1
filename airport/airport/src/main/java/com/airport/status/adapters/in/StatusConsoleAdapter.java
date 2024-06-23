package com.airport.status.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.status.application.StatusService;
import com.airport.status.domain.models.Status;

public class StatusConsoleAdapter {
    private final StatusService statusService;

    public StatusConsoleAdapter(StatusService statusService) {
        this.statusService = statusService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Estado");
            System.out.println("2. Actualizar Estado");
            System.out.println("3. Buscar Estado por ID");
            System.out.println("4. Eliminar Estado");
            System.out.println("5. Listar todos los Estados");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del estado: ");
                    String createName = scanner.nextLine();

                    Status newStatus = new Status(createName);
                    statusService.createStatus(newStatus);
                    break;

                case 2:
                    System.out.print("Ingrese ID del estado a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo nombre del estado: ");
                    String updateName = scanner.nextLine();

                    Status updatedStatus = new Status(updateId, updateName);
                    statusService.updateStatus(updatedStatus);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del estado a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<Status> status = statusService.getStatusById(findId);
                    status.ifPresentOrElse(
                        s -> System.out.println("ID: " + s.getId() + ", Nombre: " + s.getName()),
                        () -> System.out.println("Estado no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del estado a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    statusService.deleteStatus(deleteId);
                    break;

                case 5:
                    statusService.getAllStatuses().forEach(s -> {
                        System.out.println("ID: " + s.getId() + ", Nombre: " + s.getName());
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
