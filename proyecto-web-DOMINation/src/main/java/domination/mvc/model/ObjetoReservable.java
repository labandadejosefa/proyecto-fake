
package domination.mvc.model;

/**
 *
 * @author karol ** Clase abstracta mejor que Interfaz. Necesitaba atributos. Métodos NO abstractos: para todos los alquilables, eran casi idénticos)
 */
public abstract class ObjetoReservable {
        
    private int id;
    private String nombre;
    private double precioHora;
    protected double montoMIN; //cada subclase lo reemplaza por x su valor static final

    public ObjetoReservable(int id, String nombre, double precioHora, double montoMIN) {
        this.id = id;
        this.nombre = nombre;
        this.montoMIN = montoMIN;
        setPrecioHora(precioHora);
    }
        
    private void setPrecioHora(double precio){
        if (precio < montoMIN){
            throw new RuntimeException("El precio de alquiler debe ser mayor a ARS " + montoMIN);
        } this.precioHora = precio;
    }
    
    public int getId(){
        return this.id;
    }
       
    public String getNombre() {
        return nombre;
    }
                    
    public double getPrecioHora(){
        return this.precioHora;
    };
            
}
