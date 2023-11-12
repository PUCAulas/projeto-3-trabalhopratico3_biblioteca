package biblioteca;

import java.util.*;

class Usuario {
    private int id = 0;
    private static int proxID = 0;
    public int cpf;
    public String nome;
    List<Item> emprestimos = new ArrayList<>();

    public Usuario(String nome, int cpf) {
        this.id = proxID++;
        this.nome = nome;
        this.cpf = cpf;
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public boolean podeEmprestar() {
        return emprestimos.size() < 3;
    }

    public void emprestarItem(Item item) throws EmprestimoException {
        if (this.podeEmprestar()) {
            item.emprestar();
            this.emprestimos.add(item);
        } else {
            throw new EmprestimoException("O usuário não pode emprestar mais itens.");
        }
    }
}
