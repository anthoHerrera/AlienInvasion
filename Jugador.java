/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasionalien;

import javafx.scene.layout.Pane;

/**
 *
 * @author USER
 */
public class Jugador {
    private String nombre;
    private double puntaje;
    private HumanShip ship;

    public Jugador(Pane pane) {
        this.nombre = "";
        this.puntaje = 0;
        this.ship = new HumanShip(pane);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public HumanShip getShip() {
        return ship;
    }

    public void setShip(HumanShip ship) {
        this.ship = ship;
    }
    
}
