package com.kruger.datos.services.paciente;

import com.kruger.datos.entity.Paciente;
import com.kruger.datos.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class PacienteServiceImpl implements PacienteService{

@Autowired
    private PacienteRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> listar() {
        return (List<Paciente>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Paciente> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Paciente guardar(Paciente paciente) {
        return repository.save(paciente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
