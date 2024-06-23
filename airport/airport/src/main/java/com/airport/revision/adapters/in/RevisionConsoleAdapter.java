package com.airport.revision.adapters.in;

import java.util.Optional;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.airport.revision.application.RevisionService;
import com.airport.revision.domain.models.Revision;

public class RevisionConsoleAdapter {
    private final RevisionService revisionService;

    public RevisionConsoleAdapter(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("1. Crear Revisión");
            System.out.println("2. Actualizar Revisión");
            System.out.println("3. Buscar Revisión por ID");
            System.out.println("4. Eliminar Revisión");
            System.out.println("5. Listar todas las Revisiones");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la fecha de la revisión (yyyy-MM-dd): ");
                    String createDateStr = scanner.nextLine();
                    LocalDate createDate = LocalDate.parse(createDateStr, dateFormatter);
                    System.out.print("Ingrese el ID del avión: ");
                    int createPlaneId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Revision newRevision = new Revision(createDate, createPlaneId);
                    revisionService.createRevision(newRevision);
                    break;

                case 2:
                    System.out.print("Ingrese ID de la revisión a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese la nueva fecha de la revisión (yyyy-MM-dd): ");
                    String updateDateStr = scanner.nextLine();
                    LocalDate updateDate = LocalDate.parse(updateDateStr, dateFormatter);
                    System.out.print("Ingrese el nuevo ID del avión: ");
                    int updatePlaneId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Revision updatedRevision = new Revision(updateId, updateDate, updatePlaneId);
                    revisionService.updateRevision(updatedRevision);
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la revisión a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<Revision> revision = revisionService.getRevisionById(findId);
                    revision.ifPresentOrElse(
                        r -> System.out.println("ID: " + r.getId() + ", Fecha: " + r.getDate() + ", ID Avión: " + r.getIdPlane()),
                        () -> System.out.println("Revisión no encontrada")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la revisión a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    revisionService.deleteRevision(deleteId);
                    break;

                case 5:
                    revisionService.getAllRevisions().forEach(r -> {
                        System.out.println("ID: " + r.getId() + ", Fecha: " + r.getDate() + ", ID Avión: " + r.getIdPlane());
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
