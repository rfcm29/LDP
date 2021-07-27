/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.socket.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import monopoly.modelos.Movimento;
import monopoly.modelos.Negocio;
import monopoly.modelos.Player;

/**
 *
 * @author rfcm2
 */
class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private final Server server;
    private String nome; 
    private ObjectOutputStream objOut = null;
    private ObjectInputStream objIn = null;
    
    ClientHandler(Socket socket, Server server) {
        this.clientSocket = socket;
        this.server = server;
        try{
            objOut = new ObjectOutputStream(clientSocket.getOutputStream());
            objIn = new ObjectInputStream(clientSocket.getInputStream());
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            this.nome = getClientName();
            Platform.runLater(() -> {
                server.clientNames.add(nome + " - " + clientSocket.getRemoteSocketAddress());
            });
            
            Object input;
            
            while(true){
                input = objIn.readObject();
                if(input instanceof Movimento){
                    server.enviaParaTodos(input);
                } else if(input instanceof Negocio){
                    
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getClientName() throws IOException, ClassNotFoundException {
        return (String) objIn.readObject();
    }

    void writeToClient(Object input) throws IOException {
        objOut.writeObject(input);
        objOut.flush();
    }
    
}
