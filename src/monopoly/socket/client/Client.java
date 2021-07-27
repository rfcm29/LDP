/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.socket.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import monopoly.modelos.Movimento;
import monopoly.modelos.Negocio;

/**
 *
 * @author rfcm2
 */
public class Client implements Runnable, Serializable{
       
    private final String hostName;
    private final int porta;
    private final String nome;
    private final Socket clientSocket;
    private ObjectOutputStream objOut;
    private ObjectInputStream objIn;
    

    public Client(String hostName, int porta, String nome) throws IOException {
        this.hostName = hostName;
        this.porta = porta;
        this.nome = nome;
        this.clientSocket = new Socket(hostName, porta);
        this.objOut = new ObjectOutputStream(clientSocket.getOutputStream());
        this.objIn = new ObjectInputStream(clientSocket.getInputStream());
        this.objOut.flush();
        
        this.objOut.writeObject(this.nome);
        this.objOut.flush();
    }

    @Override
    public void run() {
        while(true){
            final Object input;
            try {
                input = objIn.readObject();
                
                if(input instanceof Movimento){
                
                } else if(input instanceof Negocio){
                    
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
