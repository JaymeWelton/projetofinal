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
public class AlcalinosTerrosos extends Elementos{
    String dica1, dica2, dica3;
    public AlcalinosTerrosos(JButton e, JButton n, JLabel nAtomico, JLabel mAtomica, ArrayList<Elementos> arrayElem, Socket s){ //Paineis canvas e canvas2
        super(e, n, arrayElem, s); //Envia os paineis para a classe Elementos
        setBackground(new Color(255, 215, 0, 150));
        super.setNumeroAtomico(nAtomico);
        super.setMassaAtomica(mAtomica);
    }
    
    public void setAlcalinosTerrosos(AlcalinosTerrosos at, int x, int y, int w, int h, int num, JPanel c){
        at.setLocation(x + w, y + (h * num));
        switch (num) {
            case 1:
                super.setNome("Berilio"); //Manda o nome para a classe Elementos.
                super.numeroAtomico = "4";
                super.massaAtomica = "9,0122";
                at.setText("Be");
                break;
            case 2:
                super.setNome("Magnesio");
                super.numeroAtomico = "12";
                super.massaAtomica = "24,305";
                at.setText("Mg");
                at.dica1 = "UTILIZADOS EM RODAS DE LIGA LEVE";
                at.dica2 = "É DA FAMÍLIA DOS METAIS ALCALINO-TERROSOS";
                at.dica3 = "POSSUI TRÊS CAMADAS ENERGÉTICAS";
                super.setDicas(dica1, dica2, dica3);
                super.setArrayList(at);
                break;
            case 3:
                super.setNome("Calcio");
                super.numeroAtomico = "20";
                super.massaAtomica = "40,078";
                at.setText("Ca");
                at.dica1 = "COMPÕE OS NOSSOS OSSOS E É UTILIZADO NO GESSO";
                at.dica2 = "SUA DISTRIBUIÇÃO ELETRÔNICA TERMINA EM s²";
                at.dica3 = "POSSUI QUATRO CAMADAS ENERGÉTICAS";
                super.setDicas(dica1, dica2, dica3);
                super.setArrayList(at);
                break;
            case 4:
                super.setNome("Estroncio");
                super.numeroAtomico = "38";
                super.massaAtomica = "87,62";
                at.setText("Sr");
                at.dica1 = "UTILIZADO EM FOGOS DE ARTIFÍCIO";
                at.dica2 = "POSSUI O TERCEIRO MAIOR RAIO ATÔMICO NA FAMÍLIA DOS METAIS ALCALINO-TERROSOS";
                at.dica3 = "UTILIZADO EM TINTAS QUE BRILHAM NO ESCURO";
                super.setDicas(dica1, dica2, dica3);
                super.setArrayList(at);
                break;
            case 5:
                super.setNome("Bario");
                super.numeroAtomico = "56";
                super.massaAtomica = "137,33";
                at.setText("Ba");
                at.dica1 = "SEU RAIO ATÔMICO É MAIOR QUE O DO OURO";
                at.dica2 = "POSSUI SEIS CAMADAS ENERGÉTICAS";
                at.dica3 = "É UM METAL ALCALINO–TERROSSO USADO EM FOGOS DE ARTIFÍCIO E CHAPAS DE ESTÔMAGO";
                super.setDicas(dica1, dica2, dica3);
                super.setArrayList(at);
                break;
            case 6:
                super.setNome("Radio");
                super.numeroAtomico = "88";
                super.massaAtomica = "(226)";
                at.setText("Ra");
                break;
            default:
                return;
        }
        c.add(at);
    }
    
}
