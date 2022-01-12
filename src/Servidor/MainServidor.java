/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author clistenes
 */
public class MainServidor {
    public static int count;
    /*static ArrayList<String> arrayElem;
    static ArrayList<String> escolhidos;*/
    
    public static void main(String[] args) throws IOException {
        
       //abri o socket do servidor e cria a fila que serão armazenados os clientes;
       Socket s1, s2;
       ServerSocket s = new ServerSocket(4444);
       //FilaArray fila = new FilaArray();
       ArrayList fila = new ArrayList();
       
       
        while(true){
           //recebendo cliente e guardando em uma fila;
           
           while(fila.size() != 2){
           Socket ns = s.accept();
           fila.add(ns);
           count = fila.size();
           System.out.println(count);
           }
           
            if(fila.size() == 2){
            
                //instanciando variaveis de entrada e saida de dados;
                s1 = (Socket) fila.remove(0);
                s2 = (Socket) fila.remove(0);
                /*arrayElem = new ArrayList();
                escolhidos = new ArrayList();
                tabelaPeriodica(arrayElem, escolhidos);*/
                DataOutputStream out1 = new DataOutputStream(s1.getOutputStream());
                DataOutputStream out2 = new DataOutputStream(s2.getOutputStream());
                
                //enviando mensagem de conectado;
                out1.writeUTF("conectado");
                out2.writeUTF("conectado");
                
                /*for (int i = 0; i < escolhidos.size(); i++) {
                    //System.out.println("Cheguei aqui");
                    out1.writeUTF(escolhidos.get(i).getNome());
                    out2.writeUTF(escolhidos.get(i).getNome());
                }*/
                
                //Thread do servidor;
                new Thread( new Servidor(s1, s2)).start();
                System.out.println("ELEMENTOS REMOVIDOS = " + fila.size());
            }
        }
        //s.close();
    }
    
}
