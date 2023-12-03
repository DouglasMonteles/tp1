package com.fga.tppe.tp1;

import com.fga.tppe.tp1.models.AlertaEstoqueBaixoTeste;
import com.fga.tppe.tp1.models.TestCoerenciaQuantidade;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ AlertaEstoqueBaixoTeste.class, TestCoerenciaQuantidade.class})
@IncludeCategory(TestesFuncionais.class)
public class TestesFuncionais {
}
