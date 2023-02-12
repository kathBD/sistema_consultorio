package com.controlpaciente.consultorio.model;

public class Cita {
     private int id;
     private Horario horario;
     private Paciente paciente;
     private boolean disponible;


    public Cita() {
    }

    public Cita(int id, Horario horario, boolean disponible) {
        this.id = id;
        this.horario = horario;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
