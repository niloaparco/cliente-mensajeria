/*
 * Main.java
 *
 * Created on 22 de mayo de 2009, 10:43 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nuevocliente1;

/**
 *
 * @author Erik
 */
import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
public class Main{
    
    Ventana ventana;
   // DataInputStream entrada;
   // DataOutputStream salida;
    //Thread hilo;
    /** Creates a new instance of Main */
    public Main() throws IOException{
        //Socket s = new Socket ("127.0.0.1",12345);//args[0], Integer.parseInt (args[1]));
   // Ventana ventana= new Ventana (s.getInputStream (), s.getOutputStream ());
        Ventana ventana = new Ventana();
    }
    
   /* public Main(InputStream e, OutputStream s) {
        ventana = new Ventana();
        ventana.setVisible(true);
        
        entrada = new DataInputStream(new BufferedInputStream(e));
        salida = new DataOutputStream(new BufferedOutputStream(s));
        
        hilo = new Thread(this);
        hilo.start();
    }
    
    public void run(){
        try{
            while(true){
                String lineaEntrada = entrada.readUTF();
                ventana.jTextArea1.append(lineaEntrada+"\n");
            }
        }
        catch(IOException e){
            ventana.jTextArea1.append("*Error lectura.\n");
        }
        finally{
            hilo = null;
            try{
                salida.close();
            }
            catch(IOException e){
                ventana.jTextArea1.append("*Error al cerrar.\n");
            }
        }
    }*/
    
   /* public boolean handleEvent(Event evt){
        if(evt.target == ventana.jTextField1 && evt.id == Event.ACTION_EVENT){
            try{
                salida.writeUTF((String)evt.arg);
                salida.flush();
            }
            catch(IOException e){
                ventana.jTextArea1.append("*Error en la escritura.\n");
                hilo.stop();
            }
            ventana.jTextField1.setText("");
            return true;
        }
        else if(evt.target == this && evt.id == Event.WINDOW_DESTROY){
            if(hilo != null){
                hilo.stop();
             return true;
            }
        }
       
    }*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        /*Socket s = new Socket ("127.0.0.1",12345);//args[0], Integer.parseInt (args[1]));
    new Main (s.getInputStream (), s.getOutputStream ());*/
        new Main();
    }
    
}
