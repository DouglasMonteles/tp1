package com.fga.tppe.tp1;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.fga.tppe.tp1.models.AlertaEstoqueBaixoTeste;
import com.fga.tppe.tp1.models.CadastroProdutoTest;
import com.fga.tppe.tp1.models.TestCoerenciaQuantidade;
import com.fga.tppe.tp1.models.TestDataValidade;
import com.fga.tppe.tp1.models.TestTotalItensLote;
import com.fga.tppe.tp1.models.TesteTransferenciaEntreFiliais;
import com.fga.tppe.tp1.models.TestesConsultaEstoque;
import com.fga.tppe.tp1.models.TestesGestaoTransacoes;

@RunWith(Categories.class)
@SuiteClasses({
        AlertaEstoqueBaixoTeste.class,
        CadastroProdutoTest.class,
        TestesConsultaEstoque.class,
        TestesGestaoTransacoes.class,
        TesteTransferenciaEntreFiliais.class,
        TestCoerenciaQuantidade.class,
        TestDataValidade.class,
        TestTotalItensLote.class,
        TestDataValidade.class
})
@IncludeCategory(TestesFuncionais.class)
public class TestesFuncionais {
}
