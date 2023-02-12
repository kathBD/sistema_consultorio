package com.controlpaciente.consultorio.model;

public class Consulta {

    private String id;
    private String numeroConsultas;
    private String fechaRegistro;
    private String fechaModificacion;
    private String motivoDeConsulta;
   private  String tramiento;
   private String diagnostico;


    public Consulta() {
    }

    public Consulta(String id, String numeroConsultas, String fechaRegistro, String fechaModificacion, String motivoDeConsulta, String tramiento, String diagnostico) {
        this.id = id;
        this.numeroConsultas = numeroConsultas;
        this.fechaRegistro = fechaRegistro;
        this.fechaModificacion = fechaModificacion;
        this.motivoDeConsulta = motivoDeConsulta;
        this.tramiento = tramiento;
        this.diagnostico = diagnostico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroConsultas() {
        return numeroConsultas;
    }

    public void setNumeroConsultas(String numeroConsultas) {
        this.numeroConsultas = numeroConsultas;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getMotivoDeConsulta() {
        return motivoDeConsulta;
    }

    public void setMotivoDeConsulta(String motivoDeConsulta) {
        this.motivoDeConsulta = motivoDeConsulta;
    }

    public String getTramiento() {
        return tramiento;
    }

    public void setTramiento(String tramiento) {
        this.tramiento = tramiento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
