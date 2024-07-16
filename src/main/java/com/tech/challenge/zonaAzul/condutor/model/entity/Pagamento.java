package com.tech.challenge.zonaAzul.condutor.model.entity;

import com.tech.challenge.zonaAzul.util.enums.StatusPagamento;
import com.tech.challenge.zonaAzul.util.enums.TipoPagamento;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    private StatusPagamento statusPagamento;
    private TipoPagamento formaPagamento;

}
