/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.socket.client;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rfcm2
 */
public class ClientFXMLController implements Initializable {
    
    private Client client;
    
    private ArrayList<Thread> threads = new ArrayList<>();
    
    @FXML
    private TextField nome;
    @FXML
    private TextField hostName;
    @FXML
    private TextField porta;
    @FXML
    private Button entrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void joinGame(ActionEvent event) {
        try{
            client = new Client(hostName.getText(), Integer.parseInt(porta.getText()), nome.getText());
            Thread clientThread = new Thread(client);
            clientThread.start();
            threads.add(clientThread);
        } catch(IOException e){
            
        }
    }
    
}
