/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;


/**
 *
 * @author isabe
 */
public class Conversation extends Message implements Serializable{
    // Esto nos diria la fecha con hora y segundos (no se bien donde seria)
    // DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.SystemDefault());
   //Instant fecha =Instant.now();
   //System.out.printf("Hoy es: %s/n ,", dateFormatter.format(fecha));
    
    private String llmName;
    private ArrayList<Message> messages;
    


    public Conversation(String llmName,String sender, long epochSeconds, String content) {
        super(sender,epochSeconds, content);
        
        this.llmName = llmName;
        messages=new ArrayList<>();
        
    }
    
      public static Conversation getConversationFromDelimitedString(String delimitedString, String delimiter) {

        // Con split es posible separar por el delimitador
        String[] chunks = delimitedString.split(delimiter);

        if (chunks.length != 4) {
            // Esto proximamente será una excepción
            // Tomamos linea como inválida
            return null;
        }

        try {
            String llmName = chunks[0];
            String sender = chunks[1];
            long epochSeconds=chunks[2];
            String content = chunks[3];
            
          
            conversation p = new Conversation(llmName,sender,epochSeconds,content);
            return p;
        } catch (Exception e) {
            // Tomamos linea como inválida
            return null;
        }
    }

    public static String getHeaderTableStringForConversation() {
        return String.format("|%40s|%40s|%40l|%40s|", "llmName","sender", "epochSecons","content");
    }

    public String getAsRowString() {
        return String.format("|%40s|%40s|%40l|%40s|", this.llmName,this.sender, this.epochSeconds, this.content);
    }

    public String getInstanceAsDelimitedString(String delimiter) {
        // Cuidado con el Locale en el caso de numeros de coma flotante
        return String.format(Locale.ENGLISH, "%s" + delimiter + "%s" + delimiter + "%l" + delimiter + "%s" ,llmName, sender, epochSeconds,content );
    }

    public String getLlmName() {
        return llmName;
    }

    public void setLlmName(String llmName) {
        this.llmName = llmName;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }



    

    
    
    
    
}
