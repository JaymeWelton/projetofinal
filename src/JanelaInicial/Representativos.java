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
public class Representativos extends Elementos{
    String dica1, dica2, dica3;
    public Representativos(JButton e, JButton n, JLabel nAtomico, JLabel mAtomica, ArrayList<Elementos> arrayElem, Socket s){
        super(e, n, arrayElem, s);
        setBackground(new Color(70, 130, 180, 150));
        super.setNumeroAtomico(nAtomico);
        super.setMassaAtomica(mAtomica);
    }

    public void setRepresentativos(Representativos r, int x, int y, int w, int h, int i, int j, JPanel c) {
        r.setLocation(x + ((w) * i), y + (h * j));
        c.add(r);
        switch (i) {
            case 12:
                switch (j) {
                    case 1:
                        setCorSemiMetal(r);
                        super.setNome("Boro");
                        super.numeroAtomico = "5";
                        super.massaAtomica = "10,81";
                        r.setText("B");
                        break;
                    case 2:
                        super.setNome("Aluminio");
                        super.numeroAtomico = "13";
                        super.massaAtomica = "26,982";
                        r.setText("Al");
                        r.dica1 = "É UM METAL DO TERCEIRO PERÍODO";
                        r.dica2 = "É UTILIZADO EM LATINHAS RECICLÁVEIS";
                        r.dica3 = "ENCONTRA-SE NA FAMÍLIA DO BORO";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 3:
                        super.setNome("Galio");
                        super.numeroAtomico = "31";
                        super.massaAtomica = "69,723";
                        r.setText("Ga");
                        r.dica1 = "UTILIZADO NAS TELAS DE TV";
                        r.dica2 = "POSSUI QUATRO CAMADAS ENERGÉTICAS";
                        r.dica3 = "SEU NOME LEMBRA “GALILEU”";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 4:
                        super.setNome("Indio");
                        super.numeroAtomico = "49";
                        super.massaAtomica = "114,82";
                        r.setText("In");
                        break;
                    case 5:
                        super.setNome("Talio");
                        super.numeroAtomico = "81";
                        super.massaAtomica = "204,38";
                        r.setText("Tl");
                        break;
                    case 6:
                        super.setNome("Nihonio");
                        super.numeroAtomico = "113";
                        super.massaAtomica = "(286)";
                        r.setText("Nh");
                        break;
                    default:
                        return;
                }
            return;
            case 13:
                switch (j) {
                    case 1:
                        setCorAmetal(r);
                        super.setNome("Carbono");
                        super.numeroAtomico = "6";
                        super.massaAtomica = "12,011";
                        r.setText("C");
                        r.dica1 = "CONSTITUINTE DA GRAFITE E DO DIAMENTE";
                        r.dica2 = "POSSUI DUAS CAMADAS ENERGÉTICAS";
                        r.dica3 = "É UM AMETAL";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 2:
                        setCorSemiMetal(r);
                        super.setNome("Silicio");
                        super.numeroAtomico = "14";
                        super.massaAtomica = "28,085";
                        r.setText("Si");
                        break;
                    case 3:
                        setCorSemiMetal(r);
                        super.setNome("Germanio");
                        super.numeroAtomico = "32";
                        super.massaAtomica = "72,630";
                        r.setText("Ge");
                        break;
                    case 4:
                        super.setNome("Estanho");
                        super.numeroAtomico = "50";
                        super.massaAtomica = "118,71";
                        r.setText("Sn");
                        break;
                    case 5:
                        super.setNome("Chumbo");
                        super.numeroAtomico = "82";
                        super.massaAtomica = "207,2";
                        r.setText("Pb");
                        break;
                    case 6:
                        super.setNome("Flerovio");
                        super.numeroAtomico = "114";
                        super.massaAtomica = "(289)";
                        r.setText("Fl");
                        r.dica1 = "SEU TEMPO DE MEIA VIDA É MENOR DO QUE UM SEGUNDO";
                        r.dica2 = "PERTENCE À FAMÍLIA DO CARBONO";
                        r.dica3 = "POSSUI SETE CAMADAS ENERGÉTICAS";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    default:
                        return;
                }
            return;
            case 14:
                switch (j) {
                    case 1:
                        setCorAmetal(r);
                        super.setNome("Nitrogenio");
                        super.numeroAtomico = "7";
                        super.massaAtomica = "14,007";
                        r.setText("N");
                        r.dica1 = "É UM GÁS MAS PODE SER ENCONTRADO NO ESTADO LÍQUIDO SENDO UTILIZADO NA CONSERVAÇÃO DE MATERIAIS EM TEMPERATURAS MUITO BAIXAS";
                        r.dica2 = "POSSUI DUAS CAMADAS ENERGÉTICAS";
                        r.dica3 = "ENCONTRA-SE NO GRUPO VIZINHO À FAMÍLIA DO CARBONO";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 2:
                        setCorAmetal(r);
                        super.setNome("Fosforo");
                        super.numeroAtomico = "15";
                        super.massaAtomica = "30,974";
                        r.setText("P");
                        r.dica1 = "AMETAL COM TRÊS CAMADAS ENERGÉTICAS";
                        r.dica2 = "ENCONTRADO DENTRO DE CAIXINHAS PEQUENAS";
                        r.dica3 = "EM NOSSA COZINHA PODE NOS AJUDAR A CONSEGUIR FOGO";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 3:
                        setCorSemiMetal(r);
                        super.setNome("Arsenio");
                        super.numeroAtomico = "33";
                        super.massaAtomica = "74,922";
                        r.setText("As");
                        break;
                    case 4:
                        setCorSemiMetal(r);
                        super.setNome("Antimonio");
                        super.numeroAtomico = "51";
                        super.massaAtomica = "121,76";
                        r.setText("Sb");
                        r.dica1 = "UTILIZADO EM SOMBRAS PARA OS OLHOS (MAQUIAGEM)";
                        r.dica2 = "SEMIMETAL DO 5º PERÍODO";
                        r.dica3 = "ELE É MAIS ELETRONEGATIVO DO QUE O ESTANHO E MENOS DO QUE O ARSÊNIO";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 5:
                        super.setNome("Bismuto");
                        super.numeroAtomico = "83";
                        super.massaAtomica = "208,98";
                        r.setText("Bi");
                        break;
                    case 6:
                        super.setNome("Moscovio");
                        super.numeroAtomico = "115";
                        super.massaAtomica = "(290)";
                        r.setText("Mc");
                        break;
                    default:
                        return;
                }
            return;
            case 15:
                switch (j) {
                    case 1:
                        setCorAmetal(r);
                        super.setNome("Oxigenio");
                        super.numeroAtomico = "8";
                        super.massaAtomica = "15,999";
                        r.setText("O");
                        r.dica1 = "SEM ELE NÃO EXISTIRA A COMBUSTÃO";
                        r.dica2 = "É UM AMETAL DO 2º PERÍODO";
                        r.dica3 = "O SEGUNDO ELEMENTO MAIS ELETRONEGATIVO DA TABELA";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 2:
                        setCorAmetal(r);
                        super.setNome("Enxofre");
                        super.numeroAtomico = "16";
                        super.massaAtomica = "32,06";
                        r.setText("S");
                        r.dica1 = "É ENCOTRADO EM CONSERVANTES DE FOGOS DE ARTIFÍCIO";
                        r.dica2 = "É UM NÃO METAL DA FAMILIA DO OXIGENIO";
                        r.dica3 = "SEU SÍMBOLO ENCONTRA-SE NA ROUPA DO SUPER-HOMEM";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 3:
                        setCorAmetal(r);
                        super.setNome("Selenio");
                        super.numeroAtomico = "34";
                        super.massaAtomica = "78,971";
                        r.setText("Se");
                        r.dica1 = "ELEMENTO UTILIZADO EM XAMPU ANTI-CASPA";
                        r.dica2 = "AMETAL DO 4º PERÍODO";
                        r.dica3 = "ESTÁ NA FAMÍLIA DO OXIGENIO";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 4:
                        setCorSemiMetal(r);
                        super.setNome("Telurio");
                        super.numeroAtomico = "52";
                        super.massaAtomica = "127,60";
                        r.setText("Te");
                        r.dica1 = "ENCONTRADO EM PROTEÇÃO PARA CHUMBO DE ACUMULADORES DE BATERIA";
                        r.dica2 = "É UM SEMIMETAL NÃO RADIATIVO";
                        r.dica3 = "ESTÁ NA FAMÍLIA DO OXIGENIO";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 5:
                        setCorSemiMetal(r);
                        super.setNome("Polonio");
                        super.numeroAtomico = "84";
                        super.massaAtomica = "(209)";
                        r.setText("Po");
                        r.dica1 = "É UM SEMI-METAL RADIOATIVO QUE FOI DESCOBERTO POR MARIE CORRIE";
                        r.dica2 = "PERTENCE À FAMÍLIA DO OXIGENIO";
                        r.dica3 = "SEU NÚMERO ATÔMICO ANTECEDE O DO ASTATO";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 6:
                        super.setNome("Livermorio");
                        super.numeroAtomico = "116";
                        super.massaAtomica = "(293)";
                        r.setText("Lv");
                        r.dica1 = "FOI UM DOS ÚLTIMOS ELEMENTOS A SEREM RECONHECIDOS PELA IUPAC";
                        r.dica2 = "ESTA NA FAMÍLIA DO OXIGENIO";
                        r.dica3 = "POSSUI SETE CAMADAS ENERGÉTICAS";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    default:
                        return;
                }
            return;
            case 16:
                switch (j) {
                    case 1:
                        setCorHalogenio(r);
                        super.setNome("Fluor");
                        super.numeroAtomico = "9";
                        super.massaAtomica = "18,998";
                        r.setText("F");
                        r.dica1 = "É MUITO UTILIZADO POR DENTISTAS";
                        r.dica2 = "ENCONTRA-SE NA FAMÍLIA DOS HALOGÊNIOS";
                        r.dica3 = "É O ELEMENTO MAIS ELETRONEGATIVO DA TABELA PERIÓDICA";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 2:
                        setCorHalogenio(r);
                        super.setNome("Cloro");
                        super.numeroAtomico = "17";
                        super.massaAtomica = "35,45";
                        r.setText("Cl");
                        r.dica1 = "COMPÕE O SAL DE COZINHA";
                        r.dica2 = "ENCONTRA-SE NO TERCEIRO PERÍODO AO LADO DE UM GÁS NOBRE";
                        r.dica3 = "ESTÁ NA FAMÍLIA DOS HALOGÊNIOS";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 3:
                        setCorHalogenio(r);
                        super.setNome("Bromo");
                        super.numeroAtomico = "35";
                        super.massaAtomica = "79,904";
                        r.setText("Br");
                        break;
                    case 4:
                        setCorHalogenio(r);
                        super.setNome("Iodo");
                        super.numeroAtomico = "53";
                        super.massaAtomica = "126,90";
                        r.setText("I");
                        r.dica1 = "É UTILIZADO PARA REDUZIR OS EFEITOS DE ISÓTOPOS RADIOATIVOS";
                        r.dica2 = "COM SUA SUBLIMAÇÃO, É POSSÍVEL VIZUALIZAR IMPRESSÕES DIGITAIS";
                        r.dica3 = "É UM HALOGÊNIO DO QUINTO PERÍODO";
                        super.setDicas(dica1, dica2, dica3);
                        super.setArrayList(r);
                        break;
                    case 5:
                        setCorHalogenio(r);
                        super.setNome("Astato");
                        super.numeroAtomico = "85";
                        super.massaAtomica = "(210)";
                        r.setText("At");
                        break;
                    case 6:
                        setCorHalogenio(r);
                        super.setNome("Tenessino");
                        super.numeroAtomico = "117";
                        super.massaAtomica = "(294)";
                        r.setText("Ts");
                        break;
                    default:
                        return;
                }
            default:
                break;
        }
    }
    
    private void setCorSemiMetal(Representativos rep) {
        rep.setBackground(new Color(46, 139, 87, 150));
    }
    
    private void setCorAmetal(Representativos rep){
        rep.setBackground(new Color(188, 143, 143, 150));
    }
    
    private void setCorHalogenio(Representativos rep){
        rep.setBackground(new Color(255, 0, 0, 150));
    }
}
