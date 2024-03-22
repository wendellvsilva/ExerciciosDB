package Prova;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {

    private ArrayList<Item> listaDeItens = new ArrayList<>();
    private double valorTotalDoPedido = 0;

    public double calcularValorTotal(Produto produto, int quantidade) {
        double valorTotalDoPedido = produto.getPreco() * quantidade;
        return valorTotalDoPedido;
    }

    public boolean adicionarItemNaLista(Produto produto, int quantidade) {
        if (produto != null && quantidade > 0) {
            Item item = new Item(produto, quantidade);
            listaDeItens.add(item);
            return true;
        }
        return false;
    }

    public void imprimePedido() {
        System.out.println("Pedido:");
        for (Item item : listaDeItens) {
            System.out.println(item.getProduto().getNome() + " - " + item.getQuantidade() + " unidades");
        }
    }

    public void imprimeValorTotal() {
        System.out.println("Valor Total do Pedido: R$" + valorTotalDoPedido);
    }

    public void limparCarrinho() {
        listaDeItens.clear();
    }

    public int calcularNotasTroco(double troco) {
        int contador = 0;
        while (troco > 0) {
            if (troco >= 200) {
                troco -= 200;
                contador++;
            } else if (troco >= 100) {
                troco -= 100;
                contador++;
            } else if (troco >= 50) {
                troco -= 50;
                contador++;
            } else if (troco >= 20) {
                troco -= 20;
                contador++;
            } else if (troco >= 10) {
                troco -= 10;
                contador++;
            } else if (troco >= 5) {
                troco -= 5;
                contador++;
            } else if (troco >= 2) {
                troco -= 2;
                contador++;
            } else {
                troco -= 1; //isso evita loops infinitos quando o troco restante for 1
                contador++;
            }
        }
        return contador;
    }

    public void realizarPedido(Estoque estoque) {
        Scanner scanner = new Scanner(System.in);
        Pedido pedido = new Pedido();

        if (estoque.getListaDeProdutos().isEmpty()) {
            System.out.println("Desculpe, o estoque está vazio.");// se zerarmos todo o estoque, essa mensagem aparece.
        }

        System.out.print("Digite o ID do produto desejado: ");
        int idProduto = scanner.nextInt();
        scanner.nextLine();

        Produto produtoSelecionado = estoque.encontraProduto(idProduto);
        if (produtoSelecionado == null) {
            System.out.println("Produto não encontrado.");
        }

        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (!estoque.temEstoqueOuNao(produtoSelecionado, quantidade)) {
            System.out.println("Desculpe, não há estoque suficiente para este produto.");

        }

        if (pedido.adicionarItemNaLista(produtoSelecionado, quantidade)) {
            estoque.darBaixaEmEstoque(idProduto, quantidade);
            System.out.println("Produto adicionado ao pedido com sucesso!");
        } else {
            System.out.println("Erro ao adicionar o produto ao pedido.");
        }

        int valorTotal = (int) (produtoSelecionado.getPreco() * quantidade);
        System.out.println("Valor total: R$" + valorTotal);
        System.out.print("Qual o valor de notas que deseja pagar?: ");
        int valorPago = scanner.nextInt();
        scanner.nextLine();

        if (valorPago < valorTotal) {
            System.out.println("Valor insuficiente.");//caso o cliente queira dar um valor menor que o preço do pedido
        } else {
            int troco = valorPago - valorTotal;
            System.out.println("Troco: R$" + troco);

            int quantidadeNotas = calcularNotasTroco(troco);
            System.out.println("Quantidade de notas para o troco: " + quantidadeNotas);
        }
    }
}