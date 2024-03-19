import java.util.Scanner;
import java.util.Random;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int escolha;
        do {
            System.out.println("Selecione um dos exercicíos :");
            System.out.println("1- Verificar se uma pessoa é maior de idade");
            System.out.println("2 - Desconto em produtos");
            System.out.println("3 - Jogar Jokenpo");
            System.out.println("4 - Calculadora");
            System.out.println("5 - Tabuada");
            System.out.println("6 - Gerar 10 números aleatórios");
            System.out.println("7 - Calcular a série de Fibonacci");
            System.out.println("8 - Jogo do numero(nao sei que nome dar)");
            System.out.println("9 - Calcular a série de Fibonacci com limite");
            System.out.println("0 - Sair");
            escolha = scanner.nextInt();

            switch(escolha) {
                case 1:
                    verificarIdade(scanner);
                    break;
                case 2:
                    DescontoProduto(scanner);
                    break;
                case 3:
                    jogarJokenpo(scanner, random);
                    break;
                case 4:
                    Calculadora(scanner);
                    break;
                case 5:
                    Tabuada(scanner);
                case 6:
                    gerarNumerosAleatorios(random);
                    break;
                case 7:
                    Fibonacci(scanner);
                case 8:
                    lerNumero(scanner);
                    break;
                case 9:
                    FibonacciComLimite(scanner);
                    break;

                case 0:
                    System.out.println("Programa encerrado!");
                    break;
            }
        } while(escolha != 0);

        scanner.close();
    }

    public static void DescontoProduto(Scanner scanner) {
        System.out.println("Produtos disponíveis:");
        System.out.println("1 - Camarão R$10,00");
        System.out.println("2 - Peixe sardinha R$2,00");
        System.out.println("3 - Lula R$9,00");
        System.out.println("4 - Polvo R$13,00");
        System.out.println("Digite o número do produto que você deseja:");

        int escolha = scanner.nextInt();
        int preco;
        String nomeProduto;

        switch (escolha) {
            case 1:
                nomeProduto = "Camarão";
                preco = 10;
                break;
            case 2:
                nomeProduto = "Peixe sardinha";
                preco = 2;
                break;
            case 3:
                nomeProduto = "Lula";
                preco = 9;
                break;
            case 4:
                nomeProduto = "Polvo";
                preco = 13;
                break;
            default:
                System.out.println("Produto não reconhecido.");
                return;
        }

        System.out.println("Digite a quantidade que você deseja:");
        int quantidade = scanner.nextInt();
        double valorTotal;

        if (quantidade <= 10) {
            valorTotal = quantidade * preco;
        } else if (quantidade <= 20) {
            valorTotal = quantidade * preco * 0.9;
        } else if (quantidade <= 50) {
            valorTotal = quantidade * preco * 0.8;
        } else {
            valorTotal = quantidade * preco * 0.75;
        }

        System.out.println("Você comprou " + quantidade + " unidades de "
                + nomeProduto + " e o valor total a ser pago é R$" + valorTotal);
    }
    public static void jogarJokenpo(Scanner scanner, Random random) {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Pedra");
        System.out.println("2. Papel");
        System.out.println("3. Tesoura");
        int escolhaJogador = scanner.nextInt();
        int escolhaComputador = random.nextInt(3);
        System.out.println("Sua escolha:" + escolhaJogador);
        System.out.println("Escolha da máquina:" + escolhaComputador);
        if (escolhaJogador == escolhaComputador) {
            System.out.println("Empate!");
        } else if ((escolhaJogador == 1 && escolhaComputador == 3) ||
                (escolhaJogador == 2 && escolhaComputador == 1) ||
                (escolhaJogador == 3 && escolhaComputador == 2)) {
            System.out.println("Você ganhou!");
        } else {
            System.out.println("Você perdeu!");
        }
    }
    public static void verificarIdade(Scanner scanner) {
        System.out.println("Digite a idade:");
        int idade = scanner.nextInt();
        if (idade >= 18) {
            System.out.println("Você tem " + idade + " anos e é maior de idade.");
        } else {
            System.out.println("Você tem " + idade + " anos e é menor de idade.");
        }
    }

    public static void Tabuada(Scanner scanner) {
        System.out.println("Digite um número:");
        int numero = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }

    public static void Calculadora(Scanner scanner) {

        int resultado;

        System.out.println("Bem-vindo a calculadora");
        System.out.println("Digite o primeiro número:");
        int numero1 = scanner.nextInt();
        System.out.println("Digite o segundo número:");
        int numero2 = scanner.nextInt();
        System.out.println("Agora digite qual operação deseja realizar:");
        System.out.println("1- Multiplicação, 2- Subtração, 3- Adição, 4- Divisão");
        int escolhaOperacao = scanner.nextInt();
        switch (escolhaOperacao) {
            case 1:
                resultado = (numero1 * numero2);
                System.out.println("Resultado: " + resultado);
                break;
            case 2:
                resultado = (numero1 - numero2);
                System.out.println("Resultado: " + resultado);
                break;
            case 3:
                resultado = (numero1 + numero2);
                System.out.println("Resultado: " + resultado);
                break;
            case 4:
                resultado = (numero1/numero2);
                System.out.println("Resultado: " + resultado);
                break;
        }

    }

    public static void gerarNumerosAleatorios(Random random) {
        int[] numeros = new int[10];
        for (int i = 0; i < 10; i++) {
            numeros[i] = random.nextInt(101);//método da biblioteca random pra gerar entre 0 e 100
            System.out.print(numeros[i] + " ");
        }
        int menor = numeros[0];
        int maior = numeros[0];
        for (int i = 1; i < 10; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
        }
        System.out.print("Números gerados: ");
        System.out.println("Menor número:" + menor);
        System.out.println("Maior número:" + maior);

    }

    public static void Fibonacci(Scanner scanner) {
        System.out.println("Diga um número:");
        int n = scanner.nextInt();
        int a = 0;
        int b = 1;
        for (int i = 0; i < 20; i++) {
            System.out.println(a);
            int aux = a;
            a = b;
            b = aux + b;
        }
    }

    public static void FibonacciComLimite(Scanner scanner) {
        System.out.println("Diga um número:");
        int n = scanner.nextInt();
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            System.out.println(a);
            int aux = a;
            a = b;
            b = aux + b;
        }
    }


    public static void lerNumero(Scanner scanner) {
        int numeroCerto = 10;
        System.out.println("Digite um número até acertar.");
        int num = scanner.nextInt();

        while (num != numeroCerto) {
            System.out.println("Número errado! Tente novamente");
            num = scanner.nextInt();
        }

        System.out.println("Parabéns! O número correto é o " + numeroCerto + "!");
    }
}