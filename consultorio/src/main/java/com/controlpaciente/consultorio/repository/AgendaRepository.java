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

    @Autowired
    private PacienteRepository pacienteRepository;
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
        int index  = agendasdecitas.indexOf(agenda);
        agendasdecitas.get(index).generarCitasDisponibles();
    }

    public void actualizarAgenda(Agenda agenda, String id) {
        int index  = agendasdecitas.indexOf(obtAgendaPorId(id));
        agendasdecitas.set(index,agenda);
        agendasdecitas.get(index).generarCitasDisponibles();
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
        listaCita.get(index).setPaciente(null);
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
       Paciente p = pacienteRepository.obtPacientePorId(paciente.getId());
       if (p == null){
           System.out.println("nada" );
           return null;
       }else{
        Agenda agenda = obtAgendaPorId(idAgenda);
        List<Cita> listaCita = agenda.getCitas();
        int index= listaCita.indexOf(obtCitaPorId(agenda,idCita));
           System.out.println(index);
        listaCita.get(index).setPaciente(paciente);
        listaCita.get(index).setDisponible(false);
        agenda.setCitas(listaCita);
        int ind = agendasdecitas.indexOf(agenda);
        agendasdecitas.set(ind,agenda);
        return paciente;}
    }

    private void inicializarAgenda(){
        agendasdecitas = new ArrayList<>(List.of(
                new Agenda("25", "Lunes", "2023-02-02", LocalTime.of(8,00), LocalTime.of(11,30)),
                new Agenda("26","Lunes", "2023-02-01", LocalTime.of(1,00), LocalTime.of(5,30)),
                new Agenda("27", "Martes", "2023-02-18", LocalTime.of(8,00), LocalTime.of(11,30)),
                new Agenda("28", "Martes", "2023-02-18", LocalTime.of(1,00), LocalTime.of(3,30))
        ));

    }
}
