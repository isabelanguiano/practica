/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p3pg2practica;

import controller.Controller;
import model.FakeILLM;
import model.ILLM;
import model.IRepository;
import model.Model;
import model.TSVRepository;
import view.AppView;
import view.SimpleConsoleView;

/**
 *
 * @author isabe
 */
public class P3PG2Practica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        if(args.length!=3){
            System.err.println("Error. Parámetros incorrectos");
            } else{
            ILLM illm=null;
            
            if(args[1].equals("fake")){
                illm= new FakeILLM();
                        
            } else if(args[1].equals("random")){
                
            }
            
            IRepository repository=null;
            if(args[0].equals("xml")){
                repository= new TSVRepository();
            }
            
            Model m = new Model(repository,illm);
            
            AppView v= null;
            if(args[2].equals("consola")){
                v= new SimpleConsoleView();
            } 
            
            Controller c=new Controller(m,v);
            
            v.setController(c);
            
            v.showAplicationStart("Bienvenido al programa");
            
            
        }
    }
    
}
