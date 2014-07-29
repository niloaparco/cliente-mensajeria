/*
 * ManejadorServidor.java
 *
 * Created on 21 de mayo de 2009, 11:36 PM
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

public class ManejadorServidor extends Thread {
    
    Socket conexion;
    DataInputStream entrada;
    DataOutputStream salida;
    static Vector manejador = new  Vector();
    Ventana venta = new Ventana();
    int contador=-1;
    
    /** Creates a new instance of ManejadorServidor */
    public ManejadorServidor(Socket conexion) throws IOException {
        this.conexion = conexion;
        entrada = new DataInputStream(new BufferedInputStream(conexion.getInputStream()));
        salida = new DataOutputStream(new BufferedOutputStream(conexion.getOutputStream()));  
    }
    
    public void run(){
        String nombre = conexion.getInetAddress().toString();
        try{
            emitirMensaje(nombre +" se ha unido.");
            manejador.addElement(this);
            while(true){
                String msg = entrada.readUTF();
                emitirMensaje(nombre +": "+msg);
            }
        }
        catch(IOException e){
            //emitirMensaje(nombre +" Ha lanzado un Error.");
        }
        finally{
            System.out.println("numEEro: "+manejador.capacity()+" "+manejador.lastIndexOf(this));
             venta.quitarElementoLista(0);//manejador.lastIndexOf(this));
            manejador.removeElement(this);
            emitirMensaje(nombre + " ha abandonado la conexión.");
           
            
            
            try{
                salida.close();
            }
            catch(IOException e){}
        }
    }
    
    public static void emitirMensaje(String mensaje){
        synchronized(manejador){
            Enumeration e = manejador.elements();
            while(e.hasMoreElements()){
                ManejadorServidor ms = (ManejadorServidor)e.nextElement();
                try{
                    synchronized(ms.salida){
                        ms.salida.writeUTF(mensaje);
                    }
                    ms.salida.flush();
                }
                catch(IOException er){
                    ms.stop();
                }
            }
        }
    }
}
