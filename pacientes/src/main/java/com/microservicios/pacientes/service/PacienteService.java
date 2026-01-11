/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservicios.pacientes.service;

import com.microservicios.pacientes.model.Paciente;
import com.microservicios.pacientes.repository.IPacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class PacienteService implements IPacienteService{
    @Autowired
    private IPacienteRepository pacienteRepo;

    @Override
    public List<Paciente> listaPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public void crearPaciente(Paciente p_paciente) {
        pacienteRepo.save(p_paciente);
    }

    @Override
    public void eliminarPaciente(Long p_id_paciente) {
        pacienteRepo.deleteById(p_id_paciente);
    }

    @Override
    public Paciente buscarPaciente(Long p_id_paciente) {        
        Paciente pacBuscado = pacienteRepo.findById(p_id_paciente).orElse(null);
        return pacBuscado;
    }

    @Override
    public void modificarPaciente(Long p_id_paciente,Paciente p_paciente) {
        Paciente pacEditar = this.buscarPaciente(p_id_paciente);
        
        pacEditar.setNombre(p_paciente.getNombre());
        pacEditar.setApellido(p_paciente.getApellido());
        pacEditar.setFechaNac(p_paciente.getFechaNac());
        pacEditar.setTelefono(p_paciente.getTelefono());
        pacEditar.setDni(p_paciente.getDni());
        
        pacienteRepo.save(pacEditar);
    }

    @Override
    public Paciente buscarPaciente(String p_dni) {
        return pacienteRepo.buscarPaciente(p_dni);
    }
}
