package com.tech.challenge.zonaAzul.util.mappers;

import com.tech.challenge.zonaAzul.condutor.form.CondutorForm;
import com.tech.challenge.zonaAzul.condutor.model.entity.Condutor;
import com.tech.challenge.zonaAzul.condutor.model.entity.Endereco;
import com.tech.challenge.zonaAzul.util.enums.TipoPagamento;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

public class CondutorMappers {

    public static Condutor condutorMapper(CondutorForm condutorForm){
        Condutor condutor = new Condutor();

        condutor.setNome(condutorForm.getNome());
        condutor.setCpf(condutorForm.getCpf());
        condutor.setDataNascimento(condutorForm.getDataNascimento());
        condutor.setCnh(condutorForm.getCnh());
        condutor.setEndereco(EnderecoMappers.enderecoMapper(condutorForm.getEndereco()));
        condutor.setSaldo(condutorForm.getSaldo());
        condutor.setTipoPagamentoPrincipal(condutorForm.getTipoPagamentoPrincipal());

        return condutor;
    }

}
