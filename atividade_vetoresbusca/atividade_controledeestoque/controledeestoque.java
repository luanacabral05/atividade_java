import java.util.*;
class Produto {
   String nome;
   String descricao;
   int quantidadeEmEstoque;
   double precoUnitario;
   String categoria;
   int quantidadeMaxima;
   public Produto(String nome, String descricao, int quantidadeEmEstoque, double precoUnitario, String categoria, int quantidadeMaxima) {
       this.nome = nome;
       this.descricao = descricao;
       this.quantidadeEmEstoque = quantidadeEmEstoque;
       this.precoUnitario = precoUnitario;
       this.categoria = categoria;
       this.quantidadeMaxima = quantidadeMaxima;
   }
   @Override
   public String toString() {
       return nome + " - " + quantidadeEmEstoque + " - " + precoUnitario;
   }
}
public class ControleEstoque {
   static List<Produto> produtos = new ArrayList<>();
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int opcao;
       do {
           System.out.println("\n=== Controle de Estoque ===");
           System.out.println("1. Cadastrar Produto");
           System.out.println("2. Listar Produtos");
           System.out.println("3. Filtrar por Categoria");
           System.out.println("4. Ordenar Produtos");
           System.out.println("5. Remover Produto");
           System.out.println("6. Atualizar Preço");
           System.out.println("7. Listagem com Subtotal por Categoria");
           System.out.println("0. Sair");
           System.out.print("Escolha uma opção: ");
           opcao = scanner.nextInt();
           scanner.nextLine(); // Limpar buffer
           switch (opcao) {
               case 1:
                   cadastrarProduto(scanner);
                   break;
               case 2:
                   listarProdutos();
                   break;
               case 3:
                   filtrarPorCategoria(scanner);
                   break;
               case 4:
                   ordenarProdutos();
                   break;
               case 5:
                   removerProduto(scanner);
                   break;
               case 6:
                   atualizarPreco(scanner);
                   break;
               case 7:
                   listagemComSubtotal();
                   break;
               case 0:
                   System.out.println("Saindo...");
                   break;
               default:
                   System.out.println("Opção inválida!");
           }
       } while (opcao != 0);
   }
   public static void cadastrarProduto(Scanner scanner) {
       System.out.print("Nome: ");
       String nome = scanner.nextLine();
       System.out.print("Descrição: ");
       String descricao = scanner.nextLine();
       System.out.print("Quantidade em Estoque: ");
       int quantidade = scanner.nextInt();
       System.out.print("Preço Unitário: ");
       double preco = scanner.nextDouble();
       scanner.nextLine(); // Limpar buffer
       System.out.print("Categoria: ");
       String categoria = scanner.nextLine();
       System.out.print("Quantidade Máxima: ");
       int quantidadeMaxima = scanner.nextInt();
       Produto produto = new Produto(nome, descricao, quantidade, preco, categoria, quantidadeMaxima);
       produtos.add(produto);
       System.out.println("Produto cadastrado com sucesso!");
   }
   public static void listarProdutos() {
       if (produtos.isEmpty()) {
           System.out.println("Nenhum produto cadastrado.");
       } else {
           for (Produto p : produtos) {
               System.out.println(p);
           }
       }
   }
   public static void filtrarPorCategoria(Scanner scanner) {
       System.out.print("Informe a categoria: ");
       String categoria = scanner.nextLine();
       boolean encontrado = false;
       for (Produto p : produtos) {
           if (p.categoria.equalsIgnoreCase(categoria)) {
               System.out.println(p);
               encontrado = true;
           }
       }
       if (!encontrado) {
           System.out.println("Nenhum produto encontrado na categoria informada.");
       }
   }
   public static void ordenarProdutos() {
       produtos.sort(Comparator.comparing(p -> p.nome));
       System.out.println("Produtos ordenados por nome.");
   }
   public static void removerProduto(Scanner scanner) {
       System.out.print("Informe o nome do produto a remover: ");
       String nome = scanner.nextLine();
       produtos.removeIf(p -> p.nome.equalsIgnoreCase(nome));
       System.out.println("Produto removido (se existia).");
   }
   public static void atualizarPreco(Scanner scanner) {
       System.out.print("Informe o nome do produto para atualizar o preço: ");
       String nome = scanner.nextLine();
       System.out.print("Novo preço: ");
       double novoPreco = scanner.nextDouble();
       for (Produto p : produtos) {
           if (p.nome.equalsIgnoreCase(nome)) {
               p.precoUnitario = novoPreco;
               System.out.println("Preço atualizado.");
               return;
           }
       }
       System.out.println("Produto não encontrado.");
   }
   public static void listagemComSubtotal() {
       Map<String, Double> subtotais = new HashMap<>();
       for (Produto p : produtos) {
           subtotais.put(p.categoria, subtotais.getOrDefault(p.categoria, 0.0) + (p.quantidadeEmEstoque * p.precoUnitario));
       }
       for (String categoria : subtotais.keySet()) {
           System.out.println("\nCategoria: " + categoria);
           for (Produto p : produtos) {
               if (p.categoria.equalsIgnoreCase(categoria)) {
                   System.out.println(p);
               }
           }
           System.out.printf("Subtotal: R$ %.2f%n", subtotais.get(categoria));
       }
   }
}