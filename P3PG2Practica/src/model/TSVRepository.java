/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author isabe
 */
public class TSVRepository implements IRepository {
    
    Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos.tsv");
    String delimitador = "\t";

    @Override
    public List<Conversation> importConversation() {
         ArrayList<Conversation> conversations = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(ruta);
            // leo todas la lineas del fichero con las rutas
            for (String linea : lineas) {
                // alumno con mayuscula porque viene de la clase es statico porque viene de la clase 
                // getPerson con la linea que lo ha importado lo splitea y lo va metiendo donde y hace un nuevo alumno
                //por eso definido en alumno esta este metodo creadopara crear el nuevo alumno 
                Conversation p = Conversation.getConversationFromDelimitedString(linea, delimitador);
                if (p != null) {
                    conversations.add(p);
                }
            }
            return conversations;
        } catch (IOException e) {
            // En otros ejemplos propagaremos una exception
            return null;
        }
    }

    @Override
    public void exportConversation(List<Conversation> conversations) {
       ArrayList<String> lineas = new ArrayList<>();
        for (Conversation conversation : conversations) {
            lineas.add(conversation.getInstanceAsDelimitedString(delimitador));
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            System.err.println("Ocurrió un error al intentar exportar las personas: " + e.getMessage());
            return false;
        }

    }
    }
    

   