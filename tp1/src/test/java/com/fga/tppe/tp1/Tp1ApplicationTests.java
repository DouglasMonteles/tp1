package com.fga.tppe.tp1;

import com.fga.tppe.tp1.models.*;
import org.junit.experimental.categories.Categories;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Categories.class)
@Suite.SuiteClasses({
		TestesFuncionais.class,
		TestesExcecoes.class
})
@Categories.IncludeCategory({TestesFuncionais.class, TestesExcecoes.class})
class Tp1ApplicationTests {}
