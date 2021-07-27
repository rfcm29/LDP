/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author rfcm2
 */
public class JogoControllerController implements Initializable {

    @FXML
    private Button lancarDadosButton;
    @FXML
    private Button terminarTurnoButton;
    @FXML
    private Label dinheiroJogador;
    @FXML
    private Label preco;
    @FXML
    private Button comprarButton;
    @FXML
    private Button hipotecarButton;
    @FXML
    private Button construirButton;
    @FXML
    private Label aluguer;
    @FXML
    private Label hipoteca;
    @FXML
    private Label precoConstrucao;
    @FXML
    private Label nCasas;
    @FXML
    private Label dono;
    @FXML
    private Label nomeCasa;
    @FXML
    private Label jogador1;
    @FXML
    private Label dados;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void lancarDados(ActionEvent event) {
    }

    @FXML
    private void terminarTurno(ActionEvent event) {
    }
    
}
