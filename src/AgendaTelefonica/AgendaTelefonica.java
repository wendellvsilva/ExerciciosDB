package AgendaTelefonica;

import java.util.ArrayList;

public class AgendaTelefonica {
    private ArrayList<Contato> contatos;

    public AgendaTelefonica() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(String nome, String numero) {
        contatos.add(new Contato(nome, numero));
        System.out.println("Contato adicionado com sucesso.");
    }

    public void deletarContato(String nome) {
        boolean removido = false;
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().equals(nome)) {
                contatos.remove(i);
                removido = true;
                System.out.println("Contato removido com sucesso.");
                break;
            }
        }
        if (!removido) {
            System.out.println("O contato não foi encontrado na agenda.");
        }
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            System.out.println("Agenda Telefônica:");
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }
}