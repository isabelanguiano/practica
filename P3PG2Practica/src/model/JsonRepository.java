/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import model.Conversation;

/**
 *
 * @author isabe
 */
public class JsonRepository implements IRepository{

    @Override
    public List<Conversation> importConversation() {
            if (f2.isFile() && f2.exists()) {
            List<Conversation> conversationImportadas = importarListaDeConversationsDeJSON(f2);
            if (conversationImportadas != null) {
                System.out.println("Conversaciones importadas:" + conversationImportadas.size());
                for (Conversation conversationImportada : conversationImportadas) {
                    System.out.println(conversationImportada.getAsRowString()());
                }
            } else {
                System.out.println("Error en la importación");
            }
        }
    }

    @Override
    public void exportConversation(List<Conversation> conversations) {
        ArrayList<Conversation> conversations = new ArrayList<>();
        conversations.add(new Conversation("Isabel"));
        conversations.add(new Conversation("Hola"));
        conversations.add(new Conversation("Ramón"));

        Path ruta2 = Paths.get(System.getProperty("user.home"), "Desktop", "conversations.json");
        File f2 = ruta2.toFile();

        if (!exportarListaDeConversationsAJSON(conversations, f2)) {
            System.out.println("Hubo un problema con la exportación");
        }else{
            System.out.println("Vea el resultado en:"+f2.getAbsolutePath());
        }
    }
    
        public static boolean exportarListaDeConversationsAJSON(List<Conversation> conversations, File f) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(conversations);
            Files.write(f.toPath(), json.getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (IOException ex) {
            // TODO veremos como cambiar esto cuando tratemos excepciones
            // de momento retornaremos null si hay algún problema
            System.err.println("Error:" + ex.getMessage());
            return false;
        }
    }
    
}
