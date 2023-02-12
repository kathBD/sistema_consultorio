package com.controlpaciente.consultorio.model;

public abstract class Usuario {

    /****
     * Atributos de la clase abstracta persona
     */

    private String id;
    private String nombre;
    private String apellido;
    private String telefono;


    /**
     *contructor
     */

    public Usuario() {
    }

    public Usuario(String id, String nombre, String apellido, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    /***
     * Setter y getters de la clase
     *
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
