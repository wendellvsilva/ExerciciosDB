package Automovel;

import java.util.Scanner;

public class Moto extends Automovel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Moto m1 = new Moto();
        m1.vel = 10;
        m1.nome = "Honda";
        m1.nomeMotor(scanner);
        System.out.println("Motorista:" + Automovel.getNomeMotorista());
        System.out.println("Dirigindo..");
        System.out.println("Velocidade atual: " + m1.vel + "km/h");

        int escolha;
        do {
            System.out.println("[1]Acelerar [2]Freiar [3]Buzinar [4]Ligar a moto[5]Desligar a moto");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    m1.acelerar(10);
                    System.out.println("Velocidade atual: " + m1.vel + "km/h");
                    break;
                case 2:
                    m1.frear(30);
                    if (m1.vel < 0) {
                        m1.vel = 0;
                    } else if (m1.vel == 0) {
                        System.out.println("Moto parada.");
                    }
                    System.out.println("Velocidade atual: " + m1.vel + "km/h");
                    break;
                case 3:
                    m1.buzinar();
                    break;
                case 4:
                    System.out.println("Opção indisponível: partida elétrica removida.");
                    break;
                case 5:
                    if (m1.vel == 0) {
                        m1.desligar(0);
                        System.out.println("Moto desligada.");
                    } else {
                        System.out.println("Reduzindo velocidade para desligar a moto..");
                        while (m1.vel > 0) {
                            m1.frear(30);
                            if (m1.vel < 0) {
                                m1.vel = 0;
                            }
                            System.out.println("Velocidade atual:" + m1.vel + "km/h");
                        }
                        System.out.println("Moto desligada.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida!.");
                    break;
            }
        } while (escolha != 0);
    }
}