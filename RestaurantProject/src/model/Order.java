package model;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String orderNumber;
	private Integer amount;
	private String details;
	private String time;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(String name , String orderNumber, Integer amount, String details, String time) {
		super();
		this.name = name;
		this.orderNumber = orderNumber;
		this.amount = amount;
		this.details = details;
		this.time = time;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
