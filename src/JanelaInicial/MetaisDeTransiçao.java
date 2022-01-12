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
public class MetaisDeTransiçao extends Elementos{
    String dica1, dica2, dica3;
    public MetaisDeTransiçao(JButton e, JButton n, JLabel nAtomico, JLabel mAtomica, ArrayList<Elementos> arrayElem, Socket s){
        super(e, n, arrayElem, s);
        setBackground(new Color(250, 128, 114, 150));
        super.setNumeroAtomico(nAtomico);
        super.setMassaAtomica(mAtomica);
    }

    public void setMetaisDeTransiçao(MetaisDeTransiçao m, int x, int y, int w, int h, int i, int j, JPanel c) {
        m.setLocation(x + (w * i), y + (h * j));
        c.add(m);
        switch (i) {
            case 2:
                switch (j) {
                    case 3:
                        super.setNome("Escandio");
                        super.numeroAtomico = "21";
                        super.massaAtomica = "44,956";
                        m.setText("Sc");
                        break;
                    case 4:
                        super.setNome("Itrio");
                        super.numeroAtomico = "39";
                        super.massaAtomica = "88,906";
                        m.setText("Y");
                        break;
                    case 5:
                        m.setBackground(new Color(17, 204, 228, 150));
                        super.setNome("Lantanio");
                        super.numeroAtomico = "57";
                        super.massaAtomica = "138,91";
                        m.setText("La");
                        break;
                    case 6:
                        m.setBackground(new Color(0, 85, 255, 150));
                        super.setNome("Actinio");
                        super.numeroAtomico = "89";
                        super.massaAtomica = "(227)";
                        m.setText("Ac");
                        break;
                    default:
                        return;
                }
            return;
            case 3:
                switch (j) {
                    case 3:
                        super.setNome("Titanio");
                        super.numeroAtomico = "22";
                        super.massaAtomica = "47,867";
                        m.setText("Ti");
                        m.dica1 = "É UTILIZADO COMO PINO PARA FRATURAS";
                        m.dica2 = "É UM METAL DE TRANSIÇÃO DO 4º PERÍODO";
                        m.dica3 = "SUA CONFIGURAÇÃO ELETRÔNICA TERMINA EM d²";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 4:
                        super.setNome("Zirconio");
                        super.numeroAtomico = "40";
                        super.massaAtomica = "91,224";
                        m.setText("Zr");
                        break;
                    case 5:
                        super.setNome("Hafnio");
                        super.numeroAtomico = "72";
                        super.massaAtomica = "178,49";
                        m.setText("Hf");
                        break;
                    case 6:
                        super.setNome("Rutherfordio");
                        super.numeroAtomico = "104";
                        super.massaAtomica = "(267)";
                        m.setText("Rf");
                        break;
                    default:
                        return;
                        }
            return;
            case 4:
                switch (j) {
                    case 3:
                        super.setNome("Vanadio");
                        super.numeroAtomico = "23";
                        super.massaAtomica = "50,942";
                        m.setText("V");
                        break;
                    case 4:
                        super.setNome("Niobio");
                        super.numeroAtomico = "41";
                        super.massaAtomica = "92,906";
                        m.setText("Nb");
                        break;
                    case 5:
                        super.setNome("Tantalo");
                        super.numeroAtomico = "73";
                        super.massaAtomica = "180,95";
                        m.setText("Ta");
                        break;
                    case 6:
                        super.setNome("Dubnio");
                        super.numeroAtomico = "105";
                        super.massaAtomica = "(268)";
                        m.setText("Db");
                        break;
                    default:
                    return;
                }
            return;
            case 5:
                switch (j) {
                    case 3:
                        super.setNome("Cromio");
                        super.numeroAtomico = "24";
                        super.massaAtomica = "51,996";
                        m.setText("Cr");
                        m.dica1 = "É UM METAL DE TRANSIÇÃO";
                        m.dica2 = "UTILIZADO NO PROCESSO DE GALVANOPLASTIA";
                        m.dica3 = "PERTENCE À FAMÍLIA 6 E POSSUI O MENOR RAIO ATOMICO DENTRE ESTES";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 4:
                        super.setNome("Molibdenio");
                        super.numeroAtomico = "42";
                        super.massaAtomica = "95,95";
                        m.setText("Mo");
                        break;
                    case 5:
                        super.setNome("Tungstenio");
                        super.numeroAtomico = "74";
                        super.massaAtomica = "183,84";
                        m.setText("W");
                        m.dica1 = "É UM METAL DO 6 PERIODO E COM O MAIOR PONTO DE FUSAO DE TODOS. (+5000 ºC)";
                        m.dica2 = "É O ELEMENTO MAIS DENSO DE TODA A TABELA PERIODICA";
                        m.dica3 = "ESTA LOCALIZADO NA FAMÍLIA 6, ESSE METAL É MUITO UTILIZADO EM SUPERLIGAS ALTAMENTE RESISTENTES";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 6:
                        super.setNome("Seaborgio");
                        super.numeroAtomico = "106";
                        super.massaAtomica = "(269)";
                        m.setText("Sg");
                        break;
                    default:
                        return;
                        }
            return;
            case 6:
                switch (j) {
                    case 3:
                        super.setNome("Manganes");
                        super.numeroAtomico = "25";
                        super.massaAtomica = "54,938";
                        m.setText("Mn");
                        m.dica1 = "POSSUI QUATRO CAMADAS ENERGÉTICAS";
                        m.dica2 = "ELE É UTILIZADO EM COFRES";
                        m.dica3 = "SUA CONFIGURAÇÃO ELETRÔNICA TERMINA EM d⁵";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 4:
                        super.setNome("Tecnecio");
                        super.numeroAtomico = "43";
                        super.massaAtomica = "(98)";
                        m.setText("Tc");
                        break;
                    case 5:
                        super.setNome("Renio");
                        super.numeroAtomico = "75";
                        super.massaAtomica = "186,21";
                        m.setText("Re");
                        break;
                    case 6:
                        super.setNome("Bohrio");
                        super.numeroAtomico = "107";
                        super.massaAtomica = "(270)";
                        m.setText("Bh");
                        break;
                    default:
                        return;
                }
            return;
            case 7:
                switch (j) {
                    case 3:
                        super.setNome("Ferro");
                        super.numeroAtomico = "26";
                        super.massaAtomica = "55,845";
                        m.setText("Fe");
                        m.dica1 = "É UM METAL DE TRANSIÇÃO";
                        m.dica2 = "MUITO UTILIZADO EM PORTÕES";
                        m.dica3 = "POSSUI NÚMERO ATÔMICO IGUAL A 26";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 4:
                        super.setNome("Rutenio");
                        super.numeroAtomico = "44";
                        super.massaAtomica = "101,07";
                        m.setText("Ru");
                        break;
                    case 5:
                        super.setNome("Osmio");
                        super.numeroAtomico = "76";
                        super.massaAtomica = "190,23";
                        m.setText("Os");
                        break;
                    case 6:
                        super.setNome("Hassio");
                        super.numeroAtomico = "108";
                        super.massaAtomica = "(277)";
                        m.setText("Hs");
                        break;
                    default:
                        return;
                }
            return;
            case 8:
                switch (j) {
                    case 3:
                        super.setNome("Cobalto");
                        super.numeroAtomico = "27";
                        super.massaAtomica = "58,933";
                        m.setText("Co");
                        break;
                    case 4:
                        super.setNome("Rodio");
                        super.numeroAtomico = "45";
                        super.massaAtomica = "102,91";
                        m.setText("Rh");
                        break;
                    case 5:
                        super.setNome("Iridio");
                        super.numeroAtomico = "77";
                        super.massaAtomica = "192,22";
                        m.setText("Ir");
                        m.dica1 = "UTILIZADO EM AGULHAS DE INJEÇÃO";
                        m.dica2 = "É UM METAL DE TRANSIÇÃO";
                        m.dica3 = "SUA CONFIGURAÇÃO ELETRÔNICA TERMINA EM 5d⁷";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 6:
                        super.setNome("Meitnerio");
                        super.numeroAtomico = "109";
                        super.massaAtomica = "(278)";
                        m.setText("Mt");
                        break;
                    default:
                        return;
                }
            return;
            case 9:
                switch (j) {
                    case 3:
                        super.setNome("Niquel");
                        super.numeroAtomico = "28";
                        super.massaAtomica = "58,693";
                        m.setText("Ni");
                        break;
                    case 4:
                        super.setNome("Paladio");
                        super.numeroAtomico = "46";
                        super.massaAtomica = "106,42";
                        m.setText("Pd");
                        m.dica1 = "É UTILIZADO EM PRÓTESES DENTÁRIAS";
                        m.dica2 = "ESTÁ LOCALIZADO NO QUINTO PERÍODO";
                        m.dica3 = "POSSUI RAIO ATOMICO MAIOR DO QUE O DA PRATA";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 5:
                        super.setNome("Platina");
                        super.numeroAtomico = "78";
                        super.massaAtomica = "195,08";
                        m.setText("Pt");
                        m.dica1 = "ENCONTRA-SE NO SEXTO PERÍODO";
                        m.dica2 = "MUITO UTILIZADO NO PROCESSO DE RECUPERAÇÃO DE FRATURA ÓSSEA";
                        m.dica3 = "SEU RAIO ATÔMICO É MAIOR QUE O DO OURO";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 6:
                        super.setNome("Darmstadtio");
                        super.numeroAtomico = "110";
                        super.massaAtomica = "(281)";
                        m.setText("Ds");
                        break;
                    default:
                        return;
                }
            return;
            case 10:
                switch (j) {
                    case 3:
                        super.setNome("Cobre");
                        super.numeroAtomico = "29";
                        super.massaAtomica = "63,546";
                        m.setText("Cu");
                        m.dica1 = "É MUITO UTILIZADO EM FIAÇÕES ELÉTRICAS";
                        m.dica2 = "É UM METAL DO QUARTO PERÍODO";
                        m.dica3 = "ESTÁ LOCALIZADO NA FAMÍLIA ONZE";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 4:
                        super.setNome("Prata");
                        super.numeroAtomico = "47";
                        super.massaAtomica = "107,87";
                        m.setText("Ag");
                        m.dica1 = "É USADO EM BIJUTERIAS, TALHERES, ETC";
                        m.dica2 = "É UM METAL DE TRANSIÇÃO";
                        m.dica3 = "ELEMENTO USADO NA FABRICAÇAO DE ESPELHOS";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 5:
                        super.setNome("Ouro");
                        super.numeroAtomico = "79";
                        super.massaAtomica = "196,97";
                        m.setText("Au");
                        m.dica1 = "É UM METAL DE TRANSIÇAO";
                        m.dica2 = "MUITO UTILIZADO EM JOIAS";
                        m.dica3 = "ESTÁ LOCALIZADO NO SEXTO PERÍODO DA FAMÍLIA 11";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 6:
                        super.setNome("Roentgenio");
                        super.numeroAtomico = "111";
                        super.massaAtomica = "(282)";
                        m.setText("Rg");
                        break;
                    default:
                        return;
                }
            return;
            case 11:
                switch (j) {
                    case 3:
                        super.setNome("Zinco");
                        super.numeroAtomico = "30";
                        super.massaAtomica = "65,38";
                        m.setText("Zn");
                        m.dica1 = "SEU RAIO ATÔMICO É MAIOR QUE O DO GÁS NOBRE CRIPTÔNIO";
                        m.dica2 = "É UM METAL DE TRANSIÇÃO UTILIZADO NA FABRICAÇÃO DE CALHAS";
                        m.dica3 = "POSSUI QUATRO CAMADAS ENERGÉTICAS E ENCONTRA-SE NA FAMÍLIA DOZE";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 4:
                        super.setNome("Cadmio");
                        super.numeroAtomico = "48";
                        super.massaAtomica = "112,41";
                        m.setText("Cd");
                        break;
                    case 5:
                        super.setNome("Mercurio");
                        super.numeroAtomico = "80";
                        super.massaAtomica = "200,59";
                        m.setText("Hg");
                        m.dica1 = "MUITO UTILIZADO EM COLUNAS DE TERMÔMETRO";
                        m.dica2 = "TEM O MESMO NOME DE UM PLANETA DO SISTEMA SOLAR";
                        m.dica3 = "METAL ENCONTRADO NO ESTADO LÍQUIDO NA TEMPERATURA AMBIENTE";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(m);
                        break;
                    case 6:
                        super.setNome("Copernicio");
                        super.numeroAtomico = "112";
                        super.massaAtomica = "(285)";
                        m.setText("Cn");
                        break;
                    default:
                        return;
                }
            default:
                return;
        }
    }
}
