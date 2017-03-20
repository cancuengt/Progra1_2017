/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


/**
 * Clase que contiene cada una de las cajas de parqueo
 * @author mario
 */
public class Parqueo {

    private int sotano;
    private int numero;
    private long entrada;
    private long salida;
    private long fraccion;

    /**
     * Constructor. Inicializa la caja de parqueo
     * @param sotano Número de sótano
     * @param numero Número de parqueo en el sótano
     */
    public Parqueo(int sotano,int numero,long fraccion) {
        this.sotano   = sotano;
        this.numero   = numero;
        this.entrada  = 0;
        this.salida   = 0;
        this.fraccion = fraccion;
    }

    public String getStingEntrada(){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String strDate           = sdfDate.format(new Date(this.entrada));
        return strDate;
    }

    public String getStingSalida(){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String strDate           = sdfDate.format(new Date(this.salida));
        return strDate;
    }

    public String getStringTiempo(long tiempo){
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        sdfDate.setTimeZone(TimeZone.getTimeZone("GMT"));
        String strDate           = sdfDate.format(new Date(tiempo * 1000L));
        return strDate;
    }

    public long calcularTiempo(){
        long segundos   = ((this.salida - this.entrada)/1000L);
        return segundos;
    }

    public void escribirArchivo(String nombreArchivo, long tarifa){
        String eol = System.getProperty("line.separator");
        try {
            BufferedWriter agendaArch  = new BufferedWriter(new FileWriter(nombreArchivo,true));
            String cadena = "";
            cadena += this.sotano+"|";
            cadena += this.numero+"|";
            cadena += this.entrada+"|";
            cadena += this.salida+"|";
            cadena += this.calcularTiempo()+"|";
            cadena += String.format("%.2f",this.calcularCobro(tarifa)/100)+eol;
            agendaArch.write(cadena);
            agendaArch.flush();
            agendaArch.close();
        } catch (IOException ex) {
            // Do nothing
        }
    }

    public long calcularFracciones(){
        long fracciones = (long) (Math.ceil((double) this.calcularTiempo() / (double) this.fraccion));
        return fracciones;
    }

    public float calcularCobro(long tarifa){
        return ((float) this.calcularFracciones()) * ((float) tarifa);
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
