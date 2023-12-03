package com.fga.tppe.tp1.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTotalItensLote {
    private Integer quantidadeDisponivel;
    private Produto produto;
    private Lote lote;
    private Estoque estoque;
    private Integer id;
    private String nome;


    @Before
    public void setup() {
        this.id = 1;
        this.nome = "Café";
        this.quantidadeDisponivel = 10;
        this.produto = new Produto();
        this.lote = new Lote();
        this.estoque = new Estoque();
        this.produto.setQuantidadeDisponivel(quantidadeDisponivel);
        this.produto.setLote(lote);
        this.estoque.setProdutos(produto);
        this.lote.setId(id);
        this.lote.setNome(nome);
    }
    /*public TestTotalItensLote(Integer quantidadeDisponivel){
        this.quantidadeDisponivel = quantidadeDisponivel;
    }*/


    @Test
    public void naoEmiteAlertaQuandoQuantidadeTotalLoteCorreta() {
        assertEquals(10,this.estoque.confereLote(1));
    }

}
