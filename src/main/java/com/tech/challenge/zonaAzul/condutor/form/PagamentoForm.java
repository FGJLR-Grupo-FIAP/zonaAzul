package com.tech.challenge.zonaAzul.condutor.form;

import com.tech.challenge.zonaAzul.util.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoForm {
    private TipoPagamento formaPagamento;
}
