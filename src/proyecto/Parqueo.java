/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Date;


/**
 * Clase que contiene cada una de las cajas de parqueo
 * @author mario
 */
public class Parqueo {

    public int sotano;
    public int numero;
    public long entrada;
    public long salida;
    public long cobro;

    /**
     * Constructor. Inicializa la caja de parqueo
     * @param sotano Número de sótano
     * @param numero Número de parqueo en el sótano
     */
    public Parqueo(int sotano,int numero) {
        this.sotano  = sotano;
        this.numero  = numero;
        this.entrada = 0;
        this.salida  = 0;
        this.cobro   = 0;
    }

    /**
     * Retorna 1 si la caja de parqueo está libre
     * @return int
     */
    int libre() {
        return (this.entrada == 0) ? 1 : 0;
    }

}
