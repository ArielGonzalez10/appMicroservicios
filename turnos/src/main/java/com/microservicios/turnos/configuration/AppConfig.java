/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservicios.turnos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ariel
 */
@Configuration
/*
    Esta annotation permite realizar configuraciones personalizdas 
    y definir componentes principales de la apllicacion
*/
public class AppConfig {
    
    /*
        Esta annotation le indica al contenedor de spring que registrarRestTemplate
        es un metodo que devuelve un objeto y que lo debe manejar
    */
    @Bean("apiConsumir")
    public RestTemplate registrarRestTemplate(){
        /*
            La clase RestTemplate proporciona una serie de metodos para realizar
            solicitudes HTTP y manejar la serialización y deserialización de dato
            en diferentes formatos, como JSO y XML
            Se va a utilizar para comunicar los microservicios
        */
        return new RestTemplate();
    }
}
