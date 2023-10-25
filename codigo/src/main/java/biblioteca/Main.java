package biblioteca;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca;

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
