package com.fga.tppe.tp1.exceptions;

public class EstoqueNegativoException extends RuntimeException {

    public EstoqueNegativoException() {
        super();
    }

    public EstoqueNegativoException(String msg) {
        super(msg);
    }

}
