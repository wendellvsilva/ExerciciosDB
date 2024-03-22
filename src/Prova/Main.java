package Prova;

import java.util.Scanner;

public class Main {
    private Scanner scanner;

    public static void main(String[] args) {
        Main main = new Main();
        main.controlaMenu();
    }

    public void controlaMenu() {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);
        Pedido pedido = new Pedido();
        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Mostrar estoque");
            System.out.println("2. Realizar um pedido");
            System.out.println("3. Procure um produto");
            System.out.println("4. Cadastrar um novo produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    estoque.imprimeCatalogoDoEstoque();
                    break;
                case 2:
                    pedido.realizarPedido();
                    break;
                case 3:
                    System.out.print("Digite o ID do produto desejado: ");
                    int idProduto = scanner.nextInt();
                    scanner.nextLine();
                    Produto produtoEncontrado = estoque.encontraProduto(idProduto);
                    if (produtoEncontrado != null) {
                        System.out.println("Produto encontrado:");
                        System.out.println("ID: " + produtoEncontrado.getId());
                        System.out.println("Nome: " + produtoEncontrado.getNome());
                        System.out.println("Preço: " + produtoEncontrado.getPreco());
                        System.out.println("Quantidade em estoque: " + produtoEncontrado.getQuantidadeEmEstoque());
                    } else {
                        System.out.println("Produto não encontrado.");
                        break;
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do produto: ");
                    int novoId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome do produto: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double novoPreco = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Digite a quantidade em estoque: ");
                    int novaQuantidade = scanner.nextInt();
                    scanner.nextLine();

                    Produto novoProduto = new Produto(novoId, novoNome, novoPreco, novaQuantidade);
                    if (estoque.cadastraProduto(novoProduto)) {
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar o produto.");
                    }
                    break;
                case 5:
                    System.out.println("Obrigado por usar nosso sistema. Até mais!");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
