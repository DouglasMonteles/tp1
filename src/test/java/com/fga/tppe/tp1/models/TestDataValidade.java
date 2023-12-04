package com.fga.tppe.tp1.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDataValidade {

    private Lote lote;

    @Before
    public void setup() {
        this.lote = new Lote();
    }

    @Test
    public void AlertaConfereValidade() {
        assertTrue(this.lote.confereValidade());
    }
}
