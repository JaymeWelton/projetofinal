/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JanelaInicial;

import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

/**
 *
 * @author clistenes
 */
public class TelaInicial extends javax.swing.JFrame {
    Socket test;
    ArrayList<String> escolhidos = new ArrayList();
    Jogadores jogador;
    String[] dica1 = new String[10];
    String[] dica2 = new String[10];
    String[] dica3 = new String[10];
    int index = 0;
    Socket s;
    DataInputStream in;
    DataOutputStream out;
    JanelaPrincipal frame;
    /**
     * Creates new form Tela
     */
    public TelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnJogar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnJogar.setText("JOGAR");
        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnJogar)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnJogar)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogarActionPerformed
        try {
            //se conectando ao servidor;
            s = new Socket("localhost",4444);
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
            jogador = new Jogadores();
            
            //fechar TelaInicial;
            dispose();
            
            jogador.setNome(JOptionPane.showInputDialog(null, "Insira seu nome: ", "Informa??ao do Jogador", 1));
            out.writeUTF(jogador.getNome());
            //aguardando um novo cliente para iniciar a partida;
            //TeladeTransicao tt = new TeladeTransicao();
            //tt.setVisible(true);
            //System.out.println(MainServidor.count);
            
            //quando dois clientes se conect??o o jogo come??a;
            if(in.readUTF().equals("conectado")){
                
                while (index != 10) {
                    dica1[index] = in.readUTF();
                    dica2[index] = in.readUTF();
                    dica3[index] = in.readUTF();
                    if (dica1.length == 10 && dica2.length == 10 && dica3.length == 10) {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(dica1[i]);
                            System.out.println(dica2[i]);
                            System.out.println(dica3[i]);
                        }
                    }
                    index++;
                }
                //fechando a janela do transi????o.
                //tt.dispose();
                
                

                //instancia um frame do tipo TelaPilha;
                frame = new JanelaPrincipal(this, rootPaneCheckingEnabled, s, dica1, dica2, dica3);

                //passa o frame para a tela do jogo.
                frame.setFrame(frame);
                
                //torna o frame vis??vel;
                frame.setVisible(true);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "N??o foi poss??vel se conectar ao servidor", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnJogarActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJogar;
    // End of variables declaration//GEN-END:variables
}
