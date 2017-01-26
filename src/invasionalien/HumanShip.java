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
 *
 * @author USER
 */
public class HumanShip {
    private Ellipse nave;
    private Ellipse cabina;
    private Polygon motorIzq;
    private Polygon motorDer;

    public HumanShip(Pane pane) {
        nave = new Ellipse(Constants.X_HUMAN_SHIP, Constants.Y_HUMAN_SHIP);
        cabina = new Ellipse(Constants.X_CABINA, Constants.Y_CABINA);
        motorIzq = new Polygon(Constants.X1_MOTOR,Constants.Y1_MOTOR,Constants.X2_MOTOR,
                Constants.Y2_MOTOR,Constants.X3_MOTOR,Constants.Y3_MOTOR);
        motorDer = new Polygon(Constants.X1_MOTOR,Constants.Y1_MOTOR,Constants.X2_MOTOR,
                Constants.Y2_MOTOR,Constants.X3_MOTOR,Constants.Y3_MOTOR);
        nave.setFill(Color.TURQUOISE);
        cabina.setFill(Color.LIGHTGRAY);
        motorIzq.setFill(Color.DARKKHAKI);
        motorDer.setFill(Color.DARKKHAKI);
        pane.getChildren().addAll(nave,cabina,motorIzq,motorDer);
        this.setLocation(Constants.X_OFFSET,Constants.Y_OFFSET);
        
    }
    
    public void setLocation(double x,double y) {
        nave.setCenterX(x);
        nave.setCenterY(y);
        cabina.setCenterX(x);
        cabina.setCenterY(y - 10);
        motorIzq.setTranslateX(x - 25);
        motorIzq.setTranslateY(y - 5);
        motorDer.setTranslateX(x - 5);
        motorDer.setTranslateY(y - 5);
    }
    
    public double getXLoc() {
        return nave.getCenterX();
    }
  
    public double getYLoc() {
        return nave.getCenterY();
    }
}
