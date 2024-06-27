package dao;


import java.util.List;

import model.Member;

public interface MemberDao {
	//create
	void addMember(String name,String account,String password,String address,String phone,String permission);
	void addMember(Member m);
	
	//read
	List<Member> queryAll();//全部
	String queryAll2();
	Member queryMemberById(int id);
	
	Member queryMember(String account,String password);
	Member queryUsername(String account);
	
	//update
	void updateMember(Member m);
	
	//delete
	void deleteMember(int id);
}
