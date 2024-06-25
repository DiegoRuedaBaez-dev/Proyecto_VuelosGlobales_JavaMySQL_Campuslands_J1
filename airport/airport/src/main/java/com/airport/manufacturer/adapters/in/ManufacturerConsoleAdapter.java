package com.airport.manufacturer.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.manufacturer.application.ManufacturerService;
import com.airport.manufacturer.domain.models.Manufacturer;

public class ManufacturerConsoleAdapter {
    private final ManufacturerService manufacturerService;

    public ManufacturerConsoleAdapter(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Fabricante");
            System.out.println("2. Actualizar Fabricante");
            System.out.println("3. Buscar Fabricante por ID");
            System.out.println("4. Eliminar Fabricante");
            System.out.println("5. Listar todos los Fabricantes");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del fabricante: ");
                    String createName = scanner.nextLine();

                    Manufacturer newManufacturer = new Manufacturer(createName);
                    manufacturerService.createManufacturer(newManufacturer);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del fabricante a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo nombre del fabricante: ");
                    String updateName = scanner.nextLine();

                    Manufacturer updatedManufacturer = new Manufacturer(updateId, updateName);
                    manufacturerService.updateManufacturer(updatedManufacturer);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del fabricante a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<Manufacturer> manufacturer = manufacturerService.getManufacturerById(findId);
                    manufacturer.ifPresentOrElse(
                        m -> System.out.println("ID: " + m.getId() + ", Nombre: " + m.getName()),
                        () -> System.out.println("Fabricante no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del fabricante a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    manufacturerService.deleteManufacturer(deleteId);
                    break;

                case 5:
                    manufacturerService.getAllManufacturers().forEach(m -> {
                        System.out.println("ID: " + m.getId() + ", Nombre: " + m.getName());
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
