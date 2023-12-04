package com.fga.tppe.tp1.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteTransferenciaEntreFiliais {

    private Transferencia transferencia;
    private ItemTransacao itemTransacao;
    private Produto produto;

    @Before
    public void setup() {
        this.transferencia = new Transferencia();
        this.itemTransacao = new ItemTransacao();
        this.produto = new Produto();

        produto.setLocalizacao("São Paulo");
        itemTransacao.setProduto(produto);
        transferencia.addItem(itemTransacao);
    }

    @Test
    public void testTranferenciaFiliais() {
        this.transferencia.setOrigem(produto.getLocalizacao());
        this.transferencia.setDestino("Rio de Janeiro");

        assertTrue(this.transferencia.registrarTransferencia());
        assertEquals("Rio de Janeiro", produto.getLocalizacao());
    }

    @Test
    public void testnaoTranfereEntreFiliaisQuandoOrigemEoDestinoSaoIguais() {
        this.transferencia.setOrigem(produto.getLocalizacao());
        this.transferencia.setDestino(produto.getLocalizacao());

        assertFalse(this.transferencia.registrarTransferencia());
        assertEquals("São Paulo", produto.getLocalizacao());
    }

}
