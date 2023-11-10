
package domination.mvc.model;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 *
 * @author karol
 */
public class Reserva {
    
    public static final LocalDateTime AHORA = LocalDateTime.now();
    public static final int MAX_HORAS_RESERVA =  6; //por poner una cantidad
    public static final int MIN_HORAS_RESERVA =  1; 
    
    private int idReserva;
    private ObjetoReservable objetoReserva; //SalaEnsayo, Instrumento, estadia en Praia da Pipa
    private UsuarioCliente usuario;
    private Fecha fecha;
    private HoraTurno hora;
    private int cantidadHoras;
    private double precioReserva;
    private LocalDateTime fechaYHora;
    private Duration duracion;
    private LocalDateTime finReserva;
    
    public Reserva(int idReserva, ObjetoReservable objetoReserva, UsuarioCliente usuario, Fecha fecha, HoraTurno hora, int cantidadHoras) {
        this.idReserva = idReserva;
        this.objetoReserva = objetoReserva;
        this.usuario = usuario;
        setFechaYHora(fecha,hora);
        setCantidadHoras(cantidadHoras);
        setFinReserva(fechaYHora,cantidadHoras);        
        this.precioReserva= calculaPrecio(objetoReserva, cantidadHoras);        
    }
    
    
    private void setFinReserva(LocalDateTime dateTime, int cantHoras){
        UtilExceptions.checkObjetoValido(dateTime, "El instante de tiempo para la reserva, no puede ser nulo");
        if(cantHoras >= MIN_HORAS_RESERVA && cantHoras <= MAX_HORAS_RESERVA){
            this.duracion = Duration.ofHours(cantHoras);
            this.finReserva = dateTime.plus(duracion);            
        }        
    }
    
        
    private void setFechaYHora(Fecha fecha, HoraTurno hora){
        LocalDate date = convertirFecha(fecha);
        LocalTime time = convertirHora(hora);
                
        if(LocalDateTime.of(date, time).isBefore(AHORA)){
            throw new DateTimeException("El turno de reserva debe ser posterior al actual"); //esta exception acá, para no importar la clase DateTimeExceptions en UtilExceptions
        }
        else{
            this.fechaYHora = LocalDateTime.of(date, time);
        }                
    }
                
    private LocalDate convertirFecha(Fecha fecha){        
        return LocalDate.of(fecha.getAnio(), fecha.getMes(), fecha.getDia());
    }
    
    
    private LocalTime convertirHora(HoraTurno hora){
        return LocalTime.of(hora.getHora(), 0);
    }
    
        
    public void setCantidadHoras(int cantidad){
        UtilExceptions.checkNumeroPositivo(cantidad, "La cantidad de horas debe ser mayor o igual que 1");
        this.cantidadHoras=cantidad;
    }
    
    
    private double calculaPrecio(ObjetoReservable objeto, int cantHoras){
        return objeto.getPrecioHora()*cantHoras;
    }
    
    
    public UsuarioCliente getUsuarioReserva(){
        return usuario;
    }
        
    public ObjetoReservable getObjetoReserva() { //este, para que lo puedan "ver" las clases DAO y resolver si un objetoReservable estaDisponible()
        return objetoReserva;
    }

    public LocalDateTime getFechaYHora() { //este, para que lo puedan "ver" las clases DAO y resolver si un objetoReservable estaDisponible()
        return fechaYHora;
    }

    public LocalDateTime getFinReserva() {
        return finReserva;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public int getIdReserva() {
        return idReserva;
    }
    
    
    
}
