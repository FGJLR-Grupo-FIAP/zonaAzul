package com.tech.challenge.zonaAzul.condutor.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Status;


@Entity
@Table(name = "tb_vaga")
public class Vaga {

    @Id
    private Long id;
    private String local;
    private Status statusVaga;

    public Vaga() {
    }

    public Vaga(Long id, String local, Status statusVga) {
        this.id = id;
        this.local = local;
        this.statusVaga = statusVga;
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

    public void setStatusVaga(Status statusVga) {
        this.statusVaga = statusVga;
    }
}
