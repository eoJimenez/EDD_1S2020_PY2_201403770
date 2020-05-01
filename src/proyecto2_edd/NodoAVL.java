/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_edd;

/**
 *
 * @author Jimènez
 */
public class NodoAVL {
    String dato;
    int fe;
    NodoAVL nodoIzq, nodoDer;

    public NodoAVL(String d) {
        this.dato = d;
        this.fe = 0;
        this.nodoIzq = null;
        this.nodoDer = null;
    }
    
    
}
