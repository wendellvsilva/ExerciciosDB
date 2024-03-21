package EmprestimoLivros;

public class Livro {
    private int id;
    private String titulo;
    private boolean emprestado;

    public Livro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.emprestado = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar() {
        emprestado = true;
    }

    public void devolver() {
        emprestado = false;
    }
}