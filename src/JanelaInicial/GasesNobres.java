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
public class GasesNobres extends Elementos{
    String dica1, dica2, dica3;
    public GasesNobres(JButton e, JButton n, JLabel nAtomico, JLabel mAtomica, ArrayList<Elementos> arrayElem, Socket s){ //Paineis canvas e canvas2
        super(e, n, arrayElem, s); //Envia os paineis para a classe Elementos
        setBackground(new Color(106, 90, 205, 150));
        super.setNumeroAtomico(nAtomico);
        super.setMassaAtomica(mAtomica);
    }
    
    public void setGasesNobres(GasesNobres n, int x, int y, int w, int h, int i, JPanel c){
        n.setLocation(x + (w * 17), y + (h * i));
        c.add(n);
        switch (i) {
            case 0:
                super.setNome("Helio"); //Manda o nome para a classe Elementos.
                super.numeroAtomico = "2";
                super.massaAtomica = "4,0026";
                n.setText("He");
                break;
            case 1:
                super.setNome("Neonio");
                super.numeroAtomico = "10";
                super.massaAtomica = "20,180";
                n.setText("Ne");
                n.dica1 = "UTILIZADO EM ILUMINAÇÃO DE PLACAS DE PROPAGANDAS";
                n.dica2 = "ELEMENTO NA FAMÍLIA DOS ELEMENTOS NOBRES";
                n.dica3 = "ELEMENTO DO 2º PERÍODO";
                super.setDicas(dica1, dica2, dica3);
                super.setArrayList(n);
                break;
            case 2:
                super.setNome("Argonio");
                super.numeroAtomico = "18";
                super.massaAtomica = "39,948";
                n.setText("Ar");
                n.dica1 = "É UTILIZADO EM LÂMPADAS INCANDESCENTES";
                n.dica2 = "ENCONTRA-SE NO TERCEIRO PERÍODO";
                n.dica3 = "NÃO INTERAGE COM NENHUM ELEMENTO DA TABELA PERIÓDICA";
                super.setDicas(dica1, dica2, dica3);
                super.setArrayList(n);
                break;
            case 3:
                super.setNome("Criptonio");
                super.numeroAtomico = "36";
                super.massaAtomica = "83,798";
                n.setText("Kr");
                break;
            case 4:
                super.setNome("Xenonio");
                super.numeroAtomico = "54";
                super.massaAtomica = "131,29";
                n.setText("Xe");
                n.dica1 = "UTILIZADO EM LÂMPADAS PARA BRONZEAMENTO ARTIFICIAL";
                n.dica2 = "ESTÁ NO 5º PERÍODO";
                n.dica3 = "ELEMENTO QUE FAZ PARTE DOS GASES NOBRES";
                super.setDicas(dica1, dica2, dica3);
                super.setArrayList(n);
                break;
            case 5:
                super.setNome("Radonio");
                super.numeroAtomico = "86";
                super.massaAtomica = "(222)";
                n.setText("Rn");
                n.dica1 = "POSSUI O MENOR RAIO ATÔMICO DO PERÍODO SEIS";
                n.dica2 = "UTILIZADO EM SISMÓGRAFOS";
                n.dica3 = "POSSUI A CAMADA DE VALÊNCIA COMPLETA";
                super.setDicas(dica1, dica2, dica3);
                super.setArrayList(n);
                break;
            case 6:
                super.setNome("Oganessonio");
                super.numeroAtomico = "118";
                super.massaAtomica = "(294)";
                n.setText("Og");
                break;
            default:
                break;
        }
    }
}
