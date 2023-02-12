package com.controlpaciente.consultorio.model;

import javax.sound.sampled.FloatControl;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Agenda {

    private String id;
    private String dia;

    private String fecha;
    private LocalTime ini;
    private LocalTime fin;
    private List<Cita> citas;


    public Agenda() {

    }

    public Agenda(String id, String dia, String fecha, LocalTime ini, LocalTime fin) {
        this.id = id;
        this.dia = dia;
        this.fecha = fecha;
        this.ini = ini;
        this.fin = fin;
        this.citas = new ArrayList<Cita>();
        this.generarCitasDisponibles();


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public LocalTime getIni() {
        return ini;
    }

    public void setIni(LocalTime ini) {
        this.ini = ini;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public void generarCitasDisponibles() {

        LocalTime i = this.getIni();
        LocalTime f = this.getFin();
        LocalTime nuevaHorario = i.plusMinutes(30);
        int j =0;
        while (i.isBefore(fin)){
            if (nuevaHorario.isBefore(fin)) {
                Cita c = new Cita( j++, new Horario(this.getFecha(), i, nuevaHorario),true);
                this.citas.add(c);
                i = nuevaHorario;
            }else {
                break;
            }
        }
    }
}


