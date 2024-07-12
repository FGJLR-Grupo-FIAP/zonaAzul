package com.tech.challenge.zonaAzul.condutor.model.entity;

import com.tech.challenge.zonaAzul.util.enums.TipoPagamento;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "condutor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condutor {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String cnh;
    private Endereco endereco;
    private BigDecimal saldo;
    private TipoPagamento tipoPagamentoPrincipal;
    private Date dataHoraCadastro = new Date();
    private Date dataHoraAtualizacao = new Date();
    private Boolean clienteAtivo = true;
}
