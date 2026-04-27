import entities.Usuario;
import entities.Tarefa;
import services.UsuarioService;

public class Main {
    public static void main(String[] args) {

        Usuario user = new Usuario(1, "Lucas", "lucas@email.com", "123");

        Tarefa tarefa = new Tarefa(1, "Estudar Java", "POO e Git", 3);

        UsuarioService service = new UsuarioService();

        service.cadastrar("Lucas", "lucasmen2005@gmail.com", "lucas123");
        service.cadastrar("Rafaela", "rafalouyse@gmail.com", "rafinha123");

        Usuario logado = service.login("lucasmen2005@gmail.com", "lucas123");

        if (logado != null) {
            System.out.println("Login realizado: " + logado.getNome());
        } else {
            System.out.println("Email ou senha inválidos");
        }

        System.out.println("Tarefa: " + tarefa.getTitulo());

        tarefa.concluir();

        System.out.println("Concluída? " + tarefa.isConcluida());
    }
}