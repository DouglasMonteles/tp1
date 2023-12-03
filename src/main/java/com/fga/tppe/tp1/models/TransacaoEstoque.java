package com.fga.tppe.tp1.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransacaoEstoque {

    private Integer id;
    private Date date;
    private List<ItemTransacao> itensTransacao = new ArrayList<>();

    public TransacaoEstoque() {}

    public TransacaoEstoque(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ItemTransacao> getItensTransacao() {
        return itensTransacao;
    }

    public void addItem(ItemTransacao itemTransacao) {
        this.itensTransacao.add(itemTransacao);
    }
}
