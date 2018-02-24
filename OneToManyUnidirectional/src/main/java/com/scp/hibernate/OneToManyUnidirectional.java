package com.scp.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.hibernate.entity.Cart;
import com.scp.hibernate.entity.Items;
import com.scp.hibernate.util.HibernateUtil;


public class OneToManyUnidirectional 
{
    public static void main( String[] args )
    {
       Cart cart1 = new Cart();
       
       cart1.setName("cart1");
       cart1.setTotal(2000);
       
       Cart cart2 = new Cart();
       
       cart2.setName("cart2");
       cart2.setTotal(2500);
       
       Items item1 = new Items();
       
       item1.setItem_total(100);
       item1.setQuantity(45);
       
       Items item2 = new Items();
       
       item2.setItem_total(200);
       item2.setQuantity(90);
       
       
       Items item3 = new Items();
       
       item3.setItem_total(300);
       item3.setQuantity(48);
       
       
       Items item4 = new Items();
       
       item4.setItem_total(400);
       item4.setQuantity(454);
       
       List<Items> items =new ArrayList<Items>();
       items.add(item1);
       items.add(item2);
       
       List<Items> items1 =new ArrayList<Items>();
       items1.add(item3);
       items1.add(item4);
       
       
       cart1.setItems(items);
       cart2.setItems(items1);
       
       
       SessionFactory factory = HibernateUtil.getSessionFactory();
       Session session = factory.openSession();
       Transaction transaction = session.beginTransaction();
       session.persist(cart1);
       session.persist(cart2);
       transaction.commit();
    }
}
