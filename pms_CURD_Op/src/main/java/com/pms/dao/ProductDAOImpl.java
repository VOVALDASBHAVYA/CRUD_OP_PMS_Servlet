package com.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ojas.model.Product;
import com.pms.db.DBUtility;

public class ProductDAOImpl implements ProductDAO {
public static Connection con=DBUtility.getConnection();
PreparedStatement ps =null;
List<Product> products=null;
ResultSet rs=null;
Product product=null;
String message=null;
int n=0;
	public String createProduct(Product product) {
		try {
			ps=con.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?)");
			ps.setInt(1, product.getPid());
			ps.setString(2, product.getPname());
			ps.setInt(3, product.getQty());
			ps.setDouble(4, product.getPrice());
			n=ps.executeUpdate();
			if(n!=0){
				message="Sucess...";
			}else{
				message="please try again";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	public Product viewProduct(int pid) {
		try {
			ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE PID=?");
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			if(rs.next()) {
				product = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	public List<Product> viewAllProducts() {
		try {
			products = new ArrayList<Product>();
			ps = con.prepareStatement("SELECT * FROM PRODUCT");
			rs = ps.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public String updateProduct(int pid, Product updateProduct) {
		try {
			ps = con.prepareStatement("UPDATE PRODUCT SET PNAME=?,QTY=?,PRICE=? WHERE PID=?");
			ps.setString(1, updateProduct.getPname());
			ps.setInt(2, updateProduct.getQty());
			ps.setDouble(3, updateProduct.getPrice());
			ps.setInt(4, pid);
			n = ps.executeUpdate();
			if(n!=0) {
				message = "Successfully Product Updated....";
			}else {
				message = "Please try again....";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return message;
	}

	public String deleteProduct(int pid) {
		try {
			ps = con.prepareStatement("DELETE FROM PRODUCT WHERE PID = ?");
			ps.setInt(1, pid);
			n = ps.executeUpdate();
			if(n!=0) {
				message = "Successfully Product deleted....";
			}else {
				message = "Please try again....";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
