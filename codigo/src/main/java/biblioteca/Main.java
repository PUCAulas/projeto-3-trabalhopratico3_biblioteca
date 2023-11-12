package biblioteca;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        String titulo, autor;
        int ano;
        // biblioteca.popularBiblioteca();

        while (true) {
            try {
                System.out.println("1. Adicionar usuário");
                System.out.println("2. Remover usuário");
                System.out.println("3. Editar usuário");
                System.out.println("4. Adicionar livro");
                System.out.println("5. Remover livro");
                System.out.println("6. Editar livro");
                System.out.println("7. Emprestar livro");
                System.out.println("8. Devolver livro");
                System.out.println("9. Listar itens");
                System.out.println("10. Listar usuários");
                System.out.println("11. Pesquisar itens");
                System.out.println("12. Emitir relatório por item");
                System.out.println("13. Emitir relatório por usuário");
                System.out.println("0. Sair");

                System.out.println("Escolha uma opção:");
                int opcao = scanner.nextInt();
                // scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {

                    case 1:
                        scanner = new Scanner(System.in);
                        System.out.println("Digite o nome do usuário:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o cpf do usuário:");
                        int cpf = scanner.nextInt();
                        biblioteca.adicionarUsuario(new Usuario(nome, cpf));
                        break;
                    case 2:
                        scanner = new Scanner(System.in);
                        System.out.println("Digite o nome do usuário:");
                        nome = scanner.nextLine();
                        biblioteca.removerUsuario(nome);
                        break;
                    case 3:
                        scanner = new Scanner(System.in);
                        System.out.println("Digite o nome do usuário:");
                        nome = scanner.nextLine();
                        System.out.println("Digite o novo nome do usuário:");
                        String novoNome = scanner.nextLine();
                        System.out.println("Digite o cpf do usuário:");
                        cpf = scanner.nextInt();
                        biblioteca.editarUsuario(nome, new Usuario(novoNome, cpf));
                        break;
                    case 4:
                        scanner = new Scanner(System.in);
                        System.out.println(
                                "Selecione qual tipo de item deseja cadastrar: (1 - Livro, 2 - Tese, 3 - Revista, 4 - CD, 5 - DVD)");
                        int selecaoTipo = scanner.nextInt();
                        switch (selecaoTipo) {
                            case 1:
                                System.out.println("Digite o título do livro: ");
                                titulo = scanner.nextLine();
                                System.out.println("Digite o autor do livro: ");
                                autor = scanner.nextLine();
                                System.out.println("Digite o ano do livro: ");
                                ano = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha
                                biblioteca.adicionarItem(new Livro(titulo, autor, ano));
                                break;
                            case 2:
                                System.out.println("Digite o título da tese: ");
                                titulo = scanner.nextLine();
                                System.out.println("Digite o autor da tese: ");
                                autor = scanner.nextLine();
                                System.out.println("Digite o ano da tese: ");
                                ano = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha
                                biblioteca.adicionarItem(new Tese(titulo, autor, ano));
                                break;
                            case 3:
                                System.out.println("Digite o título da revista: ");
                                titulo = scanner.nextLine();
                                System.out.println("Digite o autor da revista: ");
                                autor = scanner.nextLine();
                                System.out.println("Digite o ano da revista: ");
                                ano = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha
                                biblioteca.adicionarItem(new Revista(titulo, autor, ano));
                                break;
                            case 4:
                                System.out.println("Digite o título do CD: ");
                                titulo = scanner.nextLine();
                                System.out.println("Digite o autor do CD: ");
                                autor = scanner.nextLine();
                                System.out.println("Digite o ano do CD: ");
                                ano = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha
                                biblioteca.adicionarItem(new CD(titulo, autor, ano));
                                break;
                            case 5:
                                System.out.println("Digite o título do DVD: ");
                                titulo = scanner.nextLine();
                                System.out.println("Digite o autor do DVD: ");
                                autor = scanner.nextLine();
                                System.out.println("Digite o ano do DVD: ");
                                ano = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha
                                biblioteca.adicionarItem(new DVD(titulo, autor, ano));
                                break;

                            default:
                                System.out.println("Selecione um numero valido!");
                                break;
                        }
                        break;
                    case 5:
                        scanner = new Scanner(System.in);
                        System.out.println("Digite o título do item:");
                        titulo = scanner.nextLine();
                        biblioteca.removerItem(titulo);
                        break;
                    case 6:
                        scanner = new Scanner(System.in);
                        System.out.println("Digite o título do livro:");
                        titulo = scanner.nextLine();
                        System.out.println("Digite o novo título do livro:");
                        String novoTitulo = scanner.nextLine();
                        System.out.println("Digite o novo autor do livro:");
                        String novoAutor = scanner.nextLine();
                        System.out.println("Digite o novo ano do livro:");
                        int novoAno = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha
                        biblioteca.editarItem(titulo, new Livro(novoTitulo, novoAutor, novoAno));
                        break;

                    case 7:
                        scanner = new Scanner(System.in);
                        System.out.println("Digite o título do livro:");
                        titulo = scanner.nextLine();
                        System.out.println("Digite o nome do usuário:");
                        String nomeUsuario = scanner.nextLine();
                        if (biblioteca.emprestarItem(titulo, nomeUsuario)) {
                            System.out.println("Livro emprestado com sucesso!");
                        } else {
                            System.out.println("Não foi possível emprestar o livro.");
                        }
                        break;
                    case 8:
                        scanner = new Scanner(System.in);
                        System.out.println("Digite o título do livro:");
                        titulo = scanner.nextLine();
                        System.out.println("Digite o nome do usuário:");
                        nomeUsuario = scanner.nextLine();
                        try {
                            biblioteca.devolverItem(titulo, nomeUsuario);
                            System.out.println("Livro devolvido com sucesso!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 9:
                        scanner = new Scanner(System.in);
                        List<Item> listaItens = biblioteca.listarItens();
                        for (Item item : listaItens) {
                            System.out.println(item.titulo + " - " + item.autor + " - " + item.ano);
                        }
                        break;
                    case 10:
                        scanner = new Scanner(System.in);
                        List<Usuario> listaUsuarios = biblioteca.listarUsuarios();
                        for (Usuario usuario : listaUsuarios) {
                            System.out.println(usuario.nome);
                        }
                        break;
                    case 11:
                        scanner = new Scanner(System.in);
                        System.out.println("Digite o termo de pesquisa:");
                        String termo = scanner.nextLine();
                        System.out.println("Digite o tipo de pesquisa (titulo, autor, ano, tipo):");
                        String tipoPesquisa = scanner.nextLine();
                        List<Item> resultados = biblioteca.pesquisarItens(termo, tipoPesquisa);
                        for (Item item : resultados) {
                            System.out.println(item.titulo + " - " + item.autor + " - " + item.ano);
                        }
                        break;
                    case 12:
                        biblioteca.emitirRelatorioPorItem();
                        break;
                    case 13:
                        scanner = new Scanner(System.in);
                        System.out.println("Digite o nome do usuário:");
                        nomeUsuario = scanner.nextLine();
                        biblioteca.emitirRelatorioPorUsuario(nomeUsuario);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        scanner.close();
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, tente novamente.");
                scanner.nextLine(); // Consumir a nova linha
            } catch (EmprestimoException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
