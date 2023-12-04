package com.fga.tppe.tp1.models;

import java.util.ArrayList;
import java.util.List;


public class Estoque {

    private List<Produto> estoqueProdutos = new ArrayList<>();

    public Produto buscaProdutoNome(String nome) {
        for (Produto produto: estoqueProdutos) {
            if(produto.getNome().equalsIgnoreCase(nome)){
                produto.buscaNome();
                return produto;
            }
        }

        return null;
    }

    public Produto buscaProdutoCodigoBarra(String codigoBarra){
        for(Produto produto: estoqueProdutos){
            if(produto.getCodigoBarra().equals(codigoBarra)){
                produto.buscaNome();
                return produto;
            }
        }

        return null;
    }


    public void addProduto(Produto produto){
        this.estoqueProdutos.add(produto);
    }

    public void ListarProdutos(){
        for(Produto produto: estoqueProdutos){
            System.out.println("Produto{" +
                    "nome=" + produto.getNome() +
                    ",  quantidadeDisponivel=" + produto.getQuantidadeDisponivel() +
                    '}');
        }
    }
}
