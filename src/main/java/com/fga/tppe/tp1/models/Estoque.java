package com.fga.tppe.tp1.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    List<Produto> produtos = new ArrayList<>();
    public Integer confereLote(Integer loteId){
        Integer totalLote = 0;
        for (Produto p: produtos){
            if(p.getLote().getId().equals(loteId)) {
                totalLote+=p.getQuantidadeDisponivel();
            }
        }
        return totalLote;
    }

    public void setProdutos(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> getProduto() {
        return this.produtos;
    }
}
