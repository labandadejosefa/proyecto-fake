
package domination.mvc.model;

/**
 *
 * @author giann
 */
public class SalaEnsayo implements ObjetoReservable {
            
    private int id;
    private String nombreSala;
    private double precioHora;
   
    
    public SalaEnsayo(int id, String nombre, double precioHora) {
        setId(id);
        this.nombreSala=nombre;        
        setPrecioHora(precioHora);
    }
    
    
    public void setId(int id){
        UtilExceptions.checkNumeroPositivo(id, "Id de sala debe ser un número positivo");
        this.id=id;
    }
    
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setPrecioHora(double precio) {
        UtilExceptions.checkPrecioValidoSala(precio, "El precio por hora debe ser mayor o igual a ARS " + UtilExceptions.PRECIO_MIN_SALA);
        this.precioHora = precio;
    }

    @Override
    public double getPrecioHora() {
        return this.precioHora;
    }
    
}
