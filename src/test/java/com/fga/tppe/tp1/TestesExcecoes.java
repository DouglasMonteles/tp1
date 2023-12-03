package com.fga.tppe.tp1;

import com.fga.tppe.tp1.models.AlertaEstoqueBaixoTesteExcecao;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ AlertaEstoqueBaixoTesteExcecao.class })
@IncludeCategory(TestesExcecoes.class)
public class TestesExcecoes {
}
