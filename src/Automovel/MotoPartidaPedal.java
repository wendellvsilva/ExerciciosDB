package Automovel;

import java.util.Scanner;

public class MotoPartidaPedal extends Moto {
    private boolean motoLigada;

    public MotoPartidaPedal() {
        this.motoLigada = false;
    }

    public void ligar() {
        this.motoLigada = true;
        System.out.println("Moto ligada.");
    }

    public void desligar() {
        this.motoLigada = false;
        System.out.println("Moto desligada.");
    }

    public boolean isMotoLigada() {
        return motoLigada;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MotoPartidaPedal motoPedal = new MotoPartidaPedal();
        motoPedal.vel = 10;
        motoPedal.nome = "Honda";

        System.out.println("Pressione qualquer tecla para puxar o acelerador.");
        scanner.nextLine();
        motoPedal.ligar();

        if (motoPedal.isMotoLigada()) {
            System.out.println("Motorista: " + Automovel.getNomeMotorista());
            System.out.println("Dirigindo..");
            System.out.println("Velocidade atual: " + motoPedal.vel + " km/h");

            int escolha;
            do {
                System.out.println("[1] Acelerar [2] Freiar [3] Buzinar [4] Desligar a moto");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        motoPedal.acelerar(10);
                        System.out.println("Velocidade atual: " + motoPedal.vel + " km/h");
                        break;
                    case 2:
                        motoPedal.frear(30);
                        if (motoPedal.vel <= 0) {
                            motoPedal.vel = 0;
                        }
                        System.out.println("Velocidade atual: " + motoPedal.vel + " km/h");
                        break;
                    case 3:
                        motoPedal.buzinar();
                        break;
                    case 4:
                        motoPedal.desligar();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } while (escolha != 4);
        }
    }
}