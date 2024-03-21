package ArvoreGenealogica;

public class Main {
    public static void main(String[] args) {
        Pessoa avoPaterno = new Pessoa("João", 70);
        Pessoa avoMaterno = new Pessoa("Manuela", 72);
        Pessoa avoPaterna = new Pessoa("José", 68);
        Pessoa avoMaterna = new Pessoa("Maria", 75);

        Pessoa pai = new Pessoa("Carlos", 45, avoPaterno, avoMaterno);
        Pessoa mae = new Pessoa("Ana", 40, avoPaterna, avoMaterna);
        Pessoa filho = new Pessoa("Pedro", 20, pai, mae);
        filho.imprimirArvoreGenealogica();
    }
}