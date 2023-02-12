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
        LocalTime inicio = this.getIni();
        LocalTime fin = this.getFin();
        LocalTime nuevaHorario = inicio.plusMinutes(30);
        int i =0;
        while (inicio.isBefore(fin)){
            if (nuevaHorario.isBefore(fin)) {
                citas.add(new Cita( i++,new Horario(this.getFecha(), inicio, nuevaHorario),true));
                inicio = nuevaHorario;
            }else {
                break;
            }
        }
    }
}


