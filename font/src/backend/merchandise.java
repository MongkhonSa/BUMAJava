package backend;

import javax.persistence.*;
import java.io.Serializable;

public abstract class merchandise implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public abstract void setVAT(double VAT);

    public abstract double getVAT();

  
}
