/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasionalien;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * Esta clase representa a la persona que esta jugando
 * @author AnthonyHerrera
 */
public class Jugador {
    //caracteristicas de la clase jugador
    private String nombre;
    private double puntaje;
    private HumanShip ship;
    /**
     * Construye un jugador
     * @param pane donde se añade la nave del jugador
     */
    public Jugador(Pane pane) {
        this.nombre = "";
        this.puntaje = 0;
        this.ship = new HumanShip(pane);
        pane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
        pane.setFocusTraversable(true);
        pane.requestFocus();
    }
    //Metodos get y set de la clase jugador
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
    /**
    Clase que se encarga de manejar los eventos producidos por el jugador al 
    presionar el teclado
    */
    private class KeyHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent keyEvent) {
           switch(keyEvent.getCode()) {
            case M:
                break;
            case ESCAPE:
                break;
            case SPACE:
                break;
            /*case E:
                break;
            No es necesario ya que se tiene el boton jugar el cual inicia el juego
            */
            case P:
                break;
            case LEFT:
                if(ship.getXLoc() > Constants.LIMITE_IZQ) {
                    ship.setLocation(ship.getXLoc() - Constants.DESPLAZAMIENTO);
                }
                
                break;
            case RIGHT:
                if(ship.getXLoc() < Constants.LIMITE_DER){
                    ship.setLocation(ship.getXLoc() + Constants.DESPLAZAMIENTO);
                }
                
                break;
            default:
                break;
            }
        }
        
    }
}
