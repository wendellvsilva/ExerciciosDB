package Prova;

import java.util.ArrayList;

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

    public void realizarPagamento(int valorTotal, int valorPago) {
        int troco = valorPago - valorTotal;
        System.out.println("Troco: " + troco);

        calcularNotasTroco(troco);
    }
}