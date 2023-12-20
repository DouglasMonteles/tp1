package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.TestesExcecoes;
import com.fga.tppe.tp1.exceptions.DescricaoEmBrancoException;
import com.fga.tppe.tp1.exceptions.ValorInvalidoException;
import com.fga.tppe.tp1.services.ProdutoService;
import com.fga.tppe.tp1.services.impl.ProdutoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;


@Category(TestesExcecoes.class)
public class CadastroProdutoExcecao {

    private final ProdutoService produtoService;

    Produto produto;

    public CadastroProdutoExcecao() {
        produtoService = new ProdutoServiceImpl();
    }

    @Before
    public void setup(){
        produto = new Produto();
    }

    @Test
    public void testeDescricaoEmBranco(){
        DescricaoEmBrancoException exception = assertThrows(DescricaoEmBrancoException.class, () -> {
            produtoService.cadastroProduto("", "123456789", 0, 20.0, 50);
        });
        assertEquals("Os campos não pode estar em branco", exception.getMessage());
    }

    @Test
    public void testeProdutoInvalido(){
        ValorInvalidoException exception = assertThrows(ValorInvalidoException.class, () -> {
            produtoService.cadastroProduto("Produto A", "123456789", 0, 20.0, 50);
        });
        assertEquals("Valores de compra, venda e quantidade devem ser maiores que zero", exception.getMessage());
    }

}
