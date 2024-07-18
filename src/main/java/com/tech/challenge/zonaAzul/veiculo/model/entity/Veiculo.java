package com.tech.challenge.zonaAzul.veiculo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    private String modelo;
    private String placa;
    private String marca;
    private String cor;


}
