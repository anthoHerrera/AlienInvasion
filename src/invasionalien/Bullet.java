/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasionalien;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Esta clase representa una bala
 * @author AnthonyHerrera
 */
public class Bullet implements Runnable{
    private Ellipse bala;
    private boolean activate;
    
    public Bullet(boolean activate) {
        this.bala = new Ellipse(Constants.X_BULLET,Constants.Y_BULLET);
        this.activate = activate;
        bala.setFill(Color.BURLYWOOD);
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
    
    public void setXlocation(double x) {
        bala.setCenterX(bala.getCenterX() + x);
    }
    
    public void setYlocation(double y) {
        bala.setCenterY(bala.getCenterY() + y);
    }
    
    @Override
    public void run() {
        while(isActivate()) {
            this.setYlocation(Constants.MOVE_BULLET);
        }
    }
    
    
}
