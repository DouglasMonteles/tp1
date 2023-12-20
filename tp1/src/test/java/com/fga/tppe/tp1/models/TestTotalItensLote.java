package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.TestesFuncionais;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Category(TestesFuncionais.class)
@RunWith(Parameterized.class)
public class TestTotalItensLote {
    private Integer quantidadeDisponivel;
    private Produto produto;
    private Lote lote;
    private Estoque estoque;
    private Integer id;
    private String nome;
    private Integer idLoteEsperado;
    private Integer quantidadeEsperada;

    @Before
    public void setup() {
        this.produto = new Produto();
        this.lote = new Lote();
        this.estoque = new Estoque();
        this.produto.setQuantidadeDisponivel(quantidadeDisponivel);
        this.produto.setLote(lote);
        this.estoque.setProdutos(produto);
        this.lote.setId(id);
        this.lote.setNome(nome);
    }

    public TestTotalItensLote(Integer id, String nome, Integer quantidadeDisponivel, Integer quantidadeEsperada, Integer idLoteEsperado){
        this.id = id;
        this.nome = nome;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.quantidadeEsperada = quantidadeEsperada;
        this.idLoteEsperado = idLoteEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        Object[][] parametros = new Object[][] {
                // idLote, nome, quantidadeDisponivel, quantidadeEsperada, idLoteEsperada
                {1, "Café", 10, 10, 1},
        };

        return Arrays.asList(parametros);
    }
    @Test
    public void naoEmiteAlertaQuandoQuantidadeTotalLoteCorreta() {
        assertEquals(quantidadeEsperada,this.estoque.confereLote(idLoteEsperado));
    }

}
