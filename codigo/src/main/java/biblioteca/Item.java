package biblioteca;

import java.util.*;

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

public interface Itens {
    pegarItem();

    devolverItem();
}

public class Livro extends Item implements Itens {
    public Livro(String titulo, String autor, int ano, boolean emprestavel, int quantidade) {
        super(titulo, autor, ano, emprestavel, quantidade);
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void pegarItem(Item item) {
        if (!emprestimoAtrasado && itensEmprestados.size() < 3 && item.podeSerEmprestado()) {
            itensEmprestados.add(item);
            item.setQuantidade(item.getQuantidade() - 1);
        } else {
            System.out.println("Não foi possível pegar o item.");
        }
    }

    public void devolverItem(Item item) {
        if (itensEmprestados.contains(item)) {
            itensEmprestados.remove(item);
            item.setQuantidade(item.getQuantidade() + 1);
        } else {
            System.out.println("O item não foi emprestado por este usuário.");
        }
    }
}