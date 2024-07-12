package com.tech.challenge.zonaAzul.condutor.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketForm {

    private Date dataHoraSaida;
    private BigDecimal valor;

}
