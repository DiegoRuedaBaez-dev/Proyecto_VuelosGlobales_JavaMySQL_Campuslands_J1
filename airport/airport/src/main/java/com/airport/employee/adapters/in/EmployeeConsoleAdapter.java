package com.airport.employee.adapters.in;

import java.util.Optional;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.airport.employee.application.EmployeeService;
import com.airport.employee.domain.models.Employee;

public class EmployeeConsoleAdapter {
    private final EmployeeService employeeService;

    public EmployeeConsoleAdapter(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("1. Crear Empleado");
            System.out.println("2. Actualizar Empleado");
            System.out.println("3. Buscar Empleado por ID");
            System.out.println("4. Eliminar Empleado");
            System.out.println("5. Listar todos los Empleados");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del empleado: ");
                    String createId = scanner.nextLine();
                    System.out.print("Ingrese el nombre del empleado: ");
                    String createName = scanner.nextLine();
                    System.out.print("Ingrese el ID del rol del empleado: ");
                    int createRolId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese la fecha de ingreso (yyyy-MM-dd): ");
                    String createDateStr = scanner.nextLine();
                    LocalDate createDate = LocalDate.parse(createDateStr, dateFormatter);
                    System.out.print("Ingrese el ID de la aerolínea del empleado: ");
                    int createAirlineId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el ID del aeropuerto del empleado: ");
                    String createAirportId = scanner.nextLine();

                    Employee newEmployee = new Employee(createId, createName, createRolId, createDate, createAirlineId, createAirportId);
                    employeeService.createEmployee(newEmployee);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del empleado a actualizar: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del empleado: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del rol del empleado: ");
                    int updateRolId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese la nueva fecha de ingreso (yyyy-MM-dd): ");
                    String updateDateStr = scanner.nextLine();
                    LocalDate updateDate = LocalDate.parse(updateDateStr, dateFormatter);
                    System.out.print("Ingrese el nuevo ID de la aerolínea del empleado: ");
                    int updateAirlineId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo ID del aeropuerto del empleado: ");
                    String updateAirportId = scanner.nextLine();

                    Employee updatedEmployee = new Employee(updateId, updateName, updateRolId, updateDate, updateAirlineId, updateAirportId);
                    employeeService.updateEmployee(updatedEmployee);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del empleado a buscar: ");
                    String findId = scanner.nextLine();

                    Optional<Employee> employee = employeeService.getEmployeeById(findId);
                    employee.ifPresentOrElse(
                        e -> System.out.println("ID: " + e.getId() + ", Nombre: " + e.getName() + ", ID Rol: " + e.getIdRol() + ", Fecha de Ingreso: " + e.getIngressDate() + ", ID Aerolínea: " + e.getIdAirline() + ", ID Aeropuerto: " + e.getIdAirport()),
                        () -> System.out.println("Empleado no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del empleado a borrar: ");
                    String deleteId = scanner.nextLine();
                    employeeService.deleteEmployee(deleteId);
                    break;

                case 5:
                    employeeService.getAllEmployees().forEach(e -> {
                        System.out.println("ID: " + e.getId() + ", Nombre: " + e.getName() + ", ID Rol: " + e.getIdRol() + ", Fecha de Ingreso: " + e.getIngressDate() + ", ID Aerolínea: " + e.getIdAirline() + ", ID Aeropuerto: " + e.getIdAirport());
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
