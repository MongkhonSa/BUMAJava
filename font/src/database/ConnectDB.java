/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import backend.Alcohol;
import backend.*;
import backend.Items;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author ITokkyZ
 */
public class ConnectDB {

    public ConnectDB() {
    }
    
      public void AddObjectToDB(Object obj){
     EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("BUMA.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
            em.persist(obj);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
     }
      public void editDB(Items item,Object type,Object subType,long id,String name, String EXP, String arrivalDate, String factory, double amount, double price, double profit){
       EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("BUMA.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if(type.equals("Alcohol")){
         TypedQuery<Alcohol> query =
                    em.createQuery("SELECT i FROM Alcohol i", Alcohol.class);
                List<Alcohol> results = query.getResultList();
                for(Alcohol i :results){ 
                    if(item.getKey()==i.getKey()){
                    i.setId(id);
                    i.setAmount(amount);
                    i.setArrivalDate(arrivalDate);
                    i.setEXP(EXP);
                    i.setFactory(factory);
                    i.setName(name);
                    i.setPrice(price);
                    i.setProfit(profit);
                    
                    
                   
                    }
                }   
        }
        else if(type.equals("Drink")){
         TypedQuery<Drinks> query =
                    em.createQuery("SELECT i FROM Drinks i", Drinks.class);
                List<Drinks> results = query.getResultList();
                for(Drinks i :results){ 
                    if(item.getKey()==i.getKey()){
                    i.setId(id);
                    i.setAmount(amount);
                    i.setArrivalDate(arrivalDate);
                    i.setEXP(EXP);
                    i.setFactory(factory);
                    i.setName(name);
                    i.setPrice(price);
                    i.setProfit(profit);
                                     
                    }
                }   
        }
        else if(subType.equals("Weight")){
         TypedQuery<Weight> query =
                    em.createQuery("SELECT i FROM Weight i", Weight.class);
                List<Weight> results = query.getResultList();
                for(Weight i :results){ 
                    if(item.getKey()==i.getKey()){
                    i.setId(id);
                    i.setAmount(amount);
                    i.setArrivalDate(arrivalDate);
                    i.setEXP(EXP);
                    i.setFactory(factory);
                    i.setName(name);
                    i.setPrice(price);
                    i.setProfit(profit);
                   
                    }
                }   
        }
        else if(subType.equals("Quantity")){
         TypedQuery<Quantity> query =
                    em.createQuery("SELECT i FROM Quantity i", Quantity.class);
                List<Quantity> results = query.getResultList();
                for(Quantity i :results){ 
                    if(item.getKey()==i.getKey()){
                    i.setId(id);
                    i.setAmount(amount);
                    i.setArrivalDate(arrivalDate);
                    i.setEXP(EXP);
                    i.setFactory(factory);
                    i.setName(name);
                    i.setPrice(price);
                    i.setProfit(profit);
                   
                    }
                }   
        }
        else if(subType.equals("Cartoon")){
         TypedQuery<Cartoon> query =
                    em.createQuery("SELECT i FROM Cartoon i", Cartoon.class);
                List<Cartoon> results = query.getResultList();
                for(Cartoon i :results){ 
                    if(item.getKey()==i.getKey()){
                    i.setId(id);
                    i.setAmount(amount);
                    i.setArrivalDate(arrivalDate);
                    i.setEXP(EXP);
                    i.setFactory(factory);
                    i.setName(name);
                    i.setPrice(price);
                    i.setProfit(profit);
                   
                    }
                }   
        }
        else if(subType.equals("Magazine")){
         TypedQuery<Magazine> query =
                    em.createQuery("SELECT i FROM Magazine i", Magazine.class);
                List<Magazine> results = query.getResultList();
                for(Magazine i :results){ 
                    if(item.getKey()==i.getKey()){
                    i.setId(id);
                    i.setAmount(amount);
                    i.setArrivalDate(arrivalDate);
                    i.setEXP(EXP);
                    i.setFactory(factory);
                    i.setName(name);
                    i.setPrice(price);
                    i.setProfit(profit);
                   
                    }
                }   
        }
        else if(subType.equals("Fiction")){
         TypedQuery<Fiction> query =
                    em.createQuery("SELECT i FROM Fiction i", Fiction.class);
                List<Fiction> results = query.getResultList();
                for(Fiction i :results){ 
                    if(item.getKey()==i.getKey()){
                    i.setId(id);
                    i.setAmount(amount);
                    i.setArrivalDate(arrivalDate);
                    i.setEXP(EXP);
                    i.setFactory(factory);
                    i.setName(name);
                    i.setPrice(price);
                    i.setProfit(profit);
                   
                    }
                }   
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
      }
      public  ObservableList<Items> showTableDB(Object type){
          ObservableList<Items> ItemsList = FXCollections.observableArrayList();
          EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("BUMA.odb");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
          if(type.equals("Alcohol")){
                    TypedQuery<Alcohol> query =
                    em.createQuery("SELECT i FROM Alcohol i", Alcohol.class);
                List<Alcohol> results = query.getResultList();
                for(Alcohol i :results){ 
                    ItemsList.add(new Items(i.getId(),i.getName(),i.getEXP(),i.getArrivalDate(),i.getFactory(),i.getAmount(),i.getPrice(),i.getProfit(),i.getVAT(),i.getKey()));
                }
              }
          else  if(type.equals("Drink")){
                    TypedQuery<Drinks> query =
                    em.createQuery("SELECT i FROM Drinks i", Drinks.class);
                List<Drinks> results = query.getResultList();
                for(Drinks i :results){ 
                    ItemsList.add(new Items(i.getId(),i.getName(),i.getEXP(),i.getArrivalDate(),i.getFactory(),i.getAmount(),i.getPrice(),i.getProfit(),i.getVAT(),i.getKey()));
                }
              }
           
          else  if(type.equals("Weight")){
                    TypedQuery<Weight> query =
                    em.createQuery("SELECT i FROM Weight i", Weight.class);
                List<Weight> results = query.getResultList();
                for(Weight i :results){ 
                    ItemsList.add(new Items(i.getId(),i.getName(),i.getEXP(),i.getArrivalDate(),i.getFactory(),i.getAmount(),i.getPrice(),i.getProfit(),i.getVAT(),i.getKey()));
                }

              }
          else  if(type.equals("Quantity")){
                    TypedQuery<Quantity> query =
                    em.createQuery("SELECT i FROM Quantity i", Quantity.class);
                List<Quantity> results = query.getResultList();
                for(Quantity i :results){ 
                    ItemsList.add(new Items(i.getId(),i.getName(),i.getEXP(),i.getArrivalDate(),i.getFactory(),i.getAmount(),i.getPrice(),i.getProfit(),i.getVAT(),i.getKey()));
                }

              }
          else  if(type.equals("Cartoon")){
                    TypedQuery<Cartoon> query =
                    em.createQuery("SELECT i FROM Cartoon i", Cartoon.class);
                List<Cartoon> results = query.getResultList();
                for(Cartoon i :results){ 
                    ItemsList.add(new Items(i.getId(),i.getName(),i.getEXP(),i.getArrivalDate(),i.getFactory(),i.getAmount(),i.getPrice(),i.getProfit(),i.getVAT(),i.getKey()));
                }
              }
          else  if(type.equals("Magazine")){
                    TypedQuery<Magazine> query =
                    em.createQuery("SELECT i FROM Magazine i", Magazine.class);
                List<Magazine> results = query.getResultList();
                for(Magazine i :results){ 
                    ItemsList.add(new Items(i.getId(),i.getName(),i.getEXP(),i.getArrivalDate(),i.getFactory(),i.getAmount(),i.getPrice(),i.getProfit(),i.getVAT(),i.getKey()));
                }
              }
          else  if(type.equals("Fiction")){
                    TypedQuery<Fiction> query =
                    em.createQuery("SELECT i FROM Fiction i", Fiction.class);
                List<Fiction> results = query.getResultList();
                for(Fiction i :results){ 
                    ItemsList.add(new Items(i.getId(),i.getName(),i.getEXP(),i.getArrivalDate(),i.getFactory(),i.getAmount(),i.getPrice(),i.getProfit(),i.getVAT(),i.getKey()));
                }
              }
          em.close();
          emf.close();
           return ItemsList;
      }
    public void DeleteObjectDB(Items item,Object type,Object supType){
           EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("BUMA.odb");
                EntityManager em = emf.createEntityManager();
                
        if(type.equals("Alcohol")){
                
                em.getTransaction().begin();
                    TypedQuery<Alcohol> query =
                    em.createQuery("SELECT i FROM Alcohol i", Alcohol.class);
                List<Alcohol> results = query.getResultList();
                for(Alcohol i :results){ 
                
                     if(item.getKey()==i.getKey()){
                         em.remove(i);
                                             
                     }
                }
                
              }
        else  if(type.equals("Drink")){
                em.getTransaction().begin();
                TypedQuery<Drinks> query =
                em.createQuery("SELECT i FROM Drinks i", Drinks.class);
                List<Drinks> results = query.getResultList();
                for(Drinks i :results){ 
                   if(item.getKey()==i.getKey()){
                         em.remove(i);
                                             
                     }
                }
                
              }
           else  if(type.equals("Food")){
                em.getTransaction().begin();
                TypedQuery<Food> query =
                em.createQuery("SELECT i FROM Food i", Food.class);
                List<Food> results = query.getResultList();
                for(Food i :results){ 
                    if(item.getKey()==i.getKey())
                    {
                         em.remove(i);
                                             
                     }
                }
                
                
              }
            else  if(type.equals("Book")){
                
                    em.getTransaction().begin();
                    TypedQuery<Book> query =
                    em.createQuery("SELECT i FROM Book i", Book.class);
                    List<Book> results = query.getResultList();
                    for(Book i :results)
                    { 
                        if(item.getKey()==i.getKey()){
                             em.remove(i);
                                             
                     }
                    }
               
              }
          else  if(type.equals("Weight")){
                
                
                em.getTransaction().begin();
                    TypedQuery<Weight> query =
                    em.createQuery("SELECT i FROM Weight i", Weight.class);
                List<Weight> results = query.getResultList();
                for(Weight i :results){ 
                    
                   if(item.getKey()==i.getKey()){
                         em.remove(i);
                                             
                     }
                }
                
              }
          else  if(type.equals("Quantity")){
                
                
                em.getTransaction().begin();
                    TypedQuery<Quantity> query =
                    em.createQuery("SELECT i FROM Quantity i", Quantity.class);
                List<Quantity> results = query.getResultList();
                for(Quantity i :results){ 
                   if(item.getKey()==i.getKey()){
                         em.remove(i);
                                             
                     }
                }
                
              }
          else  if(type.equals("Cartoon")){
                em.getTransaction().begin();
                    TypedQuery<Cartoon> query =
                    em.createQuery("SELECT i FROM Cartoon i", Cartoon.class);
                List<Cartoon> results = query.getResultList();
                for(Cartoon i :results){ 
                   if(item.getKey()==i.getKey()){
                         em.remove(i);
                                             
                     }
                }
                
              }
          else  if(type.equals("Magazine")){
                          
                em.getTransaction().begin();
                    TypedQuery<Magazine> query =
                    em.createQuery("SELECT i FROM Magazine i", Magazine.class);
                List<Magazine> results = query.getResultList();
                for(Magazine i :results){ 
                   if(item.getKey()==i.getKey()){
                         em.remove(i);
                                             
                     }
                }
                
              }
          else  if(type.equals("Fiction")){
                
                em.getTransaction().begin();
                    TypedQuery<Fiction> query =
                    em.createQuery("SELECT i FROM Fiction i", Fiction.class);
                List<Fiction> results = query.getResultList();
                for(Fiction i :results){ 
                    if(item.getKey()==i.getKey()){
                         em.remove(i);
                                             
                     }
                }
                
              }
          
          
          em.getTransaction().commit();
          em.close();
          emf.close();
     
     }
}
