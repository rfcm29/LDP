/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import monopoly.socket.server.Server;

/**
 *
 * @author rfcm2
 */
public class FXMLDocumentController implements Initializable {
    
    private Button criarJogo;
    @FXML
    private Button conectar;
    
    private void handleButtonAction(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void criarJogo(ActionEvent event) throws IOException {
        
        Parent lobby = FXMLLoader.load(getClass().getResource("socket/server/ServerFXML.fxml"));
        
        Scene sceneLobby = new Scene(lobby);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneLobby);
        window.show();
    }

    @FXML
    private void conectarJogo(ActionEvent event) throws IOException {
        Parent lobby = FXMLLoader.load(getClass().getResource("socket/client/ClientFXML.fxml"));
        
        Scene sceneLobby = new Scene(lobby);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneLobby);
        window.show();
    }
    
}
