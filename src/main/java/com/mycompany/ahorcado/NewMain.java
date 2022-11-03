
package com.mycompany.ahorcado;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 50233
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          String PalabraSecreta = getPalabraSecreta();
        char[]PalabraGuiones = getPalabraFromGuiones(PalabraSecreta);
        boolean juegoTerminado = false;
        Scanner lector = new Scanner(System.in);
        int intentos = 10;
        
        
        
        do{
            System.out.println("Tienes como minimo 10 intentos");
            System.out.println("Te quedan " + intentos + " intentos");
            System.out.println(PalabraGuiones);
            System.out.println("Introduce una letra");
            char letra = lector.next().charAt(0);
            boolean algunaLetraAcertada = false;
            for(int i=0; i<PalabraSecreta.length();i++){
                if(PalabraSecreta.charAt(i)== letra){
                    PalabraGuiones[i]=letra;
                    algunaLetraAcertada = true;
                }
            }
            if(!algunaLetraAcertada){
                System.out.println("No has acertado ninguna letra");
                --intentos;
                if(intentos==0){
                    System.out.println("Has perdido porque agotaste los intentos");
                    juegoTerminado = true;
                }
            }
            else{
                boolean juegoGanado = !hayGuiones(PalabraGuiones);
                if(juegoGanado){
                    System.out.println("Has ganado el juego");
                    juegoTerminado = true;
                }
                
            }
        }while(!juegoTerminado);
        
        lector.close();
        
        
    }
    static String getPalabraSecreta() {
        String[]palabras = {"proceso", "conocer","cocina","mejorar","lapiz", "intento"};
        Random r = new Random();
        int numeroAleatorio = r.nextInt(palabras.length);
        return palabras [numeroAleatorio];
    }
    static char[]getPalabraFromGuiones(String palabra){
        int nLetrasPalabraSecreta = palabra.length();
        char[]PalabraGuiones = new char [nLetrasPalabraSecreta];
        
        for(int i=0; i<PalabraGuiones.length; i++){
            PalabraGuiones[i] = '_';
        }
        return PalabraGuiones;
        
        
    }
     static boolean hayGuiones(char[]array){
         for(char l: array){
             if(l=='_')return true;
         }
         return false;
         }
             
         
     }
    

  
