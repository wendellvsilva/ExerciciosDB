package Automovel;

import java.util.Scanner;

public class Automovel {

    static Scanner scanner = new Scanner(System.in);
    String nome;
    int vel;

    static String nomeMotorista;

    void nomeMotor(Scanner scanner){
        //System.out.println("Digite seu nome");
        nomeMotorista = "Wendell";
    }

    static String getNomeMotorista() {
        return nomeMotorista;
    }

    void setNomeMotorista(String nomeMotorista) {
        Automovel.nomeMotorista = nomeMotorista;
    }

    void acelerar(int aceleracao) {
        vel+=aceleracao;
        if (vel>=90 && vel<120){
            System.out.println("Velocidade acima da média, atenção!");
        } else if (vel>120) {
            System.out.println("VELOCIDADE ALTA, ATENÇÃO!");

        }
    }

    void frear(int aceleracao) {
        vel-=aceleracao;
    }

    void buzinar(){
        System.out.println("bibibi");
    }

    void desligar(int aceleracao) {
        if (vel > 0) {
            vel -= aceleracao;
            if (vel < 0) { // aceleracao não pode ser negativa
                vel = 0;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
