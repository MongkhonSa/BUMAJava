
package backend;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Quantity extends Food implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    public long key;
    
    public Quantity(long id, String name, String EXP, String arrivalDate, String factory, double amount, double price, double profit) {
        super(id, name, EXP, arrivalDate, factory, amount, price, profit);
    }
    
    
}
