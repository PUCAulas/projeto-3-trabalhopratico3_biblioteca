package biblioteca;

import java.util.ArrayList;

public abstract class Usuario implements Itens{

    private int id = 0;
    private static int proxID = 0;
    private String nome;
    private int cpf;
    private ArrayList<Livro> livrosEmprestados = new ArrayList<>();

    public Usuario(String nome, int cpf) {
        this.id = proxID++;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

      public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(ArrayList<Livro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public void adicionarLivroEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
    }

    public void removerLivroEmprestado(Livro livro) {
        livrosEmprestados.remove(livro);
    }

}