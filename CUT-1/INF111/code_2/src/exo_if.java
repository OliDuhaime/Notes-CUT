import java.util.Scanner;

public class exo_if {
    public static void main(String[] args) {

        ex4If();
    }

    public static void ex1If() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un nombre: ");
        float nombre = scanner.nextFloat();

        if (nombre > 0) {
            System.out.println("Plus grand que zéro");
        } else if (nombre < 0) {
            System.out.println("Plus petit que zéro");
        } else {
            System.out.println("Est zéro");
        }

    }

    public static void ex2If() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez votre poids (kg): ");
        float poids = scanner.nextFloat();

        System.out.print("Entrez votre taille (m): ");
        float taille = scanner.nextFloat();

        float IMC = poids / (taille * taille);

        if (IMC > 25) {
            System.out.println("Obèse");
        } else if (IMC >= 18.5) {
            System.out.println("Normal");
        } else {
            System.out.println("Maigre");
        }

    }

    public static void ex3If() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre d'heures: ");
        double nbHeures = scanner.nextDouble();

        double paie = 0f;

        if (nbHeures <= 40) {
            paie = nbHeures * 23;
        } else paie = 40 * 23 + (nbHeures - 40) * 23 * 1.5;

        System.out.printf("Votre paie est de: %.2f$\n", paie);
    }

    public static void ex4If() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez trois nombres:");
        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();

        float plusPetit = a;

        if (b < plusPetit) {
            plusPetit = b;
        }
        if (c < plusPetit) {
            plusPetit = c;
        }
        System.out.println("Le plus petit nombre est: " + plusPetit);
    }

}
