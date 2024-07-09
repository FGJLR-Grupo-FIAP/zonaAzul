package com.tech.challenge.zonaAzul.util.mappers;

import com.tech.challenge.zonaAzul.condutor.dto.PagamentoRecord;
import com.tech.challenge.zonaAzul.condutor.form.PagamentoForm;
import com.tech.challenge.zonaAzul.condutor.model.entity.Pagamento;

public class PagamentoMappers {

    public static PagamentoRecord pagamentoMapperDTO(Pagamento pagamento) {
        PagamentoRecord pagamentoRecord = new PagamentoRecord(pagamento.getId(),
                pagamento.getStatusPagamento(),
                pagamento.getFormaPagamento());
        return pagamentoRecord;
    }

    public static Pagamento pagamentoMapper(PagamentoForm pagamentoForm){
        Pagamento pagamento = new Pagamento();
        pagamento.setFormaPagamento(pagamento.getFormaPagamento());
        return pagamento;
    }
}
