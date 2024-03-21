package Prova;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {


    private ArrayList<Item> listaDeItens = new ArrayList<>();
    private double valorTotalDoPedido = 0;

    public double calcularValorTotal() {
        valorTotalDoPedido = 0;
        for (Item item : listaDeItens) {
            valorTotalDoPedido += item.getValorDoItem();
        }
        return valorTotalDoPedido;
    }

    public void setListaDeItens(ArrayList<Item> listaDeItens) {
        this.listaDeItens = listaDeItens;
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

    public void adicionaItem() {
    }

    public int recebeNomeDoTeclado() {
        return 0;
    }

    public void limparCarrinho() {
        listaDeItens.clear();
    }

    public void calcularNotasTroco(double troco) {
        int[] notas = {100, 50, 20, 10, 5, 2};//sao as notas em papel existentes no Brasil

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

    public ArrayList<Item> getListaDeItens() {
        return listaDeItens;
    }

    public void realizarPedido() {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        Pedido pedido = new Pedido();
        estoque.inicializaEstoque();

        if (estoque.getListaDeProdutos().isEmpty()) {
            System.out.println("Desculpe, o estoque está vazio.");
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

        if (valorPago<valorTotal){
            System.out.println("Valor insuficiente.");
        } else {


            int troco = valorPago - valorTotal;


            System.out.println("Troco: " + troco);

            calcularNotasTroco(troco);
        }
    }
}