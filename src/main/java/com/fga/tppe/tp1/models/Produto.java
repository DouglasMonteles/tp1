package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.exceptions.EstoqueNegativoException;

public class Produto {

    private Integer quantidadeDisponivel;
    private Integer limiteMinimo;
    private Fornecedor fornecedor;
    private Lote lote;
    public Produto() {}

    public boolean alertaEstoqueBaixo() {
        if (quantidadeDisponivel <= limiteMinimo) {
            System.out.println(this);
            return true;
        }

        return false;
    }

    public Produto removerProdutoDoEstoque(Integer quantidadeDesejada) {
        this.quantidadeDisponivel -= quantidadeDesejada;

        if (this.quantidadeDisponivel < 0) {
            this.quantidadeDisponivel = 0;
            throw new EstoqueNegativoException();
        }

        return this;
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public Lote getLote() {
        return lote;
    }
    public void setLote(Lote lote) {
        this.lote = lote;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "quantidadeDisponivel=" + quantidadeDisponivel +
                ", limiteMinimo=" + limiteMinimo +
                ", fornecedor=" + fornecedor +
                '}';
    }

    // Testes Gestao de transacoes

    public void receberMercadoria(int quantidadeRecebida) {
        validarQuantidadeNegativa(quantidadeRecebida);
        this.quantidadeDisponivel += quantidadeRecebida;
    }

    public void venderMercadoria(int quantidadeParaVenda) {
        validarQuantidadeNegativa(quantidadeParaVenda);
        this.quantidadeDisponivel -= quantidadeParaVenda;
    }

    public void devolverMercadoria(int quantidadeParaDevolver) {
        validarQuantidadeNegativa(quantidadeParaDevolver);
        this.quantidadeDisponivel += quantidadeParaDevolver;
    }

    public void transferirMercadoria(int quantidadeParaTransferir) {
        validarQuantidadeNegativa(quantidadeParaTransferir);
        this.quantidadeDisponivel -= quantidadeParaTransferir;
    }

    public void ajustarEstoque(int quantidadeTotalFinal) {
        this.quantidadeDisponivel = quantidadeTotalFinal;
    }

    // Método para validar se a quantidade fornecida para a transacao eh negativa e lancar a excecao nesses casos
    private void validarQuantidadeNegativa(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
    }
}
