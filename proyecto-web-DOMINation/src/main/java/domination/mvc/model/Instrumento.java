
package domination.mvc.model;

/**
 *
 * @author giann
 */
public class Instrumento extends ObjetoReservable {

    public static final double PRECIO_MIN_INSTRUMENTO = 4000;
     
    public Instrumento(int id, String nombre, double precioHora) {
        super(id, nombre, precioHora, PRECIO_MIN_INSTRUMENTO);        
    }
    
    @Override
    public String toString() {
        return "Instrumento: " + super.getNombre() + "; precio/hora ARS: " + super.getPrecioHora();
    }
    
    

   
    

    
    

    
}
