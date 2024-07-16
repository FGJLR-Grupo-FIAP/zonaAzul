package com.tech.challenge.zonaAzul.condutor.dto;

import jakarta.transaction.Status;

public record VagaRecord(

        Long id,
        String local,
        Status statusVaga

) {
}
