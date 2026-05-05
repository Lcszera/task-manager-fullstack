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
    private Usuario usuario;

    public Tarefa(int id, String titulo, String descricao, int dificuldade, Usuario usuario) {

        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.concluida = false;
        this.dataCriacao = LocalDate.now();

    }

    public int getId() {
        return id;

    }

    public Usuario getUsuario() {
        return usuario;

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
