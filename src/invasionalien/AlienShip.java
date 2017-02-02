/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasionalien;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Esta clase crea una nave alien para el juego
 * @author AnthonyHerrera
 */
public class AlienShip implements Runnable{
    private Ellipse nave;
    private Ellipse ventana_1;
    private Ellipse ventana_2;
    private Ellipse ventana_3;
    private boolean alive;
    /**
     * Construye la nave alien y la agrega al pane que la contendra
     * @param pane donde se encontrara la nave
     */
    public AlienShip(Pane pane,boolean alive,double x,double y) {
        nave = new Ellipse(Constants.X_ALIEN_SHIP,Constants.Y_ALIEN_SHIP);
        ventana_1 = new Ellipse(Constants.X_CABINA, Constants.Y_CABINA);
        ventana_2 = new Ellipse(Constants.X_CABINA, Constants.Y_CABINA);
        ventana_3 = new Ellipse(Constants.X_CABINA, Constants.Y_CABINA);
        this.alive = alive;
        this.setupAlienShip();
        pane.getChildren().addAll(nave,ventana_1,ventana_2,ventana_3);
        this.setLocation(x,y);
        
    }
    /**
     * Agrega color a los componentes que forman la nave
     */
    private void setupAlienShip() {
        nave.setFill(Color.WHITESMOKE);
        ventana_1.setFill(Color.SILVER);
        ventana_2.setFill(Color.SILVER);
        ventana_3.setFill(Color.SILVER);
    }
    /**
     * Setea la posicion de la nave alien
     * @param x nueva posicion en X
     * @param y nueva posicion en Y
     */
    public void setLocation(double x,double y) {
        nave.setCenterX(nave.getCenterX() + x);
        nave.setCenterY(nave.getCenterY() + y);
        ventana_1.setCenterX(nave.getCenterX() + x);
        ventana_1.setCenterY(nave.getCenterY() + y);
        ventana_2.setCenterX((nave.getCenterX() + 10) + x);
        ventana_2.setCenterY((nave.getCenterY() - 6) + y);
        ventana_3.setCenterX((nave.getCenterX() - 10) + x);
        ventana_3.setCenterY((nave.getCenterY() - 6) + y);
        
    }
    
    /**
     * Devuelve la posicion X actual de la nave
     * @return la posicion X actual de la nave
     */
    public double getXLoc() {
        return nave.getCenterX();
    }
    /**
     * Devuelve la posicion Y actual de la nave
     * @return la posicion Y actual de la nave
     */
    public double getYLoc() {
        return nave.getCenterY();
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public void setVisible(boolean visible) {
        nave.setVisible(visible);
        ventana_1.setVisible(visible);
        ventana_2.setVisible(visible);
        ventana_3.setVisible(visible);
    }
    /**
    Mueve la nave dentro del pane
    */
    @Override
    public void run() {
        while(isAlive()) {
            setLocation(Constants.ZERO, Constants.MOVE);
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(AlienShip.class.getName()).log(Level.SEVERE, null, ex);
            }
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if(nave.getCenterY() > Constants.LIMITE_INFERIOR) {
                        setVisible(false);
                        setAlive(false);
                    }
                }
            });
        }
    }
}
