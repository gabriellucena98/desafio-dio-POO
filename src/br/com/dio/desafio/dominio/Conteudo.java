package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;
    private double acertos = 0;
    private double perguntasTotal = 0;

    private LocalDateTime proximaTentativa;

    public Conteudo(String titulo) {
        this.titulo = titulo;
    }

    public abstract double calcularXp();

    public boolean avaliacao() {
        LocalDateTime tentativa = LocalDateTime.now();

        if (proximaTentativa == null) {
            this.proximaTentativa = tentativa;
        }

        if (proximaTentativa.isAfter(tentativa.plusHours(2))) {
            System.out.println("Você precisa esperar mais para tentar novamente!");
            return false;
        }

        if (perguntasTotal != 0) {
            double pontuacao = this.acertos/this.perguntasTotal;
            return pontuacao >= 0.7;
        } else {
            System.out.println("Você não respondeu as perguntas!");
            return false;
        }
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

    public double getAcertos() {
        return acertos;
    }

    public void setAcertos(double acertos) {
        this.acertos = acertos;
    }

    public double getPerguntasTotal() {
        return perguntasTotal;
    }

    public void setPerguntasTotal(double perguntasTotal) {
        this.perguntasTotal = perguntasTotal;
    }
}
