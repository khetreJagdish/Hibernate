package com.scp.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cart_One")
public class Cart {
		
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE)
		private int id;
		
		@Column(name="TOTAL")
		private int total;
		
		@Column(name="Name")
		private String name;
		
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="ITEM_ID")
		List<Items> items = new ArrayList<Items>();

		public List<Items> getItems() {
			return items;
		}

		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Cart [id=" + id + ", total=" + total + ", name=" + name + "]";
		}

		public void setItems(List<Items> items2) {
				this.items = items2;
			
		}
				
		
}
