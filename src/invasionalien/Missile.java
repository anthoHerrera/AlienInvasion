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
import javafx.scene.shape.Rectangle;

/**
 *
 * @author USER
 */
public class Missile implements Runnable{
    private Rectangle misil;
    private boolean activate;

    public Missile() {
    }
    
    public Missile(Pane pane, boolean activate,double x, double y) {
        this.misil = new Rectangle(Constants.X_MISSILE, Constants.Y_MISSILE);
        this.activate = activate;
        misil.setFill(Color.DARKGOLDENROD);
        pane.getChildren().add(misil);
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
        misil.setTranslateX(x);
    }
    
    public void setYlocation(double y) {
        misil.setTranslateY(misil.getTranslateY() + y);
    }
    
    public void setLocation(double x,double y) {
        misil.setTranslateX(x);
        misil.setTranslateY(y);
    }
    @Override
    public void run() {
        while(isActivate()) {
            setYlocation(Constants.MOVE_MISSILE);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Missile.class.getName()).log(Level.SEVERE, null, ex);
            }
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if(misil.getTranslateY() < Constants.LIMITE_SUPERIOR) {
                        misil.setVisible(false);
                        setActivate(false);
                    }
                }
            });
            
        }
    }
    
}
