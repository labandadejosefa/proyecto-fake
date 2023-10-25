
package domination.mvc.model;

/**
 *
 * @author giann
 */
public abstract class Usuario {
    private int id;
    private String nomUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String celular;
    private Domicilio dom;

    public Usuario(int id, String nomUsuario, String nombre, String apellido, String email, String password, String celular, Domicilio dom) {
        this.id = id;
        this.nomUsuario = nomUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.celular = celular;
        this.dom = dom;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setDomicilio(Domicilio elDom){
        dom = elDom;
    }

    public int getId() {
        return id;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public String getPassword() {
        return password;
    } 
    
}
