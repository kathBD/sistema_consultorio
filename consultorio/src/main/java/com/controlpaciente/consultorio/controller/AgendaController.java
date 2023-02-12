package com.controlpaciente.consultorio.controller;

import com.controlpaciente.consultorio.model.Agenda;
import com.controlpaciente.consultorio.model.Cita;
import com.controlpaciente.consultorio.model.Consulta;
import com.controlpaciente.consultorio.model.Paciente;
import com.controlpaciente.consultorio.servicio.AgendaServicio;
import com.controlpaciente.consultorio.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sistema/agenda")
public class AgendaController {

    @Autowired
    private AgendaServicio agendaServicio;

    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping("/listar")
    public ResponseEntity obtenertodosAgendas(){
        return new ResponseEntity(agendaServicio.obtenertodosAgendas(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity crearAgenda(@RequestBody Agenda agenda){
        agendaServicio.agregarAgenda(agenda);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{idAgenda}")
    public ResponseEntity actualizarAgenda(@PathVariable ("idAgenda") String idAgenda, @RequestBody Agenda agenda){
        agendaServicio.actualizarAgenda(agenda,idAgenda);
        return new ResponseEntity(agenda, HttpStatus.ACCEPTED);
    }

    @GetMapping("/listar/cita/{idAgenda}")
    public ResponseEntity listarCitasAgenda(@PathVariable ("idAgenda") String idAgenda){
        Agenda a = agendaServicio.obtAgendaPorId(idAgenda);
        return new ResponseEntity(agendaServicio.obtenertodasCitas(a), HttpStatus.OK);
    }

    @PutMapping("/asignar/cita/{idAgenda}/{idCita}")
    public ResponseEntity actualizarPaciente(@PathVariable ("idAgenda") String idAgenda,
                                             @PathVariable ("idCita") String idCita,
                                             @RequestBody Paciente paciente){
        Paciente p= pacienteServicio.obtPacientePorId(paciente.getId());
        if (p==null){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }else{
            Agenda a = agendaServicio.obtAgendaPorId(idAgenda);
            Cita c = agendaServicio.obtenerCitaporID(a,Integer.parseInt(idCita));
            agendaServicio.asiganarPaciente(idAgenda,c.getId(),paciente);
            return new ResponseEntity(a, HttpStatus.ACCEPTED);
        }
    }

    @PutMapping("/actdesactivar/cita/{idAgenda}/{idCita}/{accion}")
    public ResponseEntity activarDesactivaCita(@PathVariable ("idAgenda") String idAgenda,
                                                @PathVariable ("idCita") String idCita,
                                                @PathVariable ("accion") String accion){
       Agenda a = agendaServicio.obtAgendaPorId(idAgenda);
       Cita c = agendaServicio.obtenerCitaporID(a,Integer.parseInt(idCita));
       agendaServicio.activarDesactivarCita(a.getId(),c.getId(),accion);
       return new ResponseEntity(a, HttpStatus.ACCEPTED);
     }





}








