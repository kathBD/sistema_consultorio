package com.controlpaciente.consultorio.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Horario {

   private String fecha;
    private LocalTime inicio;
    private LocalTime finalizada;
    private static  final int DURACION = 30;
    private boolean disponibilidad;


    public Horario() {
    }

    public Horario(String fecha, LocalTime inicio, LocalTime finalizada, boolean disponibilidad) {
        this.fecha = fecha;
        this.inicio = inicio;
        this.finalizada = finalizada;
        this.disponibilidad = disponibilidad;
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


    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public abstract  void modificarDisponibilidad();



}
