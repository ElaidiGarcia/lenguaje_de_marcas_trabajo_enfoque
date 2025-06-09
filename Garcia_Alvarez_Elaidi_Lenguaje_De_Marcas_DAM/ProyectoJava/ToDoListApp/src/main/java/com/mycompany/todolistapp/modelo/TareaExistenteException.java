/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp.modelo;

/**
 *
 * @author elaidigarciaalvarez
 */
public class TareaExistenteException extends Exception {
    private String mensaje;
    
    public TareaExistenteException(String mensaje) {
        this.mensaje = mensaje;
    }
}
