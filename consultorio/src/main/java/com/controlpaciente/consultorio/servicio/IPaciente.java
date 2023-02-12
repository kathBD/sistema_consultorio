package com.controlpaciente.consultorio.servicio;


import com.controlpaciente.consultorio.model.Consulta;
import com.controlpaciente.consultorio.model.Paciente;

import java.util.List;
public interface IPaciente {

    Paciente obtPacientePorId(String idPaciente);
    List<Paciente> obtenertodosPacientes();
    void agregarPaciente(Paciente paciente);
    void eliminarPaciente(String idPaciente);
    Paciente actualizarPaciente(Paciente paciente, String id);
    void agregarConsulta(Paciente paciente, Consulta consulta);
    List<Consulta> obtenertodasConsultas(Paciente paciente);
    Consulta actualizarConsulta(Paciente paciente, Consulta consulta,String idConsulta);
    Consulta obtenerConsultaporID(Paciente paciente,String idConsulta);



}
