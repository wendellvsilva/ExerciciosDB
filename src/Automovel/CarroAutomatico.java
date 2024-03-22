package Automovel;

import java.util.Scanner;

public class CarroAutomatico extends Carro {
    private boolean freioPressionado;

    public CarroAutomatico() {
        super();
        this.freioPressionado = false;
    }

    public void pressionarFreio() {
        this.freioPressionado = true;
    }

    public void soltarFreio() {
        this.freioPressionado = false;
    }

    public boolean freioPressionado() {
        return freioPressionado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarroAutomatico c1 = new CarroAutomatico();
        c1.vel = 10;
        c1.nome = "Carro";


        System.out.println("Pressione o freio para ligar o carro.");
        System.out.println("Digite qualquer tecla para pressionar o freio.");
        scanner.next();
        c1.pressionarFreio();

        //verifica se o freio está pressionado antes de ligar o carro
        if (c1.freioPressionado()) {
            System.out.println("Freio pressionado. Ligando o carro...");
            System.out.println("Motorista:" + Automovel.getNomeMotorista());
            System.out.println("Dirigindo..");
            System.out.println("Velocidade atual: " + c1.vel + "km/h");

            int escolha;
            do {
                System.out.println("[1]Acelerar [2]Freiar [3]Buzinar [4]Desligar o carro");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        c1.acelerar(10);
                        System.out.println("Velocidade atual: " + c1.vel + "km/h");
                        break;
                    case 2:
                        c1.frear(30);
                        if (c1.vel <= 0) {
                            c1.vel = 0;
                        }
                        System.out.println("Velocidade atual: " + c1.vel + "km/h");
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
        } else {
            System.out.println("Freio não pressionado. Não é possível ligar o carro.");
        }
    }
}