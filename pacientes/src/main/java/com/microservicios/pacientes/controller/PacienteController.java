/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservicios.pacientes.controller;

import com.microservicios.pacientes.model.Paciente;
import com.microservicios.pacientes.service.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ariel
 */
@RestController
@RequestMapping("/pacientes")//Permite generalizar el inicio de la ruta de los endpoints
public class PacienteController {
    @Autowired
    private IPacienteService pacienteServ;
    
    @GetMapping("/listar")
    @ResponseBody
    public List<Paciente> listarPacientes(){
        return pacienteServ.listaPacientes();
    }
    
    @PostMapping("/crear")    
    public void crearPaciente(@RequestBody Paciente p_paciente){
        pacienteServ.crearPaciente(p_paciente);
        System.out.println("Paciente dado de alta correctamente");
    }
    
    @PutMapping("/modificar/{p_id_paciente}")
    public void modificarPaciente(@PathVariable Long p_id_paciente,@RequestBody Paciente p_paciente){
        pacienteServ.modificarPaciente(p_id_paciente,p_paciente);
        System.out.println("Paciente modificado oorrectamente");
    }
    
    @DeleteMapping("/eliminar/{p_id_paciente}")
    public void eliminarPaciente(@PathVariable Long p_id_paciente){
        pacienteServ.eliminarPaciente(p_id_paciente);
        System.out.println("Paciente eliminado correctamente");
    }
    
    @GetMapping("/buscar/{p_id_paciente}")
    public Paciente buscarPaciente(@PathVariable Long p_id_paciente){
        return pacienteServ.buscarPaciente(p_id_paciente);
    }
}
