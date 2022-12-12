package com.kruger.datos.repositories;

import com.kruger.datos.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente,Long> {
}
