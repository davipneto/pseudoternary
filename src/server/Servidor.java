/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import pseudoternary.BinaryConverter;
import pseudoternary.Pseudoternary;

/**
 *
 * @author Marlon Prudente <marlonoliveira@alunos.utfpr.edu.br>
 * 
 */
public class Servidor {
    /**
     * Método principal da Classe Servidor
     * Usado para Iniciar uma conexão com o cliente
     * Limitado para somente uma conexão simultânea 
     */
    public static void main(String[] args) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket SocketServidor = new ServerSocket(12345);
                /**
         * Variaveis para a decodificador Manchester*
         */
        Pseudoternary m = new Pseudoternary();
        Integer array[], decriptografado[], crip2bit[];
        BinaryConverter bc = new BinaryConverter();
        /*==============================*/
        
        System.out.println("Porta 12345 aberta!");        
        
        while (true) {
            //Aqui a conexão é feita, o servidor recebe um cliente somente, e se obtiver sucesso, mostra a mensagem de conexão
            Socket connectionSocketCliente = SocketServidor.accept();
            System.out.println("Nova conexão com o cliente: " + connectionSocketCliente.getInetAddress().getHostAddress());
            //Aqui o servidor sempre estará esperando dados do cliente, e exibe o dado na tela
            Scanner s = new Scanner(connectionSocketCliente.getInputStream());
            //Loop Principal, onde o Servidor estará sempre esperando envios do Cliente.
            while (s.hasNextLine()) {
                int i;
                crip2bit = bc.textToBinary(s.nextLine());
                array = bc.TwoBitToBit(crip2bit);
                //Aqui é possivel ver o texto criptografado pelo Pseudoternary
                System.out.println("Recebido: ");
                for(i=0;i<array.length;i++){
                    System.out.print(array[i]);
                }
                System.out.println();
                decriptografado = m.decode(array);
                //Aqui é possivel ver o resultado após a descriptografia do Pseudoternary
                System.out.println("Decriptografado: " + bc.BinaryToText(decriptografado));
            }
            
            s.close();
            //S é a variavel que esta recebendo strings do cliente, deve ser encerrada sempre que a conexao encerrar
            
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocketCliente.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocketCliente.getOutputStream());

            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase();
            outToClient.writeBytes(capitalizedSentence);

        }
    }
}
