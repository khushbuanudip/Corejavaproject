package com.edu;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import org.junit.Test;

import com.edu.Entity1.Book;


/**
 * Unit test for simple App.
 */
public class AppTest 
   
{
	 private static Session session;
	 @BeforeClass
	    public static void setup() {
	         
	    }
	     
	    @AfterClass
	    public static void tearDown() {
	        if (session != null) session.close();
	        System.out.println("Session destroyed");
	    }
	     
    @Test
	    public void testCreate() {
    	 Book b = new Book("Python","Anju",400,10408);
	    	    Integer id = (Integer) session.save(b);
	    	     
	    	    session.getTransaction().commit();
	    	     
	    	    assertTrue(id > 0);
	    }
	     
	   @Test
	    public void testUpdate() {
	    	
	    	 Integer isbn = 10406;
	    	
	    	 Book updatedProduct = (Book)session.load(Book.class,isbn);
//	    	    session.beginTransaction();
//	    	    session.save(b);
//	    	    session.getTransaction().commit();
	    	     
	    	   // Book updatedProduct = session.get(Book.class, isbn);
	    	     System.out.println(updatedProduct.getBname());
	    	    assertEquals("Java", updatedProduct.getBname());
	    }
	     
	    @Test
	    public void testGet() {
	    }
	     
	    @Test
	    public void testList() {
	    	
	    }
	     
	    @Test
	    public void testDelete() {
	    	Integer isbn=10408;
	    	Book alt = (Book)session.load(Book.class,isbn);
	        session.delete(alt);
	       
	        session.getTransaction().commit();
	        Book updatedProduct = (Book)session.find(Book.class,isbn);
	        assertNull(updatedProduct);
	    }  
	     
	    @Before
	    public void openSession() {
	    	 session = App.config();
	        Transaction tx=session.beginTransaction();
	        System.out.println("Session created");
	    }
	     
	    @After
	    public void closeSession() {
	        if (session != null) session.close();
	        System.out.println("Session closed\n");
	    }   
}