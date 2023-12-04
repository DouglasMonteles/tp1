package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.exceptions.EstoqueNegativoException;

import java.math.BigDecimal;

public class Produto {

    private Integer quantidadeDisponivel;
    private Integer limiteMinimo;

    private Fornecedor fornecedor;
    private String nome;

    private String codigoBarra;

    private BigDecimal custo;
    private BigDecimal precoVenda;


    public Produto() {}

    public Produto(String nome, String codigoBarra, double custo, double precoVenda, Integer quantidadeDisponivel ) {
            this.nome = nome;
            this.codigoBarra = codigoBarra;
            this.custo = new BigDecimal(custo);
            this.precoVenda = new BigDecimal(precoVenda);
            this.quantidadeDisponivel = quantidadeDisponivel;
    }


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

    public String buscaNome(){

        return "Produto{" +
                "nome="+ nome +
                ", Codigo de barras =" +  codigoBarra +
                "Custo=" + custo +
                "Preço de Venda=" + precoVenda +
                ",  quantidadeDisponivel=" + quantidadeDisponivel +
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

    public String getNome() {
        return nome;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public BigDecimal getPrecoVenda(){
        return precoVenda;
    }
}
