/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.microservicios.turnos.service;

import com.microservicios.turnos.model.Turno;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ariel
 */

public interface ITurnoService {
    public List<Turno>listaTurnos();
    public void crearTurno(LocalDate p_fecha,String p_tratamiento,String p_dni_paciente);
    public void eliminarTurno(Long p_id_turno);
    public Turno buscarTurno(Long p_id_turno);
    public void modificarTurno(Long p_id_turno,Turno p_turno);
    
    
}
