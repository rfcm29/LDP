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
public abstract class Propriedade extends Casa {

    private final int preco;

    public Propriedade(int preco, String nome) {
        super(nome);
        this.preco = preco;
    }

    public int getPreco() {
        return preco;
    }
}
