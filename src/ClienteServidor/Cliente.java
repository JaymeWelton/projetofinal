/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

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
 * @author jayme
 */
public class Cliente {
    public static void main(String[] args) throws IOException {
        try {
            final Socket cliente = new Socket("localhost", 4444);
            
            //Lendo mensagens do servidor...
            new Thread () {
                @Override
                public void run() {
                    try {
                        BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                        
                        while (true) {
                            String msg = leitor.readLine();
                            System.out.println("O servidor disse: " + msg);
                        }
                        
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }.start();
            
            //Escrevendo mensagens...
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader leitorTerminal = new BufferedReader(new InputStreamReader(System.in));
            String msgTerminal = null;
            
            while (true) {
                msgTerminal = leitorTerminal.readLine();
                if (msgTerminal.equalsIgnoreCase(null) || msgTerminal.length() == 0) {
                    continue;
                }
                escritor.println(msgTerminal);
                if (msgTerminal.equalsIgnoreCase("sair")) {
                    System.exit(0);
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }
}
