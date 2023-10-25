
package domination.mvc.model;

/**
 *
 * @author giann
 */
public class UsuarioPrestador extends Usuario {
    
    private Sede laSede;

    public UsuarioPrestador(Sede laSede, int id, String nomUsuario, String nombre, String apellido, String email, String password, String celular, Domicilio dom) {
        super(id, nomUsuario, nombre, apellido, email, password, celular, dom);
        this.laSede = laSede;
    }
    
    
}
