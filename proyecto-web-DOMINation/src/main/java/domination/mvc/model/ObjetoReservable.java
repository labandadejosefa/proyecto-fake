
package domination.mvc.model;

/**
 *
 * @author karol
 */
public interface ObjetoReservable {
    // Obtener el identificador único del objeto reservable (por ejemplo, ID de una sala).
    public abstract int getId();
   
    public abstract void setPrecioHora(double precio);
    
    public abstract double getPrecioHora();

}
