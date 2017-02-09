
/**
 * Write a description of class Comida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comida
{
    // instance variables - replace the example below with your own
    
    private int valorCalorifico;
    
    private String nombre;
    
    
    /**
     * Constructor for objects of class Comida
     */
    public Comida(String nombreDeLaComida, int calorias)
    {
        // initialise instance variables
        valorCalorifico = calorias;
        nombre = nombreDeLaComida;
    }
    
    public int getCalorias()
    {
        return valorCalorifico;
    }
    
    public String getNombre()
    {
        return nombre;
    }
}
