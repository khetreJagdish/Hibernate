package com.scp.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Items {
	
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE)
		@Column(name="ITEM_ID")
	 	private long id;
		
		
		@Column(name="ITEM_TOTAL")
	    private long item_total;
		
		@Column(name="QUANTITY")
	    private long quantity;
		
		@ManyToOne(optional=false)
		@JoinColumn(name="CART_ID")
	    private Cart cart;
		
	    public Items() {
		
		}
	    
	    public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getItem_total() {
			return item_total;
		}
		public void setItem_total(long item_total) {
			this.item_total = item_total;
		}
		public long getQuantity() {
			return quantity;
		}
		public void setQuantity(long quantity) {
			this.quantity = quantity;
		}
		public Cart getCart() {
			return cart;
		}
		public void setCart(Cart cart) {
			this.cart = cart;
		}

		@Override
		public String toString() {
			return "Items [id=" + id + ", item_total=" + item_total + ", quantity=" + quantity + ", cart=" + cart + "]";
		}

		
	    
		
	    
}
