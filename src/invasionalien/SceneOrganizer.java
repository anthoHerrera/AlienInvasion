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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class SceneOrganizer {
    private final Stage window;
    private Scene scenePrincipal,jugarScene,instructionsScene,scoresScene;
    private VBox rootMain,rootInstruction;

    public SceneOrganizer(Stage stage) throws IOException {
        window = stage;
        this.setupSceneMain();
        this.setupSceneInstruction();
        window.setScene(scenePrincipal);
        
    }
    
    private void setupSceneMain() throws IOException{
        rootMain = new VBox();
        InputStream is = Files.newInputStream(Paths.get("Fondos/alieninvasion.png"));
        BackgroundImage imm = new BackgroundImage(new Image(is,640,500, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        rootMain.setBackground(new Background(imm));
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
        intruccioneBtn.setOnAction(e -> window.setScene(instructionsScene));
        rootMain.setAlignment(Pos.CENTER);
        rootMain.setSpacing(20);
        rootMain.getChildren().addAll(titulo,jugarBtn,intruccioneBtn,scoreBtn);
        scenePrincipal = new Scene(rootMain, Constants.APP_WIDHT, Constants.APP_HEIGHT);
    }
    
    private void setupSceneJugar() {
        
    }
    
    private void setupSceneInstruction() throws IOException {
        rootInstruction = new VBox();
        TextArea instructions = new TextArea();
        String instrucciones = "+ El jugador tiene un numero limitado de misiles por nivel (10 por cada nivel)\n" +
                "+ Con respecto a las teclas, M permitirá disparar los misiles y con barra espaciadora disparo las balas.\n" +
                "+ Con P puedo pausar el juego.\n" +
                "+ Con E empiezo el juego.\n" +
                "+ Con las teclas <- -> me muevo de derecha a izquierda\n" +
                "+ Con la tecla Escape se sale del juego.";
        instructions.setText(instrucciones);
        instructions.setFont(new Font("times new roman", 16));
        Button volverBtn = new Button("Volver");
        volverBtn.setPrefSize(50, 20);
        volverBtn.setOnAction(e -> window.setScene(scenePrincipal));
        rootInstruction.getChildren().addAll(instructions,volverBtn);
        rootInstruction.setAlignment(Pos.CENTER);
        rootInstruction.setSpacing(20);
        InputStream is = Files.newInputStream(Paths.get("Fondos/alieninvasion.png"));
        BackgroundImage imm = new BackgroundImage(new Image(is,640,500, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        rootInstruction.setBackground(new Background(imm));
        instructionsScene = new Scene(rootInstruction, Constants.APP_WIDHT,Constants.APP_HEIGHT);
    }
    
    private void setupSceneScores() {
        
    }

    public Stage getWindow() {
        return window;
    }
    
}
