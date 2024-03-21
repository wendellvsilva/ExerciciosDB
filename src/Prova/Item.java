package Prova;

public class Item {
    private Produto produto;
    private int quantidade;
    private double valorDoItem;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorDoItem = produto.getPreco() * quantidade;
    }

    public double getValorDoItem() {
        return valorDoItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}