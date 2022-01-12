/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JanelaInicial;

import Servidor.ElementosServidor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.System.in;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author jayme
 */
public class Elementos extends JButton{
    private String nome; //Variavel que recebe o nome de cada elemento.
    ImageIcon imagem;
    String numeroAtomico, massaAtomica;
    String[] dicas = new String[3];
    JLabel label1, label2;
    ArrayList<Elementos> arrayElem;
    ArrayList<Elementos> botoesBloqueados = new ArrayList();
    Elementos botoesDesbloqueados;
    Botao legenda = new Botao();
    private ArrayList<ElementosServidor> elementos;
    int index = 0;
    
    public Elementos(JButton e, JButton n, ArrayList<Elementos> arrayElem, Socket s){ //Paineis que vem da Janela Principal.
        super();
        this.arrayElem = arrayElem;
        //super.removeMouseListener(super.getMouseListeners()[0]);
        super.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent me) {
            javax.swing.border.Border cor1 = BorderFactory.createLineBorder(getBackground(), 3);
            setBorder(cor1);
            e.setVisible(true); //Botao onde aparece o simbolo do elemento
            n.setVisible(true); //Botao onde aparece o nome do elemento
            e.setBackground(getBackground()); //Pega a cor do botao e joga no outro.
            //e.setIcon(imagem); //Coloca uma imagem do elemento no botao 
            n.setBackground(getBackground()); //Pega a cor do botao e joga no outro.
            e.setText(getText()); //Pegua o texto do botao e insere nesse botao (Apenas o simbolo)
            n.setText(nome); //Aqui, o botao recebe o nome real do elemento pelo metodo criado la em baixo.
            label1.setText(numeroAtomico); //Coloca o numero atomico do elemento.
            label2.setText(massaAtomica); //Coloca o numero atomico do elemento.
        }

        @Override
        public void mouseExited(MouseEvent me) {
            javax.swing.border.Border cor2 = BorderFactory.createLineBorder(null, 0);
            setBorder(cor2);
            e.setVisible(false); //Deixa invisivel quando o mouse sai de um botao
            n.setVisible(false); //Idem ao de cima.
            e.setBackground(null); //Apaga a cor de fundo
            n.setBackground(null); //Idem ao de cima
            e.setText(""); //Coloca uma string vazia ao botao.
            n.setText(""); //Idem ao de cima.
            label1.setText(""); //Retira o numero atomico do elemento.
            label2.setText(""); //Retira o numero atomico do elemento.
        }
        
        @Override
        public void mouseClicked(MouseEvent me){
            
            try {
                if(true){
                    System.out.println("CLIKEIIIIII");
                    System.out.println("ELEMENTOS_SOCKET = " + s);
                    //variaveis que se comunicam com o servidor;
                    DataInputStream in = new DataInputStream(s.getInputStream());
                    DataOutputStream out = new DataOutputStream(s.getOutputStream());
                    out.writeUTF(nome);
                    System.out.println("ENVIEI O NOME!!");
                    
                    /*
                    //entrada
                    new Thread(){
                        public void run(){
                            String entrada;
                            try {
                                while(true){
                                    entrada = in.readUTF();
                                    System.out.println("Resposta do Servidor: " + entrada);

                                    if(entrada.equals("acabou")){
                                        System.out.println("SÓ FALTA O JOGO FECHAR A JANELA!!!!!");
                                    }

                                    if(entrada.equalsIgnoreCase("acertou")){
                                        elementos.remove(0);
                                        JOptionPane.showMessageDialog(null, "VOCÊ ACERTOU !!", "PARABÉNS", JOptionPane.PLAIN_MESSAGE);
                                        while (!botoesBloqueados.isEmpty()) { //Tentando desbloquear os botoes mas nao funciona, teste aqui o que voce me falou no WhatsApp
                                            botoesDesbloqueados = botoesBloqueados.remove(0);
                                            botoesDesbloqueados.setEnabled(true);
                                            repaint();
                                        }
                                    }else{
                                        //bloqueia o botão;
                                        me.getComponent().setEnabled(false);
                                        me.getComponent().setBackground(null);
                                        botoesBloqueados.add((Elementos) me.getComponent());
                                        System.out.println("Tamanho da lista de botoes bloqueados: " + botoesBloqueados.size()); //Testa para ver se a lista de botoesBloqueados aumenta
                                    }
                                    //entrada
                                    System.out.println(nome); //Nao apague essa linha, eh importante.
                                }
                                   
                            } catch (IOException ex) {
                                Logger.getLogger(Elementos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }.start();
                    */
                    /*
                    String entrada = in.readUTF();
                    System.out.println("Resposta do Servidor: " + entrada);
                    
                    if(entrada.equalsIgnoreCase("acertou")){
                        elementos.remove(0);
                        JOptionPane.showMessageDialog(null, "VOCÊ ACERTOU !!", "PARABÉNS", JOptionPane.PLAIN_MESSAGE);
                        while (!botoesBloqueados.isEmpty()) { //Tentando desbloquear os botoes mas nao funciona, teste aqui o que voce me falou no WhatsApp
                            botoesDesbloqueados = botoesBloqueados.remove(0);
                            botoesDesbloqueados.setEnabled(true);
                            repaint();
                        }
                    }else{
                        //bloqueia o botão;
                        me.getComponent().setEnabled(false);
                        me.getComponent().setBackground(null);
                        botoesBloqueados.add((Elementos) me.getComponent());
                        System.out.println("Tamanho da lista de botoes bloqueados: " + botoesBloqueados.size()); //Testa para ver se a lista de botoesBloqueados aumenta
                    }
                    
                    //entrada
                    System.out.println(nome); //Nao apague essa linha, eh importante.
                    */
                    
                }
                    
            } catch (IOException ex) {
                Logger.getLogger(Elementos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        });
        super.setSize(55, 65);
        super.setLocation(10, 30);
        super.setFont(super.getFont().deriveFont(Font.PLAIN, 18));
        super.setFocusPainted(false);
        super.setVisible(true);
        super.setFocusable(false);
    }

    public void setNome(String nome) { //Aqui recebe o nome do elemento fornecido por cada janela (alcalinos, alcallinos-terrosos, etc) e joga nesse metodo.
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setImagem(ImageIcon imageIcon) {
        imagem = imageIcon;
    }
    
    public void setNumeroAtomico(JLabel l){
        label1 = l;
    }
    
    public String getNumeroAtomico(){
        return numeroAtomico;
    }
    
    public void setMassaAtomica(JLabel l){
        label2 = l;
    }
    
    public void setArrayList(Elementos e){
        arrayElem.add(e);
    }
    
    public void setDicas(String d1, String d2, String d3){
        dicas[0] = d1;
        dicas[1] = d2;
        dicas[2] = d3;
    }
    
    public String getDicas(Elementos e, int i){
        return e.dicas[i];
    }

    /**
     * @return the elementos
     */
    public ArrayList<ElementosServidor> getElementos() {
        return elementos;
    }

    /**
     * @param elementos the elementos to set
     */
    public void setElementos(ArrayList<ElementosServidor> elementos) {
        this.elementos = elementos;
    }
}
