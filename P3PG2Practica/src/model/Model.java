/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;

/**
 *
 * @author isabe
 */
public class Model {
    private ILLM llm;
    private ArrayList<Conversation> conversation;
    private IRepository repository;
    File ficheroEstadoSerializado;
    
    
    public Model(IRepository repository, ILLM llm){
        this.repository=repository; 
        ficheroEstadoSerializado = Paths.get(System.getProperty("user.home"), "Desktop", "model.bin").toFile();
        this.llm=llm;
      // NO SE   this.conversation=new Conversation(this.llm.getIdentifier());
        // Si tenemos que crear una nueva conversacion
        // esto era para crear una conversacion no una lista de conversaciones conversation= new Conversation(llm.getIdentifier());
        
        // leer un archibo binarioo con la ultima conversacion y si no existe crearla nueva (si no se puede leer del archivo binario
        
        
    }
    
    // Hay que hacer un metodo que guarde la conversacion en un archivo binario.
    
    // si en el menu quiero hacer un exportar
    public void exportar(){
        repository.exportConversation(conversation);
    }
    
    public String conversar(String input){
        // guardar las conversaciones input
        
        // aqui tenemos que generar un tipo mensanje
        Message messsageEntrada= new Message("usuario", Instant.now().getEpochSecond(), input);
        // guardar el mensaje de entrada es llamar al metodo de conversation que me ayude a guardar un mensaje
        
        String respuesta=llm.speak(input);
        
        // guardar respuesta
        Message messsageSalida= new Message("llm", Instant.now().getEpochSecond(), respuesta);
        // guardar el mensaje de salida es llamando almetodo de conversation que me ayude a guardar un mensaje
        
        
        return respuesta;
    }
    
    public boolean cargarEstadoAplicación() {
        // esto mas para practica final

        if (ficheroEstadoSerializado.exists() && ficheroEstadoSerializado.isFile()) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroEstadoSerializado));
                this.conversation = (ArrayList<Conversation>) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                // Dejamos el error para la depuración, por el canal err.
                System.err.println("Error durante la deserialización: " + ex.getMessage());
                return false;
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException ex) {
                        // Dejamos el error para la depuración, por el canal err.
                        System.err.println("Error durante la deserialización: " + ex.getMessage());
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }

    }
    
    public boolean guardarEstadoAplicación() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(ficheroEstadoSerializado));
            oos.writeObject(conversation);
            return true;
        } catch (IOException ex) {
            // Dejamos el error para la depuración, por el canal err.
            System.err.println("Error durante la serialización: " + ex.getMessage());
            return false;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    // Dejamos el error para la depuración, por el canal err.
                    System.err.println("Error al cerrar el flujo: " + ex.getMessage());
                    return false;
                }
            }
        }

    }

    public void nuevaConversacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    public void listarConversacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    public boolean importarConversation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean exportarConversation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminarConversacion(String messages) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
