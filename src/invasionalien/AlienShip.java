/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasionalien;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * Esta clase crea una nave alien para el juego
 * @author AnthonyHerrera
 */
public class AlienShip implements Runnable{
    private Ellipse nave;
    private Rectangle alaIzq;
    private Rectangle alaDer;
    private Ellipse cabina;
    /**
     * Construye la nave alien y la agrega al pane que la contendra
     * @param pane donde se encontrara la nave
     */
    public AlienShip(Pane pane) {
        nave = new Ellipse(Constants.X_ALIEN_SHIP,Constants.Y_ALIEN_SHIP);
        cabina = new Ellipse(Constants.X_CABINA, Constants.Y_CABINA);
        alaIzq = new Rectangle(Constants.WIDHT_ALA_AS,Constants.HEIGHT_ALA_AS);
        alaDer = new Rectangle(Constants.WIDHT_ALA_AS,Constants.HEIGHT_ALA_AS);
        this.setupAlienShip();
        pane.getChildren().addAll(nave,cabina,alaIzq,alaDer);
        this.setLocation(Constants.X_OFFSET,Constants.Y_OFFSET);
        
    }
    /**
     * Agrega color a los componentes que forman la nave
     */
    private void setupAlienShip() {
        nave.setFill(Color.BLACK);
        cabina.setFill(Color.GREY);
        alaIzq.setFill(Color.ROSYBROWN);
        alaDer.setFill(Color.ROSYBROWN);
    }
    /**
     * Setea la posicion de la nave alien
     * @param x nueva posicion en X
     * @param y nueva posicion en Y
     */
    public void setLocation(double x,double y) {
        nave.setCenterX(x);
        nave.setCenterY(y);
        cabina.setCenterX(x);
        cabina.setCenterY(y);
        alaIzq.setTranslateX(x - 20);
        alaIzq.setTranslateY(y - 15);
        alaDer.setTranslateX(x + 15);
        alaDer.setTranslateY(y - 15);
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
    /**
    Mueve la nave dentro del pane
    */
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
