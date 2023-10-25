
package domination.mvc.model;

/**
 *
 * @author karol
 */
public class UtilExceptions {
    public static final double PRECIO_MIN_SALA = 4500;
    public static final double PRECIO_MIN_INSTRUMENTO = 4000;
    
    public static void checkPrecioValidoSala(double precio, String mensajeError){
        if (precio < PRECIO_MIN_SALA) {
            throw new RuntimeException(mensajeError);
        }        
    }
    
    public static void checkPrecioValidoInstrumento(double precio, String mensajeError){
        if (precio < PRECIO_MIN_INSTRUMENTO) {
            throw new RuntimeException(mensajeError);
        }  
    }
    
    
    public static void checkNumeroPositivo(int numero, String mensajeError){        
        if (numero <=0){
            throw new RuntimeException(mensajeError);
        }            
    }
    
    
    public static void checkObjetoValido(Object obj, String mensajeError){
        if (obj==null) {
            throw new RuntimeException(mensajeError);
        }
    }
    
    
}
