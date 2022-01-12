/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

/**
 *
 * @author jayme
 */
public class ElementosServidor {
    private String nome;
    private String dica1;
    private String dica2;
    private String dica3;
    
    public ElementosServidor(){
        nome = null;
        dica1 = null;
        dica2 = null;
        dica3 = null;
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
     * @return the dica1
     */
    public String getDica1() {
        return dica1;
    }

    /**
     * @param dica1 the dica1 to set
     */
    public void setDica1(String dica1) {
        this.dica1 = dica1;
    }

    /**
     * @return the dica2
     */
    public String getDica2() {
        return dica2;
    }

    /**
     * @param dica2 the dica2 to set
     */
    public void setDica2(String dica2) {
        this.dica2 = dica2;
    }

    /**
     * @return the dica3
     */
    public String getDica3() {
        return dica3;
    }

    /**
     * @param dica3 the dica3 to set
     */
    public void setDica3(String dica3) {
        this.dica3 = dica3;
    }
}
