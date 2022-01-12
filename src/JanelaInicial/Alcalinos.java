/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JanelaInicial;

import java.awt.Color;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author jayme
 */
public class Alcalinos extends Elementos{
    String dica1, dica2, dica3;
    public Alcalinos(JButton e, JButton n, JLabel nAtomico, JLabel mAtomica, ArrayList<Elementos> arrayElem, Socket s){ //Paineis canvas e canvas2.
        super(e, n, arrayElem, s); //Envia os paineis para a classe Elementos.
        setBackground(new Color(255, 140, 0, 150));
        super.setNumeroAtomico(nAtomico);
        super.setMassaAtomica(mAtomica);
    }
    
    public void setAlcalinos(Alcalinos a, int x, int y, int h, int num, JPanel c){    
        a.setLocation(x, y + (h * num));
        switch (num) {
            case 1:
                super.setNome("Litio"); //Manda o nome para a classe Elementos.
                super.numeroAtomico = "3";
                super.massaAtomica = "6,94";
                //super.setImagem(new ImageIcon(getClass().getResource("/Imagens/Litio.jpg")));
                a.setText("Li");
                break;
            case 2:
                super.setNome("Sodio");
                super.numeroAtomico = "11";
                super.massaAtomica = "22,990";
                a.setText("Na");
                a.dica1 = "UM DOS COMPONETES DO SAL DE COZINHA";
                a.dica2 = "É UM METAL ALCALINO QUE EXPLODE EM CONTATO COM A ÁGUA";
                a.dica3 = "POSSUI TRÊS CAMADAS ENERGÉTICAS";
                super.setDicas(dica1, dica2, dica3);
                super.setArrayList(a);
                break;
            case 3:
                super.setNome("Potassio");
                super.numeroAtomico = "19";
                super.massaAtomica = "39,098";
                a.setText("K");
                a.dica1 = "É UM METAL DO QUARTO PERÍODO";
                a.dica2 = "É UTILIZADO EM ADUBOS QUÍMICOS";
                a.dica3 = "ESTÁ NO GRUPO DOS METAIS ALCALINOS";
                super.setDicas(dica1, dica2, dica3);
                super.setArrayList(a);
                break;
            case 4:
                super.setNome("Rubidio");
                super.numeroAtomico = "37";
                super.massaAtomica = "85,468";
                a.setText("Rb");
                break;
            case 5:
                super.setNome("Cesio");
                super.numeroAtomico = "55";
                super.massaAtomica = "132,91";
                a.setText("Cs");
                break;
            case 6:
                super.setNome("Francio");
                super.numeroAtomico = "87";
                super.massaAtomica = "(223)";
                a.setText("Fr");
                break;
            default:
                return;
            }
        c.add(a);
    }
}
