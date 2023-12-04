package com.fga.tppe.tp1.models;


import com.fga.tppe.tp1.TestesFuncionais;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
@Category(TestesFuncionais.class)
@RunWith(Parameterized.class)
public class TestesConsultaEstoque {

    private Produto produto;
    private Integer quantidadeDisponivel;
    private Integer limiteMinimo;

    private Fornecedor fornecedor;
    private String nome;

    private String codigoBarra;

    private BigDecimal custo;
    private BigDecimal precoVenda;
    Estoque estoque;

    @Before
    public void setUp(){
        estoque = new Estoque();

    }

    public TestesConsultaEstoque (String nome, String codigoBarra, double custo, double precoVenda, Integer quantidadeDisponivel ){
        this.nome = nome;
        this.codigoBarra = codigoBarra;
        this.custo = new BigDecimal(custo);
        this.precoVenda = new BigDecimal(precoVenda);
        this.quantidadeDisponivel = quantidadeDisponivel;
    }



    @Test
    public void testBuscaProdutoNomeCerto(){
        Produto produtoNome;
        produtoNome = new Produto(nome,codigoBarra,custo.doubleValue(),precoVenda.doubleValue(),quantidadeDisponivel);

        estoque.addProduto(produtoNome);

        Produto compara = estoque.buscaProdutoNome("Sasami");


        //teste

        assertEquals(compara.getNome(),produtoNome.getNome());
        assertEquals(compara.getCodigoBarras(),produtoNome.getCodigoBarras());
        assertEquals(compara.getPrecoCompra(),produtoNome.getPrecoCompra());
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
        produtoCodigoBarra = new Produto(nome,codigoBarra,custo.doubleValue(),precoVenda.doubleValue(),quantidadeDisponivel);
        estoque.addProduto(produtoCodigoBarra);
        Produto compara = estoque.buscaProdutoCodigoBarra("2023");;



        assertEquals(compara.getNome(),produtoCodigoBarra.getNome());
        assertEquals(compara.getCodigoBarras(),produtoCodigoBarra.getCodigoBarras());
        assertEquals(compara.getPrecoCompra(),produtoCodigoBarra.getPrecoCompra());
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
        produtoCodigoBarra = new Produto(nome,codigoBarra,custo.doubleValue(),precoVenda.doubleValue(),quantidadeDisponivel);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        estoque.addProduto(produtoCodigoBarra);

        estoque.ListarProdutos();
        // Captura a saída do console
        String mensagemDeSaida = outputStream.toString().trim();

        System.out.println(mensagemDeSaida);
        assertEquals("Produto{nome=Sasami,  quantidadeDisponivel=50}", mensagemDeSaida);
    }



    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] parametros = new Object[][] {
                // quantidadeDisponivel, limiteMinimo, isEstoqueBaixo, mensagemEsperada
                {"Sasami","2023",17.80,26.99,50}

        };

        return Arrays.asList(parametros);
    }


}
