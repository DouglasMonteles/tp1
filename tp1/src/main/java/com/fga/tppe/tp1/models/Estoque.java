package com.fga.tppe.tp1.models;

import java.util.ArrayList;
import java.util.List;


public class Estoque {

    private List<Produto> estoqueProdutos = new ArrayList<>();

    public Produto buscarProdutoPorNome(String nome) {
        for (Produto produto: estoqueProdutos) {
            if(produto.getNome().equalsIgnoreCase(nome)){
                produto.buscaNome();
                return produto;
            }
        }

        return null;
    }

    public Produto buscarProdutoPorCodigoDeBarra(String codigoBarra){
        for(Produto produto: estoqueProdutos){
            if(produto.getCodigoBarras().equals(codigoBarra)){
                produto.buscaNome();
                return produto;
            }
        }

        return null;
    }


    public void adicionarProduto(Produto produto){
        this.estoqueProdutos.add(produto);
    }

    public void listarProdutos(){
        for(Produto produto: estoqueProdutos){
            System.out.println("Produto{" +
                    "nome=" + produto.getNome() +
                    ",  quantidadeDisponivel=" + produto.getQuantidadeDisponivel() +
                    '}');
        }

    }

    public Integer confereLote(Integer loteId){
        Integer totalLote = 0;
        for (Produto p: estoqueProdutos){
            if(p.getLote().getId().equals(loteId)) {
                totalLote+=p.getQuantidadeDisponivel();
            }
        }
        return totalLote;
    }

    public void setProdutos(Produto produto) {
        this.estoqueProdutos.add(produto);
    }

    public List<Produto> getProduto() {
        return this.estoqueProdutos;
    }
}
