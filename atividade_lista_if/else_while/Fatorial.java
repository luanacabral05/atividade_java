import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int numero = scanner.nextInt();

        long fatorial = 1;
        int i = 1;
        while (i <= numero) {
            fatorial *= i;
            i++;
        }

        System.out.println("Fatorial de " + numero + " é: " + fatorial);

        scanner.close();
    }
}