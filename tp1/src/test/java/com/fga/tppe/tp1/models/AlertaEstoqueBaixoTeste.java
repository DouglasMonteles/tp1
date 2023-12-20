package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.TestesFuncionais;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Category(TestesFuncionais.class)
@RunWith(Parameterized.class)
public class AlertaEstoqueBaixoTeste {

    private Produto produto;
    private Integer quantidadeDisponivel;
    private Integer limiteMinimo;
    private Boolean isEstoqueBaixo;
    private String mensagemEsperada;

    @Before
    public void setup() {
        this.produto = new Produto();
        this.produto.setFornecedor(new Fornecedor(1, "Banca Verde"));
    }

    public AlertaEstoqueBaixoTeste(Integer quantidadeDisponivel,
                                   Integer limiteMinimo,
                                   Boolean isEstoqueBaixo,
                                   String mensagemEsperada) {
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.limiteMinimo = limiteMinimo;
        this.isEstoqueBaixo = isEstoqueBaixo;
        this.mensagemEsperada = mensagemEsperada;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] parametros = new Object[][] {
                // quantidadeDisponivel, limiteMinimo, isEstoqueBaixo, mensagemEsperada
                {10, 3, false, ""},
                {5,  5, true, "Produto{quantidadeDisponivel=5, limiteMinimo=5, fornecedor=Fornecedor{id=1, nome='Banca Verde'}}"},
                {3, 10, true, "Produto{quantidadeDisponivel=3, limiteMinimo=10, fornecedor=Fornecedor{id=1, nome='Banca Verde'}}"},
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void testaAlertaDeEstoqueBaixo() {
        this.produto.setQuantidadeDisponivel(quantidadeDisponivel);
        this.produto.setLimiteMinimo(limiteMinimo);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        assertEquals(isEstoqueBaixo, this.produto.alertaEstoqueBaixo());

        // Captura a saída do console
        String mensagemDeSaida = outputStream.toString().trim();

        System.out.println(produto.toString());

        assertEquals(mensagemEsperada, mensagemDeSaida);
    }

}
