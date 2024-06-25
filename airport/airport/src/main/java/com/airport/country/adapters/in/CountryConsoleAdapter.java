package com.airport.country.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.airport.country.application.CountryService;
import com.airport.country.domain.models.Country;

public class CountryConsoleAdapter {
    private final CountryService countryService;

    public CountryConsoleAdapter(CountryService countryService) {
        this.countryService = countryService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear País");
            System.out.println("2. Actualizar País");
            System.out.println("3. Buscar País por ID");
            System.out.println("4. Eliminar País");
            System.out.println("5. Listar todos los Países");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el ID del país: ");
                    String createId = scanner.nextLine();
                    System.out.print("Ingrese el nombre del país: ");
                    String createName = scanner.nextLine();

                    Country newCountry = new Country(createId, createName);
                    countryService.createCountry(newCountry);
                    break;

                case 2:
                    System.out.print("Ingrese el ID del país a actualizar: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del país: ");
                    String updateName = scanner.nextLine();

                    Country updatedCountry = new Country(updateId, updateName);
                    countryService.updateCountry(updatedCountry);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del país a buscar: ");
                    String findId = scanner.nextLine();

                    Optional<Country> country = countryService.getCountryById(findId);
                    country.ifPresentOrElse(
                        c -> System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName()),
                        () -> System.out.println("País no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el ID del país a borrar: ");
                    String deleteId = scanner.nextLine();
                    countryService.deleteCountry(deleteId);
                    break;

                case 5:
                    countryService.getAllCountries().forEach(c -> {
                        System.out.println("ID: " + c.getId() + ", Nombre: " + c.getName());
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
