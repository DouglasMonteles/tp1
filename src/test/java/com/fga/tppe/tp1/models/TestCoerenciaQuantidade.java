package com.fga.tppe.tp1.models;

import com.fga.tppe.tp1.TestesFuncionais;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Category(TestesFuncionais.class)
public class TestCoerenciaQuantidade {

            private ItemTransacao itemTransacao1;
            private ItemTransacao itemTransacao2;
            private ItemTransacao itemTransacao3;
            private Produto produto1;
            private Produto produto2;
            private Produto produto3;

            @Before
            public void setup() {
                this.produto1 = new Produto();
                this.produto2 = new Produto();
                this.produto3 = new Produto();
                this.produto1.setQuantidadeDisponivel(9);
                this.produto2.setQuantidadeDisponivel(6);
                this.produto3.setQuantidadeDisponivel(3);
                this.itemTransacao1 = new ItemTransacao();
                this.itemTransacao2 = new ItemTransacao();
                this.itemTransacao3 = new ItemTransacao();
                this.itemTransacao1.setQuantidade(3);
                this.itemTransacao2.setQuantidade(6);
                this.itemTransacao3.setQuantidade(9);
                this.itemTransacao1.setProduto(produto1);
                this.itemTransacao2.setProduto(produto2);
                this.itemTransacao3.setProduto(produto3);
            }

            @Test
            public void naoEmiteAlertaQuandoItemTransacaoMenorQueQuantidadeDisponivel() {
                assertFalse(this.itemTransacao1.alertaQuantidade());
            }

            @Test
            public void emiteAlertaQuandoItemTransacaoIgualAQuantidadeDisponivel() {
                assertTrue(this.itemTransacao2.alertaQuantidade());
            }

            @Test
            public void emiteAlertaQuandoItemQuantidadeMaiorQueQuantidadeDisponivel() {
                assertTrue(this.itemTransacao3.alertaQuantidade());
            }
        }
