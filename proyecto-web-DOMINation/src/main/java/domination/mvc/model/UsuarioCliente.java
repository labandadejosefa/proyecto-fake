
package domination.mvc.model;

/**
 *
 * @author giann
 */
public class UsuarioCliente extends Usuario {

    public UsuarioCliente(int id, String nomUsuario, String nombre, String apellido, String email, String password, String celular, Domicilio dom) {
        super(id, nomUsuario, nombre, apellido, email, password, celular, dom);
        
    }
    
    
    public Reserva crearReserva(ObjetoReservable objeto, Fecha fecha, HoraTurno hora, int cantidadHoras){
        Reserva reservaCreada = null;
        //ACÁ DEBERÍA DELEGARSE LA TAREA A UNA CLASE GESTORA O ALGUIEN QUE PUEDA HACER TODAS LAS VERIFICACIONES DE DISPONIBILIDAD: q devuelva la reserva creada o null si no pudo
        return reservaCreada;
    }
    
    
    public void modificarReserva(Reserva reserva){
        //ACÁ DEBERÍA DELEGARSE LA TAREA A UNA CLASE GESTORA O ALGUIEN QUE PUEDA HACER TODAS LAS VERIFICACIONES. O DIRECTO A DAO?
    }
    
    public void cancelarReserva(Reserva reserva){
        //ACÁ DEBERÍA DELEGARSE LA TAREA A UNA CLASE GESTORA O ALGUIEN QUE PUEDA HACER TODAS LAS VERIFICACIONES DE DISPONIBILIDAD
    }
}
