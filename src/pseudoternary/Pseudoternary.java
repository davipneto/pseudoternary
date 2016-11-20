/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package pseudoternary;

/**
 *
 * @author Geovana Franco
 */
public class Pseudoternary {
    /**
     * Metodo encode é usado para Codificar o vetor de binarios
     * @param entrada (Vetor de Binarios que representa os dados de entrada).
     * @return saida (valor codificado, de tamanho duas vezes maior que a entrada).
     */
    public Integer[] encode(Integer entrada[]){
        Integer saida[]=new Integer[entrada.length];
        // System.out.println("tam "+entrada.length);
        int atual=1;
        
        for (int i = 0; i < entrada.length; i++)
        {
            if(entrada[i]==0){
                saida[i]=atual;
                atual=-atual;
            }
            else
                saida[i]=0;
        }
        return saida;
    }
    /**
     * Metodo decode é usado para decodificar o vetor codificado de binarios
     * @param entrada (valor codificado, de tamanho duas vezes maior que o tamanho original)
     * @return saida (Vetor de Binarios que representa os dados originais de entrada)
     */
    
    public  Integer[] decode(Integer entrada[]){
        Integer saida[]= new Integer[entrada.length];
 
        for (int i = 0; i < (entrada.length); i++)
        {
            if(entrada[i]==0)
                saida[i]=1;
            else
                saida[i]=0;
        }
        
        return saida;
    }
    
}
