import java.util.Scanner;

public class VetoresBusca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[10];

        // Solicitar os valores do usuário
        System.out.println("Digite 10 valores:");
        for (int i = 0; i < 10; i++) {
            valores[i] = scanner.nextInt();
        }

        // Verificar se o vetor está ordenado
        boolean ordenado = estaOrdenado(valores);
        if (ordenado) {
            System.out.println("O vetor está ordenado.");
        } else {
            System.out.println("O vetor não está ordenado.");
        }

        // Loop para busca
        boolean continuar = true;
        while (continuar) {
            System.out.print("Digite o elemento a ser encontrado: ");
            int elemento = scanner.nextInt();
            int posicao;

            if (ordenado) {
                posicao = buscaBinaria(valores, elemento);
            } else {
                posicao = buscaLinear(valores, elemento);
            }

            if (posicao != -1) {
                System.out.println("Elemento encontrado na posição: " + posicao);
            } else {
                System.out.println("Elemento não encontrado.");
            }

            System.out.print("Deseja continuar? (sim/não): ");
            String resposta = scanner.next();
            continuar = resposta.equalsIgnoreCase("s");
        }

        scanner.close();
    }

    private static boolean estaOrdenado(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < vetor[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static int buscaLinear(int[] vetor, int elemento) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == elemento) {
                return i;
            }
        }
        return -1; // Não encontrado
    }

    private static int buscaBinaria(int[] vetor, int elemento) {
        int esquerda = 0;
        int direita = vetor.length - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (vetor[meio] == elemento) {
                return meio; // Elemento encontrado
            } else if (vetor[meio] < elemento) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1; // Não encontrado
    }
}