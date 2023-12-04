package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.TestesFuncionais;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@Category(TestesFuncionais.class)
@RunWith(Parameterized.class)
public class TestCoerenciaQuantidade {

            private ItemTransacao itemTransacao1;
            private Produto produto1;

            private Integer quantidadeDisponivel;
            private Integer quantidade;

            private Boolean resultadoEsperado;

            @Before
            public void setup() {
                this.produto1 = new Produto();
                this.produto1.setQuantidadeDisponivel(quantidadeDisponivel);
                this.itemTransacao1 = new ItemTransacao();
                this.itemTransacao1.setQuantidade(quantidade);
                this.itemTransacao1.setProduto(produto1);
            }

            public TestCoerenciaQuantidade(Integer quantidadeDisponivel, Integer quantidade, Boolean resultadoEsperado){
                this.quantidadeDisponivel = quantidadeDisponivel;
                this.quantidade = quantidade;
                this.resultadoEsperado = resultadoEsperado;
            }

        @Parameterized.Parameters
        public static Collection<Object[]> getParameters() {
            Object[][] parametros = new Object[][] {
                    // quantidadeDisponivel, quantidade
                    {9, 3, false},
                    {6, 6, true},
                    {3, 9, true},
            };

            return Arrays.asList(parametros);
        }


    @Test
            public void alertaQuantidadeItemTransacaoQuantidadeDisponivel() {
                assertEquals(resultadoEsperado, this.itemTransacao1.alertaQuantidade());
            }
        }
