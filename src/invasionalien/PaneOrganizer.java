/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasionalien;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author USER
 */
public class PaneOrganizer {
    private Pane root;
    private AlienShip naveAlien;
    private Jugador player;
    
    public PaneOrganizer() throws IOException {
        root = new VBox();
        //Pane paneScreen = new Pane();
        //naveAlien = new AlienShip(paneScreen);
        //player = new Jugador(paneScreen);
        //root.setCenter(paneScreen);
   
    }

    public Pane getRoot() {
        return root;
    }
  
}
