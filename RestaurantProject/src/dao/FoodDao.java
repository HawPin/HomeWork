package dao;

import java.util.List;

import model.Food;

public interface FoodDao {
	//create
	void addFood(String foodName, Integer price, String introduction, Integer inventory,Integer onSale);
	void addFood(Food f);
	
	//read
	List<Food> queryAll();//全部
	List<Food> queryAllOnSale();//全部
	String queryAll2();
	Food queryFoodById(int id);

	
	//update
	void updateFood(Food f);
	
	//delete
	void deleteFood(int id);
}
