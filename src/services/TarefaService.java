package services;

import entities.Tarefa;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<>();
    private int contadorId = 1;

    public Tarefa criar(String titulo, String descricao, int dificuldade) {

        Tarefa tarefa = new Tarefa(contadorId++, titulo, descricao, dificuldade);
        tarefas.add(tarefa);
        return tarefa;

    }

    public List<Tarefa> listar() {

        return tarefas;

    }


    public void concluirTarefa(int id) {

        Tarefa tarefa = buscarPorId(id);

        if (tarefa != null) {
            tarefa.concluir();
        } else {
            System.out.println("Tarefa não encontrada!");
        }

    }

    private Tarefa buscarPorId(int id) {

        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                return t;
            }
        }

    return null;

    }

}
