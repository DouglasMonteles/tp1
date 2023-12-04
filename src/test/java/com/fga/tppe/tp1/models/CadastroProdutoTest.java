package com.fga.tppe.tp1.models;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CadastroProdutoTest {

    Produto produto;

    @Before
    public void setup(){
        produto = new Produto();
    }
    @Test
    public void testeCadastroProdutoCorreto(){
        String nome = "Produto A";
        String codigoBarras = "123456789";
        double precoCompra = 10.0;
        double precoVenda = 20.0;
        int quantidadeEstoque = 50;
        double delta = 0.001;
        Produto produtoCadastrado = produto.cadastroProduto(nome, codigoBarras, precoCompra, precoVenda, quantidadeEstoque);
        assertEquals(nome, produtoCadastrado.getNome());
        assertEquals(codigoBarras, produtoCadastrado.getCodigoBarras());
        assertEquals(precoCompra, produtoCadastrado.getPrecoCompra(), delta);
        assertEquals(precoVenda, produtoCadastrado.getPrecoVenda(), delta);
        assertEquals(quantidadeEstoque, produtoCadastrado.getQuantidadeEstoque());
    }
}
