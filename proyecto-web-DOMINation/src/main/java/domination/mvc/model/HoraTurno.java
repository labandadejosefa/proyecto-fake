
package domination.mvc.model;

/**
 * Clase que muy posiblemente haya que modificar o eliminar. La validación de la combinación Fecha + Hora para poder reservar, debería hacerse
 * en lógica de negocio.
 * @author karol
 */
public class HoraTurno {
    public static final int HORA_MIN = 10;
    public static final int HORA_MAX = 22;
   
    private int hora; 

    public HoraTurno(int hora) {
        if (hora < HORA_MIN || hora > HORA_MAX) {
            throw new IllegalArgumentException("Hora fuera del rango permitido");
        }
        this.hora = hora;
    }

    public int getHora() {
        return hora;
    }

}
