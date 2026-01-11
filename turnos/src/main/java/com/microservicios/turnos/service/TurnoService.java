/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservicios.turnos.service;

import com.microservicios.turnos.model.Turno;
import com.microservicios.turnos.repository.ITurnoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ariel
 */
@Service
public class TurnoService implements ITurnoService{
    
    @Autowired
    private ITurnoRepository turnoRepo;

    @Override
    public List<Turno> listaTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public void eliminarTurno(Long p_id_turno) {
        turnoRepo.deleteById(p_id_turno);
    }

    @Override
    public Turno buscarTurno(Long p_id_turno) {
        return turnoRepo.findById(p_id_turno).orElse(null);
    }

    @Override
    public void modificarTurno(Long p_id_turno, Turno p_turno) {
        Turno turnoBusc = this.buscarTurno(p_id_turno);
        
        turnoBusc.setFecha(p_turno.getFecha());
        turnoBusc.setNombreCompletoPaciente(p_turno.getNombreCompletoPaciente());
        turnoBusc.setTratamiento(p_turno.getTratamiento());
        turnoRepo.save(turnoBusc);
    }

    @Override
    public void crearTurno(LocalDate p_fecha, String tratamiento, String p_dni_paciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
