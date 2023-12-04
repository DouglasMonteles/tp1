package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.TestesFuncionais;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
@Category(TestesFuncionais.class)
@RunWith(Parameterized.class)
public class TestDataValidade {

    private Lote lote;
    private Produto produto;
    private Boolean resultado;
    private Integer id;
    private Date validade;
    private Double precoVenda;

    @Before
    public void setup() {
        this.lote = new Lote();
        this.lote.setId(id);
        this.lote.setValidade(validade);
        this.produto = new Produto();
        this.produto.setPrecoVenda(precoVenda);
        this.produto.setLote(lote);
    }

    public TestDataValidade(Integer id, Date validade , Double precoVenda, Boolean resultado){
        this.id = id;
        this.validade = validade;
        this.precoVenda = precoVenda;
        this.resultado = resultado;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] parametros = new Object[][] {
                // lote, validade, precoVenda
                {1, new Date(9999999990000L), 10.00, false},
        };

        return Arrays.asList(parametros);
    }
    @Test
    public void AlertaConfereValidadeDentroPrazo() {
        assertEquals(resultado, this.produto.confereValidade());
    }
}
