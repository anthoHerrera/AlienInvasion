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
 *
 * @author USER
 */
public class AlienShip {
    private Ellipse nave;
    private Rectangle alaIzq;
    private Rectangle alaDer;
    private Ellipse cabina;
    
    public AlienShip(Pane pane) {
        nave = new Ellipse(Constants.X_ALIEN_SHIP,Constants.Y_ALIEN_SHIP);
        cabina = new Ellipse(Constants.X_CABINA, Constants.Y_CABINA);
        alaIzq = new Rectangle(Constants.WIDHT_ALA_AS,Constants.HEIGHT_ALA_AS);
        alaDer = new Rectangle(Constants.WIDHT_ALA_AS,Constants.HEIGHT_ALA_AS);
        nave.setFill(Color.BLACK);
        cabina.setFill(Color.GREY);
        alaIzq.setFill(Color.ROSYBROWN);
        alaDer.setFill(Color.ROSYBROWN);
        pane.getChildren().addAll(nave,cabina,alaIzq,alaDer);
        this.setXLoc(Constants.X_ALIEN_SHIP*2);
        this.setYLoc(Constants.Y_ALIEN_SHIP*2);
        
    }
    
    public void setXLoc(double x) {
        nave.setCenterX(x);
        cabina.setCenterX(x);
        alaIzq.setTranslateX(x - 20);
        alaDer.setTranslateX(x + 15);
    }
    
    public double getXLoc() {
        return nave.getCenterX();
    }
    
    public void setYLoc(double y) {
        nave.setCenterY(y);
        cabina.setCenterY(y);
        alaIzq.setTranslateY(y - 15);
        alaDer.setTranslateY(y - 15);
    }
    public double getYLoc() {
        return nave.getCenterY();
    }
}
