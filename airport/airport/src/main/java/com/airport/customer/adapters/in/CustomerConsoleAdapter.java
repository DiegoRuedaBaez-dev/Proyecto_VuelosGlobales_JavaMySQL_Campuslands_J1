package com.airport.customer.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.customer.application.CustomerService;
import com.airport.customer.domain.models.Customer;

public class CustomerConsoleAdapter {
    private final CustomerService customerService;

    public CustomerConsoleAdapter(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Buscar Cliente por ID");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Listar todos los Clientes");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del cliente: ");
                    String createId = scanner.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String createName = scanner.nextLine();
                    System.out.print("Ingrese la edad del cliente: ");
                    int createAge = scanner.nextInt();
                    System.out.print("Ingrese el ID del documento del cliente: ");
                    int createDocumentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Customer newCustomer = new Customer(createId, createName, createAge, createDocumentId);
                    customerService.createCustomer(newCustomer);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del cliente a actualizar: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del cliente: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Ingrese la nueva edad del cliente: ");
                    int updateAge = scanner.nextInt();
                    System.out.print("Ingrese el nuevo ID del documento del cliente: ");
                    int updateDocumentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Customer updatedCustomer = new Customer(updateId, updateName, updateAge, updateDocumentId);
                    customerService.updateCustomer(updatedCustomer);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del cliente a buscar: ");
                    String findId = scanner.nextLine();

                    Optional<Customer> customer = customerService.getCustomerById(findId);
                    customer.ifPresentOrElse(
                        c -> System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName() + ", Edad: " + c.getAge() + ", ID Documento: " + c.getIdDocument()),
                        () -> System.out.println("Cliente no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del cliente a borrar: ");
                    String deleteId = scanner.nextLine();
                    customerService.deleteCustomer(deleteId);
                    break;

                case 5:
                    customerService.getAllCustomers().forEach(c -> {
                        System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName() + ", Edad: " + c.getAge() + ", ID Documento: " + c.getIdDocument());
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
