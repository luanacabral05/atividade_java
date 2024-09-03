import java.util.Scanner;

public class CalculoIR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu salário bruto: ");
        double salarioBruto = scanner.nextDouble();

        double impostoRenda;
        if (salarioBruto <= 1903.98) {
            impostoRenda = 0;
        } else if (salarioBruto <= 2826.65) {
            impostoRenda = salarioBruto * 0.075 - 142.80;
        } else if (salarioBruto <= 3751.05) {
            impostoRenda = salarioBruto * 0.15 - 354.80;
        } else if (salarioBruto <= 4664.68) {
            impostoRenda = salarioBruto * 0.225 - 636.13;
        } else {
            impostoRenda = salarioBruto * 0.275 - 869.36;
        }

        double salarioLiquido = salarioBruto - impostoRenda;

        System.out.printf("Imposto de Renda: R$ %.2f%n", impostoRenda);
        System.out.printf("Salário líquido após IR: R$ %.2f%n", salarioLiquido);

        scanner.close();
    }
}