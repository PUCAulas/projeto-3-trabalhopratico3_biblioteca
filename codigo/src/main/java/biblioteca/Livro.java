package biblioteca;

import java.util.ArrayList;

public abstract class Livro extends Item implements Itens {
    public Livro(String titulo, String autor, int ano, boolean emprestavel, int quantidade) {
        super(titulo, autor, ano, emprestavel, quantidade);
    }

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;

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

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
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

     public static void listarLivrosDisponiveis(ArrayList<Livro> biblioteca) {
        System.out.println("Livros Disponíveis na Biblioteca:");
        for (Livro livro : biblioteca) {
            if (livro.isDisponivel()) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
                System.out.println("-----------------------");
            }
        }
    }
}
