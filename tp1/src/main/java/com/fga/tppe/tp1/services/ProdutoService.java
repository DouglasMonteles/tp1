package com.fga.tppe.tp1.services;

import com.fga.tppe.tp1.models.Produto;

public interface ProdutoService {

    public boolean confereValidade(Produto produto);

    public Produto cadastroProduto(String nome, String codigoBarras, double precoCompra, double precoVenda, int quantidadeEstoque);

}
