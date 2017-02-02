/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasionalien;

import javafx.application.Platform;
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
    private double cantidadDeMisiles;
    private Pane pantalla;
    /**
     * Construye un jugador
     */
    public Jugador() {
        pantalla = new Pane();
        this.nombre = "";
        this.puntaje = 0;
        this.cantidadDeMisiles = Constants.CARGA;
        this.ship = new HumanShip(pantalla);
        pantalla.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
        pantalla.setFocusTraversable(true);
        pantalla.requestFocus();
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

    public Pane getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pane pantalla) {
        this.pantalla = pantalla;
    }

    public double getCantidadDeMisiles() {
        return cantidadDeMisiles;
    }

    public void setCantidadDeMisiles(double cantidadDeMisiles) {
        this.cantidadDeMisiles = cantidadDeMisiles;
    }
    /**
     * Simula el disparo de un misil
     */
    public void disparoMisil() {
        Platform.runLater(() -> {
            new Thread(new Missile(pantalla,true,ship.getXLoc(),ship.getYLoc())).start();
        }); 
    }
    /**
     * Simula el disparo de una bala
     */
    public void disparoBala() {
        Platform.runLater(() -> {
            new Thread(new Bullet(pantalla,true,ship.getXLoc(),ship.getYLoc())).start();
        });
        
    }
    /**
     * Verifica si el jugador tiene municion para disparar misiles
     * @return true si el jugador tiene municion.
     */
    public boolean existenMuniciones() {
        return cantidadDeMisiles > 0;
    }
    
    public int numeroNave() {
        return (int) (Math.random()*450+5);
    }
    
    public void iniciarInvasion() {
        Platform.runLater(() -> {
            new Thread(new AlienShip(pantalla,true,numeroNave(),Constants.ZERO)).start();
        });
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
                Platform.runLater(() -> {
                    if(existenMuniciones()) {
                        disparoMisil();
                    }
                    cantidadDeMisiles--;
                });
                break;
                
            case ESCAPE:
                break;
                
            case SPACE:
                disparoBala();
                break;
                
            case E:
                iniciarInvasion();
                break;
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
