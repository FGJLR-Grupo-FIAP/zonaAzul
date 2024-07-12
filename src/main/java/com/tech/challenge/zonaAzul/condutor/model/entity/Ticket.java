package com.tech.challenge.zonaAzul.condutor.model.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Document(collection = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    private String id;
    private Date dataHoraEntrada;
    private Date dataHoraSaida;
    private BigDecimal valor;

    public boolean isPeriodoEstacionamentoFixo() {
        return Objects.nonNull(dataHoraEntrada) && Objects.isNull(dataHoraSaida);
    }

}
