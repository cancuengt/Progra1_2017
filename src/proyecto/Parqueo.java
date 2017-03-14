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

    private int sotano;
    private int numero;
    private long entrada;
    private long salida;
    public long cobro;
    private long fraccion;

    /**
     * Constructor. Inicializa la caja de parqueo
     * @param sotano Número de sótano
     * @param numero Número de parqueo en el sótano
     */
    public Parqueo(int sotano,int numero) {
        this.sotano   = sotano;
        this.numero   = numero;
        this.entrada  = 0;
        this.salida   = 0;
        this.cobro    = 10;
        //this.fraccion = 30*60; // Media hora
        this.fraccion = 10; // Pruebas
    }

    public long calcularTiempo(){
        long segundos   = ((this.salida - this.entrada)/1000);
        long fracciones = (long) Math.ceil((double) segundos / (double) this.fraccion);
        return fracciones;
    }

    public float calcularCobro(long tarifa){
        return ((float) this.calcularTiempo()) * ((float) tarifa);
    }

    public void marcarEntrada(){
        this.entrada = new Date().getTime();
    }

    public void marcarSalida(){
        this.salida = new Date().getTime();
    }

    /**
     * Retorna 1 si la caja de parqueo está libre
     * @return int
     */
    public int libre() {
        return (this.entrada == 0) ? 1 : 0;
    }

    public void limpiar(){
        this.entrada = 0;
        this.salida  = 0;
    }
}
