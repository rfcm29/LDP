/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelos;

import java.util.List;

/**
 *
 * @author rfcm2
 */
public class Negocio {
    private final Player player1, player2;
    private final List<Casa> casas1, casas2;
    private final int dinheiro1, dinheiro2;

    public Negocio(Player player1, Player player2, List<Casa> casas1, List<Casa> casas2, int dinheiro1, int dinheiro2) {
        this.player1 = player1;
        this.player2 = player2;
        this.casas1 = casas1;
        this.casas2 = casas2;
        this.dinheiro1 = dinheiro1;
        this.dinheiro2 = dinheiro2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public List<Casa> getCasas1() {
        return casas1;
    }

    public List<Casa> getCasas2() {
        return casas2;
    }

    public int getDinheiro1() {
        return dinheiro1;
    }

    public int getDinheiro2() {
        return dinheiro2;
    }
}
