/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JanelaInicial;

import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author jayme
 */
public class Botao extends JButton{ //Classe para o botao onde aparece o nome de cada elemento.
    public Botao(){
        super();
        super.removeMouseListener(super.getMouseListeners()[0]); //Remove todos os listeners desse botao para nao ser clicavel e essas coisas de botao.
        super.setFont(super.getFont().deriveFont(Font.PLAIN, 25)); //Fonte do botao
        super.setFocusPainted(false); //Nao deixa a borda aparecer ao ser selecionado pela tecla TAB
        super.setVisible(false); //Nao deixa visivel ate o mouse ser colocado em cima de um elemento
        super.setFocusable(false); //Nao deixa ser selecionado por tecla TAB
    }
}
