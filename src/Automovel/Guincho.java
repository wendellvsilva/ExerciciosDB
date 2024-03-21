package Automovel;

import java.util.Scanner;

public class Guincho extends Automovel {
    private Carro carro;
    private Moto moto;
    private static boolean carroGuinchado = false;
    private static boolean motoGuinchada = false;

    public Guincho(Carro carro) {
        this.carro = carro;
        guincharCarro();
        carroGuinchado = true;
    }

    public Guincho(Moto moto) {
        this.moto = moto;
        guincharMoto();
        motoGuinchada = true;
    }

    public void guincharCarro() {
        System.out.println("Motorista: " + getNomeMotorista());
        System.out.println("Dirigindo..");
        System.out.println("Guinchando um " + carro.getNome());
    }

    public void guincharMoto() {
        System.out.println("Motorista: " + getNomeMotorista());
        System.out.println("Dirigindo..");
        System.out.println("Guinchando uma " + moto.getNome());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Guincho guinchoCarro = null;
        Guincho guinchoMoto = null;

        do {
            System.out.println("Temos um carro e uma moto infratores. Qual deseja guinchar?");
            System.out.println("1 - Guinchar um carro");
            System.out.println("2 - Guinchar uma moto");
            System.out.println("0 - Sair");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    if (!carroGuinchado) {
                        Carro c1 = new Carro();
                        c1.nome = "Uno";
                        c1.nomeMotor(scanner);
                        guinchoCarro = new Guincho(c1);
                        carroGuinchado = true;
                    } else {
                        System.out.println("O carro já foi guinchado.");
                    }
                    break;
                case 2:
                    if (!motoGuinchada) {
                        Moto m1 = new Moto();
                        m1.nome = "Yamaha";
                        m1.nomeMotor(scanner);
                        guinchoMoto = new Guincho(m1);
                        motoGuinchada = true;
                    } else {
                        System.out.println("A moto já foi guinchada.");
                    }
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (guinchoCarro == null || guinchoMoto == null);

        scanner.close();
    }
}