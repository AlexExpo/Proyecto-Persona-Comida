import java.util.Scanner;
/**
 * Write a description of class Persona here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Persona
{
    // instance variables - replace the example below with your own
    private int metabolismo;
    
    private int calorias;
    
    private String nombre;
    
    private static final int LONGITUD_PALABRA = 3;

    /**
     * Constructor for objects of class Persona
     */
    public Persona(String nombreDeLaPersona, boolean hombre, int pesoEnKilogramos, int alturaEnCentimetros, int edad)
    {
        // initialise instance variables
        if (hombre) {
            metabolismo = (10 * pesoEnKilogramos) + (6 * alturaEnCentimetros) + (5 * edad) + 5;
        }
        else {
            metabolismo = (10 * pesoEnKilogramos) + (6 * alturaEnCentimetros) + (5 * edad) - 161;
        }
        calorias = 0;
        nombre = nombreDeLaPersona;
    }
    
    /**
     * Este metodo devulve -1 en caso de que la persona no coma y 
     * devulve el numero de calorias ingeridas en cas de que si coma.
     * Que coma depende de las calorias que ya lleva ingeridas.
     */
    public int comer(Comida comida)
    {
        int caloriasIngeridas = -1;
        if (metabolismo >= calorias) {
            caloriasIngeridas = comida.getCalorias();
            calorias = calorias + comida.getCalorias();
        }
        return caloriasIngeridas;
    }
    
    /**
     * Metodo que devuelve las calorias que tiene las persona.
     */
    public int getCaloriasIngeridas()
    {
        return calorias;
    }
    
    /**
     * Metodo que permite preguntar a la persona algo, si no ha 
     * sobrepasado su metabolismo basal, te contestará "SI" o "NO" 
     * dependiendo de si la pregunta tiene una longitud divisible por 3 
     * o no, respectivamente.
     * En caso de que la persona ya haya sobrepasado el metabolismo basal 
     * o en el caso de que tu pregunta contenga el nombre de la persona, 
     * responderá con la misma pregunta que le has hecho pero en mayusculas 
     * indiferentemente de la longitud de a pregunta.
     */
    public String contestar(String texto)
    {
        if (metabolismo < calorias || texto.contains(nombre)) {
            System.out.println(texto.toUpperCase());
            texto = texto.toUpperCase();
        }
        if (metabolismo >= calorias && !texto.contains(nombre)) {
            if (texto.length() % LONGITUD_PALABRA == 0) {
                System.out.println("SI");
                texto = "SI";
            }
            else    {
                System.out.println("NO");
                texto = "NO";
            }
        }
        return texto;
    }
}









