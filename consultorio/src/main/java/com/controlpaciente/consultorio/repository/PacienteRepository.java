package com.controlpaciente.consultorio.repository;


import com.controlpaciente.consultorio.model.Consulta;
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
                .filter(paciente ->id.equals(paciente.getId()))
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

    public Consulta obtPacienteConsultaPorId(Paciente paciente,String idConsulta){
        return paciente.getHistoria().stream()
                .filter(consulta ->idConsulta.equals(consulta.getId()))
                .findFirst()
                .orElse(null);
    }

    public void agregarConsulta(Paciente paciente, Consulta consulta) {
        paciente.getHistoria().add(consulta);
    }

    public void actualizarConsulta(Paciente paciente, Consulta consulta,String idConsulta) {
        List<Consulta> listaConsultas =paciente.getHistoria();
        int index= listaConsultas.indexOf(obtPacienteConsultaPorId(paciente,idConsulta));

        listaConsultas.set(index,consulta);
        paciente.setHistoria(listaConsultas);

        actualizarPaciente(paciente,paciente.getId());

    }

    public List<Consulta> listarConsultas(Paciente paciente) {
        return paciente.getHistoria();

    }

    private void inicializarPaciente(){
        pacientes = new ArrayList<>(List.of(
                new Paciente("10", "Pedro", "Castillo", "31158777", "21-11-2020","masculino", 32, 78, 1.79 ),
                new Paciente("11", "Maria", "Toll", "320547774", "10-01-2021", "femenino", 50, 74, 1.60),
                new Paciente("12", "Tsuki", "Lina", "320146666", "02-02-2023", "femenino", 55, 60, 1.65),
                new Paciente("13", "Santiago", "Smith", "3568744411", "16-03-2020", "masculino", 36, 80, 1.81 )
        ));

        Consulta consulta1= new Consulta("01","01","18-11-2020","11-02.2023","Control cronico","cero estres y caobohidratos","diabetes tipo 2");
        Consulta consulta2= new Consulta("02","05","15-05-2019","01-02.2023","dolor estomacal","esomeprazol","gastritis")    ;
        pacientes.stream().forEach(p->p.getHistoria().add(consulta1));
        pacientes.stream().forEach(p->p.getHistoria().add(consulta2));

}

}
