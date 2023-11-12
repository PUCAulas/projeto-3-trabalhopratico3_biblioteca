package biblioteca;

public class Tese extends Item {
    public Tese(String titulo, String autor, int ano) {
        super(titulo, autor, ano);
    }

    public boolean podeSerEmprestado() {
        return false;
    }
}