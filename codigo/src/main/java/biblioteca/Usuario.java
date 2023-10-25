package biblioteca;

public abstract class Usuario implements Itens{

    private int id = 0;
    private static int proxID = 0;
    private String nome;

    public Usuario(String nome) {
        this.id = proxID++;
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