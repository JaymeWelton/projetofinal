package Servidor;

import java.net.Socket;

/**
 *
 * @author aluno
 */
public class FilaArray {
       
    private Socket conteudo[];
    private int inicio;
    private int fim, nElementos, cu = 0;

    public void setFim(int fim) {
        this.fim = fim;
    }

    public int getFim() {
        return fim;
    }
    
    public void setInicio(int valor){
        inicio = valor;
    }
    
    public int getInicio(){
        return inicio;
    }

    //instancia a fila; construtor;
    public FilaArray(){
        int tam = 100;
        conteudo = new Socket[tam];
        fim = -1;
        nElementos = 0;
    }
    
    //verifica se a fila está vazia;
    public boolean vazio(){
        if(nElementos == 0)
            return true;
        else
            return false;
    }
    
    //obter o tamanho da fila;
    /**
     * informa o numero de elementos que a fila contém.
     * @return 
     */
    public int tamanhoFila(){
        return nElementos;
    }
    
    //consultar elemento do topo;
    /**
     * returna o elemento que se encontra na posição passada pelo paramento.
     * @param elem
     * @return 
     */
    public Socket consultaElem(int elem){
        return conteudo[elem - 1];
    }
    
    //inserir um novo elemento no topo da lista;
    /**
     * Insere o Socket no final da fila.
     * @param elemento
     * @return 
     */
    public boolean insereElem(Socket elemento){

            conteudo[++fim] = elemento;    //insere elemento;
            nElementos++;
            return true;        
    }
    
    //remover elemento;
    /**
     * remove o primeiro elemento da fila.
     * @return 
     */
    public Socket removeElem(){
        if(vazio()) //se a fila estiver vazio será lançado uma excessão;
            return null;
        else
            nElementos--;
            return conteudo[cu++];    //remove o elemento do inicio;
    }  
}