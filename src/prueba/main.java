
package prueba;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Jess
 */

public class main extends Application {
private Stage primaryStage;   
    
    
    @Override
    public void start(Stage primaryStage) throws IOException{
      
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));       
        Scene scene = new Scene(root,700,490,Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();  
   
        
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
