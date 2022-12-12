package com.kruger.datos.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class temp {
    private Optional<Paciente> paciente;
    private Optional<Examen> examen;

    public temp(Optional<Paciente> paciente, Optional<Examen> examen) {
        this.paciente = paciente;
        this.examen = examen;
    }

    public temp() {
    }

    public Optional<Examen> getExamen() {
        return examen;
    }

    public void setExamen(Optional<Examen> examen) {
        this.examen = examen;
    }

    public Optional<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(Optional<Paciente> paciente) {
        this.paciente = paciente;
    }
}
