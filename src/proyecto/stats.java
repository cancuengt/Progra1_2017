/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class stats {

    public String[] fechas;
    public int[]    autos;
    public int[]   horas;
    public int[]    maxHoras;
    public int      registros;

    public void horasMaximas(){
        int max1 = 0;
        int max2 = 0;
        int[] horasx = this.horas.clone();
        Arrays.sort(horasx);
        for(int i = 0;i < 24;i++){
            if(this.horas[i] == horasx[23]){
                max1 = i;
            }
            if(this.horas[i] == horasx[22]){
                max2 = i;
            }
        }
        this.maxHoras[0] = max1;
        this.maxHoras[1] = max2;
    }

    public void procesarRegistro(long timestamp){
        SimpleDateFormat sdfecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdhora  = new SimpleDateFormat("HH");
        String fecha             = sdfecha.format(new Date(timestamp));
        String hora              = sdhora.format(new Date(timestamp));

        this.agregarAFecha(fecha);
        this.horas[Integer.parseInt(hora)]+= 1;
    }

    public void ordenarFechas(){
        String temps;
        int    tempi;
        if(this.registros > 0){
            for(int i = 0;i < this.registros;i++){
                for(int j = 0;j < this.registros - 1;j++){
                    if( this.fechas[i].compareTo(this.fechas[j]) < 0 ){
                        temps          = this.fechas[i];
                        this.fechas[i] = this.fechas[j];
                        this.fechas[j] = temps;
                        tempi          = this.autos[i];
                        this.autos[i]  = this.autos[j];
                        this.autos[j]  = tempi;
                    }
                }
            }
        }
    }

    private void agregarAFecha(String fecha){
        int x = this.buscarFecha(fecha);
        if(x == -1){
            this.agregarFecha(fecha);
        }else{
            autos[x]+= 1;
        }
    }

    private void agregarFecha(String fecha){
        // Agrega en el ultimo registro
        this.fechas[this.registros] = fecha;
        this.autos[this.registros]  = 1;
        // Siguiente registro
        this.registros++;
    }

    /**
     * Devuelve la posición de la fecha en un arrray desordenado
     * @param fecha
     * @return -1 si no existe o la posición
     */
    private int buscarFecha(String fecha){
        int posicion = -1;
        for(int i = 0;i < 30;i++){
            if(this.fechas[i].equals(fecha)){
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public stats(){
        this.fechas = new String[30];
        this.autos  = new int[30];
        for(int i = 0;i< 30;i++){
            this.fechas[i] = "";
            this.autos[i]  = 0;
        }

        this.horas  = new int[24];
        for(int i = 0;i< 24;i++){
            this.horas[i] = 0;
        }

        this.maxHoras = new int[2];
        this.maxHoras[0] = 0;
        this.maxHoras[1] = 0;

        this.registros = 0;
    }

}


