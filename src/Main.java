import entities.Usuario;
import entities.Tarefa;
import services.UsuarioService;
import services.TarefaService;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TarefaService tarefaService = new TarefaService();
        UsuarioService usuarioService = new UsuarioService();

        // MENU INTERATIVO ABAIXO

        int escolha = -1;
        String nome;
        String email;
        String senha;
        Usuario usuarioLogado = null;
        String titulo;
        String descricao;
        int dificuldade;
        int id;

        while (escolha != 0) {

            System.out.println("\nPor favor, escolha uma opção do menu: " +
                    "\n1. Cadastrar \n2. Login \n3. Criar tarefa \n4. Minhas tarefas " +
                    "\n5. Concluir tarefa \n6. Excluir tarefa \n7. Editar tarefa \n0. Sair");
                escolha = sc.nextInt();

                switch (escolha) {
                    case 1:

                        System.out.println("\nDigite seu nome: ");
                            nome = sc.next();
                        System.out.println("\nDigite seu email: ");
                            email = sc.next();
                        System.out.println("\nDigite sua senha: ");
                            senha = sc.next();

                                usuarioService.cadastrar(nome, email, senha);
                                System.out.println("\nCadastro efetuado com sucesso!");

                        break;
                    case 2:

                        System.out.println("\nDigite seu email: ");
                            email = sc.next();
                        System.out.println("\nDigite sua senha: ");
                            senha = sc.next();

                                usuarioLogado = usuarioService.login(email, senha);

                                if (usuarioLogado != null) {
                                    System.out.println("\nLogin efetuado com sucesso!");
                                } else {
                                    System.out.println("\nEmail ou senha inválida!");
                                }


                        break;
                    case 3:

                                if (usuarioLogado == null) {
                                    System.out.println("\nFaça login primeiro!");
                                } else {
                                    System.out.println("\nTítulo: ");
                                        titulo = sc.next();
                                    System.out.println("\nDescrição: ");
                                        descricao = sc.next();
                                    System.out.println("\nDificuldade: ");
                                        dificuldade = sc.nextInt();

                                    tarefaService.criar(titulo, descricao, dificuldade, usuarioLogado);

                                    System.out.println("\nTarefa criada com sucesso!");

                                }

                        break;
                    case 4:

                                if (usuarioLogado == null) {
                                    System.out.println("\nFaça login primeiro!");
                                } else {

                                    List<Tarefa> tarefasUsuario = tarefaService.listarPorUsuario(usuarioLogado);

                                    boolean encontrouTarefa = false;

                                    for (Tarefa t : tarefasUsuario) {

                                        if (!t.isExcluida()) {

                                            encontrouTarefa = true;

                                            System.out.println(
                                                    "==================== \n\nTítulo: " + t.getTitulo() +
                                                            "\nID: " + t.getId() +
                                                            "\nDescrição: " + t.getDescricao() +
                                                            "\nDificuldade: " + t.getDificuldade() +
                                                            "\nConcluída: " + t.isConcluida() +
                                                            "\nCriada em: " + t.getDataCriacao() +
                                                            "\nEditada em: " + t.getDataEdicao() +
                                                            "\nConcluída em: " + t.getDataConclusao() +
                                                            "\nExcluída em: " + t.getDataExclusao() +
                                                    "\n\n==================="
                                            );
                                        }

                                    }

                                    if (!encontrouTarefa) {
                                        System.out.println("\nNenhuma tarefa encontrada!");
                                    }

                                }

                        break;
                    case 5:

                                if (usuarioLogado == null) {
                                    System.out.println("Faça login primeiro!");
                                } else {

                                    System.out.println("\nDigite o ID da tarefa: ");
                                        id = sc.nextInt();

                                if (tarefaService.concluirTarefa(id)) {
                                    System.out.println("\nA tarefa com o ID: " + id + " foi concluída!");
                                    } else {

                                    System.out.println("\nTarefa não encontrada!");
                                }

                                }

                        break;
                    case 6:

                                if (usuarioLogado == null) {
                                    System.out.println("Faça login primeiro!");
                                } else {

                                    System.out.println("\nDigite o ID da tarefa: ");
                                        id = sc.nextInt();

                                if (tarefaService.excluirTarefa(id)) {
                                    System.out.println("\nA tarefa com o ID: " + id + " foi excluída!");
                                } else {

                                    System.out.println("\nTarefa não encontrada!");
                                }

                                }

                        break;
                    case 7:

                                if (usuarioLogado == null) {
                                    System.out.println("Faça login primeiro!");
                                } else {

                                    System.out.println("\nInforme o ID da tarefa que será editada: ");
                                        id = sc.nextInt();

                                        sc.nextLine();

                                    System.out.println("\nDigite o novo título: ");
                                        titulo = sc.nextLine();

                                    System.out.println("\nDigite a nova descrição: ");
                                        descricao = sc.nextLine();

                                    System.out.println("\nDigite a nova dificuldade: ");
                                        dificuldade = sc.nextInt();

                                if (tarefaService.editarTarefa(id, titulo, descricao, dificuldade)) {
                                    System.out.println("\nA tarefa com o ID: " + id + " foi editada!");
                                } else {

                                    System.out.println("\nTarefa não encontrada!");
                                }

                                }

                        break;
                    case 0:
                        System.out.println("0. Saindo...");
                        break;

                    default:
                        System.out.println("\nOpção inválida!");
                }
        }

        sc.close();
    }
}