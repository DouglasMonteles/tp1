package com.fga.tppe.tp1.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.fga.tppe.tp1.TestesExcecoes;
import com.fga.tppe.tp1.exceptions.ValorInvalidoException;

@Category(TestesExcecoes.class)
public class TestesGestaoTransacoesExcecao {
    private Produto produto;

    @Before
    public void setUp() {
        produto = new Produto();
    }

    @Test
    public void testVendaMercadoriaNegativo() {
        int quantidadeParaVenda = -19;

        assertThrows(ValorInvalidoException.class, () -> {
            produto.venderMercadoria(quantidadeParaVenda);
        });
    }

    @Test
    public void testDevolucaoNegativo() {
        int quantidadeParaDevolver = -5;

        assertThrows(ValorInvalidoException.class, () -> {
            produto.devolverMercadoria(quantidadeParaDevolver);
        });
    }

    @Test
    public void testTransferenciaNegativo() {
        int quantidadeParaTransferir = -92;

        assertThrows(ValorInvalidoException.class, () -> {
            produto.transferirMercadoria(quantidadeParaTransferir);
        });
    }

    @Test
    public void testAjusteEstoqueNulo() {
        int QuantidadeTotalFinal = 0;
        produto.ajustarEstoque(QuantidadeTotalFinal);

        int quantidadeEsperada = 0;
        assertEquals(quantidadeEsperada, produto.getQuantidadeDisponivel()); // Não deveria lançar exceção e o valor deveria ser validado corretamente, como atualizado
    }

    @Test
    public void testAjusteEstoqueNegativo() {
        int QuantidadeTotalFinal = -450;
        produto.ajustarEstoque(QuantidadeTotalFinal);

        int quantidadeEsperada = -450;
        assertEquals(quantidadeEsperada, produto.getQuantidadeDisponivel()); // Não deveria lançar exceção e o valor deveria ser validado corretamente, como atualizado
    }
}
