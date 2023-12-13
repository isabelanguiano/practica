/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;

/**
 *
 * @author isabe
 */
public abstract class AppView {

    
        protected Controller c;

    public abstract void showAplicationStart (String initInfo);
    
    public abstract void mostrarMenuPrincipal();
    
    public abstract void mostrarFinPrograma(String initFin);

    public void setController(Controller c) {
        this.c = c;
    }

}
