package com.tech.challenge.zonaAzul.util.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusPagamento {
    PENDENTE("PENDENTE"),
    CANCELADO("CANCELADO"),
    APROVADO("APROVADO");

    private String value;
    StatusPagamento(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static StatusPagamento fromString(String text) {
        if (text != null) {
            for (StatusPagamento statusPagamento : StatusPagamento.values()) {
                if (text.equalsIgnoreCase(statusPagamento.value)) {
                    return statusPagamento;
                }
            }
        }
        throw new IllegalArgumentException("Status de pagamento inválido: " + text);
    }
}





