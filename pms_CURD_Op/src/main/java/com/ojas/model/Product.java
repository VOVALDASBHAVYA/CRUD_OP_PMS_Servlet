package com.ojas.model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable{
	public int pid;
	public String pname;
	public int qty;
	public double price;
	
	public Product() {
		
	}
 
	public Product(int pid, String pname, int qty, double price) {
		
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}
	
	
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pid, pname, price, qty);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return pid == other.pid && Objects.equals(pname, other.pname)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && qty == other.qty;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + "]";
	}

	
}
