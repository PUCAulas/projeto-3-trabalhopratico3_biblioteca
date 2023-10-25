package biblioteca;

//import java.util.*;

public abstract class Item implements Comparable<Item>, Emprestavel {
    private String titulo;
    private String autor;
    private int ano;
    private int vezesEmprestado;
    private boolean emprestavel;
    private int quantidade;

    public Item(String titulo, String autor, int ano, boolean emprestavel, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.emprestavel = emprestavel;
        this.quantidade = quantidade;
    }

    // Getters e setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getVezesEmprestado() {
        return vezesEmprestado;
    }

    public void setVezesEmprestado(int vezesEmprestado) {
        this.vezesEmprestado = vezesEmprestado;
    }

    public boolean isEmprestavel() {
        return emprestavel;
    }

    public void setEmprestavel(boolean emprestavel) {
        this.emprestavel = emprestavel;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean podeSerEmprestado() {
        return emprestavel && quantidade > 1;
    }

    @Override
    public int compareTo(Item outro) {
        return this.titulo.compareTo(outro.getTitulo());
    }
}

