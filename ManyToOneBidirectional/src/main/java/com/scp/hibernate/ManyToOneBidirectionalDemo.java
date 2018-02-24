package com.scp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.scp.hibernate.entity.Cart;
import com.scp.hibernate.entity.Items;

public class ManyToOneBidirectionalDemo 
{
    public static void main( String[] args )
    {
        
        
        Configuration configuration = new Configuration();
        configuration.configure();
        
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        Cart  cart = new Cart();
        cart.setName("Jagdish");
        cart.setTotal(15222);
        
        Cart  cart1 = new Cart();
        cart1.setName("Amol");
        cart1.setTotal(18542);
        
        
        Items items1 = new Items();
        items1.setItem_total(10000);
        items1.setQuantity(10);
        
        Items items2 = new Items();
        items2.setItem_total(20000);
        items2.setQuantity(20);
       
        Items items3 = new Items();
        items3.setItem_total(30000);
        items3.setQuantity(30);
        
        items1.setCart(cart);
        items2.setCart(cart);
        items3.setCart(cart);
        
        
        Items items4 = new Items();
        items4.setItem_total(40000);
        items4.setQuantity(100);
        
        Items items5 = new Items();
        items5.setItem_total(50000);
        items5.setQuantity(200);
       
        Items items6 = new Items();
        items6.setItem_total(60000);
        items6.setQuantity(300);
        
        items1.setCart(cart);
        items2.setCart(cart);
        items3.setCart(cart);
        
        
        
        
        
        
        
        items4.setCart(cart1);
        items5.setCart(cart1);
        items6.setCart(cart1);
        
        session.save(cart);
        session.save(cart1);
        session.save(items1);
        session.save(items2);
        session.save(items3);
        
        session.save(items4);
        session.save(items5);
        session.save(items6);
        
        
        session.flush();   
        transaction.commit();
        session.close();
    }
}
