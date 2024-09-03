import java.util.Scanner;

public class CalculoINSS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu salário bruto: ");
        double salarioBruto = scanner.nextDouble();

        double aliquota;
        if (salarioBruto <= 1212.00) {
            aliquota = 0.075;
        } else if (salarioBruto <= 2427.35) {
            aliquota = 0.09;
        } else if (salarioBruto <= 3641.03) {
            aliquota = 0.12;
        } else if (salarioBruto <= 7087.22) {
            aliquota = 0.14;
        } else {
            aliquota = 0.14;  // Alíquota fixa para salários acima do teto do INSS
        }

        double contribuicaoINSS = salarioBruto * aliquota;
        double salarioLiquido = salarioBruto - contribuicaoINSS;

        System.out.printf("Contribuição ao INSS: R$ %.2f%n", contribuicaoINSS);
        System.out.printf("Salário líquido: R$ %.2f%n", salarioLiquido);

        scanner.close();
    }
}