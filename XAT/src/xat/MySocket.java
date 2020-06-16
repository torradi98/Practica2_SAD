/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class MySocket extends Socket{
    Socket s;
    public MySocket(String host,int port){//creamos el socket y lo conectamos el puero especifico en el nombre del host
        try{
            this.s=new Socket(host,port);
        }catch(IOException ex){
            Logger.getLogger(MySocket.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public MySocket(Socket soc){
            this.s=soc;
        }
    public void MyConnect(SocketAddress endpoint){//conecta el socket con el servidor
        try{
            this.s.connect(endpoint);
        }catch(IOException ex){
             Logger.getLogger(MySocket.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public InputStream MygetInpuStream(){//si el socket tiene un canal asociado, la fuente de entrada pasa a ser el canal
        try{
            return s.getInputStream();
        }catch(IOException ex){
            Logger.getLogger(MySocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public OutputStream MygetOutputStream(){//=MyGetInpustream pero con la fuente de salida
        try{
            return this.s.getOutputStream();
        }catch(IOException ex){
            Logger.getLogger(MySocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void Myclose(){//cierra el socket y todo lo asociado a él(canal y Input-OutputStream)
        try{
            this.s.close();
        }catch(IOException ex){
            Logger.getLogger(MySocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
