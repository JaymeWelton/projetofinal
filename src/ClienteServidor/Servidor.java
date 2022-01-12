/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author jayme
 */
public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = null;
        ArrayList<Socket> cli = new ArrayList();
        
        try {
            System.out.println("Inicializando o servidor...");
            servidor = new ServerSocket(4444);
            System.out.println("Servido inicializado.");
            
            while (true) {
                Socket cliente = servidor.accept();
                
                while (cli.size() != 2) {
                    cli.add(cliente);
                }
                if (cli.size() == 2) {
                    Socket jogador1 = cli.remove(0);
                    Socket jogador2 = cli.remove(0);
                    
                    //JanelaInicial.JanelaPrincipal obj = new JanelaInicial.JanelaPrincipal(null, true, jogador1);
                    //obj.setVisible(true);
                }
                //new GerenciadorDeClientes(cliente);
            }
            
        } catch (Exception e) {
            System.err.println("Porta ocupada.");
            if (servidor != null) {
                servidor.close();
            }
        }
    }
}
