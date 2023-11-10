
package domination.mvc.model.DAO;

import domination.mvc.model.Instrumento;
import domination.mvc.model.Reserva;
import domination.mvc.model.UtilExceptions;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karol
 */
public class InstrumentoDAO implements DAO<Instrumento, Integer>, IDisponibleDAO {
    private static int contador = 1; // Simula un id autoincremental de base de datos
    private List<Instrumento> instrumentos;
    private List<Reserva> reservas; //esta lista acá: para hacer una reserva, hay que consultar cuál su objeto reservable. Después: HAY QUE CONSULTAR DISPONIBLIDLAD VIA BDD

    
    public InstrumentoDAO() {
        this.instrumentos = new ArrayList();
        this.reservas = new ArrayList();
    }
    
    
    @Override
    public void add(Instrumento instrumento) {
        UtilExceptions.checkObjetoValido(instrumento, "El instrumento a agregar, no pude ser nulo");
        instrumentos.add(instrumento);
        contador++;
        //ACÁ HAY QUE AGREGAR LA LÓGICA VERDADERA VIA BDD. 
    }
            
    
    @Override
    public void update(Instrumento instrumento){
        UtilExceptions.checkObjetoValido(instrumento, "El instrumento a editar, no pude ser nulo");
           //ACÁ HAY QUE AGREGAR LA LÓGICA PARA LA MODIFICACIÓN VIA BDD. 
    }

    @Override
    public void delete(Integer idInstrumento) {
        UtilExceptions.checkNumeroPositivo(idInstrumento, "El id del instrumento a eliminar no puede ser nulo o negativo");
        //ACÁ HAY QUE AGREGAR LA LA LÓGICA PARA LA ELIMINACIÓN VIA BDD. 
    }

    @Override
    public List<Instrumento> getAll() {
        return new ArrayList<>(this.instrumentos);
        //ACÁ HAY QUE AGREGAR LA LÓGICA PARA mostrar la lista VIA BDD. 
    }

    @Override
    public Instrumento getById(Integer idInstrumento) {
        return new Instrumento(100, "instru", 4500);
        //ACÁ HAY QUE CAMBIAR POR LA LÓGICA PARA LA BÚSQUEDA POR ID, VIA BDD.
    }

    @Override
    public boolean estaDisponible(Object obj, LocalDateTime fechaYHora, int cantidadHoras) {
        Instrumento instrumento = (Instrumento) obj;
        Duration duracionDeseada = Duration.ofHours(cantidadHoras);
        int i = 0;
        boolean estaDisp = false;
        while (i<reservas.size() && reservas.get(i).getObjetoReserva()!=instrumento) {            
            i++;
        }
        if (i<reservas.size()) {
           estaDisp = fechaYHora.plus(duracionDeseada).isBefore(reservas.get(i).getFechaYHora()) || fechaYHora.isAfter(reservas.get(i).getFinReserva()); //esto daría el true 
        }
        return estaDisp;
    }
                
}
