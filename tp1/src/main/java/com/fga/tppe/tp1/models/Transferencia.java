package com.fga.tppe.tp1.models;

public class Transferencia extends TransacaoEstoque {

    private String origem;
    private String destino;

    public boolean registrarTransferencia() {
        for (ItemTransacao it : getItensTransacao()) {
            if (!it.getProduto().getLocalizacao().equals(destino)) {
                it.getProduto().setLocalizacao(destino);
                return true;
            }
        }
        return false;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
