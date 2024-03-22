
package Automovel;


import java.util.Scanner;

public class Carro extends Automovel {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Carro c1 = new Carro();
        c1.vel = 10;
        c1.nome = "Uno";
        c1.nomeMotor(scanner);
        System.out.println("Motorista:" + Automovel.getNomeMotorista());
        System.out.println("Dirigindo..");
        System.out.println("Velocidade atual: " + c1.vel + "km/h");

        int escolha;
        do {
            System.out.println("[1]Acelerar[2]Freiar[3]Buzinar[4]Desligar o carro");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    c1.acelerar(10);
                    System.out.println("Velocidade atual:" + c1.vel + "km/h");
                    break;
                case 2:
                    c1.frear(30);
                    if(c1.vel<=0){
                        c1.vel = 0;
                    }
                    System.out.println("Velocidade atual:" + c1.vel + "km/h");
                    break;
                case 3:
                    c1.buzinar();
                    break;
                case 4:
                    if (c1.vel == 0){
                        c1.desligar(0);
                        System.out.println("Carro desligado.");
                    } else {
                        System.out.println("Reduzindo velocidade para desligar o carro..");
                        while (c1.vel > 0){
                            c1.frear(30);
                            if (c1.vel < 0) {
                                c1.vel = 0;
                            }
                            System.out.println("Velocidade atual:" + c1.vel + "km/h");
                        }
                        System.out.println("Carro desligado.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");


            }

        } while (escolha != 4);


    }
}

