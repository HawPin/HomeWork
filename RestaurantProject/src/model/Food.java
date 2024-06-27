package model;

import java.io.Serializable;

public class Food implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String foodName;
	private Integer price;
	private String introduction;
	private Integer inventory;
	private Integer onSale;
	
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Food(String foodName, Integer price, String introduction, Integer inventory,Integer onSale) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.introduction = introduction;
		this.inventory = inventory;
		this.onSale = onSale;
	}


	public Integer getOnSale() {
		return onSale;
	}

	public void setOnSale(Integer onSale) {
		this.onSale = onSale;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	
}
