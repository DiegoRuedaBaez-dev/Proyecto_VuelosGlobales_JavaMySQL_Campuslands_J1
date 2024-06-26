package com.airport;
import java.util.Scanner;

import com.airport.roles.Admin;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Seleccione el rol con el que desea ingresar:");
            System.out.println("1. Ingresar como Administrador");
            System.out.println("2. Ingresar como Agente de Ventas");
            System.out.println("3. Ingresar como Técnico de Mantenimiento");
            System.out.println("4. Ingresar como Cliente");
            System.out.println("5. Salir");

            System.out.print("Opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Has ingresado como: Administrador");
                    Admin.admin();
                    break;
                case 2:
                    System.out.println("Has ingresado como: Agente de Ventas");
                    // Aquí puedes agregar la lógica para Agente de Ventas
                    break;
                case 3:
                    System.out.println("Has ingresado como: Técnico de Mantenimiento");
                    // Aquí puedes agregar la lógica para Técnico de Mantenimiento
                    break;
                case 4:
                    System.out.println("Has ingresado como: Cliente");
                    // Aquí puedes agregar la lógica para Cliente
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        } while (option != 5);

        scanner.close();
    }
}