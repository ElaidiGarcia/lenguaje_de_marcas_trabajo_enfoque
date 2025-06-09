/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author elaidigarciaalvarez
 */
public class InMemoryTareaRepository implements TareaRepository {
    private ArrayList<Tarea> tareas;
    
    public InMemoryTareaRepository() {
        tareas = new ArrayList<>();
    }

    @Override
    public void create(Tarea tarea) throws TareaExistenteException {
        Tarea tareaBuscada = this.read(tarea.titulo);
        
        if (tareaBuscada == null) {
            tareas.add(tarea);
        } else {
            throw new TareaExistenteException("Esta tarea ya existe, no puedes volverla a meter en la lista");
        }
    }

    @Override
    public Tarea read(String titulo) {
        for(Tarea tarea: tareas) {
            if (tarea.titulo.equals(titulo)) {
                return tarea;
            }
        }
        
        return null;
    }

    @Override
    public Collection<Tarea> readAll() {
        return tareas;
    }

    @Override
    public Tarea delete(String titulo) {
        return null;
    }

    @Override
    public void update(String titulo, String descripcion) {
        
    }
    
}
