package com.kruger.pertenece.controllers;

import com.kruger.pertenece.entity.Paciente;
import com.kruger.pertenece.services.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Paciente")
public class PacienteController {
    @Autowired
    private PacienteService services;
    @GetMapping
    public List<Paciente> Listar(){return services.listar();}
    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Paciente> pacienteOptional = services.porId(id);
        if(pacienteOptional.isPresent()){
            return  ResponseEntity.ok(pacienteOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/")
    public ResponseEntity<?> crear(@RequestBody Paciente paciente){
            return ResponseEntity.status(HttpStatus.CREATED).body(services.guardar(paciente));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Paciente paciente, @PathVariable Long Pacedula){
        Optional<Paciente> pa=services.porId(Pacedula);
        if(pa.isPresent()){
            Paciente examenDb = pa.get();
            examenDb.setPaNombre(paciente.getPaNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body(services.guardar(examenDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long Pacedula){
        Optional<Paciente> o=services.porId(Pacedula);
        if(o.isPresent()){
            services.eliminar(o.get().getPaCedula());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
