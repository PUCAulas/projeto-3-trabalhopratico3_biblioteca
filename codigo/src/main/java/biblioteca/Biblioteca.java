package biblioteca;

import java.util.*;

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
    
}
