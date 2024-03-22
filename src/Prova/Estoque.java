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

    public void imprimeCatalogoDoEstoque() {
        System.out.println("Estoque:");
        for (Produto produto : listaDeProdutos) {
            System.out.println(produto.getNome() + " - " + produto.getQuantidadeEmEstoque());
        }
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



    public boolean darBaixaEmEstoque(int id, int quantidadeParaDarBaixa) {
        Produto produto = encontraProduto(id);
        if (produto != null && produto.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa) {
            produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
            return true;
        }
        return false;
    }

    public boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixa) {
        return produto.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa;
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }
}