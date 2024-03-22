package EmprestimoLivros;

public class Livro {
    private int id;
    private String titulo;
    private boolean emprestado;
    private Pessoa pessoaEmprestada;

    public Livro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.emprestado = false;
        this.pessoaEmprestada = null;
    }

    public int getId() {
        return id;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public Pessoa getPessoaEmprestada() {
        return pessoaEmprestada;
    }

    public void emprestarPara(Pessoa pessoa) {
        if (!emprestado) {
            this.emprestado = true;
            this.pessoaEmprestada = pessoa;
            System.out.println("Livro \"" + titulo + "\" emprestado para " + pessoa.getNome());
        } else {
            System.out.println("Este livro já está emprestado para " + pessoaEmprestada.getNome());
        }
    }

    public void devolver() {
        if (emprestado) {
            this.emprestado = false;
            System.out.println("Livro \"" + titulo + "\" devolvido por " + pessoaEmprestada.getNome());
            this.pessoaEmprestada = null;
        } else {
            System.out.println("Este livro já foi devolvido");
        }
    }
}