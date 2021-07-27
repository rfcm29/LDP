/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rfcm2
 */
public class Player {
    
    private static final int DINHEIRO_INICIAL = 1500;
    
    private final String nome;
    private int dinheiro;
    private final List<Propriedade> propriedades;
    
    public Player(String nome) {
        this.nome = nome;
        this.dinheiro = DINHEIRO_INICIAL;
        this.propriedades = new ArrayList<>();
    }
    
}
