package Automovel;

import java.util.Scanner;

public class MotoPartidaPedal extends Moto {
    private boolean aceleradorPuxado;

    public MotoPartidaPedal() {
        super();
        this.aceleradorPuxado = false;
    }

    public void puxarAcelerador() {
        this.aceleradorPuxado = true;
    }

    public void soltarAcelerador() {
        this.aceleradorPuxado = false;
    }

    public void ligar() {
        if (aceleradorPuxado) {
            System.out.println("Moto ligada.");
        } else {
            System.out.println("Não é possível ligar a moto sem o acelerador puxado.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MotoPartidaPedal motoPedal = new MotoPartidaPedal();
        motoPedal.vel = 10;
        motoPedal.nome = "Moto Partida Pedal";
        motoPedal.nomeMotor(scanner);
        System.out.println("Motorista:" + Automovel.getNomeMotorista());
        System.out.println("Dirigindo..");
        System.out.println("Velocidade atual: " + motoPedal.vel + "km/h");

        int escolha;
        do {
            System.out.println("[1]Acelerar [2]Freiar [3]Buzinar [4]Ligar a moto [5]Desligar a moto [6]Puxar acelerador");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    motoPedal.acelerar(10);
                    System.out.println("Velocidade atual: " + motoPedal.vel + "km/h");
                    break;
                case 2:
                    motoPedal.frear(30);
                    if (motoPedal.vel < 0) {
                        motoPedal.vel = 0;
                    } else if (motoPedal.vel == 0) {
                        System.out.println("Moto parada.");
                    }
                    System.out.println("Velocidade atual: " + motoPedal.vel + "km/h");
                    break;
                case 3:
                    motoPedal.buzinar();
                    break;
                case 4:
                    motoPedal.ligar();
                    break;
                case 5:
                    if (motoPedal.vel == 0) {
                        motoPedal.desligar(0);
                        System.out.println("Moto desligada.");
                    } else {
                        System.out.println("Reduzindo velocidade para desligar a moto..");
                        while (motoPedal.vel > 0) {
                            motoPedal.frear(30);
                            if (motoPedal.vel < 0) {
                                motoPedal.vel = 0;
                            }
                            System.out.println("Velocidade atual:" + motoPedal.vel + "km/h");
                        }
                        System.out.println("Moto desligada.");
                    }
                    break;
                case 6:
                    if (!motoPedal.aceleradorPuxado) {
                        motoPedal.puxarAcelerador();
                        System.out.println("Acelerador puxado.");
                    } else {
                        motoPedal.soltarAcelerador();
                        System.out.println("Acelerador solto.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!.");
                    break;
            }
        } while (escolha != 0);
    }
}