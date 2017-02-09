
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

    /**
     * Constructor for objects of class Persona
     */
    public Persona(String nombre, boolean hombre, int pesoEnKilogramos, int alturaEnCentimetros, int edad)
    {
        // initialise instance variables
        if (hombre) {
            metabolismo = (10 * pesoEnKilogramos) + (6 * alturaEnCentimetros) + (5 * edad) + 5;
        }
        else {
            metabolismo = (10 * pesoEnKilogramos) + (6 * alturaEnCentimetros) + (5 * edad) - 161;
        }
        calorias = 0;
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
    
    public int getCaloriasIngeridas()
    {
        return calorias;
    }
    
    public void contestar()
    {
        
    }
}









