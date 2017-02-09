import java.util.ArrayList;
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
    
    private ArrayList<Comida> listaDeComidaIngerida;
    
    private Comida comidaConMasCalorias;
    
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
        listaDeComidaIngerida = new ArrayList<Comida>();
        comidaConMasCalorias = null;
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
            listaDeComidaIngerida.add(comida);
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
    
    /**
     * Este metodo imprime por pantalla y que devuelve
     * el nombre de la comida más calórico ingerida hasta
     * ahora por un usuario. En caso de que la persona no haya
     * comido nada el método infoma por pantalla de tal situación 
     * y devuelve null. En caso de que haya empate entre dos 
     * o más comidas, imprime y devuelve la última de ellas.
     */
    public String getAlimentoMasCaloricoConsumido()
    {
        Comida comidaActual = null;
        String nombreADevolver = null;
        for (Comida comida : listaDeComidaIngerida) {
            if (comidaActual == null) {
                comidaActual = comida;
                nombreADevolver = comidaActual.getNombre();
                comidaConMasCalorias = comida;
            }
            else {
                if (comidaActual.getCalorias() <= comida.getCalorias()) {
                    comidaActual = comida;
                    nombreADevolver = comidaActual.getNombre();
                    comidaConMasCalorias = comida;
                }
            }
        }
        if (comidaActual == null) {
            System.out.println("La persona aun no ha comido nada.");
        }
        else {
            System.out.println(nombreADevolver);
        }
        return nombreADevolver;
    }
    
    /**
     * Este metodo no devuelve nada y imprime por pantalla 
     * la lista de comidas ingeridas ordenadas de mayor a menor
     * valor calórico. En el listado debe mostrarse el nombre de 
     * la comida y su valor calórico. En caso de que la persona 
     * no haya ingerido aun comida el método debe indicarlo por pantalla.
     */
    public void verListadoComidasIngeridas()
    {
        while (listaDeComidaIngerida.size() > 0) {
            getAlimentoMasCaloricoConsumido();
            System.out.println("Nombre de la comida: " + comidaConMasCalorias.getNombre() + ". Valor calorifico: " + comidaConMasCalorias.getCalorias() + ".");
            int contador = 0;
            while (listaDeComidaIngerida.get(contador).getNombre().contains(comidaConMasCalorias.getNombre())) {
                listaDeComidaIngerida.remove(contador);
            }
            contador++;
        }
    }
    
}









