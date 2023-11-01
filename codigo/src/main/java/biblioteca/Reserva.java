package biblioteca;

public class Reserva {
    private Usuario usuario;
    private Livro livro;
    private boolean status;

    public Reserva(Usuario usuario, Livro livro, boolean status) {
        this.usuario = usuario;
        this.livro = livro;
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
