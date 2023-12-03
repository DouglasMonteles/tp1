package com.fga.tppe.tp1.models;

import java.math.BigDecimal;

public class Lote {
    private Integer id;
    private String nome;


    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}
