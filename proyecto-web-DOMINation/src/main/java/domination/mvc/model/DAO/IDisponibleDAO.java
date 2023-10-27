
package domination.mvc.model.DAO;

import java.time.LocalDateTime;

/**
 *
 * @author karol
 */
public interface IDisponibleDAO {
    
    public abstract boolean estaDisponible(Object obj, LocalDateTime fechaYHora, int cantidadHoras);
            
}
