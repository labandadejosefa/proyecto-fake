
package domination.mvc.model.DAO;

import domination.mvc.model.Reserva;
import domination.mvc.model.SalaEnsayo;
import domination.mvc.model.UtilExceptions;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karol
 */
public class SalaEnsayoDAO implements DAO<SalaEnsayo, Integer>, IDisponibleDAO {
    private static int contador = 1; // Simula un id autoincremental de base de datos
    private List<SalaEnsayo> salas; // Listado de salas de ensayo. Después: HAY QUE CONSULTAR TABLA SALAENSAYO VIA BDD
    private List<Reserva> reservas; //esta lista acá: para hacer una reserva, hay que consultar cuál su objeto reservable. Después: HAY QUE CONSULTAR DISPONIBLIDLAD VIA BDD

    public SalaEnsayoDAO() {
        this.salas = new ArrayList();
        this.reservas = new ArrayList();
    }
        
    public void mostrarOfertaHoraria(){
        //ESTE MÉTODO DEBERÍA TRABAJAR CON LAS TABLAS RESERVA Y SALADEENSAYO SIMULTÁNEAMENTE. Creo.
    }
        
    @Override
    public void add(SalaEnsayo sala){
        UtilExceptions.checkObjetoValido(sala, "La sala a agregar, no pude ser nula");
        salas.add(sala);
        contador++;
    }

    
    @Override
    public void create(SalaEnsayo entidad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //ACÁ HAY QUE AGREGAR LA LÓGICA PARA LA CREACION VIA BDD. 
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

    @Override
    public boolean estaDisponible(Object obj, LocalDateTime fechaYHora, int cantidadHoras) {
        SalaEnsayo sala = (SalaEnsayo) obj; //downcasting -quiero ver a 'obj' como una instancia de SalaEnsayo
        Duration duracionDeseada = Duration.ofHours(cantidadHoras);
        int i = 0;         
        boolean estaDisp = false;
        while (i<reservas.size() && reservas.get(i).getObjeto() != sala) {            
            i++;
        }
        if (i<reservas.size()) {            
            estaDisp = fechaYHora.plus(duracionDeseada).isBefore(reservas.get(i).getFechaYHora()) || fechaYHora.isAfter(reservas.get(i).getFinReserva()); //esto daría el true
        }
        return estaDisp; 
        //Así como está, SÓLO responde por el instante consultado. No muestra oferta horaria del objeto deseado
        //ACÁ HAY QUE REEMPLAZAR POR LA LÓGICA DE BÚSQUEDA VIA BDD. 
        
    }
        
}
