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
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ariel
 */
@Service
public class TurnoService implements ITurnoService{
    
    @Autowired
    private ITurnoRepository turnoRepo;
    
    //Se inyecta el restTemplate y debe hacer referencia al bean, por lo tanto debe tener el mismo nombre que el bean
    @Autowired
    private RestTemplate apiConsumir;

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
    public void crearTurno(LocalDate p_fecha, String p_tratamiento, String p_dni_paciente) {
        
            //Paso 1: Buscar el paciente en la api de pacientes
            //Paso 2: Setear los datos del paciente en un objeto
            //Paso 3: Setear los datos del nuevo turno
            Turno nuevoTurno = new Turno();
            nuevoTurno.setFecha(p_fecha);
            nuevoTurno.setTratamiento(p_tratamiento);
            //nuevoTurno.setNombreCompletoPaciente(p_dni_paciente);
            turnoRepo.save(nuevoTurno);
    }
}
