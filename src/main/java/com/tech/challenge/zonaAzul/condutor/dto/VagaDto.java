package com.tech.challenge.zonaAzul.condutor.dto;

import com.tech.challenge.zonaAzul.condutor.model.entity.Vaga;
import jakarta.transaction.Status;

public class VagaDto {

    private Long id;
    private String local;
    private Status statusVaga;


    public VagaDto(){

    }

    public VagaDto(Long id, String local, Status statusVaga) {
        this.id = id;
        this.local = local;
        this.statusVaga = statusVaga;
    }

    public VagaDto(Vaga entity) {
        this.id = entity.getId();
        this.local = entity.getLocal();
        this.statusVaga = entity.getStatusVaga();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Status getStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(Status statusVaga) {
        this.statusVaga = statusVaga;
    }
}
