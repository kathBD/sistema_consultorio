package com.controlpaciente.consultorio.model;

public class Paciente extends Usuario {

    /**
     * Atributos de clase
     */
   private int edad;
   private double peso;
   private double estatura;
   private  String sexo;
   private String fecha_ingreso;




    public Paciente(String id, String nombre, String apellido, String telefono, String fecha_ingreso, String sexo,int edad,double peso,double estatura ) {
        super(id, nombre, apellido, telefono);
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.sexo = sexo;
        this.fecha_ingreso = fecha_ingreso;

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }


    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "edad=" + edad +
                ", peso=" + peso +
                ", estatura=" + estatura +
                ", sexo='" + sexo + '\'' +
                ", fecha_ingreso='" + fecha_ingreso + '\'' +
                '}';
    }
}
