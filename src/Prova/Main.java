package Prova;

import java.util.Scanner;

public class Main {
    private Estoque estoque;
    private Pedido pedido;
    private Scanner scanner;

    public Main() {
        this.estoque = new Estoque();
        this.pedido = new Pedido();
        this.scanner = new Scanner(System.in);
        estoque.inicializaEstoque();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.controlaMenu();
    }

    public void controlaMenu() {
        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Mostrar estoque");
            System.out.println("2. Realizar um pedido");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    estoque.mostraEstoque();
                    break;
                case 2:
                    realizarPedido();
                    break;
                case 3:
                    System.out.println("Obrigado por usar nosso sistema. Até mais!");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }



    private void realizarPedido() {

        if (estoque.getListaDeProdutos().isEmpty()) {
            System.out.println("Desculpe, o estoque está vazio.");
            return;
        }

        estoque.imprimeCatalogoDoEstoque();

        System.out.print("Digite o ID do produto desejado: ");
        int idProduto = scanner.nextInt();
        scanner.nextLine();

        Produto produtoSelecionado = estoque.encontraProduto(idProduto);
        if (produtoSelecionado == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (!estoque.temEstoqueOuNao(produtoSelecionado, quantidade)) {
            System.out.println("Desculpe, não há estoque suficiente para este produto.");
            return;
        }

        if (pedido.adicionarItemNaLista(produtoSelecionado, quantidade)) {
            estoque.darBaixaEmEstoque(idProduto, quantidade);
            System.out.println("Produto adicionado ao pedido com sucesso!");
        } else {
            System.out.println("Erro ao adicionar o produto ao pedido.");
        }

        int valorTotal = (int) (produtoSelecionado.getPreco() * quantidade);
        System.out.println("Valor total: " + valorTotal);
        System.out.print("Digite o valor pago pelo cliente: ");
        int valorPago = scanner.nextInt();
        scanner.nextLine();
        int troco = valorPago - valorTotal;
        System.out.println("Troco: " + troco);

        calcularNotasTroco(troco);
    }

    private void calcularNotasTroco(double troco) {
        int[] notas = {100, 50, 20, 10, 5, 2};

        System.out.println("Valor do troco: R$" + troco);
        System.out.println("Notas para o troco:");

        for (int nota : notas) {
            int quantidade = (int) (troco / nota);
            troco -= quantidade * nota;
            if (quantidade > 0) {
                System.out.println(quantidade + " nota(s) de R$" + nota);
            }
        }
    }
}