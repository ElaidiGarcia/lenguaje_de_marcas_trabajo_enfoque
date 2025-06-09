/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp.controlador;

import com.mycompany.todolistapp.modelo.Tarea;
import com.mycompany.todolistapp.modelo.TareaExistenteException;
import com.mycompany.todolistapp.modelo.TareaRepository;
import com.mycompany.todolistapp.vista.CrearTareaFrame;
import com.mycompany.todolistapp.vista.ToDoListFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author elaidigarciaalvarez
 */
public class CrearTareaController {
    private CrearTareaFrame crearTareaFrame;
    private ToDoListFrame toDoListFrame;
    private TareaRepository repository;
    
    public CrearTareaController(
            CrearTareaFrame crearTareaFrame
    ) {
        this.crearTareaFrame = crearTareaFrame;
    }
    
    public void setProperties(ToDoListFrame toDoListFrame, TareaRepository repository) {
        this.toDoListFrame = toDoListFrame;
        this.repository = repository;
    }
    
    public void navegaHaciaAtras() {
       crearTareaFrame.setVisible(false);
       toDoListFrame.setVisible(true);
    }
    
    public void crearTarea(String titulo, String descripcion){
        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(
                    crearTareaFrame, 
                    "El titulo de la tarea no puede estar vacio",
                    "ERROR",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(
                    crearTareaFrame, 
                    "La descripción de la tarea no puede estar vacia",
                    "ERROR",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        Tarea tarea = new Tarea(titulo, descripcion);
        
        try {
            repository.create(tarea);
            toDoListFrame.recargaTareas();
        } catch(TareaExistenteException exception) {
            
            JOptionPane.showMessageDialog(
                    crearTareaFrame, 
                    "La tarea ya existía previamente. No puedes duplicarla",
                    "ERROR",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        
        JOptionPane.showMessageDialog(
                    crearTareaFrame, 
                    "La tarea se creó correctamente",
                    "ÉXITO",
                    JOptionPane.INFORMATION_MESSAGE
        );
        
        navegaHaciaAtras();
    }
}
