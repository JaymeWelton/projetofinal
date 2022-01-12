package Servidor;

import JanelaInicial.Elementos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author clistenes
 */
public class Protocolo {
    ArrayList<ElementosServidor> elementos;
    int index = 0;
    
    public Protocolo(ArrayList elem){
        elementos = elem;
        for (int i = 0; i < elementos.size(); i++) {
            System.out.println(elementos.get(i).getNome()); //Estou testando se os elementos estao aqui.
        }
    }
    
    public String ProcessLine(String command){
        if(command.equalsIgnoreCase(elementos.get(index).getNome())){
            
            //Aument o index para quadno acertar passar para o proximo elemento.
            index++; 
            
            //Aqui era para encerrar a partida quadno index chegasse em 10... mas nao funciona XD
            if (index == 10) { 
                System.out.println("Consegui chegar aquiiiiiiiiiiiiiiiiiiiiiiiiii: " + index);
                return "acabou 10";
            }
            
            return "acertou";
            
        }else{
            return "errou";
        }
        
    }
    
}
