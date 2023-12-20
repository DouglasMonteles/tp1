package com.fga.tppe.tp1.services.impl;

import com.fga.tppe.tp1.exceptions.DescricaoEmBrancoException;
import com.fga.tppe.tp1.exceptions.ValorInvalidoException;
import com.fga.tppe.tp1.models.Lote;
import com.fga.tppe.tp1.models.Produto;
import com.fga.tppe.tp1.services.ProdutoService;
import com.fga.tppe.tp1.services.Validacao;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    public Produto cadastroProduto(String nome, String codigoBarras, double precoCompra, double precoVenda, int quantidadeEstoque)
            throws DescricaoEmBrancoException, ValorInvalidoException {
        Produto produto = new Produto();
        Validacao.validarEntradas(nome, codigoBarras, precoCompra, precoVenda, quantidadeEstoque);
        produto.setNome(nome);
        produto.setCodigoBarras(codigoBarras);
        produto.setPrecoCompra(precoCompra);
        produto.setPrecoVenda(precoVenda);
        produto.setQuantidadeEstoque(quantidadeEstoque);

        System.out.println("Produto cadastrado com sucesso!");
        return produto;
    }

    public boolean confereValidade(Produto produto){

        Date dataAtual = new Date();
        Lote lote = produto.getLote();
        double precoVenda = produto.getPrecoVenda();

        long tresDiasMillis = 3 * 24 * 60 * 60 * 1000L;
        Date dataAtualMenos3Dias = new Date(dataAtual.getTime() - tresDiasMillis);

        if (lote.getValidade().before(dataAtualMenos3Dias)) {
            System.out.println("A data de validade é anterior a 3 dias atrás da data atual.");
            precoVenda = precoVenda - (precoVenda * 0.2);
            return true;
        } else if (lote.getValidade().equals(dataAtualMenos3Dias)) {
            System.out.println("A data de validade é exatamente 3 dias atrás da data atual.");
            return false;
        } else {
            System.out.println("A data de validade é posterior a 3 dias atrás da data atual.");
            return false;
        }
    }

}
