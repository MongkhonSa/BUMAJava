
package backend;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public abstract class Book extends merchandise implements Serializable{
    private static final long serialVersionUID = 1L;
 
    @Id @GeneratedValue
    public long key;
    
    private static double VAT;
    public long id;
    public String name;
    public String EXP;
    public String arrivalDate;
    public String factory;
    public double amount;
    public double price;
    public double profit;
    public double totalPrice;

    public Book(long id, String name, String EXP, String arrivalDate, String factory, double amount, double price, double profit) {
        this.id = id;
        this.name = name;
        this.EXP = EXP;
        this.arrivalDate = arrivalDate;
        this.factory = factory;
        this.amount = amount;
        this.price = price;
        this.profit = profit;
        this.totalPrice = (price+profit)*(1+this.getVAT());
    }

 
 
    @Override
    public double getVAT() {
        return VAT;
    }
    @Override
    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEXP() {
        return EXP;
    }

    public void setEXP(String EXP) {
        this.EXP = EXP;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getKey() {
        return key;
    }

   
    
    
    
}
