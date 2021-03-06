/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import JanelaInicial.JanelaPrincipal;
import JanelaInicial.Jogadores;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author clistenes
 */
public class Servidor implements Runnable {
    Socket s, oponent;
    static ArrayList<ElementosServidor> arrayElem; //ArrayList com 40 elementos com dicas.
    static ArrayList<ElementosServidor> escolhidos; //ArrayList com os elementos escolhidos.
    static ElementosServidor elem;
    static String[] dica1 = new String[10];
    static String[] dica2 = new String[10];
    static String[] dica3 = new String[10];
    static String nomeJogador1, nomeJogador2;
    static int ponto1 = 0, ponto2 = 0;
    //metodo construtor.
     public Servidor(Socket ns, Socket oponente){
        this.s = ns;
        this.oponent = oponente;
    }
    
    @Override
    public void run(){
        arrayElem = new ArrayList();
        escolhidos = new ArrayList();
        tabelaPeriodica(arrayElem, escolhidos);
        
        
        try {     
            //Cliente 1;
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Protocolo protocolo = new Protocolo(escolhidos);
            
            //Cliente 2;
            String cliente2;
            DataInputStream inOponent = new DataInputStream(oponent.getInputStream());
            DataOutputStream outOponent = new DataOutputStream(oponent.getOutputStream());
            
            //lendo
            nomeJogador1 = in.readUTF();
            nomeJogador2 = inOponent.readUTF();
            
            
            //passando as dicas dos elementos escolhidos para o jogador.
            for (int i = 0; i < escolhidos.size(); i++) {
                out.writeUTF(dica1[i]);
                out.writeUTF(dica2[i]);
                out.writeUTF(dica3[i]);
                outOponent.writeUTF(dica1[i]);
                outOponent.writeUTF(dica2[i]);
                outOponent.writeUTF(dica3[i]);
            }
            
            
            //escrevendo
            out.writeUTF(nomeJogador1);
            out.writeUTF(nomeJogador2);
            outOponent.writeUTF(nomeJogador2);
            outOponent.writeUTF(nomeJogador1);
            out.writeUTF(String.valueOf(ponto1));
            out.writeUTF(String.valueOf(ponto2));
            outOponent.writeUTF(String.valueOf(ponto2));
            outOponent.writeUTF(String.valueOf(ponto1));
            
            //testando servidor;
            System.out.println("SERVIDOR - CLIENTE 1: " + s);
            System.out.println("SERVIDOR - CLIENTE 2: " + oponent);
            

            new Thread(){
                public void run(){
                    String cliente1;
                    while (true) {
                        try {
                            
                            //recebe uma mensagem do cliente1.
                            cliente1 = in.readUTF();
           
                            //processa as mensagens.
                            String processo1 = protocolo.ProcessLine(cliente1);
                            //String processo2 = protocolo.ProcessLine(cliente1);
                            
                            if(processo1.equals("acabou 10")){
                                
                                out.writeUTF(processo1);
                                outOponent.writeUTF(processo1 + " jogador");
                            }
                            else if(processo1.equals("acertou")){

                                
                                //envia os pontos.
                                ponto1 += 10;
                                
                                //manda essa mensagem processada para os clientes.
                                out.writeUTF("acertou pontos " + String.valueOf(ponto1));
                                outOponent.writeUTF("acertou jogador pontos " + String.valueOf(ponto1));
                            }
                            
                            else{
                                //manda essa mensagem processada para os clientes.
                                out.writeUTF("errou");
                                outOponent.writeUTF("errou");

                            }
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }.start();
            
            
            while(true){
                //testa o servidor.
                System.out.println("SERVIDOR - ESTOU LENDO");
                
                //recebe uma mensagem do cliente2.
                cliente2 = inOponent.readUTF();
                
                //processa as mensagens.
                String process1 = protocolo.ProcessLine(cliente2);
                //String process2 = protocolo.ProcessLine(cliente2);
                            
                //printa essa mensagem.
                System.out.println(cliente2);
                
                if(process1.equals("acabou 10")){
                    outOponent.writeUTF(process1);
                    out.writeUTF(process1 + " jogador");
                    
                }else if (process1.equals("acertou")){

                    
                    //envia os pontos.
                    ponto2 += 10;
                    
                    //enviar uma resposta para os clientes.
                    outOponent.writeUTF("acertou pontos " + ponto2);
                    out.writeUTF("acertou jogador pontos " + ponto2);
                    
                    
                }
                else{
                    outOponent.writeUTF("errou");
                    out.writeUTF("errou");
                }
                
                //testa o servidor
                System.out.println("SERVIDOR - CHEGUEI NO FINAL");
            }
            
        } catch (IOException ex) {
            
        }
    
    }
    
    //passa todas as dicas para o array e seleciona os 10 elementos da partida.
    static public void tabelaPeriodica(ArrayList array, ArrayList esc) { //Aqui eu crio a lista com os e40 elementos e depois lan??o para a JanelaPrincipal.
        for (int i = 1; i < 41; i++) {
            elem = new ElementosServidor();
            switch (i) {
                case 1:
                    elem.setNome("Hidrogenio");
                    elem.setDica1("UTILIZADO COMO COMBUST??VEL PARA FOGUETES.");
                    elem.setDica2("POSSUI O MENOR RAIO AT??MICO DA TABELA PERI??DICA.");
                    elem.setDica3("POSSUI UM ??NICO PR??TON.");
                    array.add(elem);
                    break;
                case 2:
                    elem.setNome("Sodio");
                    elem.setDica1("UM DOS COMPONETES DO SAL DE COZINHA.");
                    elem.setDica2("?? UM METAL ALCALINO QUE EXPLODE EM CONTATO COM A ??GUA.");
                    elem.setDica3("POSSUI TR??S CAMADAS ENERG??TICAS.");
                    array.add(elem);
                    break;
                case 3:
                    elem.setNome("Potassio");
                    elem.setDica1("?? UM METAL DO QUARTO PER??ODO.");
                    elem.setDica2("?? UTILIZADO EM ADUBOS QU??MICOS.");
                    elem.setDica3("EST?? NO GRUPO DOS METAIS ALCALINOS.");
                    array.add(elem);
                    break;
                case 4:
                    elem.setNome("Magnesio");
                    elem.setDica1("UTILIZADOS EM RODAS DE LIGA LEVE.");
                    elem.setDica2("?? DA FAM??LIA DOS METAIS ALCALINO-TERROSOS.");
                    elem.setDica3("POSSUI TR??S CAMADAS ENERG??TICAS.");
                    array.add(elem);
                    break;
                case 5:
                    elem.setNome("Calcio");
                    elem.setDica1("COMP??E OS NOSSOS OSSOS E ?? UTILIZADO NO GESSO.");
                    elem.setDica2("SUA DISTRIBUI????O ELETR??NICA TERMINA EM s??.");
                    elem.setDica3("POSSUI QUATRO CAMADAS ENERG??TICAS.");
                    array.add(elem);
                    break;
                case 6:
                    elem.setNome("Estroncio");
                    elem.setDica1("UTILIZADO EM FOGOS DE ARTIF??CIO.");
                    elem.setDica2("POSSUI O TERCEIRO MAIOR RAIO AT??MICO NA FAM??LIA DOS METAIS ALCALINO-TERROSOS.");
                    elem.setDica3("UTILIZADO EM TINTAS QUE BRILHAM NO ESCURO.");
                    array.add(elem);
                    break;
                case 7:
                    elem.setNome("Bario");
                    elem.setDica1("SEU RAIO AT??MICO ?? MAIOR QUE O DO OURO.");
                    elem.setDica2("POSSUI SEIS CAMADAS ENERG??TICAS.");
                    elem.setDica3("?? UM METAL ALCALINO???TERROSSO USADO EM FOGOS DE ARTIF??CIO E CHAPAS DE EST??MAGO.");
                    array.add(elem);
                    break;
                case 8:
                    elem.setNome("Titanio");
                    elem.setDica1("?? UTILIZADO COMO PINO PARA FRATURAS.");
                    elem.setDica2("?? UM METAL DE TRANSI????O DO 4?? PER??ODO.");
                    elem.setDica3("SUA CONFIGURA????O ELETR??NICA TERMINA EM d??.");
                    array.add(elem);
                    break;
                case 9:
                    elem.setNome("Cromio");
                    elem.setDica1("?? UM METAL DE TRANSI????O.");
                    elem.setDica2("UTILIZADO NO PROCESSO DE GALVANOPLASTIA.");
                    elem.setDica3("PERTENCE ?? FAM??LIA 6 E POSSUI O MENOR RAIO ATOMICO DENTRE ESTES.");
                    array.add(elem);
                    break;
                case 10:
                    elem.setNome("Tungstenio");
                    elem.setDica1("?? UM METAL DO 6 PERIODO E COM O MAIOR PONTO DE FUSAO DE TODOS. (+5000 ??C).");
                    elem.setDica2("?? O ELEMENTO MAIS DENSO DE TODA A TABELA PERIODICA.");
                    elem.setDica3("ESTA LOCALIZADO NA FAM??LIA 6, ESSE METAL ?? MUITO UTILIZADO EM SUPERLIGAS ALTAMENTE RESISTENTES.");
                    array.add(elem);
                    break;
                case 11:
                    elem.setNome("Manganes");
                    elem.setDica1("POSSUI QUATRO CAMADAS ENERG??TICAS.");
                    elem.setDica2("ELE ?? UTILIZADO EM COFRES.");
                    elem.setDica3("SUA CONFIGURA????O ELETR??NICA TERMINA EM d???.");
                    array.add(elem);
                    break;
                case 12:
                    elem.setNome("Ferro");
                    elem.setDica1("?? UM METAL DE TRANSI????O.");
                    elem.setDica2("MUITO UTILIZADO EM PORT??ES.");
                    elem.setDica3("POSSUI N??MERO AT??MICO IGUAL A 26.");
                    array.add(elem);
                    break;
                case 13:
                    elem.setNome("Iridio");
                    elem.setDica1("UTILIZADO EM AGULHAS DE INJE????O.");
                    elem.setDica2("?? UM METAL DE TRANSI????O.");
                    elem.setDica3("SUA CONFIGURA????O ELETR??NICA TERMINA EM 5d???.");
                    array.add(elem);
                    break;
                case 14:
                    elem.setNome("Paladio");
                    elem.setDica1("?? UTILIZADO EM PR??TESES DENT??RIAS.");
                    elem.setDica2("EST?? LOCALIZADO NO QUINTO PER??ODO.");
                    elem.setDica3("POSSUI RAIO ATOMICO MAIOR DO QUE O DA PRATA.");
                    array.add(elem);
                    break;
                case 15:
                    elem.setNome("Platina");
                    elem.setDica1("ENCONTRA-SE NO SEXTO PER??ODO.");
                    elem.setDica2("MUITO UTILIZADO NO PROCESSO DE RECUPERA????O DE FRATURA ??SSEA.");
                    elem.setDica3("SEU RAIO AT??MICO ?? MAIOR QUE O DO OURO.");
                    array.add(elem);
                    break;
                case 16:
                    elem.setNome("Cobre");
                    elem.setDica1("?? MUITO UTILIZADO EM FIA????ES EL??TRICAS.");
                    elem.setDica2("?? UM METAL DO QUARTO PER??ODO.");
                    elem.setDica3("EST?? LOCALIZADO NA FAM??LIA ONZE.");
                    array.add(elem);
                    break;
                case 17:
                    elem.setNome("Prata");
                    elem.setDica1("?? USADO EM BIJUTERIAS, TALHERES, ETC.");
                    elem.setDica2("?? UM METAL DE TRANSI????O.");
                    elem.setDica3("ELEMENTO USADO NA FABRICA??AO DE ESPELHOS.");
                    array.add(elem);
                    break;
                case 18:
                    elem.setNome("Ouro");
                    elem.setDica1("?? UM METAL DE TRANSI??AO.");
                    elem.setDica2("MUITO UTILIZADO EM JOIAS.");
                    elem.setDica3("EST?? LOCALIZADO NO SEXTO PER??ODO DA FAM??LIA 11.");
                    array.add(elem);
                    break;
                case 19:
                    elem.setNome("Zinco");
                    elem.setDica1("SEU RAIO AT??MICO ?? MAIOR QUE O DO G??S NOBRE CRIPT??NIO.");
                    elem.setDica2("?? UM METAL DE TRANSI????O UTILIZADO NA FABRICA????O DE CALHAS.");
                    elem.setDica3("POSSUI QUATRO CAMADAS ENERG??TICAS E ENCONTRA-SE NA FAM??LIA DOZE.");
                    array.add(elem);
                    break;
                case 20:
                    elem.setNome("Mercurio");
                    elem.setDica1("MUITO UTILIZADO EM COLUNAS DE TERM??METRO.");
                    elem.setDica2("TEM O MESMO NOME DE UM PLANETA DO SISTEMA SOLAR.");
                    elem.setDica3("METAL ENCONTRADO NO ESTADO L??QUIDO NA TEMPERATURA AMBIENTE.");
                    array.add(elem);
                    break;
                case 21:
                    elem.setNome("Aluminio");
                    elem.setDica1("?? UM METAL DO TERCEIRO PER??ODO.");
                    elem.setDica2("?? UTILIZADO EM LATINHAS RECICL??VEIS.");
                    elem.setDica3("ENCONTRA-SE NA FAM??LIA DO BORO.");
                    array.add(elem);
                    break;
                case 22:
                    elem.setNome("Galio");
                    elem.setDica1("UTILIZADO NAS TELAS DE TV.");
                    elem.setDica2("POSSUI QUATRO CAMADAS ENERG??TICAS.");
                    elem.setDica3("SEU NOME LEMBRA ???GALILEU???.");
                    array.add(elem);
                    break;
                case 23:
                    elem.setNome("Carbono");
                    elem.setDica1("CONSTITUINTE DA GRAFITE E DO DIAMENTE.");
                    elem.setDica2("POSSUI DUAS CAMADAS ENERG??TICAS.");
                    elem.setDica3("?? UM AMETAL.");
                    array.add(elem);
                    break;
                case 24:
                    elem.setNome("Flerovio");
                    elem.setDica1("SEU TEMPO DE MEIA VIDA ?? MENOR DO QUE UM SEGUNDO.");
                    elem.setDica2("PERTENCE ?? FAM??LIA DO CARBONO.");
                    elem.setDica3("POSSUI SETE CAMADAS ENERG??TICAS.");
                    array.add(elem);
                    break;
                case 25:
                    elem.setNome("Nitrogenio");
                    elem.setDica1("?? UM G??S MAS PODE SER ENCONTRADO NO ESTADO L??QUIDO SENDO UTILIZADO NA CONSERVA????O DE MATERIAIS EM TEMPERATURAS MUITO BAIXAS.");
                    elem.setDica2("POSSUI DUAS CAMADAS ENERG??TICAS.");
                    elem.setDica3("ENCONTRA-SE NO GRUPO VIZINHO ?? FAM??LIA DO CARBONO.");
                    array.add(elem);
                    break;
                case 26:
                    elem.setNome("Fosforo");
                    elem.setDica1("AMETAL COM TR??S CAMADAS ENERG??TICAS.");
                    elem.setDica2("ENCONTRADO DENTRO DE CAIXINHAS PEQUENAS.");
                    elem.setDica3("EM NOSSA COZINHA PODE NOS AJUDAR A CONSEGUIR FOGO.");
                    array.add(elem);
                    break;
                case 27:
                    elem.setNome("Antimonio");
                    elem.setDica1("UTILIZADO EM SOMBRAS PARA OS OLHOS (MAQUIAGEM).");
                    elem.setDica2("SEMIMETAL DO 5?? PER??ODO.");
                    elem.setDica3("ELE ?? MAIS ELETRONEGATIVO DO QUE O ESTANHO E MENOS DO QUE O ARS??NIO.");
                    array.add(elem);
                    break;
                case 28:
                    elem.setNome("Oxigenio");
                    elem.setDica1("SEM ELE N??O EXISTIRA A COMBUST??O.");
                    elem.setDica2("?? UM AMETAL DO 2?? PER??ODO.");
                    elem.setDica3("O SEGUNDO ELEMENTO MAIS ELETRONEGATIVO DA TABELA.");
                    array.add(elem);
                    break;
                case 29:
                    elem.setNome("Enxofre");
                    elem.setDica1("?? ENCOTRADO EM CONSERVANTES DE FOGOS DE ARTIF??CIO.");
                    elem.setDica2("?? UM N??O METAL DA FAMILIA DO OXIGENIO.");
                    elem.setDica3("SEU S??MBOLO ENCONTRA-SE NA ROUPA DO SUPER-HOMEM.");
                    array.add(elem);
                    break;
                case 30:
                    elem.setNome("Selenio");
                    elem.setDica1("ELEMENTO UTILIZADO EM XAMPU ANTI-CASPA.");
                    elem.setDica2("AMETAL DO 4?? PER??ODO.");
                    elem.setDica3("EST?? NA FAM??LIA DO OXIGENIO.");
                    array.add(elem);
                    break;
                case 31:
                    elem.setNome("Telurio");
                    elem.setDica1("ENCONTRADO EM PROTE????O PARA CHUMBO DE ACUMULADORES DE BATERIA.");
                    elem.setDica2("?? UM SEMIMETAL N??O RADIATIVO.");
                    elem.setDica3("EST?? NA FAM??LIA DO OXIGENIO.");
                    array.add(elem);
                    break;
                case 32:
                    elem.setNome("Polonio");
                    elem.setDica1("?? UM SEMI-METAL RADIOATIVO QUE FOI DESCOBERTO POR MARIE CORRIE.");
                    elem.setDica2("PERTENCE ?? FAM??LIA DO OXIGENIO.");
                    elem.setDica3("SEU N??MERO AT??MICO ANTECEDE O DO ASTATO.");
                    array.add(elem);
                    break;
                case 33:
                    elem.setNome("Livermorio");
                    elem.setDica1("FOI UM DOS ??LTIMOS ELEMENTOS A SEREM RECONHECIDOS PELA IUPAC.");
                    elem.setDica2("ESTA NA FAM??LIA DO OXIGENIO.");
                    elem.setDica3("POSSUI SETE CAMADAS ENERG??TICAS.");
                    array.add(elem);
                    break;
                case 34:
                    elem.setNome("Fluor");
                    elem.setDica1("?? MUITO UTILIZADO POR DENTISTAS.");
                    elem.setDica2("ENCONTRA-SE NA FAM??LIA DO FLUOR.");
                    elem.setDica3("?? O ELEMENTO MAIS ELETRONEGATIVO DA TABELA PERI??DICA.");
                    array.add(elem);
                    break;
                case 35:
                    elem.setNome("Cloro");
                    elem.setDica1("COMP??E O SAL DE COZINHA.");
                    elem.setDica2("ENCONTRA-SE NO TERCEIRO PER??ODO AO LADO DE UM G??S NOBRE.");
                    elem.setDica3("EST?? NA FAM??LIA DO FLUOR.");
                    array.add(elem);
                    break;
                case 36:
                    elem.setNome("Iodo");
                    elem.setDica1("?? UTILIZADO PARA REDUZIR OS EFEITOS DE IS??TOPOS RADIOATIVOS.");
                    elem.setDica2("COM SUA SUBLIMA????O, ?? POSS??VEL VIZUALIZAR IMPRESS??ES DIGITAIS.");
                    elem.setDica3("ENCONTRA-SE NA FAMILIA DO FLUOR E NO QUINTO PER??ODO.");
                    array.add(elem);
                    break;
                case 37:
                    elem.setNome("Neonio");
                    elem.setDica1("UTILIZADO EM ILUMINA????O DE PLACAS DE PROPAGANDAS.");
                    elem.setDica2("ELEMENTO NA FAM??LIA DOS ELEMENTOS NOBRES.");
                    elem.setDica3("ELEMENTO DO 2?? PER??ODO.");
                    array.add(elem);
                    break;
                case 38:
                    elem.setNome("Argonio");
                    elem.setDica1("?? UTILIZADO EM L??MPADAS INCANDESCENTES.");
                    elem.setDica2("ENCONTRA-SE NO TERCEIRO PER??ODO.");
                    elem.setDica3("N??O INTERAGE COM NENHUM ELEMENTO DA TABELA PERI??DICA.");
                    array.add(elem);
                    break;
                case 39:
                    elem.setNome("Xenonio");
                    elem.setDica1("UTILIZADO EM L??MPADAS PARA BRONZEAMENTO ARTIFICIAL.");
                    elem.setDica2("EST?? NO 5?? PER??ODO.");
                    elem.setDica3("ELEMENTO QUE FAZ PARTE DOS GASES NOBRES.");
                    array.add(elem);
                    break;
                case 40:
                    elem.setNome("Radonio");
                    elem.setDica1("POSSUI O MENOR RAIO AT??MICO DO PER??ODO SEIS.");
                    elem.setDica2("UTILIZADO EM SISM??GRAFOS.");
                    elem.setDica3("POSSUI A CAMADA DE VAL??NCIA COMPLETA.");
                    array.add(elem);
                    break;
                default:
                    continue;
            }
        }
        System.out.println("Tamanho da lista com todos os elementos: " + arrayElem.size()); //Verifica se a llista tem os 40 elementos.
        
        int index = 0;
        ElementosServidor elem;
        while (esc.size() != 10) { //Escolhe aleatoriamente 10 elementos para come??ar o jogo.
            index = (int) (Math.random() * 40);
            elem = (ElementosServidor) array.get(index);

            if (esc.isEmpty()) { //Adiciona o 1?? elemento.
                esc.add(elem);
            }else{
                if (!esc.contains(elem)) { //Testa se o elemento escolhido ja esta dentro da lista.
                    esc.add(elem);
                }
            }
        }
        toString(esc);
    }
    /**
     *
     * @param elem
     */
    static public void toString(ArrayList<ElementosServidor> elem){
        
        for (int i = 0; i < elem.size(); i++) {
            dica1[i] = elem.get(i).getDica1();
            dica2[i] = elem.get(i).getDica2();
            dica3[i] = elem.get(i).getDica3();
        }
        
        /*System.out.println("Tamanho do array de dicas: " + aux1.length);
        System.out.println("Tamanho do array de dicas: " + aux1[0]);
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Dicas 1 dos elementos: " + aux1[i]);
            System.out.println("Dicas 2 dos elementos: " + aux2[i]);
            System.out.println("Dicas 3 dos elementos: " + aux3[i]);
        }*/
    }
}
