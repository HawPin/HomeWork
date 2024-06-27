package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.OrderDao;
import model.Food;
import model.Order;


public class OrderDaoImpl implements OrderDao{

	public static void main(String[] args) {

	}

	@Override
	public void add(Order p) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into `order`(name,orderNumber,amount,details,time) values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1,p.getName());
			ps.setString(2, p.getOrderNumber());
			ps.setInt(3, p.getAmount());
			ps.setString(4, p.getDetails());
			ps.setString(5, p.getTime());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Order> queryAll() {
		/*
		 * 1.先連線-->Connection
		 * 2.sQL
		 * 3.new ArrayList
		 * 4.執行-->preparedstatement-->executeQuery
		 * 5.ResultSet-->顯示-->List
		 * 
		 */
		
		
		Connection conn=DbConnection.getDb();
		String SQL="select * from `order`";
		List<Order> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Order m=new Order();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrderNumber(rs.getString("orderNumber"));
				m.setAmount(rs.getInt("amount"));
				m.setDetails(rs.getString("details"));
				m.setTime(rs.getString("time"));
				
				l.add(m);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return l;
	}

	@Override
	public List<Order> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}