import java.util.Scanner;

public class NumerosParesImpares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int inicio = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int fim = scanner.nextInt();

        System.out.println("Números pares:");
        for (int i = Math.min(inicio, fim); i <= Math.max(inicio, fim); i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println("\nNúmeros ímpares:");
        for (int i = Math.min(inicio, fim); i <= Math.max(inicio, fim); i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}