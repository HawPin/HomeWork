package model;

import java.io.Serializable;

public class Member implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String account;
	private String password;
	private String address;
	private String phone;
	private String permission;
	
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(String name, String account, String password, String address, String phone,
			String permission) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.permission = permission;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}
