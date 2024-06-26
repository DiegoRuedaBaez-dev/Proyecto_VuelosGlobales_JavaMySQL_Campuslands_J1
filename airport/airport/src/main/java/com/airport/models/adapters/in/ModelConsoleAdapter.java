package com.airport.models.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.models.application.ModelService;
import com.airport.models.domain.models.Model;
public class ModelConsoleAdapter {
    private final ModelService modelService;

    public ModelConsoleAdapter(ModelService modelService) {
        this.modelService = modelService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Modelo");
            System.out.println("2. Actualizar Modelo");
            System.out.println("3. Buscar Modelo por ID");
            System.out.println("4. Eliminar Modelo");
            System.out.println("5. Listar todos los Modelos");
            System.out.println("6. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del modelo: ");
                    String createName = scanner.nextLine();
                    System.out.print("Ingrese el ID del fabricante: ");
                    int createManufacturedId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Model newModel = new Model(createName, createManufacturedId);
                    modelService.createModel(newModel);
                    break;
                case 2:
                    System.out.print("Ingrese ID del modelo a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo nombre: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del fabricante: ");
                    int updateManufacturedId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Model updatedModel = new Model(updateId, updateName, updateManufacturedId);
                    modelService.updateModel(updatedModel);
                    break;
                case 3:
                    System.out.print("Ingrese el ID del modelo a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Optional<Model> model = modelService.getModelById(findId);
                    model.ifPresentOrElse(
                        m -> System.out.println("ID: " + m.getId() + ", Nombre: " + m.getName() + ", ID Fabricante: " + m.getManufacturedId()),
                        () -> System.out.println("Modelo no encontrado")
                    );
                    break;
                case 4:
                    System.out.print("Ingrese el ID del modelo a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    modelService.deleteModel(deleteId);
                    break;
                case 5:
                    modelService.getAllModels().forEach(m -> {
                        System.out.println("ID: " + m.getId() + ", Nombre: " + m.getName() + ", ID Fabricante: " + m.getManufacturedId());
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