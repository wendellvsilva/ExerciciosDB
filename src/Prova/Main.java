package Prova;

import java.util.Scanner;

public class Main {
    private Scanner scanner;


    public static void main(String[] args) {
        Main main = new Main();
        main.controlaMenu();
    }

    public void controlaMenu() {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);
        Pedido pedido = new Pedido();
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
                    pedido.realizarPedido();
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

}