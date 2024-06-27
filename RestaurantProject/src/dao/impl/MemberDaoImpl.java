package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao {

	public static void main(String[] args) {
		Member m=new MemberDaoImpl().queryUsername("uuuuuu");
		System.out.println(m);
		

	}

	@Override
	public void addMember(String name, String account, String password, String address, String phone,String permission) {
		/*
		 * 1.先連線
		 * 2.SQL
		 * 3.PreparedStatement-->set..
		 * 4.executeupdate
		 */
		
		Connection conn=DbConnection.getDb();
		String SQL="insert into member(name,account,password,address,phone,permission) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, name);
			ps.setString(2, account);
			ps.setString(3, password);
			ps.setString(4, address);
			ps.setString(5, phone);
			ps.setString(6, permission);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void addMember(Member m) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into member(name,account,password,address,phone,permission) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getAccount());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getPermission());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Member> queryAll() {
		/*
		 * 1.先連線-->Connection
		 * 2.sQL
		 * 3.new ArrayList
		 * 4.執行-->preparedstatement-->executeQuery
		 * 5.ResultSet-->顯示-->List
		 * 
		 */
		
		
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setPermission(rs.getString("permission"));
				
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
		String SQL="select * from member";
		String show="";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				show=show+"ID:"+rs.getInt("id")+
						"    姓名:"+rs.getString("name")+
						"    帳號:"+rs.getString("account")+
						"    密碼:"+rs.getString("password")+
						"    地址:"+rs.getString("address")+
						"    電話:"+rs.getString("phone")+
						"    權限:"+rs.getString("permission")+"\n";
			}  
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return show;
	}

	@Override
	public Member queryMemberById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where id=?";
		Member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setPermission(rs.getString("permission"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}

	@Override
	public void updateMember(Member m) {//改好舊會員inject
		Connection conn=DbConnection.getDb();
		String SQL="update company.member set name=?,password=?,address=?,phone=?,permission=? where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getAddress());
			ps.setString(4, m.getPhone());
			ps.setString(5, m.getPermission());
			ps.setInt(6, m.getId());

			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteMember(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from member where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Member queryMember(String account, String password) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where account=? and password=?";
		Member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, account);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setPermission(rs.getString("permission"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return m;
	}

	@Override
	public Member queryUsername(String account) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where account=?";
		Member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, account);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new Member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

}