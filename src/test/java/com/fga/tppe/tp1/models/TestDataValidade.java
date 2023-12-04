package com.fga.tppe.tp1.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDataValidade {

    private Lote lote;
    private Produto produto;

    @Before
    public void setup() {
        this.lote = new Lote();
        this.lote.setId(1);
        this.lote.setValidade(new Date(1234567890000L));
        this.produto = new Produto();
        this.produto.setPrecoVenda(10.00);
        this.produto.setLote(lote);
    }

    @Test
    public void AlertaConfereValidade() {
        assertTrue(this.produto.confereValidade());
    }
}
