
package backend;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Fiction extends Book implements Serializable{
    
    @Id @GeneratedValue
    public long key;

    public Fiction(long id, String name, String EXP, String arrivalDate, String factory, double amount, double price, double profit) {
        super(id, name, EXP, arrivalDate, factory, amount, price, profit);
    }

   
  
}
