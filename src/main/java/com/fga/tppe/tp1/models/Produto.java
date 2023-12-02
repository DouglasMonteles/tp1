package com.fga.tppe.tp1.models;

public class Produto {

    private Integer quantidadeDisponivel;
    private Integer limiteMinimo;

    public Produto() {}

    public Produto(Integer quantidadeDisponivel, Integer limiteMinimo) {
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.limiteMinimo = limiteMinimo;
    }

    public boolean alertaEstoqueBaixo() {
        if (quantidadeDisponivel <= limiteMinimo) {
            return true;
        }

        return false;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Integer getLimiteMinimo() {
        return limiteMinimo;
    }

    public void setLimiteMinimo(Integer limiteMinimo) {
        this.limiteMinimo = limiteMinimo;
    }

}
