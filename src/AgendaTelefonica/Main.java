package AgendaTelefonica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaTelefonica agenda = new AgendaTelefonica();

        int escolha;
        do {
            System.out.println("---Agenda Telefônica DB---");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Deletar contato");
            System.out.println("3 - Listar contatos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nomeAdicao = scanner.nextLine();
                    System.out.print("Digite o número: ");
                    String numeroAdicao = scanner.nextLine();
                    agenda.adicionarContato(nomeAdicao, numeroAdicao);
                    break;
                case 2:
                    System.out.print("Digite o nome a ser deletado: ");
                    String nomeDelecao = scanner.nextLine();
                    agenda.deletarContato(nomeDelecao);
                    break;
                case 3:
                    agenda.listarContatos();
                    break;
                case 0:
                    System.out.println("Saindo.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        scanner.close();
    }
}

