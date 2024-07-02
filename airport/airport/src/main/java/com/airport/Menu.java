package com.airport;

import java.sql.DriverManager;
import java.util.Scanner;

import com.airport.roles.Admin;
import com.airport.roles.Client;
import com.airport.roles.Sales;
import com.airport.roles.Tech;

public class Menu {
    public static void main(String[] args) {
        //hace que las conexiones se cierren automáticamente a los 5 minutos
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║                           ║");
        System.out.println("║  Agencia Vuelos Globales  ║");
        System.out.println("║                           ║");
        System.out.println("╚═══════════════════════════╝");
        DriverManager.setLoginTimeout(300);
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        boolean validInput = false;

        do {
            System.out.println("Ingrese su usuario:");
            String username = scanner.nextLine();
            System.out.println("Ingrese su clave:");
            String password = scanner.nextLine();

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
                Admin.admin(scanner);
            } else if (username.equals(salesUsername) && password.equals(salesPassword)) {
                System.out.println("Has ingresado como: Agente de Ventas");
                Sales.sales(scanner);
            } else if (username.equals(techUsername) && password.equals(techPassword)) {
                System.out.println("Has ingresado como: Técnico de Mantenimiento");
                Tech.tech(scanner);
            } else if (username.equals(clientUsername) && password.equals(clientPassword)) {
                System.out.println("Has ingresado como: Cliente");
                Client.client(scanner);
            } else {
                System.out.println("Usuario o clave incorrecta. Por favor, intenta de nuevo.");
            }
            while (!validInput) {
                System.out.println("¿Desea intentar nuevamente? (1 para sí, 5 para salir)");
                try {
                    option = Integer.parseInt(scanner.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    validInput = false;
                }
            }

        } while (option != 5);

        System.out.println("Saliendo...");
        scanner.close();
    }
}