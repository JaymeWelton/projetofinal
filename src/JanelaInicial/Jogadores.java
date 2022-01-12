/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JanelaInicial;

/**
 *
 * @author jayme
 */
public class Jogadores {
    private String nome;
    private String pontos;
    
    public Jogadores(){
        nome = null;
        pontos = "0";
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the pontos
     */
    public String getPontos() {
        return pontos;
    }

    /**
     * @param pontos the pontos to set
     */
    public void setPontos(String pontos) {
        this.pontos = pontos;
    }
}
