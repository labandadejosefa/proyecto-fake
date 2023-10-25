
package domination.mvc.model.DAO;

import domination.mvc.model.Reserva;
import domination.mvc.model.SalaEnsayo;
import domination.mvc.model.UtilExceptions;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karol
 */
public class SalaEnsayoDAO implements DAO<SalaEnsayo, Integer> {
    private static int contador = 1; // Simula un id autoincremental de base de datos
    private List<SalaEnsayo> salas; // Listado de salas de ensayo
    private List<Reserva> reservas; //esta lista acá, porque para hacer una reserva, hay que consultar disponibilidad a la BDD

    public SalaEnsayoDAO() {
        this.salas = new ArrayList();
        this.reservas = new ArrayList();
    }
    
    @Override
    public void add(SalaEnsayo sala){
        UtilExceptions.checkObjetoValido(sala, "La sala a agregar, no pude ser nula");
        salas.add(sala);
        contador++;
    }
    

    @Override
    public void update(SalaEnsayo sala)  {
        UtilExceptions.checkObjetoValido(sala, "La sala a editar, no pude ser nula");
        //ACÁ HAY QUE AGREGAR LA LÓGICA PARA LA MODIFICACIÓN VIA BDD. 
    }

    @Override
    public void delete(Integer id) {
        UtilExceptions.checkNumeroPositivo(id, "El id de la sala a eliminar no puede ser nulo o negativo");
        //ACÁ HAY QUE AGREGAR LA LA LÓGICA PARA LA ELIMINACIÓN VIA BDD. 
    }

    @Override
    public List<SalaEnsayo> getAll() {
        return new ArrayList<>(this.salas);
        //ACÁ HAY QUE AGREGAR LA LÓGICA PARA mostrar la lista VIA BDD. 
    }

    @Override
    public SalaEnsayo getById(Integer id) {
        UtilExceptions.checkNumeroPositivo(id, "El ID no puede ser negativo");
        SalaEnsayo salaEncontrada = null;
        int i =0;
        
        while (i<salas.size() && salas.get(i).getId() != id) {
            i++;            
        }
        if(i<salas.size()){
            salaEncontrada = salas.get(i);
        }        
        return salaEncontrada;
        //ACÁ HAY QUE CAMBIAR POR LA LÓGICA PARA LA BÚSQUEDA POR ID, VIA BDD. 
    }
    
    
}
