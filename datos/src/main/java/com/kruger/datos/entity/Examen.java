package com.kruger.datos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;

@Entity
@Table(name="EXAMEN")
public class Examen {
private Float Azucar;
private Float Grasa;
private Float Oxigeno;
private String Riesgo;
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long Id;
private ZonedDateTime Fecha;

@NotNull
private Long paciente;

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public Float getAzucar() {
        return Azucar;
    }

    public void setAzucar(Float azucar) {
        Azucar = azucar;
    }

    public Float getGrasa() {
        return Grasa;
    }

    public void setGrasa(Float grasa) {
        Grasa = grasa;
    }

    public Float getOxigeno() {
        return Oxigeno;
    }

    public void setOxigeno(Float oxigeno) {
        Oxigeno = oxigeno;
    }

    public String getRiesgo() {
        return Riesgo;
    }

    public void setRiesgo(String riesgo) {
        Riesgo = riesgo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public ZonedDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(ZonedDateTime fecha) {
        this.Fecha = fecha;
    }
}
