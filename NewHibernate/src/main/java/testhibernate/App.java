package testhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class App 
{
    public static void main( String[] args )
    {
    	try{
		    
	    	
		    Configuration cfg=new Configuration();
		    cfg.configure("Hibernate.cfg.xml");  
		    SessionFactory factory=cfg.buildSessionFactory();  
		    //creating session object  
		    Session session=factory.openSession();  
		     //creating transaction object  
		    Transaction t=session.beginTransaction();  
		    Name n=new Name();
		    n.setfName("santhanam");
		    n.setlName("sandel");
		    
		    
		    Alien A=new Alien();
		    A.setAlienNo(21);
		    A.setAlienname(n);
		    A.setAlienColor("White");
		    
	    
		    
		    session.persist(A);
		    
		    Alien a=session.get(Alien.class, 22);
		    System.out.println(a);
		    t.commit();//transaction is committed
		   
		  
		  session.close();
		  
		  System.out.println("successfully saved");  
		      }catch(Exception ex)
		      {
		    	  System.out.println("Problem in connection"+ex.getMessage());
		      }

    }
    }

