/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasionalien;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * La clase principal del juego
 * @author AnthonyHerrera
 */
public class InvasionAlien extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        SceneOrganizer organizer = new SceneOrganizer(primaryStage);
        organizer.getWindow().setTitle("Invasion Alien!");
        organizer.getWindow().show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
