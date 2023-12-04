package com.fga.tppe.tp1;

import com.fga.tppe.tp1.models.AlertaEstoqueBaixoTesteExcecao;
import com.fga.tppe.tp1.models.CadastroProdutoExcecao;
import com.fga.tppe.tp1.models.TestesGestaoTransacoesExcecao;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({
        AlertaEstoqueBaixoTesteExcecao.class,
        TestesGestaoTransacoesExcecao.class,
        CadastroProdutoExcecao.class
})
@IncludeCategory(TestesExcecoes.class)
public class TestesExcecoes {
}
