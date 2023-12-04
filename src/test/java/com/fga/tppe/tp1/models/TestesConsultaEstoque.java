package com.fga.tppe.tp1.models;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TestesConsultaEstoque {

    private Produto produto;
    Estoque estoque;

    @Before
    public void setUp(){
        estoque = new Estoque();

    }



    @Test
    public void testBuscaProdutoNomeCerto(){
        Produto produtoNome;
        produtoNome = new Produto("Cartela de Ovo","2131",9.5,16.76,30);

        estoque.addProduto(produtoNome);

        Produto compara = estoque.buscaProdutoNome("Cartela de Ovo");


        assertEquals(compara.getNome(),produtoNome.getNome());
        assertEquals(compara.getCodigoBarra(),produtoNome.getCodigoBarra());
        assertEquals(compara.getCusto(),produtoNome.getCusto());
        assertEquals(compara.getPrecoVenda(),produtoNome.getPrecoVenda());
        assertEquals(compara.getQuantidadeDisponivel(),produtoNome.getQuantidadeDisponivel());

    }

    @Test
    public void testBuscaProdutoNomeErrado(){
        Produto comparaErrado = estoque.buscaProdutoNome("leite");
        assertNull(comparaErrado);



    }

    @Test
    public void testBuscaProdutoCodigoBarraCerto(){
        //teste para o caso certo
        Produto produtoCodigoBarra;
        produtoCodigoBarra = new Produto("Frango","2023",17.80,26.99,50);
        estoque.addProduto(produtoCodigoBarra);
        Produto compara = estoque.buscaProdutoCodigoBarra("2023");;



        assertEquals(compara.getNome(),produtoCodigoBarra.getNome());
        assertEquals(compara.getCodigoBarra(),produtoCodigoBarra.getCodigoBarra());
        assertEquals(compara.getCusto(),produtoCodigoBarra.getCusto());
        assertEquals(compara.getPrecoVenda(),produtoCodigoBarra.getPrecoVenda());
        assertEquals(compara.getQuantidadeDisponivel(),produtoCodigoBarra.getQuantidadeDisponivel());


    }



    @Test
    public void testBuscaProdutoCodigoBarraErrado(){

        //teste para o caso errado
        Produto comparaErrado = estoque.buscaProdutoCodigoBarra("2000");
        assertNull(comparaErrado);
    }


    @Test
    public void testListarEstoque(){

        Produto produtoCodigoBarra;
        produtoCodigoBarra = new Produto("Sasami","2023",17.80,26.99,50);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        estoque.addProduto(produtoCodigoBarra);

        estoque.ListarProdutos();
        // Captura a saída do console
        String mensagemDeSaida = outputStream.toString().trim();

        System.out.println(mensagemDeSaida);
        assertEquals("Produto{nome=Sasami,  quantidadeDisponivel=50}", mensagemDeSaida);
    }


}
