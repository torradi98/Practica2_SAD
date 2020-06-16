/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Cliente {
    public static final int Server_port=7450;
    public static String name,li="Initial";
    public static final String Server_host="LocalHost";
    public static void main(String args[])throws IOException{
        Scanner reader=new Scanner(System.in);
        MySocket s= new MySocket(Server_host,Server_port);
        PrintWriter output=new PrintWriter(s.MygetOutputStream(),true);
        BufferedReader br= new BufferedReader(new InputStreamReader(s.MygetInpuStream()));
      
        Thread inputThread= new Thread(new Runnable() {
        public void run(){
                
                String linia;
                while((linia = reader.nextLine()) != null){
                    li = linia;
                    output.print(linia+"\n");
                    output.flush();
                }
                
            }
        });
        Thread outputThread= new Thread(new Runnable() {
            public void run(){
                
                try {
                    String msg;
                    while((msg = br.readLine()) != null){
                        if(msg.contains(li) && msg.contains("joined")){
                            name = li;
                        }else if(name == null){
                            System.out.println(msg);

                        }else if(!msg.contains(name)){
                            System.out.println(msg);

                        }        
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } 
        });
        inputThread.start();
        outputThread.start();
        System.out.println("Client has started");
        
     
      
    }  }

