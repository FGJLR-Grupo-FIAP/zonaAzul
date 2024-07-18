package com.tech.challenge.zonaAzul.veiculo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoForm {
    private String modelo;
    private String marca;
    private String cor;
    private String placa;

}
