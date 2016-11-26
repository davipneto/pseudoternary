/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package pseudoternary;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 */
public class BinaryConverter {
    /**
     * Este método transforma um vetor que contém uma representação binária em String.
     * @param binario (Vetor de entrada, cada posição representa um bit).
     * @return nome (String formada pelo conjunto de binario do vetor de entrada).
     */
    public Integer[] BitTo2Bit(Integer[] bit){
        Integer[] saida = new Integer[2*bit.length];
        int i=0,s=0;
        while(i<bit.length){
            switch(bit[i]){
                case 0: saida[s]=saida[s+1]=0; break;
                case 1: saida[s]=0;saida[s+1]=1; break;
                case -1: saida[s]=saida[s+1]=1; break;
            }
            i++;
            s=s+2;
        }
        return saida;
    }
    
    public Integer[] TwoBitToBit(Integer[] twoBit){
        Integer[] saida = new Integer[twoBit.length/2];
        int i=0,s=0;
        while(s<twoBit.length){
            switch(twoBit[s]){
                case 1: saida[i]=-1; break;
                case 0:
                    if (twoBit[s+1]==0)
                        saida[i]=0;
                    else
                        saida[i]=1;
                    break;
            }
            i++;
            s=s+2;
        }
        return saida;
    }
    
    public String BinaryToText(Integer[] binario) {
        int letras = (binario.length / 8);
        char c[] = new char[binario.length];
        String nome;
        int j = 0, k = 0, l = 1, m = 0;
        int op = 0;
        //Aqui, estou percorrendo todo o vetorzão de 0's e 1's e separando 8 bits em números decimais
        while (k != binario.length) {
            //For é usado para percorrer o vetor de 8 em 8 posições e armazenar em OP.
            for (j = 0; j < 8; j++) {
                op += binario[k] * l;
                //L irá variar de 1|2|4|8|16|32|64|128, usada para resgatar o valor decimal dos 8 bits do vetor
                l = 2 * l;
                //K é a única variável que não é zerada, pois ela está percorrendo todo o vetorzão.
                k++;
            }
            //Aqui estou convertendo decimal para ASCII (A conversão é feita pelo próprio compilador)
            c[m] = (char) op;
            m++;
            //Feito o resgate do charactere, é preciso zerar as variáveis usadas dentro do FOR, para percorrer as próximas 8 posições
            op = 0;
            l = 1;

        }
        //aqui estou invertendo a ordem da string
        int tam = c.length;
        char[] aux = new char[c.length];
        for (int i = 0; i < aux.length; i++) {
            tam--;
            aux[i] = c[tam];
        }
        //Aqui eu estou copiando so a parte que interessa do vetor
        //Pois o tamanho do Vetor está maior, pois foi preciso para que se pudesse resgatar o código ASCII.
        c = Arrays.copyOfRange(aux, binario.length - letras, binario.length);        
        //aqui estou transformando o vetor de char em uma string
        nome = String.valueOf(c);        
        return nome;
    }
    /**
     * Este método transforma uma String em um vetor que contém sua representação binária
     * @param texto (String de entrada).
     * @return array (Vetor do Tipo Inteiro, cada posição representa um bit da String de entrada).
     */
    public Integer[] textToBinary(String texto) {
        int op = texto.length() * 8; //numero de characteres * numero de bits
        Integer[] array = new Integer[op];
        int j = 0, k = 0;
        
        //Loop principal, ele irá percorrer todos os caractéres da String texto
        for (char c : texto.toCharArray()) {
            //Aqui estou transformando em um vetorzão com todos os 0's e 1's
            while (j != 8) {
                //Aqui estou recebendo o valor binário dos caracteres
                //Utilizando A Biblioteca commons-lang3-3.5, estou preenchendo com 0's a esquerda, até completar 8 bits
                //Pois se não usar algo para preencher com 0's a esquerda, o tamanho representado fica variando.
                array[k] = Character.getNumericValue(StringUtils.leftPad(Integer.toBinaryString((c)), 8, "0").charAt(j));
                j++;
                k++;
            }
            j = 0;
        }
        //aqui estou invertendo a ordem da string
        //Pois caso não seja invertido, ficará armazenado ao contrário
        int tam = array.length;
        Integer[] aux = new Integer[op];
        for (int i = 0; i < aux.length; i++) {
            tam--;
            aux[i] = array[tam];
        }
        array = aux;
        return array;
    }

}
