package biblioteca;

import java.util.*;

public class Biblioteca {
    Map<String, Item> itens = new HashMap<>();
    Map<String, Usuario> usuarios = new HashMap<>();

    public void adicionarItem(Item item) {
        itens.put(item.titulo, item);
    }

    public void removerItem(String titulo) {
        itens.remove(titulo);
    }

    public void editarItem(String titulo, Item novoItem) {
        removerItem(titulo);
        adicionarItem(novoItem);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.nome, usuario);
    }

    public void removerUsuario(String nome) {
        usuarios.remove(nome);
    }

    public void editarUsuario(String nome, Usuario novoUsuario) {
        removerUsuario(nome);
        adicionarUsuario(novoUsuario);
    }

    public void emprestarItem(String titulo, String nomeUsuario) throws EmprestimoException {
        Item item = itens.get(titulo);
        Usuario usuario = usuarios.get(nomeUsuario);
        if (item == null) {
            throw new EmprestimoException("Item não encontrado.");
        } else if (usuario == null) {
            throw new EmprestimoException("Usuário não encontrado.");
        } else if (!(item instanceof Emprestavel)) {
            throw new EmprestimoException("Este item não pode ser emprestado.");
        } else if (!item.disponivel) {
            throw new EmprestimoException("Este item já está emprestado.");
        } else if (!usuario.podeEmprestar()) {
            throw new EmprestimoException("O usuário já atingiu o limite de empréstimos.");
        } else {
            item.disponivel = false;
            item.vezesEmprestado++;
            usuario.emprestimos.add(item);
        }
    }

    public boolean devolverItem(String titulo, String nomeUsuario) throws Exception {
        Item item = itens.get(titulo);
        Usuario usuario = usuarios.get(nomeUsuario);
        if (item == null) {
            throw new Exception("Item não encontrado na biblioteca.");
        }
        if (usuario == null) {
            throw new Exception("Usuário não encontrado.");
        }
        if (!usuario.emprestimos.contains(item)) {
            throw new Exception("Este usuário não emprestou este item.");
        }
        item.disponivel = true;
        usuario.emprestimos.remove(item);
        return true;
    }

    public List<Item> listarItens() {
        List<Item> listaItens = new ArrayList<>(itens.values());
        listaItens.sort(Comparator.comparing(item -> item.titulo));
        return listaItens;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>(usuarios.values());
        listaUsuarios.sort(Comparator.comparing(usuario -> usuario.nome));
        return listaUsuarios;
    }

    public List<Item> pesquisarItens(String termo, String tipoPesquisa) {
        List<Item> resultados = new ArrayList<>();
        for (Item item : itens.values()) {
            switch (tipoPesquisa) {
                case "titulo":
                    if (item.titulo.contains(termo)) {
                        resultados.add(item);
                    }
                    break;
                case "autor":
                    if (item.autor.contains(termo)) {
                        resultados.add(item);
                    }
                    break;
                case "ano":
                    if (Integer.toString(item.ano).equals(termo)) {
                        resultados.add(item);
                    }
                    break;
                case "tipo":
                    if (item.getTipo().equals(termo)) {
                        resultados.add(item);
                    }
                    break;
            }
        }
        resultados.sort(Comparator.comparing(item -> item.titulo));
        return resultados;
    }

    public void emitirRelatorioPorItem() {
        List<Item> listaItens = new ArrayList<>(itens.values());
        listaItens.sort(Comparator.comparing(item -> item.ano));
        for (Item item : listaItens) {
            System.out.println(item.titulo + " - " + item.ano + " - " + item.vezesEmprestado + " vezes emprestado");
        }
    }

    public void emitirRelatorioPorUsuario(String nomeUsuario) {
        Usuario usuario = usuarios.get(nomeUsuario);
        if (usuario != null) {
            List<Item> emprestimos = new ArrayList<>(usuario.emprestimos);
            emprestimos.sort(Comparator.comparing(item -> item.titulo));
            for (Item item : emprestimos) {
                System.out.println(item.titulo);
            }
        }
    }

    public void popularBiblioteca() {
        for (int i = 1; i <= 3; i++) {
            adicionarItem(new Livro("Livro " + i, "Autor " + i, 2000 + i));
            adicionarItem(new Tese("Tese " + i, "Autor " + i, 2000 + i));
            adicionarItem(new Revista("Revista " + i, "Autor " + i, 2000 + i));
            adicionarItem(new CD("CD " + i, "Autor " + i, 2000 + i));
            adicionarItem(new DVD("DVD " + i, "Autor " + i, 2000 + i));
            adicionarUsuario(new Usuario("Usuário " + i, 122));
        }
    }

}
