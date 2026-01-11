/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.microservicios.pacientes.repository;

import com.microservicios.pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ariel
 */
@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long>{
    //Agregamos el metodo personalizado y agregamos la Query perosnalizada
    //Hicimos esto ya que PacienteRepository solo tiene los metodos por defecto para el CRUD
    @Query("SELECT p FROM Paciente p WHERE p.dni =:p_dni")
    Paciente buscarPaciente(String p_dni);
}
