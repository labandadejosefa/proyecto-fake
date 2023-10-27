
package domination.mvc.model;

/**
 *
 * @author giann
 */
public class Instrumento implements ObjetoReservable {
    private int id;
    private String nombre;
    private double precioHora;

    public Instrumento(int id, String nombre, double precioHora) {
        this.id = id;
        this.nombre = nombre;
        setPrecioHora(precioHora);
    }
     

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
    @Override
    public void setPrecioHora(double precio) {        
        UtilExceptions.checkPrecioValidoInstrumento(precio, "El precio por hora debe ser mayor o igual a ARS " + UtilExceptions.PRECIO_MIN_INSTRUMENTO);
        this.precioHora = precio;    
    }

    @Override
    public double getPrecioHora() {
        return this.precioHora;
    }
        
    
    
    

    
}
