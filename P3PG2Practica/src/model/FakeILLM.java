/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 *
 * @author isabe
 */
public class FakeILLM implements ILLM{
    //private ArrayList<String> frases:
    private HashMap<String, ArrayList<String>> frases;
    private Random rand;
    
    public FakeILLM(){
        /*frases=new ArrayList<>();
        
        frases.add("Hola buenos dias");
        frases.add("¿que tal estas hoy?);*/
        
        rand = new Random();
        
        frases=new HashMap<>();
        
     
        
        ArrayList<String> refranes = new ArrayList<>();
        refranes.add("No por muchho madrugar amanece mas temprano");
        
        frases.put("refranes",refranes);
        

    }
    
    @Override
    public String speak(String input){
        String frase="";
        
        if(input.contains("refrán")){
            ArrayList<String> refranes = frases.get("refranes");
            int numRefran=rand.nextInt(refranes.size());
            frase=refranes.get(numRefran);
            
        }
        return frase;
        // esto es para coger un refran aleatorio en caso contrario que coja una clase cualquiera
        
    }
    
    // hay que añadir los metodos que hay en ILLM
    @Override
    public String getIdentifier(){
        return "FakeLLM";
        // esto de FakeILLM nos da lo que tiene qie dar el identificador
    }
   
    
}
