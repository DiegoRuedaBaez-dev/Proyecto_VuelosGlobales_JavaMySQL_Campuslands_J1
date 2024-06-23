package com.airport.plane.adapters.in;

import java.util.Optional;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.airport.plane.application.PlaneService;
import com.airport.plane.domain.models.Plane;

public class PlaneConsoleAdapter {
    private final PlaneService planeService;

    public PlaneConsoleAdapter(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("1. Crear Avión");
            System.out.println("2. Actualizar Avión");
            System.out.println("3. Buscar Avión por ID");
            System.out.println("4. Eliminar Avión");
            System.out.println("5. Listar todos los Aviones");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese las placas del avión: ");
                    String createPlates = scanner.nextLine();
                    System.out.print("Ingrese la capacidad del avión: ");
                    int createCapacity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese la fecha de fabricación (yyyy-MM-dd): ");
                    String createDateStr = scanner.nextLine();
                    LocalDate createDate = LocalDate.parse(createDateStr, dateFormatter);
                    System.out.print("Ingrese el ID del estado del avión: ");
                    int createStatusId = scanner.nextInt();
                    System.out.print("Ingrese el ID del modelo del avión: ");
                    int createModelId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Plane newPlane = new Plane(createPlates, createCapacity, createDate, createStatusId, createModelId);
                    planeService.createPlane(newPlane);
                    break;

                case 2:
                    System.out.print("Ingrese ID del avión a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese las nuevas placas: ");
                    String updatePlates = scanner.nextLine();
                    System.out.print("Ingrese la nueva capacidad: ");
                    int updateCapacity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese la nueva fecha de fabricación (yyyy-MM-dd): ");
                    String updateDateStr = scanner.nextLine();
                    LocalDate updateDate = LocalDate.parse(updateDateStr, dateFormatter);
                    System.out.print("Ingrese el nuevo ID del estado del avión: ");
                    int updateStatusId = scanner.nextInt();
                    System.out.print("Ingrese el nuevo ID del modelo del avión: ");
                    int updateModelId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Plane updatedPlane = new Plane(updateId, updatePlates, updateCapacity, updateDate, updateStatusId, updateModelId);
                    planeService.updatePlane(updatedPlane);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del avión a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<Plane> plane = planeService.getPlaneById(findId);
                    plane.ifPresentOrElse(
                        p -> System.out.println("ID: " + p.getId() + ", Placas: " + p.getPlates() + ", Capacidad: " + p.getCapacity() + ", Fecha de Fabricación: " + p.getFabricationDate() + ", ID Estado: " + p.getIdStatus() + ", ID Modelo: " + p.getIdModel()),
                        () -> System.out.println("Avión no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del avión a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    planeService.deletePlane(deleteId);
                    break;

                case 5:
                    planeService.getAllPlanes().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", Placas: " + p.getPlates() + ", Capacidad: " + p.getCapacity() + ", Fecha de Fabricación: " + p.getFabricationDate() + ", ID Estado: " + p.getIdStatus() + ", ID Modelo: " + p.getIdModel());
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
