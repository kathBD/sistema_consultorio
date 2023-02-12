package com.controlpaciente.consultorio.servicio;

import com.controlpaciente.consultorio.model.Paciente;
import com.controlpaciente.consultorio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteServicio implements IPaciente{

   @Autowired
    private PacienteRepository pacienteRepository;


    @Override
    public Paciente obtPacientePorId(String idPaciente) {
        return pacienteRepository.obtPacientePorId(idPaciente);
    }

    @Override
    public List<Paciente> obtenertodosPacientes() {
        return pacienteRepository.getPacientes();
    }

    @Override
    public void agregarPaciente(Paciente paciente) {
        pacienteRepository.agregarPaciente(paciente);
    }

    @Override
    public void eliminarPaciente(String idPaciente) {
        pacienteRepository.removerPaciente(idPaciente);
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente, String id) {
        pacienteRepository.actualizarPaciente(paciente,id);
        return paciente;
    }


}
