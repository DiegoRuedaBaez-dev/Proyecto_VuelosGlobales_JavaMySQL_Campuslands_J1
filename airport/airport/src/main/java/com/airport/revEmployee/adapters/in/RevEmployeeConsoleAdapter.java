package com.airport.revEmployee.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.revEmployee.application.RevEmployeeService;
import com.airport.revEmployee.domain.models.RevEmployee;

public class RevEmployeeConsoleAdapter {
    private final RevEmployeeService revEmployeeService;

    public RevEmployeeConsoleAdapter(RevEmployeeService revEmployeeService) {
        this.revEmployeeService = revEmployeeService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Asignar Revisión a Empleado");
            System.out.println("2. Actualizar Revisión de Empleado");
            System.out.println("3. Buscar Revisión de Empleado por ID");
            System.out.println("4. Eliminar Revisión de Empleado");
            System.out.println("5. Listar todas las Revisiones de Empleados");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del empleado: ");
                    String createEmployeeId = scanner.nextLine();
                    System.out.print("Ingrese el ID de la revisión: ");
                    int createRevisionId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    RevEmployee newRevEmployee = new RevEmployee(createEmployeeId, createRevisionId);
                    revEmployeeService.createRevEmployee(newRevEmployee);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del empleado: ");
                    String updateEmployeeId = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID de la revisión: ");
                    int updateRevisionId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    RevEmployee updatedRevEmployee = new RevEmployee(updateEmployeeId, updateRevisionId);
                    revEmployeeService.updateRevEmployee(updatedRevEmployee);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del empleado a buscar: ");
                    String findEmployeeId = scanner.nextLine();
                    System.out.print("Ingrese el ID de la revisión a buscar: ");
                    int findRevisionId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<RevEmployee> revEmployee = revEmployeeService.getRevEmployeeById(findEmployeeId, findRevisionId);
                    revEmployee.ifPresentOrElse(
                        re -> System.out.println("ID Empleado: " + re.getIdEmployee() + ", ID Revisión: " + re.getIdRevision()),
                        () -> System.out.println("Revisión de empleado no encontrada")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del empleado: ");
                    String deleteEmployeeId = scanner.nextLine();
                    System.out.print("Ingrese el ID de la revisión a borrar: ");
                    int deleteRevisionId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    revEmployeeService.deleteRevEmployee(deleteEmployeeId, deleteRevisionId);
                    break;

                case 5:
                    revEmployeeService.getAllRevEmployees().forEach(re -> {
                        System.out.println("ID Empleado: " + re.getIdEmployee() + ", ID Revisión: " + re.getIdRevision());
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
