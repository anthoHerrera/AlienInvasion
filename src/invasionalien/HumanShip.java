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
        motorIzq = new Polygon(Constants.X1_MOTOR_IZQ,Constants.Y1_MOTOR_IZQ,Constants.X2_MOTOR_IZQ,
                Constants.Y2_MOTOR_IZQ,Constants.X3_MOTOR_IZQ,Constants.Y3_MOTOR_IZQ);
        motorDer = new Polygon(Constants.X1_MOTOR_DER,Constants.Y1_MOTOR_DER,Constants.X2_MOTOR_DER,
                Constants.Y2_MOTOR_DER,Constants.X3_MOTOR_DER,Constants.Y3_MOTOR_DER);
        nave.setFill(Color.TURQUOISE);
        cabina.setFill(Color.LIGHTGRAY);
        motorIzq.setFill(Color.DARKKHAKI);
        motorDer.setFill(Color.DARKKHAKI);
        pane.getChildren().addAll(nave,cabina,motorIzq,motorDer);
        this.setXLoc(Constants.X_HUMAN_SHIP*10);
        this.setYLoc(Constants.Y_HUMAN_SHIP*2);
        
    }
    
    public void setXLoc(double x) {
        nave.setCenterX(x);
        cabina.setCenterX(x);
        motorIzq.setTranslateX(x);
        motorDer.setTranslateX(x);
    }
    
    public double getXLoc() {
        return nave.getCenterX();
    }
    
    public void setYLoc(double y) {
        nave.setCenterY(y);
        cabina.setCenterY(y - 10);
        motorIzq.setTranslateX(y);
        motorDer.setTranslateY(y - 32);
    }
    public double getYLoc() {
        return nave.getCenterY();
    }
}
