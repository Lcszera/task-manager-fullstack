import entities.Usuario;
import entities.Tarefa;
import services.UsuarioService;
import services.TarefaService;

public class Main {
    public static void main(String[] args) {

        TarefaService tarefaService = new TarefaService();
        UsuarioService usuarioService = new UsuarioService();


        usuarioService.cadastrar("Lucas", "lucasmen2005@gmail.com", "123");
        Usuario lucas = usuarioService.login("lucasmen2005@gmail.com", "123");


        Tarefa tarefa = tarefaService.criar(
                "Protótipo Web",
                "Projeto Freelancer",
                1,
                lucas
        );


        usuarioService.cadastrar("Rafaella", "rafalouyse@gmail.com", "rafinha123");

        Usuario logado = usuarioService.login("lucasmen2005@gmail.com", "lucas123");

        if (logado != null) {
            System.out.println("Login realizado: " + logado.getNome());
        } else {
            System.out.println("Email ou senha inválidos");
        }


    }
}