package com.fga.tppe.tp1.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.fga.tppe.tp1.TestesFuncionais;

@Category(TestesFuncionais.class)
@RunWith(Parameterized.class)
public class TestesGestaoTransacoes {
    private Produto produto;
    private Integer quantidadeDisponivel;
    private Integer limiteMinimo;
    private Integer quantidadeRecebida;
    private Integer quantidadeEsperada;

    public TestesGestaoTransacoes(Integer quantidadeDisponivel,
                                  Integer limiteMinimo,
                                  Integer quantidadeRecebida,
                                  Integer quantidadeEsperada) {
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.limiteMinimo = limiteMinimo;
        this.quantidadeRecebida = quantidadeRecebida;
        this.quantidadeEsperada = quantidadeEsperada;
    }

    @Before
    public void setUp() {
        produto = new Produto();
        produto.setQuantidadeDisponivel(quantidadeDisponivel); // Definindo a quantidade inicial como 10
        produto.setLimiteMinimo(limiteMinimo); // Definindo o limite mínimo como 20 para acionar o alerta de estoque baixo
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] parametros = new Object[][] {
                // quantidadeDisponivel, limiteMinimo, quantidadeRecebida, quantidadeEsperada
                {10, 20, 15, 25},
                {0,   5, 30, 30},
                {50, 10,  0, 50},
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void testRecebimentoMercadoria() {
        produto.receberMercadoria(quantidadeRecebida);

        assertEquals(quantidadeEsperada, produto.getQuantidadeDisponivel()); // Não deveria lançar exceção e o valor deveria ser validado corretamente, como atualizado
    }

}
