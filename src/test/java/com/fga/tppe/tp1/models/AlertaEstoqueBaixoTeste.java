package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.TestesFuncionais;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Category(TestesFuncionais.class)
public class AlertaEstoqueBaixoTeste {

    private Produto produto1;
    private Produto produto2;
    private Produto produto3;

    @Before
    public void setup() {
        this.produto1 = new Produto(10, 3);
        this.produto2 = new Produto(5, 5);
        this.produto3 = new Produto(3, 10);
    }

    @Test
    public void naoEmiteAlertaQuandoLimiteMinimoAindaNaoFoiAtingidoTeste() {
        assertFalse(this.produto1.alertaEstoqueBaixo());
    }

    @Test
    public void emiteAlertaQuandoLimiteMinimoIgualAQuantidadeTeste() {
        assertTrue(this.produto2.alertaEstoqueBaixo());
    }

    @Test
    public void emiteAlertaQuandoLimiteMinimoMaiorQueQuantidadeTeste() {
        assertTrue(this.produto3.alertaEstoqueBaixo());
    }

}
