package com.kruger.datos.controllers;

import com.kruger.datos.entity.Examen;
import com.kruger.datos.entity.Paciente;
import com.kruger.datos.entity.temp;
import com.kruger.datos.services.examen.ExamenService;
import com.kruger.datos.services.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Datos")
public class DatosController {

    @Autowired
    private ExamenService service;
    @Autowired
    private PacienteService services;

    @GetMapping
    public List<Examen> Listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Paciente> pacienteOptional=services.porId(id);
        if(pacienteOptional.isPresent()){
            List<Examen> list1 =service.listar();
            Optional<Examen> examenOptional=null;
            List<Optional<Examen>> list2=new ArrayList<>();
            for(int i=0; i<list1.size(); i++){
                if((list1.get(i).getPaciente()).intValue()==id.intValue()){
                    list2.add(service.porId(list1.get(i).getId()));
                }
            }
            int max=0;
            for(int i=0; i<list2.size();i++){
                if(list2.get(i).get().getId().intValue()>max){
                    max=list2.get(i).get().getId().intValue();
                    examenOptional=list2.get(i);
                }
            }
            temp tempOptional=new temp(pacienteOptional,examenOptional);
            return  ResponseEntity.ok(tempOptional);
        }
        return ResponseEntity.notFound().build();
    }
}
