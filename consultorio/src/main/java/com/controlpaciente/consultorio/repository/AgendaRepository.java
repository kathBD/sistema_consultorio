package com.controlpaciente.consultorio.repository;

import com.controlpaciente.consultorio.model.Agenda;
import com.controlpaciente.consultorio.model.Cita;
import com.controlpaciente.consultorio.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AgendaRepository {

    private List<Agenda> agendasdecitas;

    public List<Agenda> getAgendasdecitas(){
        return agendasdecitas;
    }

    public AgendaRepository() {
        inicializarAgenda();
    }

    public Agenda obtAgendaPorId(String id){
        return agendasdecitas.stream()
                .filter(agenda ->id.equals(agenda.getId()))
                .findFirst()
                .orElse(null);
    }

    public void agregarAgenda(Agenda agenda){
        agendasdecitas.add(agenda);
    }

    public void actualizarAgenda(Agenda a, String id) {
        int index= agendasdecitas.indexOf(obtAgendaPorId(id));
        agendasdecitas.set(index,a);
    }

    public Cita obtCitaPorId(Agenda agenda, int idCita){
        return agenda.getCitas().stream()
                .filter(cita -> idCita == cita.getId())
                .findFirst()
                .orElse(null);
    }

    public void agregarCita(Agenda agenda, Cita cita) {
                agenda.getCitas().add(cita);
    }

    public List<Cita> listarCitas(Agenda agenda) {
        return agenda.getCitas();
    }

    public void actualizarCita(Agenda agenda, Cita cita,int idCita) {
        List<Cita> listaCita =agenda.getCitas();
        int index= listaCita.indexOf(obtCitaPorId(agenda,idCita));

        listaCita.set(index,cita);
        agenda.setCitas(listaCita);

        actualizarAgenda(agenda,agenda.getId());
    }
//String id, String dia, String fecha, LocalTime ini, LocalTime fin
    public void cancelarCita(String idAgenda, int idCita) {
        Agenda agenda = obtAgendaPorId(idAgenda);
        List<Cita> listaCita = agenda.getCitas();
        int index= listaCita.indexOf(obtCitaPorId(agenda,idCita));
        listaCita.get(index).setDisponible(true);
        agenda.setCitas(listaCita);
        actualizarAgenda(agenda,agenda.getId());
   }

    public void confirmarCita(String idAgenda, int idCita ) {
        Agenda agenda = obtAgendaPorId(idAgenda);
        List<Cita> listaCita = agenda.getCitas();
        int index= listaCita.indexOf(obtCitaPorId(agenda,idCita));
        listaCita.get(index).setDisponible(false);
        agenda.setCitas(listaCita);
        actualizarAgenda(agenda,agenda.getId());
    }
    public Paciente asignarPaciente(String idAgenda, int idCita, Paciente paciente ){
        Agenda agenda = obtAgendaPorId(idAgenda);
        List<Cita> listaCita = agenda.getCitas();
        int index= listaCita.indexOf(obtCitaPorId(agenda,idCita));
        listaCita.get(index).setPaciente(paciente);
        agenda.setCitas(listaCita);
        actualizarAgenda(agenda,agenda.getId());
        return paciente;
    }

    private void inicializarAgenda(){
        agendasdecitas = new ArrayList<>(List.of(
                new Agenda("25", "Lunes", "10-02-2023", LocalTime.of(8,00), LocalTime.of(11,30)),
                new Agenda("26","Lunes", "10-02-2023", LocalTime.of(1,00), LocalTime.of(5,30)),
                new Agenda("27", "Martes", "12-02-2023", LocalTime.of(8,00), LocalTime.of(11,30)),
                new Agenda("28", "Martes", "12-02-2023", LocalTime.of(1,00), LocalTime.of(3,30))
        ));

    }
}
