package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.exceptions.EstoqueNegativoException;

public class Produto {

    private Integer quantidadeDisponivel;
    private Integer limiteMinimo;

    private Fornecedor fornecedor;

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
        if (quantidadeRecebida < 0) {
            throw new IllegalArgumentException("Quantidade recebida não pode ser negativa.");
        }

        this.quantidadeDisponivel += quantidadeRecebida;
    }

    public void venderMercadoria(int quantidadeParaVenda) {
        if (quantidadeParaVenda < 0) {
            throw new IllegalArgumentException("Quantidade para venda não pode ser negativa.");
        }

        if (this.quantidadeDisponivel < quantidadeParaVenda) {
            throw new IllegalArgumentException("Quantidade para venda excede o estoque disponível.");
        }

        this.quantidadeDisponivel -= quantidadeParaVenda;
    }

    public void devolverMercadoria(int quantidadeParaDevolver) {
        if (quantidadeParaDevolver < 0) {
            throw new IllegalArgumentException("Quantidade para devolução não pode ser negativa.");
        }

        this.quantidadeDisponivel += quantidadeParaDevolver;
    }

    public void transferirMercadoria(int quantidadeParaTransferir) {
        if (quantidadeParaTransferir < 0) {
            throw new IllegalArgumentException("Quantidade para transferência não pode ser negativa.");
        }

        if (this.quantidadeDisponivel < quantidadeParaTransferir) {
            throw new IllegalArgumentException("Quantidade para transferência excede o estoque disponível.");
        }

        this.quantidadeDisponivel -= quantidadeParaTransferir;
    }

    public void ajustarEstoque(int quantidadeTotalFinal) {
        this.quantidadeDisponivel = quantidadeTotalFinal;    }
}
