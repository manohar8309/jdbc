package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBatchExecution {
	public static void main(String[] args) {
		List<Product> list=new ArrayList<Product>();
		
		Product p1=new Product(3, "mobile", 10000, "oppo",10, "2year", "10-05-2020", 12);
		Product p2=new Product(4, "laptop", 10000, "oppo",10, "2year", "10-05-2020", 12);
		Product p3=new Product(5, "book", 10000, "oppo",10, "2year", "10-05-2020", 12);
		Product p4=new Product(6, "blutooth", 1500, "boat",10, "2year", "10-05-2020", 12);
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		String path="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jdbcprc";
		String user="root";
		String password="root";
		Connection connection=null;
		String query="INSERT INTO product VALUES (?,?,?,?,?,?,?,?)";
		try {
			Class.forName(path);
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			for (Product p : list) {
				preparedStatement.setInt(1, p.getId());
				preparedStatement.setString(2, p.getName());
				preparedStatement.setDouble(3, p.getPrice());
				preparedStatement.setString(4, p.getManufacture());
				preparedStatement.setDouble(5, p.getDiscount());
				preparedStatement.setString(6, p.getWarranty());
				preparedStatement.setString(7, p.getManufactureDate());
				preparedStatement.setDouble(8, p.getGst());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("saved");
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}		
}


