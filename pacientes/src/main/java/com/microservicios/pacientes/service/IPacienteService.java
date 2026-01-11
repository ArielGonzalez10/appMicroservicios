/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.microservicios.pacientes.service;

import com.microservicios.pacientes.model.Paciente;
import java.util.List;


/**
 *
 * @author ariel
 */
public interface IPacienteService {
   public List<Paciente> listaPacientes();
   public void crearPaciente(Paciente p_paciente);
   public void eliminarPaciente(Long p_id_paciente);
   public Paciente buscarPaciente(Long p_id_paciente);
   public void modificarPaciente(Long p_id_paciente,Paciente p_paciente);
   //Agregamos el metodo que necesitamos personalizar para consumir los datos del paciente
   public Paciente buscarPaciente(String p_dni);
}
