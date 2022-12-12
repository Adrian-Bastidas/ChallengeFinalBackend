package com.kruger.pertenece.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name="PACIENTE")
public class Paciente {
    private String PaNombre;
    private String PaApellido;
    @Id
    private Long PaCedula;
    private Date PaFechaNacimiento;

    private String PaCorreo;

    public String getPaCorreo() {
        return PaCorreo;
    }

    public void setPaCorreo(String paCorreo) {
        PaCorreo = paCorreo;
    }

    public String getPaNombre() {
        return PaNombre;
    }

    public void setPaNombre(String paNombre) {
        PaNombre = paNombre;
    }

    public String getPaApellido() {
        return PaApellido;
    }

    public void setPaApellido(String paApellido) {
        PaApellido = paApellido;
    }

    public Long getPaCedula() {
        return PaCedula;
    }

    public void setPaCedula(Long paCedula) {
        PaCedula = paCedula;
    }

    public Date getPaFechaNacimiento() {
        return PaFechaNacimiento;
    }

    public void setPaFechaNacimiento(Date paFechaNacimiento) {
        PaFechaNacimiento = paFechaNacimiento;
    }
}
