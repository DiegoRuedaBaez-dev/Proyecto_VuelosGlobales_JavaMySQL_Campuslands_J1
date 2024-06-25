package com.airport.city.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.city.application.CityService;
import com.airport.city.domain.models.City;

public class CityConsoleAdapter {
    private final CityService cityService;

    public CityConsoleAdapter(CityService cityService) {
        this.cityService = cityService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Ciudad");
            System.out.println("2. Actualizar Ciudad");
            System.out.println("3. Buscar Ciudad por ID");
            System.out.println("4. Eliminar Ciudad");
            System.out.println("5. Listar todas las Ciudades");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID de la ciudad: ");
                    String createId = scanner.nextLine();
                    System.out.print("Ingrese el nombre de la ciudad: ");
                    String createName = scanner.nextLine();
                    System.out.print("Ingrese el ID del país: ");
                    String createIdCountry = scanner.nextLine();
                    City newCity = new City(createId, createName, createIdCountry);
                    cityService.createCity(newCity);
                    break;

                case 2:
                    System.out.print("Ingrese ID de la ciudad a actualizar: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Ingrese el nuevo ID del país: ");
                    String updateIdCountry = scanner.nextLine();
                    City updatedCity = new City(updateId, updateName, updateIdCountry);
                    cityService.updateCity(updatedCity);
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la ciudad a buscar: ");
                    String findId = scanner.nextLine();

                    Optional<City> city = cityService.getCityById(findId);
                    city.ifPresentOrElse(
                        c -> System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName() + ", ID País: " + c.getIdCountry()),
                        () -> System.out.println("Ciudad no encontrada")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la ciudad a borrar: ");
                    String deleteId = scanner.nextLine();
                    cityService.deleteCity(deleteId);
                    break;

                case 5:
                    cityService.getAllCities().forEach(c -> {
                        System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName() + ", ID País: " + c.getIdCountry());
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
