/*
 * Main.java
 *
 * Created on 21 de mayo de 2009, 11:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nuevoservidor;

/**
 *
 * @author Erik
 */
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Main {
    Ventana ventana;
    /** Creates a new instance of Main */
    public Main(int puerto) throws IOException {
        ServerSocket servidor = new ServerSocket(puerto);
        
        ventana = new Ventana();
        ventana.setVisible(true);
       // ventana.jLabel3.setText(servidor.g);
       
        while(true){
            Socket cliente = servidor.accept();
            System.out.println("Recibido de: "+cliente.getInetAddress());
            ventana.agregarElementoLista(cliente.getInetAddress().toString());
             
            ManejadorServidor manser = new ManejadorServidor(cliente);
            manser.start();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Main(12345);
        
    }
    
}
