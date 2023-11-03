
package domination.mvc.model;

/**
 *
 * @author giann
 */
public class SalaEnsayo extends ObjetoReservable {
    
    public static final double PRECIO_MIN_SALA = 4500;

    public SalaEnsayo(int id, String nombre, double precioHora) {
        super(id, nombre, precioHora, PRECIO_MIN_SALA);        
    }

    @Override
    public String toString() {
        return "Sala de Ensayo: " + super.getNombre() +"; precio/hora ARS: " +super.getPrecioHora();
    }
    
}
