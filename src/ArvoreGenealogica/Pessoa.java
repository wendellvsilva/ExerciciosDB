package ArvoreGenealogica;

public class Pessoa {
    private String nome;
    private int idade;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(String nome, int idade, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.idade = idade;
        this.pai = pai;
        this.mae = mae;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Pessoa getPai() {
        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }


    public void imprimirArvoreGenealogica() {
        if (pai != null) {
            if (pai.getPai() != null) {
                System.out.println("Avô Paterno: " + pai.getPai().getNome() + ", Idade: " + pai.getPai().getIdade());
            }
            if (pai.getMae() != null) {
                System.out.println("Avó Paterna: " + pai.getMae().getNome() + ", Idade: " + pai.getMae().getIdade());
            }
            System.out.println("Pai: " + pai.getNome() + ", Idade: " + pai.getIdade());
        } else {
            System.out.println("Pai: Desconhecido");
        }
        if (mae != null) {
            if (mae.getPai() != null) {
                System.out.println("Avô Materno: " + mae.getPai().getNome() + ", Idade: " + mae.getPai().getIdade());
            }
            if (mae.getMae() != null) {
                System.out.println("Avó Materna: " + mae.getMae().getNome() + ", Idade: " + mae.getMae().getIdade());
            }
            System.out.println("Mãe: " + mae.getNome() + ", Idade: " + mae.getIdade());
        } else {
            System.out.println("Mãe: Desconhecida");
        }
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

