public class Main {
    public static void main(String[] args) {
        imprimirNumerosDe1A100();
        imprimirSomatorioNumerosImparesEntre10E1000();
        imprimirMultiplosDe3QueNaoTerminamEm3();
    }

    public static void imprimirNumerosDe1A100() {
        for (int i = 1; i <= 100; i++) {
            if (i < 100) {
                System.out.print(i + ", ");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void imprimirSomatorioNumerosImparesEntre10E1000() {
        int soma = 0;
        for (int i = 11; i < 1000; i += 2) {
            soma += i;
        }
        System.out.println("Somatório de todos os números ímpares entre 10 e 1000: " + soma);
    }

    public static void imprimirMultiplosDe3QueNaoTerminamEm3() {
        boolean primeiro = true;
        for (int i = 3; i <= 100; i += 3) {
            if (i % 10 != 3) {
                if (!primeiro) {
                    System.out.print(", ");
                }
                System.out.print(i);
                primeiro = false;
            }
        }
        System.out.println();
    }
}