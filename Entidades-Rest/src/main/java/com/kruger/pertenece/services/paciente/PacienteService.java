package com.kruger.pertenece.services.paciente;

import com.kruger.pertenece.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    List<Paciente> listar();
    Optional<Paciente> porId(Long id);
    Paciente guardar(Paciente paciente);
    void eliminar(Long id);
}
