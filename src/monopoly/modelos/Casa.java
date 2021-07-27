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
public abstract class Casa {
    private final String nome;

    public Casa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
