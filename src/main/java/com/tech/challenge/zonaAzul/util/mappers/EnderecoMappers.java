package com.tech.challenge.zonaAzul.util.mappers;

import com.tech.challenge.zonaAzul.condutor.form.EnderecoForm;
import com.tech.challenge.zonaAzul.condutor.model.entity.Endereco;

public class EnderecoMappers {

    public static Endereco enderecoMapper(EnderecoForm enderecoForm){
        Endereco endereco = new Endereco();
        endereco.setCep(enderecoForm.getCep());
        endereco.setCidade(enderecoForm.getCidade());
        endereco.setLogradouro(enderecoForm.getLogradouro());
        endereco.setNumero(enderecoForm.getNumero());
        endereco.setBairro(enderecoForm.getBairro());
        endereco.setComplemento(enderecoForm.getComplemento());
        endereco.setEstado(enderecoForm.getEstado());

        return endereco;
    }

}
