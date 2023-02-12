package com.controlpaciente.consultorio.servicio;

import com.controlpaciente.consultorio.model.Agenda;
import com.controlpaciente.consultorio.model.Cita;
import com.controlpaciente.consultorio.model.Paciente;

import java.util.List;

public class AgendaServicio implements IAgenda{


    @Override
    public Paciente obtAgendaPorId(String idAgenda) {
        return null;
    }

    @Override
    public List<Agenda> obtenertodosAgendas() {
        return null;
    }

    @Override
    public void agregarAgenda(Agenda agenda) {

    }

    @Override
    public Agenda actualizarAgenda(Agenda agenda, String idagenda) {
        return null;
    }

    @Override
    public List<Cita> obtenertodasConsultas(Agenda agenda) {
        return null;
    }

    @Override
    public Cita actualizarCita(Agenda agenda, Cita cita, int idCita) {
        return null;
    }

    @Override
    public Cita obtenerCitaporID(Agenda agenda, int idCita) {
        return null;
    }

    @Override
    public void cancelarCita(Agenda agenda, int idCita) {

    }

    @Override
    public void aceptarCita(Agenda agenda, int idCita) {

    }

    @Override
    public void asiganarPaciente(String idAgenda, int idCita, Paciente paciente) {

    }
}
