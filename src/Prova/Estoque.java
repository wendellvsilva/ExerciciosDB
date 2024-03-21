package Prova;

import java.util.ArrayList;

public class Estoque {

    public Estoque() {
        inicializaEstoque();
    }

    private int id = 1;
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>();

    public void inicializaEstoque() {
        Produto p1 = new Produto(1, "Arroz", 5.99, 100);
        Produto p2 = new Produto(2, "Feijão", 4.99, 80);
        Produto p3 = new Produto(3, "Óleo", 7.99, 50);

        listaDeProdutos.add(p1);
        listaDeProdutos.add(p2);
        listaDeProdutos.add(p3);
    }

    public void mostraEstoque() {
        System.out.println("Estoque:");
        for (Produto produto : listaDeProdutos) {
            System.out.println(produto.getNome() + " - " + produto.getQuantidadeEmEstoque());
        }
    }

    public Produto encontraProduto(String nome) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public Produto encontraProduto(int id) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public boolean cadastraProduto(Produto produto) {
        if (produto != null) {
            listaDeProdutos.add(produto);
            return true;
        }
        return false;
    }

    public void imprimeCatalogoDoEstoque() {
        System.out.println("Catálogo do Estoque:");
        for (Produto produto : listaDeProdutos) {
            System.out.println(produto.getId() + " - " + produto.getNome() + " - R$ " + produto.getPreco());
        }
    }

    public boolean darBaixaEmEstoque(String nome, int quantidadeParaDarBaixa) {
        Produto produto = encontraProduto(nome);
        if (produto != null && produto.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa) {
            produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
            return true;
        }
        return false;
    }

    public boolean darBaixaEmEstoque(int id, int quantidadeParaDarBaixa) {
        Produto produto = encontraProduto(id);
        if (produto != null && produto.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa) {
            produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
            return true;
        }
        return false;
    }

    public int getPosicaoDoProdutoNaLista(Produto produto) {
        return listaDeProdutos.indexOf(produto);
    }

    public boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixa) {
        return produto.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa;
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }
}