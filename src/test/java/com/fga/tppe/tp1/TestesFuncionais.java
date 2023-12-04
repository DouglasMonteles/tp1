package com.fga.tppe.tp1;

import com.fga.tppe.tp1.models.*;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({
        AlertaEstoqueBaixoTeste.class,
        CadastroProdutoTest.class,
        TestesConsultaEstoque.class,
        TestesGestaoTransacoes.class,
        TesteTransferenciaEntreFiliais.class,
        TestCoerenciaQuantidade.class,
        TestDataValidade.class,
        TestTotalItensLote.class
})
@IncludeCategory(TestesFuncionais.class)
public class TestesFuncionais {
}
