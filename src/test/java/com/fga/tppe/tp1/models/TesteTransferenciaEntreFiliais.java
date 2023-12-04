package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.TestesFuncionais;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@Category(TestesFuncionais.class)
@RunWith(Parameterized.class)
public class TesteTransferenciaEntreFiliais {

    private Transferencia transferencia;
    private ItemTransacao itemTransacao;
    private Produto produto;
    private String origem;
    private String destino;
    private Boolean resultadoEsperado;

    public TesteTransferenciaEntreFiliais(String origem,
                                          String destino,
                                          Boolean resultadoEsperado) {
        this.origem = origem;
        this.destino = destino;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Before
    public void setup() {
        this.transferencia = new Transferencia();
        this.itemTransacao = new ItemTransacao();
        this.produto = new Produto();

        produto.setLocalizacao(origem);
        itemTransacao.setProduto(produto);
        transferencia.addItem(itemTransacao);

        this.transferencia.setOrigem(origem);
        this.transferencia.setDestino(destino);
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] parametros = new Object[][] {
                // origem, destino, resultadoEsperado
                {"São Paulo", "Rio de Janeiro", true},
                {"São Paulo", "São Paulo",      false},
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void testTranferenciaFiliais() {
        assertEquals(resultadoEsperado, this.transferencia.registrarTransferencia());
        assertEquals(destino, produto.getLocalizacao());
    }

}
