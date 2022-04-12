/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;

/**
 *
 * @author Sophya
 */
public class Subconjunto {
    // A Java program to print all subsets of a set
    public Subconjunto(){
    }
    
    int cantOperaciones= 0;
    int cont = 0;
    public void operaciones(ArrayList<Integer> listaNumeros){
        long inicioFuncion = System.currentTimeMillis();
        for(int numero : listaNumeros){ 
            long inicioCorreo = System.nanoTime();
            numero += ((numero + 3) * (numero - 1) * Math.pow(numero,2)) / numero - Math.log10(numero);
            cantOperaciones += 9;
            System.out.println("\n Numero formado: " + numero);
            long tiempoTotal = System.nanoTime()-inicioCorreo;
            System.out.println("\n Duró " + (tiempoTotal) + " nanosegundos haciendo la operacion " +cont);
            cont ++;
        }
        
        System.out.println("\n Cantidad de operaciones realizadas: " + cantOperaciones);
        long tiempoTotal = System.currentTimeMillis()-inicioFuncion;
        System.out.println("\n Duró " + tiempoTotal + " milisegundos haciendo la función.");
    }
}