/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JanelaInicial;

import java.awt.Color;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jayme
 */
public class MetaisTransiçaoInterna extends Elementos{
    
    public MetaisTransiçaoInterna(JButton e, JButton n, JLabel nAtomico, JLabel mAtomica, ArrayList<Elementos> arrayElem, Socket s) {
        super(e, n, arrayElem, s);
        setBackground(new Color(17, 204, 228, 150));
        super.setNumeroAtomico(nAtomico);
        super.setMassaAtomica(mAtomica);
    }
    
    public void setMetaisTransiçaoInterna(MetaisTransiçaoInterna m, int x, int y, int w, int h, int i, int j, JPanel c){
        m.setLocation(x + (w * i), y + (h * j) + 6);
        c.add(m);
        switch (i) {
            case 3:
                switch (j) {
                    case 7:
                        super.setNome("Cerio");
                        super.numeroAtomico = "58";
                        super.massaAtomica = "140,12";
                        m.setText("Ce");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Torio");
                        super.numeroAtomico = "90";
                        super.massaAtomica = "232,04";
                        m.setText("Th");
                        break;
                    default:
                        return;
                }
            return;
            case 4:
                switch (j) {
                    case 7:
                        super.setNome("Praseodimio");
                        super.numeroAtomico = "59";
                        super.massaAtomica = "140,91";
                        m.setText("Pr");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Protactinio");
                        super.numeroAtomico = "91";
                        super.massaAtomica = "231,04";
                        m.setText("Pa");
                        break;
                    default:
                        return;
                }
            return;
            case 5:
                switch (j) {
                    case 7:
                        super.setNome("Neodimio");
                        super.numeroAtomico = "60";
                        super.massaAtomica = "144,24";
                        m.setText("Nd");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Uranio");
                        super.numeroAtomico = "92";
                        super.massaAtomica = "238,03";
                        m.setText("U");
                        break;
                    default:
                        return;
                }
            return;
            case 6:
                switch (j) {
                    case 7:
                        super.setNome("Promecio");
                        super.numeroAtomico = "61";
                        super.massaAtomica = "(145)";
                        m.setText("Pm");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Netunio");
                        super.numeroAtomico = "93";
                        super.massaAtomica = "(237)";
                        m.setText("Np");
                        break;
                    default:
                        return;
                }
            return;
            case 7:
                switch (j) {
                    case 7:
                        super.setNome("Samario");
                        super.numeroAtomico = "62";
                        super.massaAtomica = "150,36";
                        m.setText("Sm");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Plutonio");
                        super.numeroAtomico = "94";
                        super.massaAtomica = "(244)";
                        m.setText("Pu");
                        break;
                    default:
                        return;
                }
            return;
            case 8:
                switch (j) {
                    case 7:
                        super.setNome("Europio");
                        super.numeroAtomico = "63";
                        super.massaAtomica = "151,96";
                        m.setText("Eu");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Americio");
                        super.numeroAtomico = "95";
                        super.massaAtomica = "(243)";
                        m.setText("Am");
                        break;
                    default:
                        return;
                }
            return;
            case 9:
                switch (j) {
                    case 7:
                        super.setNome("Gadolinio");
                        super.numeroAtomico = "64";
                        super.massaAtomica = "157,25";
                        m.setText("Gd");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Curio");
                        super.numeroAtomico = "96";
                        super.massaAtomica = "(247)";
                        m.setText("Cm");
                        break;
                    default:
                        return;
                }
            return;
            case 10:
                switch (j) {
                    case 7:
                        super.setNome("Terbio");
                        super.numeroAtomico = "65";
                        super.massaAtomica = "158,93";
                        m.setText("Tb");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Berquelio");
                        super.numeroAtomico = "97";
                        super.massaAtomica = "(247)";
                        m.setText("Bk");
                        break;
                    default:
                        return;
                }
            return;
            case 11:
                switch (j) {
                    case 7:
                        super.setNome("Disprosio");
                        super.numeroAtomico = "66";
                        super.massaAtomica = "162,50";
                        m.setText("Dy");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Californio");
                        super.numeroAtomico = "98";
                        super.massaAtomica = "(251)";
                        m.setText("Cf");
                        break;
                    default:
                        return;
                }
            return;
            case 12:
                switch (j) {
                    case 7:
                        super.setNome("Holmio");
                        super.numeroAtomico = "67";
                        super.massaAtomica = "164,93";
                        m.setText("Ho");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Einstenio");
                        super.numeroAtomico = "99";
                        super.massaAtomica = "(252)";
                        m.setText("Es");
                        break;
                    default:
                        return;
                }
            return;
            case 13:
                switch (j) {
                    case 7:
                        super.setNome("Erbio");
                        super.numeroAtomico = "68";
                        super.massaAtomica = "167,26";
                        m.setText("Er");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Fermio");
                        super.numeroAtomico = "100";
                        super.massaAtomica = "(257)";
                        m.setText("Fm");
                        break;
                    default:
                        return;
                }
            return;
            case 14:
                switch (j) {
                    case 7:
                        super.setNome("Tulio");
                        super.numeroAtomico = "69";
                        super.massaAtomica = "168,93";
                        m.setText("Tm");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Mendelevio");
                        super.numeroAtomico = "101";
                        super.massaAtomica = "(258)";
                        m.setText("Md");
                        break;
                    default:
                        return;
                }
            return;
            case 15:
                switch (j) {
                    case 7:
                        super.setNome("Iterbio");
                        super.numeroAtomico = "70";
                        super.massaAtomica = "173,05";
                        m.setText("Yb");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Nobelio");
                        super.numeroAtomico = "102";
                        super.massaAtomica = "(259)";
                        m.setText("No");
                        break;
                    default:
                        return;
                }
            return;
            case 16:
                switch (j) {
                    case 7:
                        super.setNome("Lutecio");
                        super.numeroAtomico = "71";
                        super.massaAtomica = "174,97";
                        m.setText("Lu");
                        break;
                    case 8:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Laurencio");
                        super.numeroAtomico = "103";
                        super.massaAtomica = "(266)";
                        m.setText("Lr");
                        break;
                    default:
                        return;
                }
            return;
        }
    }
}
