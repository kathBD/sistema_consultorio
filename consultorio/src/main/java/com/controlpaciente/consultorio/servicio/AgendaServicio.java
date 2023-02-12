package com.controlpaciente.consultorio.servicio;

import com.controlpaciente.consultorio.model.Agenda;
import com.controlpaciente.consultorio.model.Cita;
import com.controlpaciente.consultorio.model.Paciente;
import com.controlpaciente.consultorio.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgendaServicio implements IAgenda{

    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public Agenda obtAgendaPorId(String idAgenda) {
        return agendaRepository.obtAgendaPorId(idAgenda);
    }

    @Override
    public List<Agenda> obtenertodosAgendas() {
        return agendaRepository.getAgendasdecitas();
    }

    @Override
    public void agregarAgenda(Agenda agenda) {
       agendaRepository.agregarAgenda(agenda);
    }

    @Override
    public Agenda actualizarAgenda(Agenda agenda, String idagenda) {
        agendaRepository.actualizarAgenda(agenda, idagenda);
        return agenda;
    }

    @Override
    public List<Cita> obtenertodasCitas(Agenda agenda) {
        return agendaRepository.listarCitas(agenda);
    }

    @Override
    public Cita actualizarCita(Agenda agenda, Cita cita, int idCita) {
         agendaRepository.actualizarCita(agenda,cita,idCita);
         return cita;
    }

    @Override
    public Cita obtenerCitaporID(Agenda agenda, int idCita) {
        return agendaRepository.obtCitaPorId(agenda,idCita);
    }

    @Override
    public void activarDesactivarCita(String idAgenda, int idCita,String accion) {
        if (accion == "a"){
            agendaRepository.confirmarCita(idAgenda, idCita);
        }else{
            agendaRepository.cancelarCita(idAgenda, idCita);
        }
    }

    @Override
    public void asiganarPaciente(String idAgenda, int idCita, Paciente paciente) {

    }


}
