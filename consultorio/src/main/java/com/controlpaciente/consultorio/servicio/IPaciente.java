package com.controlpaciente.consultorio.servicio;


import com.controlpaciente.consultorio.model.Paciente;

import java.util.List;
public interface IPaciente {

    Paciente obtPacientePorId(String idPaciente);
    List<Paciente> obtenertodosPacientes();
    void agregarPaciente(Paciente paciente);
    void eliminarPaciente(String idPaciente);
    Paciente actualizarPaciente(Paciente paciente, String id);

}
