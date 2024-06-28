package com.airport;

import java.util.Scanner;

import com.airport.roles.Admin;
import com.airport.roles.Client;
import com.airport.roles.Sales;
import com.airport.roles.Tech;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Ingrese su usuario:");
            String username = scanner.next();
            System.out.println("Ingrese su clave:");
            String password = scanner.next();

            String adminUsername = "admin";
            String adminPassword = "adminPass";

            String salesUsername = "sales";
            String salesPassword = "salesPass";

            String techUsername = "tech";
            String techPassword = "techPass";

            String clientUsername = "client";
            String clientPassword = "clientPass";

            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                System.out.println("Has ingresado como: Administrador");
                Admin.admin();
            } else if (username.equals(salesUsername) && password.equals(salesPassword)) {
                System.out.println("Has ingresado como: Agente de Ventas");
                Sales.sales();
            } else if (username.equals(techUsername) && password.equals(techPassword)) {
                System.out.println("Has ingresado como: Técnico de Mantenimiento");
                Tech.tech();
            } else if (username.equals(clientUsername) && password.equals(clientPassword)) {
                System.out.println("Has ingresado como: Cliente");
                Client.client();
            } else {
                System.out.println("Usuario o clave incorrecta. Por favor, intenta de nuevo.");
            }

            System.out.println("¿Desea intentar nuevamente? (1 para sí, 5 para salir)");
            option = scanner.nextInt();

        } while (option != 5);

        System.out.println("Saliendo...");
        scanner.close();
    }
}
