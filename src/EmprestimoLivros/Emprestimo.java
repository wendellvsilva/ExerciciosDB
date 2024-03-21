package EmprestimoLivros;

import java.util.Date;

public class Emprestimo {

    private Livro livro;
    private Pessoa pessoa;
    private Date dataEmprestimo;

    public Emprestimo(Livro livro, Pessoa pessoa) {
        this.livro = livro;
        this.pessoa = pessoa;
        this.dataEmprestimo = new Date();
    }

    public Livro getLivro() {
        return livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

}
