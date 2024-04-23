import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        MenuBuilder menu = new MenuBuilder("[%d] %s\n");
        DataHandler fifaAudience;
        fifaAudience = new DataHandler("data/fifa_countries_audience.csv");
        menu.addOption("Ordenar por ordem alfabética");
        menu.addOption("Ordenar por audiência TV");
        menu.addOption("Encerrar");

        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            menu.clear();
            menu.draw();
            menu.drawPrompt();
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    menu.clear();
                    fifaAudience.sortByCountryName();
                    fifaAudience.print();
                    System.out.printf("Aperte ENTER para voltar");
                    scanner.nextLine();
                    break;
                case "2":
                    menu.clear();
                    fifaAudience.sortByAudience();
                    fifaAudience.print();
                    System.out.printf("Aperte ENTER para voltar");
                    scanner.nextLine();
                    break;
                case "3":
                    break;
            }
        } while (!option.equalsIgnoreCase("3"));
        scanner.close();
    }
}