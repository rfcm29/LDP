/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.socket.server;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author rfcm2
 */
public class ServerFXMLController implements Initializable {
    
    private static ArrayList<Thread> threads;
    

    @FXML
    private Button iniciaServer;
    @FXML
    private TextField port;
    @FXML
    private TextField nJogadores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        threads = new ArrayList<>();
    }

    @FXML
    private void iniciarServer(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        try {
            Server server = new Server(Integer.parseInt(port.getText()), Integer.parseInt(nJogadores.getText()));
            Thread serverThread = new Thread(server);
            serverThread.setName("Server Thread");
            serverThread.start();
            threads.add(serverThread);
            stage.hide();
            stage.setScene(criarNovaUI(server));
            stage.show();
        } catch (IllegalArgumentException | IllegalStateException | IOException ex) {
            Logger.getLogger(ServerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Scene criarNovaUI(Server server) {
        
        GridPane rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setPadding(new Insets(20));
        rootPane.setHgap(10);
        rootPane.setVgap(10);

        Label logLabel = new Label("Server Log");
        ListView<String> logView = new ListView<>();
        //ObservableList<String> logList = server.log.getLog();
        //logView.setItems(logList);

        Label clientLabel = new Label("Clients Connected");
        ListView<String> clientView = new ListView<>();
        ObservableList<String> clientList = server.clientNames;
        clientView.setItems(clientList);
        
        rootPane.add(logLabel, 0, 0);   
        rootPane.add(logView, 0, 1);
        rootPane.add(clientLabel, 0, 2);
        rootPane.add(clientView, 0, 3);
        
        return new Scene(rootPane, 400, 600);
    }
    
}
