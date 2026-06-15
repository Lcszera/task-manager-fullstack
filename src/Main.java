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
        int senha;

        while (escolha != 0) {

            System.out.println("\nPor favor, escolha uma opção do menu: \n1. Cadastrar \n2. Login \n0. Sair");
                escolha = sc.nextInt();

                switch (escolha) {
                    case 1:

                        System.out.println("\nDigite seu nome: ");
                            nome = sc.next();
                        System.out.println("\nDigite seu email: ");
                            email = sc.next();
                        System.out.println("\nDigite sua senha: ");
                            senha = sc.nextInt();

                        break;
                    case 2:
                        System.out.println("2. Login selecionado");
                        break;
                    case 0:
                        System.out.println("0. Saindo...");
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                }
        }

        // PARTE CADASTRAL ABAIXO


        usuarioService.cadastrar("Lucas", "lucasmen2005@gmail.com", "123");
        Usuario lucas = usuarioService.login("lucasmen2005@gmail.com", "123");

        usuarioService.cadastrar("Rafaella", "rafalouyse@gmail.com", "123");
        Usuario rafaella = usuarioService.login("rafalouyse@gmail.com", "123");


        // TAREFAS ABAIXO


        Tarefa tarefasLucas = tarefaService.criar(
                "Protótipo Web",
                "Projeto Freelancer",
                1,
                lucas
        );

        Tarefa tarefasRafaella = tarefaService.criar(
                "Teste Aplicação",
                "Teste do TaskMannager",
                0, rafaella
                );


        List<Tarefa> listarLucas = tarefaService.listarPorUsuario(lucas);

        System.out.println(listarLucas.size());

        // UM POUCO DE REDUNDÂNCIA NA PARTE CADASTRAL ABAIXO

        /*

        usuarioService.cadastrar("Rafaella", "rafalouyse@gmail.com", "rafinha123");

        Usuario logado = usuarioService.login("lucasmen2005@gmail.com", "lucas123");


        // CONDIÇÃO PARA CHECAR SE AS CREDENCIAIS DO USUÁRIO ESTÃO CORRETAS, ABAIXO


        if (logado != null) {
            System.out.println("Login realizado: " + logado.getNome());
        } else {
            System.out.println("Email ou senha inválidos");
        }



         */
    }
}