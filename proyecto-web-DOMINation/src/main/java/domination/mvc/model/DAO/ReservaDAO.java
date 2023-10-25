
package domination.mvc.model.DAO;

import domination.mvc.model.Reserva;
import domination.mvc.model.UtilExceptions;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karol
 */
public class ReservaDAO implements DAO<Reserva, Integer>{

    private static int contador = 1; // Simula un id autoincremental de base de datos
    private List<Reserva> reservas;  //esto también es falopa. Hay que consultar vía BDD

    public ReservaDAO() {
        this.reservas = new ArrayList<>(); //esto también es falopa
    }
   
    
    @Override
    public void add(Reserva reserva) {
        UtilExceptions.checkObjetoValido(reserva, "La reserva a agregar, no pude ser nula");
        reservas.add(reserva);
    }

    @Override
    public void update(Reserva reserva)  {
        UtilExceptions.checkObjetoValido(reserva, "La reserva a editar, no pude ser nula");
        //ACÁ HAY QUE AGREGAR LA LÓGICA PARA LA MODIFICACIÓN VIA BDD. 
    }

    @Override
    public void delete(Integer id) {
        UtilExceptions.checkNumeroPositivo(id, "El id de la reserva a eliminar, no puede ser nulo o negativo");
        //ACÁ HAY QUE AGREGAR LA LA LÓGICA PARA LA ELIMINACIÓN VIA BDD.
    }

    @Override
    public List<Reserva> getAll() {
        return new ArrayList<>(this.reservas);
        //ACÁ HAY QUE AGREGAR LA LÓGICA PARA mostrar la lista VIA BDD. 
    }

    @Override
    public Reserva getById(Integer id) {
        Reserva reservaEncontrada = null;
        //ACÁ HAY QUE CAMBIAR POR LA LÓGICA PARA LA BÚSQUEDA POR ID, VIA BDD.         
        return reservaEncontrada;
    }
    
}
