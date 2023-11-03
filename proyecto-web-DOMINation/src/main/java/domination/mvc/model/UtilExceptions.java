
package domination.mvc.model;

/**
 *
 * @author karol
 */
public class UtilExceptions {
        
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
