package entities;

import java.time.LocalDate;

public class Tarefa {

    private int id;
    private int dificuldade;
    private boolean concluida;
    private String titulo;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;

    public Tarefa(int id, String titulo, String descricao, int dificuldade) {

        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.concluida = false;
        this.dataCriacao = LocalDate.now();

    }

    public void concluir() {

        this.concluida = true;
        this.dataConclusao = LocalDate.now();

}

    public boolean isConcluida() {
        return concluida;

    }

    public String getTitulo() {
        return titulo;

    }

}
