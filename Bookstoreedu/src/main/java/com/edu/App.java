package com.edu;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.edu.Entity1.Book;


import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
	
	public static Session config()
	{
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Book.class);
	       SessionFactory sf=con.buildSessionFactory();
	       Session session = sf.openSession();
	       
         return session;
	}
	public static String addBook(Session s,Transaction t) 
	{
		System.out.println("Enter Book name");
		Scanner sc1=new Scanner(System.in);
		String name=sc1.nextLine();
		System.out.println("Enter Author name");
		String Aname=sc1.nextLine();
		 
		 System.out.println("Enter Book ISBN no");
		 int isbn=sc1.nextInt();
		 System.out.println("Enter Book price");
		 int price=sc1.nextInt();
		 Book b=new Book();
        b.setBisbnno(isbn);
        b.setBname(name);
        b.setBauthor(Aname);
        b.setPrice(price);
        s.save(b);
       
        t.commit();
       
       
        Query query = s.createQuery("from Book");
        List<Book> books = query.list();
        for(Book bl:books)
        {
      System.out.println("Book Name: "+bl.getBname()+", Author Name: "+bl.getBauthor()+", ISBN No: "+bl.getBisbnno());
        }
       
        s.close();
		return "Book is added";
	}
	public static String updateBook(Session s,Transaction t)
	{
		Scanner sc1=new Scanner(System.in);
		 System.out.println("Enter Book ISBN no");
		 int isbn=sc1.nextInt();
		 System.out.println("Enter updated price");
		 int price=sc1.nextInt();
		Book al = (Book)s.get(Book.class, isbn);
	      al.setPrice(price);
	       System.out.println("Updated Successfully");
	       t.commit();
	       s.close();
		return "price updated";
	}
	public static String deleteBook(Session s,Transaction t) 
	{
		Scanner sc1=new Scanner(System.in);
		 System.out.println("Enter Book ISBN no");
		 int isbn=sc1.nextInt();
		Book alt = (Book)s.load(Book.class,isbn);
        s.delete(alt);
       
        s.getTransaction().commit();
        Query query = s.createQuery("from Book");
        List<Book> books = query.list();
        for(Book bl:books)
        {
      System.out.println("Book Name: "+bl.getBname()+", Author Name: "+bl.getBauthor()+", ISBN No: "+bl.getBisbnno());
        }
		return "Book is deleted";
	}
	public static String readBooks(Session s)
	{
		
		Query query = s.createQuery("from Book");
	        List<Book> books = query.list();
	        for(Book bl:books)
	        {
	      System.out.println("Book Name: "+bl.getBname()+", Author Name: "+bl.getBauthor()+", ISBN No: "+bl.getBisbnno()+"Price"+bl.getPrice());
	        }
		return "Read all books";
	}
    public static void main( String[] args )
    
    {
    	while(true)
    	{
    		
     	  
    		System.out.println("Enter the option 1 admin, 2. User ");
    		
        	
    		Scanner sc=new Scanner(System.in);
    		int op1=sc.nextInt();
    		
    		if(op1==1)
    		{
    		System.out.println("Enter the username");
    		Scanner sc1=new Scanner(System.in);
    		String user=sc1.nextLine();
    		
    		if(user.equals("khushbu") )
    		{
    			System.out.println("Enter the Password");
    			Scanner sc2=new Scanner(System.in);
        		String pass=sc2.nextLine();
        		if(pass.equals("khushbu"))
        		{
    	
         while(true)  
         {
        	 //Crud operation
        	 Session session = config();
       		 Transaction tx=session.beginTransaction();
        	 System.out.println("Enter the option 1. add book, 2. get list of book  3. delete book 4. update Price");
           int entry=sc.nextInt();
           if(entry==1)
           {
        	
        	   
        	   System.out.println(addBook(session,tx));
        	  
        	   
           }
           else if(entry==2)
           {
        	   
        	  
      		 //Transaction tx1=session.beginTransaction();
        	   System.out.println(readBooks(session));
        	   session.close();
           }
           else if(entry==3)
           {
        	   try
        	   {
        	   
        	   System.out.println(deleteBook(session, tx));
        	 //  session.close();
        	   }
        	   catch (Exception e)
        	   {
        		   e.printStackTrace();
        	   }
           }
           else if(entry==4)
           {
        	   try
        	   {
        	   System.out.println(updateBook(session, tx));
        	   }
        	   catch (Exception e)
        	   {
        		   e.printStackTrace();
        	   }
           }
        
         // session.save(tele1);
        
       
        
         
         
		  //Read query
         
       
    	//session.close();
    	
    	 //update query
//        Transaction  tx2=session.beginTransaction();
//       Book al = (Book)session.get(Book.class, 113451);
//        al.setBname("Who will cry");
//         System.out.println("Updated Successfully");
//         session.getTransaction().commit();
                      // sf.close();
         
    	                System.out.println( "Hello World!" );
        		}
    		}
    		else
    		{
    			System.out.println("Invalid input");
    			return;
    		}
    		}
    		}
    		else if(op1==2)
    		{
    			 Session session = config();
           		 Transaction tx=session.beginTransaction();
    			System.out.println("Display books");
   			System.out.println(readBooks(session));
    			
    		}
    }
}
    
}
