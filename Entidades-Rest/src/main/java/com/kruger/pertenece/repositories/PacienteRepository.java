package com.kruger.pertenece.repositories;

import com.kruger.pertenece.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente,Long> {
}
