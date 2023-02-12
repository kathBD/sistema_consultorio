package com.controlpaciente.consultorio.controller;


import com.controlpaciente.consultorio.model.Consulta;
import com.controlpaciente.consultorio.model.Paciente;
import com.controlpaciente.consultorio.servicio.IPaciente;
import com.controlpaciente.consultorio.servicio.PacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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
        pacienteServicio.actualizarPaciente(paciente,id);
        return new ResponseEntity(paciente, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarPaciente(@PathVariable ("id") String id){
        pacienteServicio.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar/historial/{idPaciente}")
    public ResponseEntity listarHistoriaPaciente(@PathVariable ("idPaciente") String id){
        Paciente p = pacienteServicio.obtPacientePorId(id);
        return new ResponseEntity(pacienteServicio.obtenertodasConsultas(p), HttpStatus.OK);
    }

    @PostMapping("/crear/consulta/{idPaciente}")
    public ResponseEntity crearConsultaAPaciente(@PathVariable ("idPaciente") String id,@RequestBody Consulta consulta){
        Paciente p = pacienteServicio.obtPacientePorId(id);
        pacienteServicio.agregarConsulta(p,consulta);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/consulta/{idpaciente}/{idconsulta}")
    public ResponseEntity actualizarPaciente(@PathVariable ("idpaciente") String idPaciente,
                                             @PathVariable ("idconsulta") String idConsulta,
                                             @RequestBody Consulta consulta){
        Paciente p = pacienteServicio.obtPacientePorId(idPaciente);
        pacienteServicio.actualizarConsulta(p,consulta,idConsulta);

        return new ResponseEntity(p, HttpStatus.ACCEPTED);
    }




}
