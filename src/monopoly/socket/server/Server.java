/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rfcm2
 */
public final class Server implements Runnable{
    private final int porta;
    private final int numeroJogadores;
    private ServerSocket serverSocket;
    private final List<ClientHandler> jogadores;
    
    protected ObservableList<String> clientNames;
    
    public Server(int porta, int numeroJogadores) throws IllegalArgumentException, IllegalStateException, IOException {
        if(porta <= 1024) throw new IllegalArgumentException("Numero de porta deve ser um numero positivo maior que 1024"); // para evitar problemas com permissoes administrativas
        if(numeroJogadores <= 1) throw new IllegalArgumentException("Numero de jogadores deve ser um numero positivo maior que 1"); // nao vamos jogar sozinhos ne?
        
        this.porta = porta;
        this.numeroJogadores = numeroJogadores;
        this.serverSocket = null;
        this.jogadores = new ArrayList<>();
        
        clientNames = FXCollections.observableArrayList();
    }

    @Override
    public void run() {
        try{
            if(serverSocket != null) throw new IllegalStateException("Servidor ja se encontra a correr!");

            serverSocket = new ServerSocket(porta);

            for(int index=0; index < this.numeroJogadores; index++) {
                Socket cliente = serverSocket.accept();
                System.out.println("Novo Cliente conectado");
                ClientHandler socketCliente = new ClientHandler(cliente, this);
                jogadores.add(socketCliente);
                new Thread(socketCliente).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public final void enviarMensagem() {
        
    }
    
    public final void parar() {
        
    }
    
    public void enviaParaTodos(Object input){
        for(ClientHandler cl: jogadores){
            cl.writeToClient(input);
        }
    }
    
    public void enviaParaUm(){
        
    }

    /**
     *
     * @return
     */
    public List<ClientHandler> getJogadores() {
        return jogadores;
    }
}
