package com.tech.challenge.zonaAzul.util.mappers;

import com.tech.challenge.zonaAzul.condutor.dto.VeiculoDTO;
import com.tech.challenge.zonaAzul.condutor.form.VeiculoForm;
import com.tech.challenge.zonaAzul.condutor.model.entity.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoMapper {

    public static VeiculoDTO veiculoMapperDTO(Veiculo veiculo) {
        return new VeiculoDTO(
                veiculo.getModelo(),
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getCor()
        );
    }

    public static Veiculo veiculoMapper(VeiculoForm veiculoForm) {
        return new Veiculo(
            veiculoForm.getModelo(),
            veiculoForm.getPlaca(),
            veiculoForm.getMarca(),
            veiculoForm.getCor()
        );
    }

    public static List<VeiculoDTO> veiculoMapper(List<Veiculo> veiculoList) {
        List<VeiculoDTO> veiculoDTOList = new ArrayList<>();
        veiculoList.forEach(Item -> {
            veiculoDTOList.add(veiculoMapperDTO(Item));
        });
        return veiculoDTOList;
    }





}
