
package domination.mvc.model;

import java.util.ArrayList;

/**
 *
 * @author giann
 */
public class Sede {
    private Domicilio dom;    
    private ArrayList<ObjetoReservable> reservables;
    
    
    public Sede(Domicilio dom) {
        this.dom = dom;
        this.reservables = new ArrayList<>();
    }
    
    
}
