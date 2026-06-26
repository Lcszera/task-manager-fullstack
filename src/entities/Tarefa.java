package entities;

import java.time.LocalDate;

public class Tarefa {

    private int id;
    private int dificuldade;
    private boolean concluida;
    private boolean excluida;
    private boolean editada;
    private String titulo;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataConclusao;
    private LocalDate dataExclusao;
    private LocalDate dataEdicao;
    private Usuario usuario;

    public Tarefa(int id, String titulo, String descricao, int dificuldade, Usuario usuario) {

        this.id = id;
        this.usuario = usuario;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.concluida = false;
        this.excluida = false;
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

    public void excluir() {

        this.excluida = true;
        this.dataExclusao = LocalDate.now();

    }

    public boolean isExcluida() {
        return excluida;

    }


    public boolean isEditada() {
        return editada;

    }

    public LocalDate getDataConclusao() {
        return dataExclusao;

    }

    public String getTitulo() {
        return titulo;

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;

    }

    public String getDescricao() {
        return descricao;

    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;

    }

    public int getDificuldade() {
        return dificuldade;

    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;

    }

    public LocalDate getDataEdicao() {
        return dataEdicao;

    }

    public void setDataEdicao(LocalDate dataEdicao) {
        this.dataEdicao = dataEdicao;

    }

}
