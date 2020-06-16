/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xat;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author carlos.torra
 */
public class MyServerSocket extends ServerSocket{
    Socket s;
    ServerSocket se;
    MySocket ms;
    public MyServerSocket(int port) throws IOException{
        this.se=new ServerSocket(port);
    }
    public MySocket accept(){//se encarga de aceptar la conexión con el socket
       try{
           this.s=se.accept();
           this.ms=new MySocket(s);
           return ms;
       }catch(IOException ex){
           Logger.getLogger(MySocket.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }
    public void close(){//misma funcion que para el MyScoket
        try {
            this.se.close();
        } catch (IOException ex) {
            Logger.getLogger(MyServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
