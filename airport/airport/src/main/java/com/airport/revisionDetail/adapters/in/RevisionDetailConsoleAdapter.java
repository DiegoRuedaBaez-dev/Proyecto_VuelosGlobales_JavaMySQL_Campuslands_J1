package com.airport.revisionDetail.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.revisionDetail.application.RevisionDetailService;
import com.airport.revisionDetail.domain.models.RevisionDetail;

public class RevisionDetailConsoleAdapter {
    private final RevisionDetailService revisionDetailService;

    public RevisionDetailConsoleAdapter(RevisionDetailService revisionDetailService) {
        this.revisionDetailService = revisionDetailService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Detalle de Revisión");
            System.out.println("2. Actualizar Detalle de Revisión");
            System.out.println("3. Buscar Detalle de Revisión por ID");
            System.out.println("4. Eliminar Detalle de Revisión");
            System.out.println("5. Listar todos los Detalles de Revisión");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la descripción de la revisión: ");
                    String createDescription = scanner.nextLine();
                    System.out.print("Ingrese el ID del empleado: ");
                    String createEmployeeId = scanner.nextLine();

                    RevisionDetail newRevisionDetail = new RevisionDetail(createDescription, createEmployeeId);
                    revisionDetailService.createRevisionDetail(newRevisionDetail);
                    break;

                case 2:
                    System.out.print("Ingrese ID del detalle de revisión a actualizar: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Ingrese la nueva descripción: ");
                    String updateDescription = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del empleado: ");
                    String updateEmployeeId = scanner.nextLine();

                    RevisionDetail updatedRevisionDetail = new RevisionDetail(updateId, updateDescription, updateEmployeeId);
                    revisionDetailService.updateRevisionDetail(updatedRevisionDetail);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del detalle de revisión a buscar: ");
                    String findId = scanner.nextLine();

                    Optional<RevisionDetail> revisionDetail = revisionDetailService.getRevisionDetailById(findId);
                    revisionDetail.ifPresentOrElse(
                        rd -> System.out.println("ID: " + rd.getId() + ", Descripción: " + rd.getDescription() + ", ID Empleado: " + rd.getIdEmployee()),
                        () -> System.out.println("Detalle de revisión no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del detalle de revisión a borrar: ");
                    String deleteId = scanner.nextLine();
                    revisionDetailService.deleteRevisionDetail(deleteId);
                    break;

                case 5:
                    revisionDetailService.getAllRevisionDetails().forEach(rd -> {
                        System.out.println("ID: " + rd.getId() + ", Descripción: " + rd.getDescription() + ", ID Empleado: " + rd.getIdEmployee());
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
