package com.controlpaciente.consultorio.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public  class Horario {


    private String id;
    private String fecha;
    private LocalTime inicio;
    private LocalTime finalizada;
    //private static  final int DURACION = 30;

    private  String dia;
    //private boolean disponibilidad;


    public Horario() {
    }

    public Horario(String fecha, LocalTime inicio, LocalTime finalizada ) {
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }





}
