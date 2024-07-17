package com.tech.challenge.zonaAzul.ticket.pagamento.model.service;

import com.tech.challenge.zonaAzul.ticket.pagamento.model.entity.Pagamento;
import com.tech.challenge.zonaAzul.util.enums.StatusPagamento;
import com.tech.challenge.zonaAzul.util.enums.TipoPagamento;
import com.tech.challenge.zonaAzul.util.exception.PaymentMethodException;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    public void autorizarPagamento(Pagamento pagamento) {
        pagamento.setStatusPagamento(StatusPagamento.APROVADO);
    }

    public void validarFormaPagamento(TipoPagamento tipoPagamento, boolean periodoEstacionamentoFixo) {
        if (!periodoEstacionamentoFixo && TipoPagamento.PIX.equals(tipoPagamento)) {
            throw new PaymentMethodException("Pagamento via PIX está disponível apenas para período fixo informado na compra do Ticket");
        }
    }

}
