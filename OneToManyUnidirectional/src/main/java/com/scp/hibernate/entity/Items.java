package com.scp.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Items_One")
public class Items {
	
	@Id
	@GeneratedValue
	
	private long id;
	private long item_total;
	private long quantity;
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
	@Override
	public String toString() {
		return "Items [id=" + id + ", item_total=" + item_total + ", quantity=" + quantity + "]";
	}
	
	
	
}
