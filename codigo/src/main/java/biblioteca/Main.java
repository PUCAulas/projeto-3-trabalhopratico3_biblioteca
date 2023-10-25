import java.util.*;

public interface Emprestavel {
    boolean podeSerEmprestado();
}

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

    // Getters e setters

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

public class Usuario {

    private int id = 0;
    private String nome;

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

}

public class Biblioteca {
    private List<Item> itens = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public Biblioteca(List<Item> itens, List<Usuario> usuarios) {
        this.itens = itens;
        this.usuarios = usuarios;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        Collections.sort(itens);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario getUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public Item getItem(String titulo) {
        for (Item item : itens) {
            if (item.getTitulo().equals(titulo)) {
                return item;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar item");
            System.out.println("2. Adicionar usuário");
            System.out.println("3. Pegar item");
            System.out.println("4. Devolver item");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            switch (opcao) {
                case 1:
                    sc = new Scanner(System.in);
                    System.out.print("Digite o título do item: ");
                    String titulo = sc.nextLine();
                    System.out.print("Digite o autor do item: ");
                    String autor = sc.nextLine();
                    System.out.print("Digite o ano do item: ");
                    int ano = sc.nextInt();
                    sc.nextLine(); // Consume newline left-over
                    Item item = new Livro(titulo, autor, ano, true, 3);
                    biblioteca.adicionarItem(item);
                    break;
                case 2:
                    sc = new Scanner(System.in);
                    System.out.print("Digite o nome do usuário: ");
                    String nome = sc.nextLine();
                    Usuario usuario = new Usuario(nome);
                    biblioteca.adicionarUsuario(usuario);
                    break;
                case 3:
                    sc = new Scanner(System.in);
                    System.out.print("Digite o nome do usuário: ");
                    nome = sc.nextLine();
                    System.out.print("Digite o título do item: ");
                    titulo = sc.nextLine();
                    usuario = biblioteca.getUsuario(nome);
                    item = biblioteca.getItem(titulo);
                    if (usuario != null && item != null) {
                        usuario.pegarItem(item);
                    } else {
                        System.out.println("Usuário ou item não encontrado.");
                    }
                    break;
                case 4:
                    sc = new Scanner(System.in);
                    System.out.print("Digite o nome do usuário: ");
                    nome = sc.nextLine();
                    System.out.print("Digite o título do item: ");
                    titulo = sc.nextLine();
                    usuario = biblioteca.getUsuario(nome);
                    item = biblioteca.getItem(titulo);
                    if (usuario != null && item != null) {
                        usuario.devolverItem(item);
                    } else {
                        System.out.println("Usuário ou item não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
