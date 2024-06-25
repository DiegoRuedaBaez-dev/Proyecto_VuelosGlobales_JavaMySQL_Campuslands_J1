package com.airport.gate.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.gate.application.GateService;
import com.airport.gate.domain.models.Gate;

public class GateConsoleAdapter {
    private final GateService gateService;

    public GateConsoleAdapter(GateService gateService) {
        this.gateService = gateService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Gate");
            System.out.println("2. Actualizar Gate");
            System.out.println("3. Buscar Gate por ID");
            System.out.println("4. Eliminar Gate");
            System.out.println("5. Listar todos los Gates");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el número del gate: ");
                    String createGateNumber = scanner.nextLine();
                    System.out.print("Ingrese el ID del aeropuerto: ");
                    String createAirportId = scanner.nextLine();

                    Gate newGate = new Gate(createGateNumber, createAirportId);
                    gateService.createGate(newGate);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del gate a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ingrese el nuevo número del gate: ");
                    String updateGateNumber = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del aeropuerto: ");
                    String updateAirportId = scanner.nextLine();

                    Gate updatedGate = new Gate(updateId, updateGateNumber, updateAirportId);
                    gateService.updateGate(updatedGate);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del gate a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Optional<Gate> gate = gateService.getGateById(findId);
                    gate.ifPresentOrElse(
                        g -> System.out.println("ID: " + g.getId() + ", Número del Gate: " + g.getGateNumber() + ", ID Aeropuerto: " + g.getIdAirport()),
                        () -> System.out.println("Gate no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del gate a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    gateService.deleteGate(deleteId);
                    break;

                case 5:
                    gateService.getAllGates().forEach(g -> {
                        System.out.println("ID: " + g.getId() + ", Número del Gate: " + g.getGateNumber() + ", ID Aeropuerto: " + g.getIdAirport());
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
