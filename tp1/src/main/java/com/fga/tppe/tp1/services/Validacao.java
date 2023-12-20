package com.fga.tppe.tp1.services;

import com.fga.tppe.tp1.exceptions.DescricaoEmBrancoException;
import com.fga.tppe.tp1.exceptions.ValorInvalidoException;

public class Validacao {

    public static void validarEntradas(String nome, String codigoBarras, Double precoCompra, Double precoVenda, Integer quantidadeEstoque)
            throws DescricaoEmBrancoException, ValorInvalidoException {
        if (nome == null || codigoBarras == null || nome.isEmpty() || codigoBarras.isEmpty() ||
                precoCompra == null || precoVenda == null || quantidadeEstoque == null){
            throw new DescricaoEmBrancoException("Os campos não pode estar em branco");
        }
        if (precoCompra <= 0 || precoVenda <= 0 || quantidadeEstoque <= 0){
            throw new ValorInvalidoException("Valores de compra, venda e quantidade devem ser maiores que zero");
        }
    }

    // Método para validar se a quantidade fornecida para a transacao eh negativa e lancar a excecao nesses casos
    public static void validarQuantidadeNegativa(int quantidade) {
        if (quantidade < 0) {
            throw new ValorInvalidoException("Quantidade não pode ser negativa.");
        }
    }

}
