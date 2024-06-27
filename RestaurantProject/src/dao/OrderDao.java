package dao;

import java.util.List;

import model.Order;

public interface OrderDao {
	//create
	void add(Order p);
	
	
	//read
	List<Order> selectAll();
	Order selectById(int id);
	List<Order> queryAll();//全部
	
	
	//update
	
	
	//delete

}