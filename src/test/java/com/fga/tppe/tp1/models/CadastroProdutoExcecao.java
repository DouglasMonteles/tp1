package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.TestesExcecoes;
import com.fga.tppe.tp1.exceptions.DescricaoEmBrancoException;
import com.fga.tppe.tp1.exceptions.ValorInvalidoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.junit.Assert.*;


@Category(TestesExcecoes.class)

public class CadastroProdutoExcecao {

    Produto produto;

    @Before
    public void setup(){
        produto = new Produto();
    }

    @Test
    public void testeDescricaoEmBranco(){
        DescricaoEmBrancoException exception = assertThrows(DescricaoEmBrancoException.class, () -> {
            produto.cadastroProduto("", "123456789", 0, 20.0, 50);
        });
        assertEquals("Os campos não pode estar em branco", exception.getMessage());
    }

    @Test
    public void testeProdutoInvalido(){
        ValorInvalidoException exception = assertThrows(ValorInvalidoException.class, () -> {
            produto.cadastroProduto("Produto A", "123456789", 0, 20.0, 50);
        });
        assertEquals("Valores de compra, venda e quantidade devem ser maiores que zero", exception.getMessage());
    }

}
