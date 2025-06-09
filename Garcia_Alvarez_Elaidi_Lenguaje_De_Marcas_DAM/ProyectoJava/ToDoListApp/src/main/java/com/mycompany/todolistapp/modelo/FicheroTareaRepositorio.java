/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todolistapp.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elaidigarciaalvarez
 */
public class FicheroTareaRepositorio implements TareaRepository {
    private String nombreFichero = "tareas.txt";

    @Override
    public void create(Tarea tarea) throws TareaExistenteException {
        Tarea tareaLeida = read(tarea.titulo);
        
        if (tareaLeida == null) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero, true))) {
                pw.println(tarea.titulo + "-" + tarea.descripcion);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new TareaExistenteException("Esta tarea ya existe tronco");
        }
        
    }

    @Override
    public Tarea read(String titulo) {
        FileReader fr = null;
        BufferedReader br = null;
        Tarea tarea = null;
        try {
            //Abrimos el fichero
            File archivo = new File(nombreFichero);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            //Vamos leyendo línea a línea
            String linea;
            //Para cada línea, si es distinto de null, es que hay contenido.
            //por lo tanto, puedo leer lo que tiene esa línea.
            //Si me da null, es que no hay nada más que leer del fichero.
            while((linea = br.readLine()) != null) {
                //me fijo si la línea que acabo de leer contiene mi título
                if (linea.contains(titulo)) {
                    //parto la línea por -, para obtener el título y descripcion por separado
                    String[] partes = linea.split("-");
                    //creo la tarea y me la guardo en la variable tarea para devolverla.
                    tarea = new Tarea(partes[0], partes[1]);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheroTareaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheroTareaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(FicheroTareaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return tarea;
    }

    @Override
    public Collection<Tarea> readAll() {
        ArrayList<Tarea> tareas = new ArrayList<Tarea>();
        FileReader fr = null;
        BufferedReader br = null;
        Tarea tarea = null;
        try {
            //Abrimos el fichero
            File archivo = new File(nombreFichero);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            //Vamos leyendo línea a línea
            String linea;
            //Para cada línea, si es distinto de null, es que hay contenido.
            //por lo tanto, puedo leer lo que tiene esa línea.
            //Si me da null, es que no hay nada más que leer del fichero.
            while((linea = br.readLine()) != null) {
                //parto la línea por -, para obtener el título y descripcion por separado
                String[] partes = linea.split("-");
                //creo la tarea y me la guardo en la variable tarea para devolverla.
                tarea = new Tarea(partes[0], partes[1]);
                tareas.add(tarea);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheroTareaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicheroTareaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(FicheroTareaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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
