package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.TestesExcecoes;
import com.fga.tppe.tp1.exceptions.EstoqueNegativoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(TestesExcecoes.class)
public class AlertaEstoqueBaixoTesteExcecao {

    private Produto produto;

    @Before
    public void setup() {
        this.produto = new Produto();
        this.produto.setLimiteMinimo(5);
        this.produto.setQuantidadeDisponivel(-1);
    }

    @Test
    public void lancaExcecaoQuantoEstoqueDeProdutoForMenorQueZero() {
        int quantidadeDesejada = 4;
        Assert.assertThrows(EstoqueNegativoException.class, () -> produto.removerProdutoDoEstoque(quantidadeDesejada));
    }

}
