/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasionalien;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;

/**
 * Clase que representa una nave humana
 * @author AnthonyHerrera
 */
public class HumanShip {
    private Ellipse nave;
    private Ellipse cabina;
    private Polygon motorIzq;
    private Polygon motorDer;
    private Bullet bullet;
    /**
     * Construye la nave humana y la agrega al pane que la contendra
     * @param pane donde se encontrara la nave
     */
    public HumanShip(Pane pane) {
        nave = new Ellipse(Constants.X_HUMAN_SHIP, Constants.Y_HUMAN_SHIP);
        cabina = new Ellipse(Constants.X_CABINA, Constants.Y_CABINA);
        motorIzq = new Polygon(Constants.X1_MOTOR,Constants.Y1_MOTOR,Constants.X2_MOTOR,
                Constants.Y2_MOTOR,Constants.X3_MOTOR,Constants.Y3_MOTOR);
        motorDer = new Polygon(Constants.X1_MOTOR,Constants.Y1_MOTOR,Constants.X2_MOTOR,
                Constants.Y2_MOTOR,Constants.X3_MOTOR,Constants.Y3_MOTOR);
        bullet = new Bullet(false);
        this.setupHumanShip();
        pane.getChildren().addAll(nave,cabina,motorIzq,motorDer);
        this.setLocation(Constants.X_OFFSET);
        
    }
    /**
    Agrega color a los componetes que forman la nave
    */
    private void setupHumanShip() {
        nave.setFill(Color.TURQUOISE);
        cabina.setFill(Color.LIGHTGRAY);
        motorIzq.setFill(Color.DARKKHAKI);
        motorDer.setFill(Color.DARKKHAKI);
    }
    /**
     * Setea la posicion de la nave
     * @param x nueva posicion donde se encontrara la nave
     */
    public void setLocation(double x) {
        nave.setCenterX(x);
        nave.setCenterY(Constants.Y_OFFSET);
        cabina.setCenterX(x);
        cabina.setCenterY(Constants.Y_OFFSET - 10);
        motorIzq.setTranslateX(x - 25);
        motorIzq.setTranslateY(Constants.Y_OFFSET - 5);
        motorDer.setTranslateX(x - 5);
        motorDer.setTranslateY(Constants.Y_OFFSET - 5);
        bullet.setXlocation(x);
    }
    
    public double getXLoc() {
        return nave.getCenterX();
    }
  
    public double getYLoc() {
        return nave.getCenterY();
    }

}
