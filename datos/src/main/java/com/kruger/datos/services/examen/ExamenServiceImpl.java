package com.kruger.datos.services.examen;

import com.kruger.datos.entity.Examen;
import com.kruger.datos.repositories.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements ExamenService{

    @Autowired
    private ExamenRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Examen> listar() {
        return (List<Examen>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Examen> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Examen guardar(Examen examen) {
        return repository.save(examen);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
