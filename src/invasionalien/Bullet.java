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
 * Esta clase representa una bala
 * @author AnthonyHerrera
 */
public class Bullet implements Runnable{
    private Ellipse bala;
    private boolean activate;
    
    public Bullet(Pane pane,boolean activate,double x,double y) {
        this.bala = new Ellipse(Constants.X_BULLET,Constants.Y_BULLET);
        this.activate = activate;
        bala.setFill(Color.BURLYWOOD);
        pane.getChildren().add(bala);
        this.setXlocation(x);
        this.setYlocation(y);
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
    
    public void setXlocation(double x) {
        bala.setCenterX(x);
    }
    
    public void setYlocation(double y) {
        bala.setCenterY(bala.getCenterY() + y);
    }
    
    public void setLocation(double x,double y) {
        bala.setCenterX(x);
        bala.setCenterY(y);
    }
    
    @Override
    public void run() {
        while(isActivate()) {
            setYlocation(Constants.MOVE_BULLET);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if(bala.getCenterY() < Constants.LIMITE_SUPERIOR) {
                        bala.setVisible(false);
                        setActivate(false);
                    }
                }
            });
            
        }
    }
    
    
}
