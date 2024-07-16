package com.tech.challenge.zonaAzul.condutor.model.entity;

import com.tech.challenge.zonaAzul.condutor.dto.UsuarioRecordDTO;
import com.tech.challenge.zonaAzul.util.Consts.ZonaAzulConst;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private UsuarioRecordDTO condutor;
    private Pagamento pagamento;

    public boolean isPeriodoEstacionamentoFixo() {
        return Objects.nonNull(dataHoraEntrada) && Objects.isNull(dataHoraSaida);
    }

    public void calcularValor(int quantidadeHoras) {
        valor = BigDecimal.valueOf(quantidadeHoras * ZonaAzulConst.PRECO_POR_HORA_ESTACIONADA);
        valor = valor.setScale(2, RoundingMode.HALF_EVEN);
    }

}
