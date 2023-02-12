package com.controlpaciente.consultorio.servicio;

import com.controlpaciente.consultorio.model.Agenda;
import com.controlpaciente.consultorio.model.Cita;
import com.controlpaciente.consultorio.model.Paciente;

import java.util.List;

public interface IAgenda {
    Paciente obtAgendaPorId(String idAgenda);
    List<Agenda> obtenertodosAgendas();
    void agregarAgenda(Agenda agenda);

    Agenda actualizarAgenda(Agenda agenda, String idagenda);

    List<Cita> obtenertodasConsultas(Agenda agenda );
    Cita actualizarCita(Agenda agenda, Cita cita,int idCita);
    Cita obtenerCitaporID(Agenda agenda,int idCita);
    void cancelarCita(Agenda agenda,int idCita);
    void aceptarCita(Agenda agenda,int idCita);
    void asiganarPaciente(String idAgenda,int idCita, Paciente paciente);
}
