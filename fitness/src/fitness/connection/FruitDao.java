package fitness.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import fitness.model.Fruit;

public class FruitDao {
	public List<Fruit> getAllFruits(){
	 List<Fruit> fruits = new ArrayList<Fruit>();
	 Connection connection = JDBCConnection.getJDBCConnection();
	 String sql = "select * from fruit";
	 try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		 ResultSet rs = preparedStatement.executeQuery();
		 while (rs.next()) {
			 Fruit fruit = new Fruit();
			 fruit.setName(rs.getString("name"));
			 fruit.setCarb(rs.getFloat("carb"));
			 fruit.setXo(rs.getFloat("xo"));
			 fruit.setFat(rs.getFloat("fat"));
			 fruit.setProtein(rs.getFloat("protein"));
			 fruits.add(fruit);
		 }
	 } catch (SQLException e) {
		 e.printStackTrace(); 
	 }
	 return fruits;
			 
	 
 }
	public void addFruit(Fruit fruit) {
		Connection connection = JDBCConnection.getJDBCConnection();
		 String sql = "select * from fruit";
		 try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, fruit.getName());
			preparedStatement.setFloat(2, fruit.getCarb());
			preparedStatement.setFloat(3, fruit.getXo());
			preparedStatement.setFloat(4, fruit.getFat());
			preparedStatement.setFloat(5, fruit.getProtein());
			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
		 } catch (SQLException e) {
			 e.printStackTrace();
			 
		 }
	}	 
}
