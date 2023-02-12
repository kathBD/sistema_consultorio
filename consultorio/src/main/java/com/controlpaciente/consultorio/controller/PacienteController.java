package com.controlpaciente.consultorio.controller;


import com.controlpaciente.consultorio.model.Paciente;
import com.controlpaciente.consultorio.servicio.IPaciente;
import com.controlpaciente.consultorio.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sistema/paciente")
public class PacienteController {


   @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping("/listar")
    public ResponseEntity obtenertodosPacientes(){
        return new ResponseEntity(pacienteServicio.obtenertodosPacientes(), HttpStatus.OK);
    }



    @PostMapping("/crear")
    public ResponseEntity crearPaciente(@RequestBody Paciente paciente){
        pacienteServicio.agregarPaciente(paciente);
        return new ResponseEntity(HttpStatus.CREATED);
    }


  @PutMapping("/actualizar/{pacienteId}")
    public ResponseEntity actualizarPaciente(@PathVariable ("pacienteId") String id, @RequestBody Paciente paciente){
        Paciente  p= pacienteServicio.obtPacientePorId(id);
        pacienteServicio.actualizarPaciente(p,id);
        return new ResponseEntity(p, HttpStatus.ACCEPTED);
  }


/*
*
*   @DeleteMapping("/{noteId}")
    public ResponseEntity deleteNote(@PathVariable("noteId") String id){
        List<Note> newNotes = notes.stream().filter(n -> !n.getId().equals(id)).collect(Collectors.toList());
        this.notes = newNotes;
        return new ResponseEntity(notes, HttpStatus.GONE);
    }
* */




}
