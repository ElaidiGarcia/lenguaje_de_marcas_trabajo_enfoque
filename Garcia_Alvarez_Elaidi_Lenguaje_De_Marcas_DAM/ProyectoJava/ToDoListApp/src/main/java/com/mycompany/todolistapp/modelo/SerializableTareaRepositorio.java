/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp.modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author elaidigarciaalvarez
 */
public class SerializableTareaRepositorio implements TareaRepository {

    @Override
    public void create(Tarea tarea) throws TareaExistenteException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tarea.bin"))) {
            oos.writeObject(tarea);
            System.out.println("Tarea guardada exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tarea read(String titulo) {
        return null;
    }

    @Override
    public Collection<Tarea> readAll() {
        ArrayList<Tarea> coleccion = new ArrayList<Tarea>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tarea.bin"))) {
            Tarea tarea = (Tarea) ois.readObject();
            System.out.println("Tarea recuperada:");
            System.out.println(tarea.titulo + "-" + tarea.descripcion);
            coleccion.add(tarea);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return coleccion;
    }

    @Override
    public Tarea delete(String titulo) {
        return null;
    }

    @Override
    public void update(String titulo, String descripcion) {
        
    }
    
}
