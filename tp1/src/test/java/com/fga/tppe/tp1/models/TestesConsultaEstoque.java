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
    private Estoque estoque;

    @Before
    public void configurarTeste() {
        estoque = new Estoque();
    }

    public TestesConsultaEstoque(String nome, String codigoBarra, double custo, double precoVenda, Integer quantidadeDisponivel) {
        this.nome = nome;
        this.codigoBarra = codigoBarra;
        this.custo = new BigDecimal(custo);
        this.precoVenda = new BigDecimal(precoVenda);
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Test
    public void testBuscarProdutoPorNomeCorreto() {
        Produto produtoNome = new Produto(nome, codigoBarra, custo.doubleValue(), precoVenda.doubleValue(), quantidadeDisponivel);
        estoque.adicionarProduto(produtoNome);

        Produto comparar = estoque.buscarProdutoPorNome("Sasami");

        assertEquals(comparar.getNome(), produtoNome.getNome());
        assertEquals(comparar.getCodigoBarras(), produtoNome.getCodigoBarras());
        assertEquals(comparar.getPrecoCompra(), produtoNome.getPrecoCompra());
        assertEquals(comparar.getPrecoVenda(), produtoNome.getPrecoVenda());
        assertEquals(comparar.getQuantidadeDisponivel(), produtoNome.getQuantidadeDisponivel());
    }

    @Test
    public void testBuscarProdutoPorNomeInexistente() {
        Produto compararInexistente = estoque.buscarProdutoPorNome("leite");
        assertNull(compararInexistente);
    }

    @Test
    public void testBuscarProdutoPorCodigoDeBarraCorreto() {
        Produto produtoCodigoBarra = new Produto(nome, codigoBarra, custo.doubleValue(), precoVenda.doubleValue(), quantidadeDisponivel);
        estoque.adicionarProduto(produtoCodigoBarra);

        Produto comparar = estoque.buscarProdutoPorCodigoDeBarra("2023");

        assertEquals(comparar.getNome(), produtoCodigoBarra.getNome());
        assertEquals(comparar.getCodigoBarras(), produtoCodigoBarra.getCodigoBarras());
        assertEquals(comparar.getPrecoCompra(), produtoCodigoBarra.getPrecoCompra());
        assertEquals(comparar.getPrecoVenda(), produtoCodigoBarra.getPrecoVenda());
        assertEquals(comparar.getQuantidadeDisponivel(), produtoCodigoBarra.getQuantidadeDisponivel());
    }

    @Test
    public void testBuscarProdutoPorCodigoDeBarraInexistente() {
        Produto compararInexistente = estoque.buscarProdutoPorCodigoDeBarra("2000");
        assertNull(compararInexistente);
    }

    @Test
    public void testListarEstoque() {
        Produto produtoCodigoBarra = new Produto(nome, codigoBarra, custo.doubleValue(), precoVenda.doubleValue(), quantidadeDisponivel);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        estoque.adicionarProduto(produtoCodigoBarra);

        estoque.listarProdutos();
        String mensagemDeSaida = outputStream.toString().trim();

        System.out.println(mensagemDeSaida);
        assertEquals("Produto{nome=Sasami,  quantidadeDisponivel=50}", mensagemDeSaida);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> obterParametros() {
        Object[][] parametros = new Object[][] {
                {"Sasami", "2023", 17.80, 26.99, 50}
        };

        return Arrays.asList(parametros);
    }
}
