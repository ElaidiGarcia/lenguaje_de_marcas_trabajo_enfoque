/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp.modelo;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author elaidigarciaalvarez
 */
public interface TareaRepository {
    //CRUD
    public void create(Tarea tarea) throws TareaExistenteException;
    public Tarea read(String titulo);
    public Collection<Tarea> readAll();
    public Tarea delete(String titulo);
    public void update(String titulo, String descripcion);
}
