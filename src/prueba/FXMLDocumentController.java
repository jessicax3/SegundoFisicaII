/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 *
 * @author Jess
 */
public class FXMLDocumentController implements Initializable {

    
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnIniciar;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Pane paneview;
    @FXML
    private HBox botones;


    @FXML
    private void botonSalir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void botonContinuar(ActionEvent event) throws IOException{

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/prueba/Problem.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
        
    }


    

    

}
