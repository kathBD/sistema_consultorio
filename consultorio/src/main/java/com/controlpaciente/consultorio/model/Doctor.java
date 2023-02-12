package com.controlpaciente.consultorio.model;

public class Doctor extends Usuario {

    /**
     * Atributos de la clase doctor
     */

    private String especialidad;



    public Doctor(String id, String nombre, String apellido, String telefono, String especialidad) {
        super(id, nombre, apellido, telefono);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "especialidad='" + especialidad + '\'' +
                '}';
    }
}
