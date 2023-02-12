package com.controlpaciente.consultorio.servicio;

import com.controlpaciente.consultorio.model.Consulta;
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

    @Override
    public void agregarConsulta(Paciente paciente, Consulta consulta) {
        pacienteRepository.agregarConsulta(paciente, consulta);
    }

    @Override
    public List<Consulta> obtenertodasConsultas(Paciente paciente) {
        return pacienteRepository.listarConsultas(paciente);
    }

    @Override
    public Consulta actualizarConsulta(Paciente paciente, Consulta consulta, String idConsulta) {
        pacienteRepository.actualizarConsulta(paciente, consulta, idConsulta);
        return consulta;
    }

    @Override
    public Consulta obtenerConsultaporID(Paciente paciente, String idConsulta) {
        return pacienteRepository.obtPacienteConsultaPorId(paciente,idConsulta);
    }


}
