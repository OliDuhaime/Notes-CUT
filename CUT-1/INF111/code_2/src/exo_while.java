import java.util.Scanner;

public class exo_while {
    public static void main(String[] args) {
        ex1While();
        ex2While();
        ex3While();
        ex4While();
    }

    public static void ex1While() {
        int compteur = 0;
        while (compteur < 10) {
            compteur++;
        }
        System.out.println("Le compteur est à : " + compteur);
    }

    public static void ex2While() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un nombre : ");
        int nombre = scanner.nextInt();
        int compteur = 0;

        while (compteur < nombre) {
            System.out.print(compteur + " ");
            compteur += 2;
        }
        System.out.println();

    }

    public static void ex3While() {
        int compteur = 1;
        while (compteur < 10) {
            if (compteur % 2 == 1) {
                System.out.print(compteur + " ");
            }
            compteur++;
        }
    }

    public static void ex4While() {
        Scanner scanner = new Scanner(System.in);
        int nombreMaximum = 0;
        int nombreMinimum = 0;
        int interval = 0;

        System.out.print("Entrez un nombre minimum : ");
        nombreMinimum = scanner.nextInt();
        System.out.print("Entrez un nombre maximum : ");
        nombreMaximum = scanner.nextInt();
        System.out.print("Entrez un intervalle : ");
        interval = scanner.nextInt();

        int compteur = nombreMinimum;

        while (compteur < nombreMaximum) {
            System.out.print(compteur + " ");
            compteur += interval;
        }
        System.out.println();
    }


}
