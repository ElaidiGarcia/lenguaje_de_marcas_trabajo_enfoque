/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp.modelo;

import java.io.Serializable;

/**
 *
 * @author elaidigarciaalvarez
 */
public class Tarea implements Serializable {
    public String titulo;
    public String descripcion;
    
    public Tarea (String titulo, String descripcion) {
        this.descripcion = descripcion;
        this.titulo = titulo;
    }
}

