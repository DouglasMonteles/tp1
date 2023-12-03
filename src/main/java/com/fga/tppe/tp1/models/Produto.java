package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.exceptions.EstoqueNegativoException;
import com.fga.tppe.tp1.exceptions.DescricaoEmBrancoException;
import com.fga.tppe.tp1.exceptions.ValorInvalidoException;
public class Produto {

    private Integer quantidadeDisponivel;
    private Integer limiteMinimo;

    private Fornecedor fornecedor;
    private String nome;
    private String codigoBarras;
    private double precoCompra;
    private double precoVenda;
    private int quantidadeEstoque;

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
    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }
    public void setCodigoBarras(String codigoBarras){
        this.codigoBarras = codigoBarras;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }
    public void setPrecoCompra(double precoCompra){
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(double precoVenda){
        this.precoVenda = precoVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto cadastroProduto(String nome, String codigoBarras, double precoCompra, double precoVenda, int quantidadeEstoque)
            throws DescricaoEmBrancoException, ValorInvalidoException {
        Produto produto = new Produto();
        validarEntradas(nome, codigoBarras, precoCompra, precoVenda, quantidadeEstoque);
        produto.setNome(nome);
        produto.setCodigoBarras(codigoBarras);
        produto.setPrecoCompra(precoCompra);
        produto.setPrecoVenda(precoVenda);
        produto.setQuantidadeEstoque(quantidadeEstoque);

        System.out.println("Produto cadastrado com sucesso!");
        return produto;
    }

    private void validarEntradas(String nome, String codigoBarras, Double precoCompra, Double precoVenda, Integer quantidadeEstoque)
            throws DescricaoEmBrancoException, ValorInvalidoException {
        if (nome == null || codigoBarras == null || nome.isEmpty() || codigoBarras.isEmpty() || precoCompra == null || precoVenda == null || quantidadeEstoque == null){
            throw new DescricaoEmBrancoException("Os campos não pode estar em branco");
        }
        if (precoCompra <= 0 || precoVenda <= 0 || quantidadeEstoque <= 0){
            throw new ValorInvalidoException("Valores de compra, venda e quantidade devem ser maiores que zero");
        }
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
            throw new ValorInvalidoException("Quantidade não pode ser negativa.");
        }
    }
}
