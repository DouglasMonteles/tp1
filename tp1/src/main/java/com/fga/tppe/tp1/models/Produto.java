package com.fga.tppe.tp1.models;

import java.util.Date;

import com.fga.tppe.tp1.exceptions.DescricaoEmBrancoException;
import com.fga.tppe.tp1.exceptions.EstoqueNegativoException;
import com.fga.tppe.tp1.exceptions.ValorInvalidoException;
import com.fga.tppe.tp1.services.Validacao;

public class Produto {

    private Integer quantidadeDisponivel;
    private Integer limiteMinimo;
    private Fornecedor fornecedor;
    private Lote lote;
    private String nome;
    private String codigoBarras;
    private double precoCompra;
    private double precoVenda;
    private int quantidadeEstoque;

    private String localizacao;

    public Produto() {}

    public Produto(String nome, String codigoBarras, double precoCompra, double precoVenda, Integer quantidadeDisponivel ) {
            this.nome = nome;
            this.codigoBarras = codigoBarras;
            this.precoCompra = precoCompra;
            this.precoVenda = precoVenda;
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
        Validacao.validarEntradas(nome, codigoBarras, precoCompra, precoVenda, quantidadeEstoque);
        produto.setNome(nome);
        produto.setCodigoBarras(codigoBarras);
        produto.setPrecoCompra(precoCompra);
        produto.setPrecoVenda(precoVenda);
        produto.setQuantidadeEstoque(quantidadeEstoque);

        System.out.println("Produto cadastrado com sucesso!");
        return produto;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
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
                ", Codigo de barras =" +  codigoBarras +
                "Custo=" + precoCompra +
                "Preço de Venda=" + precoVenda +
                ",  quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }

    // Testes Gestao de transacoes

    public void receberMercadoria(int quantidadeRecebida) {
        Validacao.validarQuantidadeNegativa(quantidadeRecebida);
        this.quantidadeDisponivel += quantidadeRecebida;
    }

    public void venderMercadoria(int quantidadeParaVenda) {
        Validacao.validarQuantidadeNegativa(quantidadeParaVenda);
        this.quantidadeDisponivel -= quantidadeParaVenda;
    }

    public void devolverMercadoria(int quantidadeParaDevolver) {
        Validacao.validarQuantidadeNegativa(quantidadeParaDevolver);
        this.quantidadeDisponivel += quantidadeParaDevolver;
    }

    public void transferirMercadoria(int quantidadeParaTransferir) {
        Validacao.validarQuantidadeNegativa(quantidadeParaTransferir);
        this.quantidadeDisponivel -= quantidadeParaTransferir;
    }

    public void ajustarEstoque(int quantidadeTotalFinal) {
        this.quantidadeDisponivel = quantidadeTotalFinal;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }
    public boolean confereValidade(){

        Date dataAtual = new Date();

        long tresDiasMillis = 3 * 24 * 60 * 60 * 1000L;
        Date dataAtualMenos3Dias = new Date(dataAtual.getTime() - tresDiasMillis);

        if (lote.getValidade().before(dataAtualMenos3Dias)) {
            System.out.println("A data de validade é anterior a 3 dias atrás da data atual.");
            precoVenda = precoVenda - (precoVenda * 0.2);
            return true;
        } else if (lote.getValidade().equals(dataAtualMenos3Dias)) {
            System.out.println("A data de validade é exatamente 3 dias atrás da data atual.");
            return false;
        } else {
            System.out.println("A data de validade é posterior a 3 dias atrás da data atual.");
            return false;
        }
    }
}
