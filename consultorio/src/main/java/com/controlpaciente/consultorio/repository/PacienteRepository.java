package com.controlpaciente.consultorio.repository;


import com.controlpaciente.consultorio.model.Paciente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class PacienteRepository {

    private List<Paciente> pacientes;

    public PacienteRepository(){
        //this.pacientes = new ArrayList<Paciente>();
        inicializarPaciente();
    }

    public List<Paciente> getPacientes(){
        return pacientes;
    }
    public Paciente obtPacientePorId(String id){
        return pacientes.stream()
                .filter(paciente ->paciente.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void agregarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }



    public void removerPaciente(String id) {
        Paciente paciente = obtPacientePorId(id);
        if (paciente == null){
            System.out.println("El paciente: "+ id + " no existe");
        }  else {
            pacientes.remove(paciente);
        }
    }

    public void actualizarPaciente(Paciente p, String id) {
        int index= pacientes.indexOf(obtPacientePorId(id));
        pacientes.set(index,p);
      }
    //String sexo,int edad,double peso,double estatura

    private void inicializarPaciente(){
        pacientes = new ArrayList<>(List.of(
                new Paciente("10", "Pedro", "Castillo", "31158777", "21-11-2020","masculino", 32, 78, 1.79 ),
                new Paciente("11", "Maria", "Toll", "320547774", "10-01-2021", "femenino", 50, 74, 1.60),
                new Paciente("12", "Tsuki", "Lina", "320146666", "02-02-2023", "femenino", 55, 60, 1.65),
                new Paciente("13", "Santiago", "Smith", "3568744411", "16-03-2020", "masculino", 36, 80, 1.81 )
        ));
}

}
