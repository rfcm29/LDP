/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelos;

/**
 *
 * @author rfcm2
 */
public class Movimento {
    
    private final Player player;
    private final int numeroCasas;

    public Movimento(Player player, int numeroCasas) {
        this.player = player;
        this.numeroCasas = numeroCasas;
    }
}
