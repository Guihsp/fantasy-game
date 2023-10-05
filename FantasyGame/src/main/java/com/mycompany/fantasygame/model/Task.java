package com.mycompany.fantasygame.model;

public class Task {
    private String id;
    private String titulo;
    private String descricao;
    private String status;
    private String dataCriacao;
    private String dataAtualizacao;
    private String dataConclusao;
    private String emailUsuario;

    public Task() {
    }

    public Task(String id, String titulo, String descricao, String status, String dataCriacao, String dataAtualizacao, String dataConclusao, String emailUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.dataConclusao = dataConclusao;
        this.emailUsuario = emailUsuario;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
    
}