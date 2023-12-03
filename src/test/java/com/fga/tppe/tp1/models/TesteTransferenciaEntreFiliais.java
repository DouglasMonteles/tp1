package com.fga.tppe.tp1.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteTransferenciaEntreFiliais {

    private Transferencia transferencia;

    @Before
    public void setup() {
        this.transferencia = new Transferencia();
    }

    @Test
    public void testTranferenciaFiliais() {
        assertTrue(this.transferencia.registrarTransferencia());
    }

}
