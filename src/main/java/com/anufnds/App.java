package com.anufnds;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anufnds.model.Cart;
import com.anufnds.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        try
        {
        	Cart c1=new Cart();
        	
        	Product p1=new Product();
        	p1.setProductname("TV");
        	Product p2=new Product();
        	p2.setProductname("Fridge");
        	Product p3=new Product();
        	p3.setProductname("laptop");
        	
        	c1.getProduct().add(p1);
        	c1.getProduct().add(p2);
        	c1.getProduct().add(p3);

        	
        	
        	session.beginTransaction();
        	session.save(c1);
        	session.save(p1);
        	session.save(p2);
        	session.save(p3);
            session.getTransaction().commit();
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	session.close();
        	factory.close();
        }
    }
}

    
        
    