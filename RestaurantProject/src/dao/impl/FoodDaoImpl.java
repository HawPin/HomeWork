package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.FoodDao;
import model.Food;

public class FoodDaoImpl implements FoodDao {

	public static void main(String[] args) {		

	}
	
	@Override
	public void addFood(String foodName, Integer price, String introduction, Integer inventory,Integer onSale) {
		/*
		 * 1.先連線
		 * 2.SQL
		 * 3.PreparedStatement-->set..
		 * 4.executeupdate
		 */
		
		Connection conn=DbConnection.getDb();
		String SQL="insert into food(foodName,price,introduction,inventory,onSale) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, foodName);
			ps.setInt(2, price);
			ps.setString(3, introduction);
			ps.setInt(4, inventory);
			ps.setInt(5, onSale);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void addFood(Food m) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into food(foodName,price,introduction,inventory,onSale) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getFoodName());
			ps.setInt(2, m.getPrice());
			ps.setString(3, m.getIntroduction());
			ps.setInt(4, m.getInventory());
			ps.setInt(5, m.getOnSale());

			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Food> queryAll() {
		/*
		 * 1.先連線-->Connection
		 * 2.sQL
		 * 3.new ArrayList
		 * 4.執行-->preparedstatement-->executeQuery
		 * 5.ResultSet-->顯示-->List
		 * 
		 */
		
		
		Connection conn=DbConnection.getDb();
		String SQL="select * from food";
		List<Food> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Food m=new Food();
				m.setId(rs.getInt("id"));
				m.setFoodName(rs.getString("foodName"));
				m.setPrice(rs.getInt("price"));
				m.setIntroduction(rs.getString("introduction"));
				m.setInventory(rs.getInt("inventory"));
				m.setOnSale(rs.getInt("onSale"));
				
				l.add(m);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}
	
	@Override
	public List<Food> queryAllOnSale() {
		/*
		 * 1.先連線-->Connection
		 * 2.sQL
		 * 3.new ArrayList
		 * 4.執行-->preparedstatement-->executeQuery
		 * 5.ResultSet-->顯示-->List
		 * 
		 */
		
		
		Connection conn=DbConnection.getDb();
		String SQL="select * from food where onsale=1";
		List<Food> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Food m=new Food();
				m.setId(rs.getInt("id"));
				m.setFoodName(rs.getString("foodName"));
				m.setPrice(rs.getInt("price"));
				m.setIntroduction(rs.getString("introduction"));
				m.setInventory(rs.getInt("inventory"));
				m.setOnSale(rs.getInt("onSale"));
				
				l.add(m);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public String queryAll2() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from food";
		String show="";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				show=show+"id:"+rs.getInt("id")+
						"    品名:"+rs.getString("foodName")+
						"    價格:"+rs.getInt("price")+
						"    商品簡介:"+rs.getString("introduction")+
						"    庫存量:"+rs.getInt("inventory")+
						"    上架:"+rs.getInt("onSale")+"\n";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return show;
	}

	@Override
	public Food queryFoodById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from food where id=?";
		Food m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new Food();
				m.setId(rs.getInt("id"));
				m.setFoodName(rs.getString("foodName"));
				m.setPrice(rs.getInt("price"));
				m.setIntroduction(rs.getString("introduction"));
				m.setInventory(rs.getInt("inventory"));
				m.setOnSale(rs.getInt("onSale"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}

	@Override
	public void updateFood(Food m) {//改好舊會員inject
		Connection conn=DbConnection.getDb();
		String SQL="update company.food set foodName=?,price=?,introduction=?,inventory=?,onSale=? where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getFoodName());
			ps.setInt(2, m.getPrice());
			ps.setString(3, m.getIntroduction());
			ps.setInt(4, m.getInventory());
			ps.setInt(5, m.getOnSale());
			ps.setInt(6, m.getId());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteFood(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from food where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}