package com.tech.challenge.zonaAzul.ticket.pagamento.model.service;

import com.tech.challenge.zonaAzul.ticket.pagamento.model.entity.Pagamento;
import com.tech.challenge.zonaAzul.util.enums.StatusPagamento;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    public void autorizarPagamento(Pagamento pagamento) {
        pagamento.setStatusPagamento(StatusPagamento.APROVADO);
    }

}
