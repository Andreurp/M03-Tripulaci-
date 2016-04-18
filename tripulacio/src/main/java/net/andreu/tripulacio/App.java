package net.andreu.tripulacio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("tripulacio");
        EntityManager e = emf.createEntityManager();
        System.out.println(e.isOpen());
        
        Vaixell barco = new Vaixell("Perla Negra");
        Vaixell barco2 = new Vaixell("Titanic");
        
        Tripulant t1 = new Tripulant();
        t1.setNom("Andreu Rodriguez");
        t1.setRang("capita");
        t1.setVaxeill(barco);
        
        Tripulant t2 = new Tripulant();
        t2.setNom("Edward Smith");
        t2.setRang("capita");
        t2.setVaxeill(barco2);
        
        e.getTransaction().begin();
        e.persist(barco);
        e.persist(barco2);
        e.getTransaction().commit();
        
        e.getTransaction().begin();
        e.persist(t1);
        e.persist(t2);
        e.getTransaction().commit();
        e.close();
    }
}
