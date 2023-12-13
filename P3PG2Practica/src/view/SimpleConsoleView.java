/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import static com.coti.tools.Esdia.readInt;

/**
 *
 * @author isabe
 */
public class SimpleConsoleView extends AppView{
    

    @Override
    public void showAplicationStart(String initInfo) {
        System.out.println(initInfo);// cuando me quiera leer el contenido en vez de println seria leyendo 
    }

    @Override
    public void mostrarMenuPrincipal() {
         int opcion;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Menu CRUD");
            System.out.println("2. Exportar/importar");
            System.out.println("3. Nueva conversación");
            System.out.println("4. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    subMenuCRUD();
                    break;
                case 2:
                    subMenuImportacionExportacion();
                    break;
                case 3:
                    nuevaConversacion();
                    break;
                case 4:
                    System.out.println("Estoy saliendo");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
    
        @Override
    public void mostrarFinPrograma(String initFin) {
         System.out.println(initFin);
    }



    private void subMenuCRUD() {
        int opcion;
        do {
            System.out.println("\n--- SUBMENU CRUD ---");
            System.out.println("1. Listar conversaciones");
            System.out.println("2. Eliminar conversaciones");
            System.out.println("3. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    listarConversacion();
                    break;
                case 2:
                    eliminarConversacion();
                    break;
                case 3:
                    System.out.println("Estoy saliendo al Menu Pincipal");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    private void subMenuImportacionExportacion() {
        int opcion;
        do {
            System.out.println("\n--- SUBMENU IMPORTACIÓN EXPORTACIÓN ---");
            System.out.println("1. Exportar conversación");
            System.out.println("2. Importar conversación");
            System.out.println("3. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    exportarConversacion();
                    break;
                case 2:
                    importarConversacion();
                    break;
                case 3:
                    System.out.println("Sliendo al Menú Principal");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }


    private void nuevaConversacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void listarConversacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void eliminarConversacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void exportarConversation() {
        if(c.exportarConversation){
             System.out.println("Exportación realizada con exito");
        }else{

            System.out.println("Hubo un error en la exportación");
            }
 
         }

    private void importarConversation() {
        if(c.importarConversation()){
             System.out.println("Exportación realizada con exito");
        }else{

          
            System.out.println("Hubo un error en la importación");
        }  
    }
    
    
    }

  
    
    

