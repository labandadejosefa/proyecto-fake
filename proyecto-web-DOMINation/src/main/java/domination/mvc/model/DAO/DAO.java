
package domination.mvc.model.DAO;

import java.util.List;

/**
 *
 * @author giann
 */
public interface DAO<E, Z> {
    public abstract void add(E entidad) throws Exception;
    public abstract void update(E entidad) throws Exception;
    public abstract void delete(Z id) throws Exception;
    public abstract List<E> getAll() throws Exception;
    public abstract E getById(Z id) throws Exception;    
}
