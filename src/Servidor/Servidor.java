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
    static public void tabelaPeriodica(ArrayList array, ArrayList esc) { //Aqui eu crio a lista com os e40 elementos e depois lanço para a JanelaPrincipal.
        for (int i = 1; i < 41; i++) {
            elem = new ElementosServidor();
            switch (i) {
                case 1:
                    elem.setNome("Hidrogenio");
                    elem.setDica1("UTILIZADO COMO COMBUSTÍVEL PARA FOGUETES.");
                    elem.setDica2("POSSUI O MENOR RAIO ATÔMICO DA TABELA PERIÓDICA.");
                    elem.setDica3("POSSUI UM ÚNICO PRÓTON.");
                    array.add(elem);
                    break;
                case 2:
                    elem.setNome("Sodio");
                    elem.setDica1("UM DOS COMPONETES DO SAL DE COZINHA.");
                    elem.setDica2("É UM METAL ALCALINO QUE EXPLODE EM CONTATO COM A ÁGUA.");
                    elem.setDica3("POSSUI TRÊS CAMADAS ENERGÉTICAS.");
                    array.add(elem);
                    break;
                case 3:
                    elem.setNome("Potassio");
                    elem.setDica1("É UM METAL DO QUARTO PERÍODO.");
                    elem.setDica2("É UTILIZADO EM ADUBOS QUÍMICOS.");
                    elem.setDica3("ESTÁ NO GRUPO DOS METAIS ALCALINOS.");
                    array.add(elem);
                    break;
                case 4:
                    elem.setNome("Magnesio");
                    elem.setDica1("UTILIZADOS EM RODAS DE LIGA LEVE.");
                    elem.setDica2("É DA FAMÍLIA DOS METAIS ALCALINO-TERROSOS.");
                    elem.setDica3("POSSUI TRÊS CAMADAS ENERGÉTICAS.");
                    array.add(elem);
                    break;
                case 5:
                    elem.setNome("Calcio");
                    elem.setDica1("COMPÕE OS NOSSOS OSSOS E É UTILIZADO NO GESSO.");
                    elem.setDica2("SUA DISTRIBUIÇÃO ELETRÔNICA TERMINA EM s².");
                    elem.setDica3("POSSUI QUATRO CAMADAS ENERGÉTICAS.");
                    array.add(elem);
                    break;
                case 6:
                    elem.setNome("Estroncio");
                    elem.setDica1("UTILIZADO EM FOGOS DE ARTIFÍCIO.");
                    elem.setDica2("POSSUI O TERCEIRO MAIOR RAIO ATÔMICO NA FAMÍLIA DOS METAIS ALCALINO-TERROSOS.");
                    elem.setDica3("UTILIZADO EM TINTAS QUE BRILHAM NO ESCURO.");
                    array.add(elem);
                    break;
                case 7:
                    elem.setNome("Bario");
                    elem.setDica1("SEU RAIO ATÔMICO É MAIOR QUE O DO OURO.");
                    elem.setDica2("POSSUI SEIS CAMADAS ENERGÉTICAS.");
                    elem.setDica3("É UM METAL ALCALINO–TERROSSO USADO EM FOGOS DE ARTIFÍCIO E CHAPAS DE ESTÔMAGO.");
                    array.add(elem);
                    break;
                case 8:
                    elem.setNome("Titanio");
                    elem.setDica1("É UTILIZADO COMO PINO PARA FRATURAS.");
                    elem.setDica2("É UM METAL DE TRANSIÇÃO DO 4º PERÍODO.");
                    elem.setDica3("SUA CONFIGURAÇÃO ELETRÔNICA TERMINA EM d².");
                    array.add(elem);
                    break;
                case 9:
                    elem.setNome("Cromio");
                    elem.setDica1("É UM METAL DE TRANSIÇÃO.");
                    elem.setDica2("UTILIZADO NO PROCESSO DE GALVANOPLASTIA.");
                    elem.setDica3("PERTENCE À FAMÍLIA 6 E POSSUI O MENOR RAIO ATOMICO DENTRE ESTES.");
                    array.add(elem);
                    break;
                case 10:
                    elem.setNome("Tungstenio");
                    elem.setDica1("É UM METAL DO 6 PERIODO E COM O MAIOR PONTO DE FUSAO DE TODOS. (+5000 ºC).");
                    elem.setDica2("É O ELEMENTO MAIS DENSO DE TODA A TABELA PERIODICA.");
                    elem.setDica3("ESTA LOCALIZADO NA FAMÍLIA 6, ESSE METAL É MUITO UTILIZADO EM SUPERLIGAS ALTAMENTE RESISTENTES.");
                    array.add(elem);
                    break;
                case 11:
                    elem.setNome("Manganes");
                    elem.setDica1("POSSUI QUATRO CAMADAS ENERGÉTICAS.");
                    elem.setDica2("ELE É UTILIZADO EM COFRES.");
                    elem.setDica3("SUA CONFIGURAÇÃO ELETRÔNICA TERMINA EM d⁵.");
                    array.add(elem);
                    break;
                case 12:
                    elem.setNome("Ferro");
                    elem.setDica1("É UM METAL DE TRANSIÇÃO.");
                    elem.setDica2("MUITO UTILIZADO EM PORTÕES.");
                    elem.setDica3("POSSUI NÚMERO ATÔMICO IGUAL A 26.");
                    array.add(elem);
                    break;
                case 13:
                    elem.setNome("Iridio");
                    elem.setDica1("UTILIZADO EM AGULHAS DE INJEÇÃO.");
                    elem.setDica2("É UM METAL DE TRANSIÇÃO.");
                    elem.setDica3("SUA CONFIGURAÇÃO ELETRÔNICA TERMINA EM 5d⁷.");
                    array.add(elem);
                    break;
                case 14:
                    elem.setNome("Paladio");
                    elem.setDica1("É UTILIZADO EM PRÓTESES DENTÁRIAS.");
                    elem.setDica2("ESTÁ LOCALIZADO NO QUINTO PERÍODO.");
                    elem.setDica3("POSSUI RAIO ATOMICO MAIOR DO QUE O DA PRATA.");
                    array.add(elem);
                    break;
                case 15:
                    elem.setNome("Platina");
                    elem.setDica1("ENCONTRA-SE NO SEXTO PERÍODO.");
                    elem.setDica2("MUITO UTILIZADO NO PROCESSO DE RECUPERAÇÃO DE FRATURA ÓSSEA.");
                    elem.setDica3("SEU RAIO ATÔMICO É MAIOR QUE O DO OURO.");
                    array.add(elem);
                    break;
                case 16:
                    elem.setNome("Cobre");
                    elem.setDica1("É MUITO UTILIZADO EM FIAÇÕES ELÉTRICAS.");
                    elem.setDica2("É UM METAL DO QUARTO PERÍODO.");
                    elem.setDica3("ESTÁ LOCALIZADO NA FAMÍLIA ONZE.");
                    array.add(elem);
                    break;
                case 17:
                    elem.setNome("Prata");
                    elem.setDica1("É USADO EM BIJUTERIAS, TALHERES, ETC.");
                    elem.setDica2("É UM METAL DE TRANSIÇÃO.");
                    elem.setDica3("ELEMENTO USADO NA FABRICAÇAO DE ESPELHOS.");
                    array.add(elem);
                    break;
                case 18:
                    elem.setNome("Ouro");
                    elem.setDica1("É UM METAL DE TRANSIÇAO.");
                    elem.setDica2("MUITO UTILIZADO EM JOIAS.");
                    elem.setDica3("ESTÁ LOCALIZADO NO SEXTO PERÍODO DA FAMÍLIA 11.");
                    array.add(elem);
                    break;
                case 19:
                    elem.setNome("Zinco");
                    elem.setDica1("SEU RAIO ATÔMICO É MAIOR QUE O DO GÁS NOBRE CRIPTÔNIO.");
                    elem.setDica2("É UM METAL DE TRANSIÇÃO UTILIZADO NA FABRICAÇÃO DE CALHAS.");
                    elem.setDica3("POSSUI QUATRO CAMADAS ENERGÉTICAS E ENCONTRA-SE NA FAMÍLIA DOZE.");
                    array.add(elem);
                    break;
                case 20:
                    elem.setNome("Mercurio");
                    elem.setDica1("MUITO UTILIZADO EM COLUNAS DE TERMÔMETRO.");
                    elem.setDica2("TEM O MESMO NOME DE UM PLANETA DO SISTEMA SOLAR.");
                    elem.setDica3("METAL ENCONTRADO NO ESTADO LÍQUIDO NA TEMPERATURA AMBIENTE.");
                    array.add(elem);
                    break;
                case 21:
                    elem.setNome("Aluminio");
                    elem.setDica1("É UM METAL DO TERCEIRO PERÍODO.");
                    elem.setDica2("É UTILIZADO EM LATINHAS RECICLÁVEIS.");
                    elem.setDica3("ENCONTRA-SE NA FAMÍLIA DO BORO.");
                    array.add(elem);
                    break;
                case 22:
                    elem.setNome("Galio");
                    elem.setDica1("UTILIZADO NAS TELAS DE TV.");
                    elem.setDica2("POSSUI QUATRO CAMADAS ENERGÉTICAS.");
                    elem.setDica3("SEU NOME LEMBRA “GALILEU”.");
                    array.add(elem);
                    break;
                case 23:
                    elem.setNome("Carbono");
                    elem.setDica1("CONSTITUINTE DA GRAFITE E DO DIAMENTE.");
                    elem.setDica2("POSSUI DUAS CAMADAS ENERGÉTICAS.");
                    elem.setDica3("É UM AMETAL.");
                    array.add(elem);
                    break;
                case 24:
                    elem.setNome("Flerovio");
                    elem.setDica1("SEU TEMPO DE MEIA VIDA É MENOR DO QUE UM SEGUNDO.");
                    elem.setDica2("PERTENCE À FAMÍLIA DO CARBONO.");
                    elem.setDica3("POSSUI SETE CAMADAS ENERGÉTICAS.");
                    array.add(elem);
                    break;
                case 25:
                    elem.setNome("Nitrogenio");
                    elem.setDica1("É UM GÁS MAS PODE SER ENCONTRADO NO ESTADO LÍQUIDO SENDO UTILIZADO NA CONSERVAÇÃO DE MATERIAIS EM TEMPERATURAS MUITO BAIXAS.");
                    elem.setDica2("POSSUI DUAS CAMADAS ENERGÉTICAS.");
                    elem.setDica3("ENCONTRA-SE NO GRUPO VIZINHO À FAMÍLIA DO CARBONO.");
                    array.add(elem);
                    break;
                case 26:
                    elem.setNome("Fosforo");
                    elem.setDica1("AMETAL COM TRÊS CAMADAS ENERGÉTICAS.");
                    elem.setDica2("ENCONTRADO DENTRO DE CAIXINHAS PEQUENAS.");
                    elem.setDica3("EM NOSSA COZINHA PODE NOS AJUDAR A CONSEGUIR FOGO.");
                    array.add(elem);
                    break;
                case 27:
                    elem.setNome("Antimonio");
                    elem.setDica1("UTILIZADO EM SOMBRAS PARA OS OLHOS (MAQUIAGEM).");
                    elem.setDica2("SEMIMETAL DO 5º PERÍODO.");
                    elem.setDica3("ELE É MAIS ELETRONEGATIVO DO QUE O ESTANHO E MENOS DO QUE O ARSÊNIO.");
                    array.add(elem);
                    break;
                case 28:
                    elem.setNome("Oxigenio");
                    elem.setDica1("SEM ELE NÃO EXISTIRA A COMBUSTÃO.");
                    elem.setDica2("É UM AMETAL DO 2º PERÍODO.");
                    elem.setDica3("O SEGUNDO ELEMENTO MAIS ELETRONEGATIVO DA TABELA.");
                    array.add(elem);
                    break;
                case 29:
                    elem.setNome("Enxofre");
                    elem.setDica1("É ENCOTRADO EM CONSERVANTES DE FOGOS DE ARTIFÍCIO.");
                    elem.setDica2("É UM NÃO METAL DA FAMILIA DO OXIGENIO.");
                    elem.setDica3("SEU SÍMBOLO ENCONTRA-SE NA ROUPA DO SUPER-HOMEM.");
                    array.add(elem);
                    break;
                case 30:
                    elem.setNome("Selenio");
                    elem.setDica1("ELEMENTO UTILIZADO EM XAMPU ANTI-CASPA.");
                    elem.setDica2("AMETAL DO 4º PERÍODO.");
                    elem.setDica3("ESTÁ NA FAMÍLIA DO OXIGENIO.");
                    array.add(elem);
                    break;
                case 31:
                    elem.setNome("Telurio");
                    elem.setDica1("ENCONTRADO EM PROTEÇÃO PARA CHUMBO DE ACUMULADORES DE BATERIA.");
                    elem.setDica2("É UM SEMIMETAL NÃO RADIATIVO.");
                    elem.setDica3("ESTÁ NA FAMÍLIA DO OXIGENIO.");
                    array.add(elem);
                    break;
                case 32:
                    elem.setNome("Polonio");
                    elem.setDica1("É UM SEMI-METAL RADIOATIVO QUE FOI DESCOBERTO POR MARIE CORRIE.");
                    elem.setDica2("PERTENCE À FAMÍLIA DO OXIGENIO.");
                    elem.setDica3("SEU NÚMERO ATÔMICO ANTECEDE O DO ASTATO.");
                    array.add(elem);
                    break;
                case 33:
                    elem.setNome("Livermorio");
                    elem.setDica1("FOI UM DOS ÚLTIMOS ELEMENTOS A SEREM RECONHECIDOS PELA IUPAC.");
                    elem.setDica2("ESTA NA FAMÍLIA DO OXIGENIO.");
                    elem.setDica3("POSSUI SETE CAMADAS ENERGÉTICAS.");
                    array.add(elem);
                    break;
                case 34:
                    elem.setNome("Fluor");
                    elem.setDica1("É MUITO UTILIZADO POR DENTISTAS.");
                    elem.setDica2("ENCONTRA-SE NA FAMÍLIA DO FLUOR.");
                    elem.setDica3("É O ELEMENTO MAIS ELETRONEGATIVO DA TABELA PERIÓDICA.");
                    array.add(elem);
                    break;
                case 35:
                    elem.setNome("Cloro");
                    elem.setDica1("COMPÕE O SAL DE COZINHA.");
                    elem.setDica2("ENCONTRA-SE NO TERCEIRO PERÍODO AO LADO DE UM GÁS NOBRE.");
                    elem.setDica3("ESTÁ NA FAMÍLIA DO FLUOR.");
                    array.add(elem);
                    break;
                case 36:
                    elem.setNome("Iodo");
                    elem.setDica1("É UTILIZADO PARA REDUZIR OS EFEITOS DE ISÓTOPOS RADIOATIVOS.");
                    elem.setDica2("COM SUA SUBLIMAÇÃO, É POSSÍVEL VIZUALIZAR IMPRESSÕES DIGITAIS.");
                    elem.setDica3("ENCONTRA-SE NA FAMILIA DO FLUOR E NO QUINTO PERÍODO.");
                    array.add(elem);
                    break;
                case 37:
                    elem.setNome("Neonio");
                    elem.setDica1("UTILIZADO EM ILUMINAÇÃO DE PLACAS DE PROPAGANDAS.");
                    elem.setDica2("ELEMENTO NA FAMÍLIA DOS ELEMENTOS NOBRES.");
                    elem.setDica3("ELEMENTO DO 2º PERÍODO.");
                    array.add(elem);
                    break;
                case 38:
                    elem.setNome("Argonio");
                    elem.setDica1("É UTILIZADO EM LÂMPADAS INCANDESCENTES.");
                    elem.setDica2("ENCONTRA-SE NO TERCEIRO PERÍODO.");
                    elem.setDica3("NÃO INTERAGE COM NENHUM ELEMENTO DA TABELA PERIÓDICA.");
                    array.add(elem);
                    break;
                case 39:
                    elem.setNome("Xenonio");
                    elem.setDica1("UTILIZADO EM LÂMPADAS PARA BRONZEAMENTO ARTIFICIAL.");
                    elem.setDica2("ESTÁ NO 5º PERÍODO.");
                    elem.setDica3("ELEMENTO QUE FAZ PARTE DOS GASES NOBRES.");
                    array.add(elem);
                    break;
                case 40:
                    elem.setNome("Radonio");
                    elem.setDica1("POSSUI O MENOR RAIO ATÔMICO DO PERÍODO SEIS.");
                    elem.setDica2("UTILIZADO EM SISMÓGRAFOS.");
                    elem.setDica3("POSSUI A CAMADA DE VALÊNCIA COMPLETA.");
                    array.add(elem);
                    break;
                default:
                    continue;
            }
        }
        System.out.println("Tamanho da lista com todos os elementos: " + arrayElem.size()); //Verifica se a llista tem os 40 elementos.
        
        int index = 0;
        ElementosServidor elem;
        while (esc.size() != 10) { //Escolhe aleatoriamente 10 elementos para começar o jogo.
            index = (int) (Math.random() * 40);
            elem = (ElementosServidor) array.get(index);

            if (esc.isEmpty()) { //Adiciona o 1º elemento.
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
