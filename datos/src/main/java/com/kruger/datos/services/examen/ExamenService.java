package com.kruger.datos.services.examen;

import com.kruger.datos.entity.Examen;

import java.util.List;
import java.util.Optional;

public interface ExamenService {

    List<Examen> listar();
    Optional<Examen> porId(Long id);
    Examen guardar(Examen examen);
    void eliminar(Long id);
}
