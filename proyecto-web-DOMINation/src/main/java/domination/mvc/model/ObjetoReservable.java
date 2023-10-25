
package domination.mvc.model;

/**
 *
 * @author karol
 */
public interface ObjetoReservable {
    // Obtener el identificador único del objeto reservable (por ejemplo, ID de una sala).
    public abstract int getId();

    // Verificar si el objeto está disponible para una fecha y hora específicas: DEBERÁ SER UNA RESPONSABILILDAD DE OTRA CLASE 'GESTORA' que tome reserva, usuario, objetoreserv
    //public abstract boolean estaDisponible(Fecha fecha, HoraTurno hora);
    
    public abstract void setPrecioHora(double precio);
    
    public abstract double getPrecioHora();

}
