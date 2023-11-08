package biblioteca;

//import java.util.*;

public abstract class Item {
    String titulo;
    String autor;
    int ano;
    boolean disponivel;
    int vezesEmprestado;

    public Item(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
        this.vezesEmprestado = 0;
    }

    public String getTipo() {
        return this.getClass().getSimpleName();
    }
}

