/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservicios.turnos.controller;

import com.microservicios.turnos.model.Turno;
import com.microservicios.turnos.service.ITurnoService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ariel
 */
@RequestMapping("/turnos")
@RestController
public class TurnoController {
    @Autowired
    private ITurnoService turnoServ;
    
    @PostMapping("/crear")
    public void crearTurno(@RequestBody LocalDate p_fecha,@RequestBody String p_tratamiento,@RequestBody String p_dni_paciente){
        turnoServ.crearTurno(p_fecha, p_tratamiento, p_dni_paciente);
        System.out.println("Turno creado Correctamente");
    }
    
    @DeleteMapping("/eliminar")
    public void eliminarTurno(@RequestParam Long p_id_turno){
        turnoServ.eliminarTurno(p_id_turno);
    }
    
    @GetMapping("/listar")
    public List<Turno> listaTurnos(){
        return turnoServ.listaTurnos();
    }
    
    @GetMapping("/buscar/{p_id_turno}")
    public Turno buscarTurno(@PathVariable Long p_id_turno){
        return turnoServ.buscarTurno(p_id_turno);
    }
    
    @PutMapping("/modificarTurno/{p_id_turno}")
    public void modificarTurno(@PathVariable Long p_id_turno,@RequestBody Turno p_turno){
        turnoServ.modificarTurno(p_id_turno, p_turno);
        System.out.println("Modificar Turno");
    }
    
}
