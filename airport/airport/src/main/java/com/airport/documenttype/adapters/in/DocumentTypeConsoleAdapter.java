package com.airport.documenttype.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.documenttype.application.DocumentTypeService;
import com.airport.documenttype.domain.models.DocumentType;

public class DocumentTypeConsoleAdapter {
    private final DocumentTypeService documentTypeService;

    public DocumentTypeConsoleAdapter(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Tipo de Documento");
            System.out.println("2. Actualizar Tipo de Documento");
            System.out.println("3. Buscar Tipo de Documento por ID");
            System.out.println("4. Eliminar Tipo de Documento");
            System.out.println("5. Listar todos los Tipos de Documento");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del tipo de documento: ");
                    String createName = scanner.nextLine();

                    DocumentType newDocumentType = new DocumentType(createName);
                    documentTypeService.createDocumentType(newDocumentType);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del tipo de documento a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo nombre del tipo de documento: ");
                    String updateName = scanner.nextLine();

                    DocumentType updatedDocumentType = new DocumentType(updateId, updateName);
                    documentTypeService.updateDocumentType(updatedDocumentType);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del tipo de documento a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<DocumentType> documentType = documentTypeService.getDocumentTypeById(findId);
                    documentType.ifPresentOrElse(
                        dt -> System.out.println("ID: " + dt.getId() + ", Nombre: " + dt.getName()),
                        () -> System.out.println("Tipo de documento no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del tipo de documento a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    documentTypeService.deleteDocumentType(deleteId);
                    break;

                case 5:
                    documentTypeService.getAllDocumentTypes().forEach(dt -> {
                        System.out.println("ID: " + dt.getId() + ", Nombre: " + dt.getName());
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
