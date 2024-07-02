package com.airport.roles;
import java.util.Scanner;

import com.airport.revision.adapters.in.RevisionConsoleAdapter;
import com.airport.revision.adapters.out.RevisionMySQLRepository;
import com.airport.revision.application.RevisionService;
import com.airport.revisionDetail.adapters.in.RevisionDetailConsoleAdapter;
import com.airport.revisionDetail.adapters.out.RevisionDetailMySQLRepository;
import com.airport.revisionDetail.application.RevisionDetailService;
import com.airport.status.adapters.in.StatusConsoleAdapter;
import com.airport.status.adapters.out.StatusMySQLRepository;
import com.airport.status.application.StatusService;

public class Tech {
    public static void tech() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("¿Qué desea realizar?:");
            System.out.println("1. Gestionar Revisiones");
            System.out.println("2. Gestionar Detalles de Revision");
            System.out.println("3. Gestionar Estados");
            System.out.println("4. Salir");
            
            System.out.print("Opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 
            
            String url = "jdbc:mysql://localhost:3306/airport";
            String user = "campus2023";
            String password = "campus2023";

            switch (option) {
                case 1 -> {
                    RevisionMySQLRepository revisionRepository = new RevisionMySQLRepository(url, user, password);
                    RevisionService revisionService = new RevisionService(revisionRepository);
                    RevisionConsoleAdapter revisionConsoleAdapter = new RevisionConsoleAdapter(revisionService);

                    revisionConsoleAdapter.start();
                }
                case 2 -> {
                    RevisionDetailMySQLRepository revisionDetailMySQLRepository = new RevisionDetailMySQLRepository(url, user, password);
                    RevisionDetailService revisionDetailService = new RevisionDetailService(revisionDetailMySQLRepository);
                    RevisionDetailConsoleAdapter revisionDetailConsoleAdapter = new RevisionDetailConsoleAdapter(revisionDetailService);

                    revisionDetailConsoleAdapter.start();
                }
                case 3 -> {
                    StatusMySQLRepository statusRepository = new StatusMySQLRepository(url, user, password);
                    StatusService statusService = new StatusService(statusRepository);
                    StatusConsoleAdapter statusConsoleAdapter = new StatusConsoleAdapter(statusService);

                    statusConsoleAdapter.start();
                }
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
}
