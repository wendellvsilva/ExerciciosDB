package EmprestimoLivros;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        int proximoIdPessoa = 1;
        int proximoIdLivro = 1;

        int escolha;
        do {
            System.out.println("--------LIVRARIA DB-------");
            System.out.println("1 - Adicionar Pessoa");
            System.out.println("2 - Adicionar Livro");
            System.out.println("3 - Realizar Empréstimo");
            System.out.println("4 - Devolver Livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome da pessoa: ");
                    scanner.nextLine();
                    String nomePessoa = scanner.nextLine();
                    pessoas.add(new Pessoa(proximoIdPessoa, nomePessoa));
                    System.out.println("Pessoa adicionada com sucesso! (ID: " + proximoIdPessoa + ")");
                    proximoIdPessoa++;
                    break;
                case 2:
                    System.out.print("Digite o título do livro: ");
                    scanner.nextLine();
                    String tituloLivro = scanner.nextLine();
                    livros.add(new Livro(proximoIdLivro, tituloLivro));
                    System.out.println("Livro adicionado com sucesso! (ID: " + proximoIdLivro + ")");
                    proximoIdLivro++;
                    break;
                case 3:
                    System.out.println("DB Empréstimos");
                    System.out.print("Digite o ID da pessoa: ");
                    int idPessoa = scanner.nextInt();
                    System.out.print("Digite o ID do livro: ");
                    int idLivro = scanner.nextInt();

                    Pessoa pessoaSelecionada = null;
                    Livro livroSelecionado = null;

                    for (Pessoa pessoa : pessoas) {
                        if (pessoa.getId() == idPessoa) {
                            pessoaSelecionada = pessoa;
                            break;
                        }
                    }

                    for (Livro livro : livros) {
                        if (livro.getId() == idLivro) {
                            livroSelecionado = livro;
                            break;
                        }
                    }

                    if (pessoaSelecionada != null && livroSelecionado != null) {
                        if (!livroSelecionado.isEmprestado()) {
                            Emprestimo emprestimo = new Emprestimo(livroSelecionado, pessoaSelecionada);
                            livroSelecionado.emprestar();
                            emprestimos.add(emprestimo);
                            System.out.println("Empréstimo realizado com sucesso!");
                        } else {
                            System.out.println("Livro já está emprestado.");
                        }
                    } else {
                        System.out.println("ID da pessoa ou do livro inválido.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do livro a ser devolvido: ");
                    int idLivroDevolucao = scanner.nextInt();
                    Livro livroDevolucao = null;

                    for (Livro livro : livros) {
                        if (livro.getId() == idLivroDevolucao) {
                            livroDevolucao = livro;
                            break;
                        }
                    }

                    if (livroDevolucao != null) {
                        if (livroDevolucao.isEmprestado()) {
                            for (Emprestimo emprestimo : emprestimos) {
                                if (emprestimo.getLivro().getId() == livroDevolucao.getId()) {
                                    livroDevolucao.devolver();
                                    emprestimos.remove(emprestimo);
                                    System.out.println("Livro devolvido com sucesso!");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Livro não está emprestado.");
                        }
                    } else {
                        System.out.println("ID do livro inválido.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);

        scanner.close();
    }
}