/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Model;
import view.AppView;
import model.Conversation;

/**
 *
 * @author isabe
 */
public class Controller {
    
    private Model m;
    private AppView v;

    public Controller(Model m, AppView v) {
        this.m = m;
        this.v = v;
        v.setController(this);
    }
    
     public void initApplication(){
        
        // Carga inicial programa
        // si no sireslizas quitas el model.cargarEstado quedaria
        // view.mostrarInicio("Cargado estado anterior con exito");
        //  view.mostrarMenuPrincipal();;
        // view.mostrarFinPrograma
        if(m.cargarEstadoAplicación()){
            v.showAplicationStart("Cargado estado anterior con exito");
        }else{
            v.showAplicationStart("No se encontró fichero para carga del programa");
        }
        
        // Menú principal
        v.mostrarMenuPrincipal();
        
        
        // Guardado final del programa
        if(m.guardarEstadoAplicación()){
            v.mostrarFinPrograma("Guardado el estado de la aplicación.\nSaliendo...");
        }else{
            v.mostrarFinPrograma("No se pudo guardar el estado de la aplicación.\nSaliendo...");
        }
        
    }
     

     private void nuevaConversacion(){
         m.nuevaConversacion();
     }
     
      private void listarConversacion() {
          m.listarConversacion();
      }
      
      private void eliminarConversacion(String messages){
          m.eliminarConversacion(messages);
      }
     
      private boolean exportarConversation(){
         return m.exportarConversation();
      }
      
      private boolean importarConversation(){
         return m.importarConversation();
      }
      
     
     
    
}
