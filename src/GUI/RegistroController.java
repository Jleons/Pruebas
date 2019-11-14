/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
//Inicio sesión
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import main.EstructurasDeDatos;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class RegistroController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML // fx:id="user_cedula"
    private TextField user_cedula; // Value injected by FXMLLoader

    @FXML // fx:id="enter"
    private Button enter; // Value injected by FXMLLoader

    @FXML // fx:id="user_password"
    private PasswordField user_password; // Value injected by FXMLLoader

    @FXML // fx:id="Nueva_cuenta"
    private Label Nueva_cuenta; // Value injected by FXMLLoader

    @FXML
    void Registro(MouseEvent event) {
        // EstructurasDeDatos.changeScene("new_account");
    }

    @FXML
    void login(ActionEvent event) {
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
 
    
    
}
