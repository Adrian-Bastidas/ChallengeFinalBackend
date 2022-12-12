package com.kruger.pertenece.controllers;

import com.kruger.pertenece.entity.Examen;
import com.kruger.pertenece.entity.Paciente;
import com.kruger.pertenece.services.examen.ExamenService;
import com.kruger.pertenece.services.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Examen")
public class ExamenController {

    @Autowired
    private ExamenService service;
    @Autowired
    private PacienteService services;

    @GetMapping
    public List<Examen> Listar(){return service.listar();}
    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Examen> examenOptional = service.porId(id);
        if(examenOptional.isPresent()){
            return  ResponseEntity.ok(examenOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/")
    public ResponseEntity<?> crear(@RequestBody Examen examen){
        Optional<Paciente> pacienteOptional = services.porId(examen.getPaciente());
        if(pacienteOptional.isPresent()){
            if((examen.getOxigeno()>0&&examen.getOxigeno()<100) &&(examen.getGrasa()>0
                    &&examen.getOxigeno()<100)&&(examen.getAzucar()>0&&examen.getAzucar()<100)){
                examen.setFecha(ZonedDateTime.now());
                if(examen.getAzucar()>70&&examen.getGrasa()>88.5&&examen.getOxigeno()<60)
                    examen.setRiesgo("Alto");
                else if((examen.getAzucar()<=70&&examen.getAzucar()>=50)
                        &&(examen.getGrasa()<=88.5 &&examen.getGrasa()>=62.2)
                        &&(examen.getOxigeno()<=70&&examen.getOxigeno()>=60))
                    examen.setRiesgo("Medio");
                else if(examen.getAzucar()<50&&examen.getGrasa()<62.2
                        &&examen.getOxigeno()>70)
                    examen.setRiesgo("Bajo");
                else
                    examen.setRiesgo("Desconocido");
                return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(examen));
            }
            else
                return ResponseEntity.notFound().build();
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id){
        Optional<Examen> ex=service.porId(id);
        if(ex.isPresent()){
            Examen examenDb = ex.get();
            examenDb.setRiesgo(examen.getRiesgo());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(examenDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Examen> o=service.porId(id);
        if(o.isPresent()){
            service.eliminar(o.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
