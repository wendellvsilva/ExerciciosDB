package Metodos;

import Metodos.Calculadora;

import java.util.Scanner;

public class Menu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha;
        do {
            System.out.println("-----MENU DE OPÇÕES-------");
            System.out.println("1 - Calcular média");
            System.out.println("2 - Equivalência de segundos");
            System.out.println("3 - Calculadora");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    SistemaMedias(scanner);
                    break;
                case 2:
                    equivalenciaSegundos(scanner);
                    break;
                case 3:
                    calculadora(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do programa");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 0);

        scanner.close();
    }

    public static void SistemaMedias(Scanner scanner) {
        System.out.println("Digite qual opção você deseja:");
        System.out.println("1 - Calcular sua média");
        System.out.println("2 - Verificar situação da média do aluno");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1:
                calcularMedia(scanner);
                break;
            case 2:
                VerificacaoMedia(scanner);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void calcularMedia(Scanner scanner) {

        System.out.println("Digite sua primeira nota");
        float n1 = scanner.nextFloat();
        System.out.println("Digite sua segunda nota");
        float n2 = scanner.nextFloat();
        System.out.println("Digite sua terceira nota");
        float n3 = scanner.nextFloat();

        float media = (n1 + n2 + n3)/3;
        System.out.println("Sua média é " + media);
    }

    public static void VerificacaoMedia(Scanner scanner){
        System.out.println("Digite sua média:");
        float notaAluno = scanner.nextFloat();
        if (notaAluno >= 6) {
            System.out.println("Aprovado!");
        } else if (notaAluno >= 4 && notaAluno < 6) {
            System.out.println("Verificação suplementar.");
        } else if (notaAluno >= 0 && notaAluno < 4) {
            System.out.println("Reprovado!");
        } else {
            System.out.println("Nota inválida! Tente novamente.");
        }
    }

    public static void equivalenciaSegundos(Scanner scanner) {
        int segundos = lerSegundos(scanner);
        int horas = calcularHoras(segundos);
        int minutos = calcularMinutos(segundos);
        int segundosRestantes = calcularSegundos(segundos);

        escreverEquivalencia(segundos, horas, minutos, segundosRestantes);
    }

    public static int lerSegundos(Scanner scanner) {
        System.out.println("Digite a quantidade de segundos:");
        return scanner.nextInt();
    }

    public static int calcularHoras(int segundos) {
        return segundos / 3600;
    }

    public static int calcularMinutos(int segundos) {
        return (segundos % 3600) / 60;
    }

    public static int calcularSegundos(int segundos) {
        return segundos % 60;
    }

    public static void escreverEquivalencia(int totalSegundos, int horas, int minutos, int segundosRestantes) {
        System.out.println(totalSegundos + " segundos equivalem a " + horas + " horas, " + minutos + " minutos e " +
                segundosRestantes + " segundos.");
    }

    public static void calculadora(Scanner scanner) {
        System.out.println("Selecione uma operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("5 - Potenciação");

        int opcao = scanner.nextInt();
        System.out.println("Digite os dois números:");

        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        switch (opcao) {
            case 1:
                System.out.println("Resultado da soma: " + Calculadora.somar(num1, num2));
                break;
            case 2:
                System.out.println("Resultado da subtração: " + Calculadora.subtrair(num1, num2));
                break;
            case 3:
                System.out.println("Resultado da multiplicação: " + Calculadora.multiplicar(num1, num2));
                break;
            case 4:
                System.out.println("Resultado da divisão: " + Calculadora.dividir(num1, num2));
                break;
            case 5:
                System.out.println("Resultado da potenciação: " + Calculadora.potencia(num1, num2));
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}

