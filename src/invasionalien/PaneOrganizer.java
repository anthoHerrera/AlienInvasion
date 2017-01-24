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
        InputStream is = Files.newInputStream(Paths.get("Fondos/alieninvasion.png"));
        BackgroundImage imm = new BackgroundImage(new Image(is,640,500, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        root.setBackground(new Background(imm));
        this.setupPane();
   
    }

    public Pane getRoot() {
        return root;
    }

    
    private void setupPane(){
        Label titulo = new Label("Alien invasion!");
        Button jugarBtn = new Button("Jugar");
        Button intruccioneBtn = new Button("Instrucciones");
        Button scoreBtn = new Button("Scores");
        jugarBtn.setPrefSize(100, 30);
        intruccioneBtn.setPrefSize(100, 30);
        scoreBtn.setPrefSize(100, 30);
        titulo.setTextFill(Color.GREENYELLOW);
        titulo.setFont(new Font("Harrington", 40));
        titulo.setStyle("");
        intruccioneBtn.setOnAction(new instructionHandler());
        root.getChildren().addAll(titulo,jugarBtn,intruccioneBtn,scoreBtn);
    }
    
    private class instructionHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            
            TextArea instructions = new TextArea();
            String instrucciones = "El jugador tiene un numero limitado de misiles por nivel (10 por cada nivel)\n" +
                    "Con respecto a las teclas, M permitirá disparar los misiles y con barra espaciadora disparo las balas.\n" +
                    "Con P puedo pausar el juego.\n" +
                    "Con E empiezo el juego.\n" +
                    "Con las teclas <- -> me muevo de derecha a izquierda\n" +
                    "Con la tecla Escape se sale del juego.";
            instructions.setText(instrucciones);
            instructions.setFont(new Font("times new roman", 16));
            Button volverBtn = new Button("Volver");
            volverBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    for(Node n: root.getChildren()) {
                        n.setVisible(true);
                    }
                    root.getChildren().remove(instructions);
                    root.getChildren().remove(volverBtn);
                    
                }
            });
            for(Node n: root.getChildren()) {
                n.setVisible(false);
            }
            root.getChildren().addAll(instructions,volverBtn);
            
        }
        
    }
}
