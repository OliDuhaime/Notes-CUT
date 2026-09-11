import java.util.Scanner;

public class exo_base {
    public static void main(String[] args) {
        ex6Base();
    }

    public static void ex1Base() {
        System.out.println("Bonjour tout le monde");
    }

    public static void ex2Base() {
        System.out.println("7h00 - déjeuner");
        System.out.println("12h00 - diner");
        System.out.println("17h00 - souper");
    }

    public static void ex3Base() {
        Scanner scanner = new Scanner(System.in);

        int entier = scanner.nextInt();
        System.out.println(2* entier);
    }

    public static void ex4Base() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre: ");
        int entier = scanner.nextInt();
        System.out.println(entier * entier);
    }

    public static void ex5Base() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Combien avez vous acheté de cet article: ");
        int nombre = scanner.nextInt();

        System.out.println("Quel est le prix cet article: ");
        float prix = scanner.nextFloat();

        System.out.printf("Prix final: %.2f$", nombre * prix * 1.15);

    }

    public static void ex6Base() {
        double PI = Math.PI;

        System.out.printf("%.2f", PI);
        System.out.printf("\n%.6f", PI);
        System.out.printf("\n%.10f", PI);

    }

}
