package biblioteca;

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
