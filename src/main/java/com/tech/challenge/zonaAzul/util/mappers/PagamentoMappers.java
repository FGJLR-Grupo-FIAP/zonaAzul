package com.tech.challenge.zonaAzul.util.mappers;

import com.tech.challenge.zonaAzul.condutor.dto.PagamentoRecord;
import com.tech.challenge.zonaAzul.condutor.form.PagamentoForm;
import com.tech.challenge.zonaAzul.condutor.model.entity.Pagamento;
import com.tech.challenge.zonaAzul.util.enums.StatusPagamento;

public class PagamentoMappers {

    public static PagamentoRecord pagamentoMapperDTO(Pagamento pagamento) {
        PagamentoRecord pagamentoRecord = new PagamentoRecord(
                pagamento.getStatusPagamento(),
                pagamento.getFormaPagamento());
        return pagamentoRecord;
    }

    public static Pagamento pagamentoMapper(PagamentoForm pagamentoForm){
        Pagamento pagamento = new Pagamento();
        pagamento.setStatusPagamento(StatusPagamento.PENDENTE);
        pagamento.setFormaPagamento(pagamentoForm.getFormaPagamento());
        return pagamento;
    }
}
