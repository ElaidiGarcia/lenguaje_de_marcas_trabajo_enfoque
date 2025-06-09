/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp.controlador;

import com.mycompany.todolistapp.modelo.TareaRepository;
import com.mycompany.todolistapp.vista.CrearTareaFrame;
import com.mycompany.todolistapp.vista.ToDoListFrame;

/**
 *
 * @author elaidigarciaalvarez
 */
public class ToDoListController {
    private ToDoListFrame toDoListFrame;
    private TareaRepository repository;
    
    public ToDoListController(ToDoListFrame toDoListFrame, TareaRepository repository) {
        this.toDoListFrame = toDoListFrame;
        this.repository = repository;
    }
    
    public void navegarACrearTareaVista() {
        toDoListFrame.setVisible(false);
        CrearTareaFrame crearTareaFrame = new CrearTareaFrame();
        crearTareaFrame.setProperties(toDoListFrame, repository);
        crearTareaFrame.setVisible(true);
    }
}
