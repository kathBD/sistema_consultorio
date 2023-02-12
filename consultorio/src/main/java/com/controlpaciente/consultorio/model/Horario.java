package com.controlpaciente.consultorio.model;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public  class Horario {


    private String id;
    private String fecha;
    private LocalTime inicio;
    private LocalTime finalizada;
    //private static  final int DURACION = 30;

    private  DayOfWeek dia;
    //private boolean disponibilidad;


    public Horario() {
    }

    public Horario(DayOfWeek dia, String fecha, LocalTime inicio, LocalTime finalizada ) {
        this.dia = dia;
        this.fecha = fecha;
        this.inicio = inicio;
        this.finalizada = finalizada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(LocalTime finalizada) {
        this.finalizada = finalizada;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }
}
