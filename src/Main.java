import entities.Usuario;
import entities.Tarefa;

public class Main {
    public static void main(String[] args) {

        Usuario user = new Usuario(1, "Lucas", "lucas@email.com", "123");

        Tarefa tarefa = new Tarefa(1, "Estudar Java", "POO e Git", 3);

        System.out.println("Usuário: " + user.getNome());
        System.out.println("Tarefa: " + tarefa.getTitulo());

        tarefa.concluir();

        System.out.println("Concluída? " + tarefa.isConcluida());
    }
}