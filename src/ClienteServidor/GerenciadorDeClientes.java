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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jayme
 */
public class GerenciadorDeClientes extends Thread{
    private Socket cliente;
    private String nomeCliente;
    private static final ArrayList<Socket> clientes = new ArrayList();
    
    public GerenciadorDeClientes (Socket cliente){
        this.cliente = cliente;
        start();
    }

    @Override
    public void run() {
        try {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            escritor.println("Por favor escreva seu nome.");
            String msg = leitor.readLine();
            this.nomeCliente = msg;
            escritor.println("Ola " + this.nomeCliente);
            clientes.add(this.cliente);
            
            while (true) {
                msg = leitor.readLine();
                if (msg.equalsIgnoreCase("sair")) {
                    this.cliente.close();
                }
                escritor.println(this.nomeCliente + " voce disse: " + msg);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorDeClientes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("O cliente fechou a conecxao.");
        }
    }
    
    
}
