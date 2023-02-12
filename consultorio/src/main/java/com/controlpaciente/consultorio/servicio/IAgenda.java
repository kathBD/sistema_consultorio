package com.controlpaciente.consultorio.servicio;

import com.controlpaciente.consultorio.model.Agenda;
import com.controlpaciente.consultorio.model.Cita;
import com.controlpaciente.consultorio.model.Paciente;

import java.util.List;

public interface IAgenda {
    Agenda obtAgendaPorId(String idAgenda);
    List<Agenda> obtenertodosAgendas();
    void agregarAgenda(Agenda agenda);

    Agenda actualizarAgenda(Agenda agenda, String idagenda);

    List<Cita> obtenertodasCitas(Agenda agenda );
    Cita actualizarCita(Agenda agenda, Cita cita,int idCita);
    Cita obtenerCitaporID(Agenda agenda,int idCita);
    void activarDesactivarCita(String idAgenda,int idCita,String accion);
    void asiganarPaciente(String idAgenda,int idCita, Paciente paciente);


}
