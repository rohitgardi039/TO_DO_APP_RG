package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bo.app_bo;
import bo.app_bo_add;

import java.sql.Connection;

public class App_dao_class {
	
	public static Connection getConnection() {
		Connection con =null;
		try {
			String url="jdbc:mysql://localhost:3306/to_do_app";
			String username="root";
			String password="9307285627";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=(Connection) DriverManager.getConnection(url,username,password);
			
		}catch(Exception e)
		{
			
		}
		return con;
		
	}

	public static int signup(app_bo em)
	{
		int status=0;
		try
		{
			Connection con= App_dao_class.getConnection();
			String sql="insert into signup(name,email,phone,Password) values(?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1,em.getName());
			ps.setString(2, em.getEmail());
			ps.setString(3,em.getPhone());
			ps.setString(4,em.getPassword());
			status=ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	
	public static boolean userLogin(String email,String pass) {
		
		boolean status1 =false;
		
		try {
			Connection con=App_dao_class.getConnection();
			String sql="select * from signup where email=? and password=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			status1=rs.next();
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return status1;

			
				}

	public static int do_app(app_bo_add ab) {
		int status1=0;
		try {
			Connection con=App_dao_class.getConnection();
			String query="insert into add_app(task,status,Name) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, ab.getTask());
			ps.setString(2, ab.getStatus());
			ps.setString(3, ab.getName());
			
			
			status1=ps.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e);
		}
		return status1;
	}

	
	@SuppressWarnings("rawtypes")
	public static List getAllApp() {
	
			List<app_bo_add> list=new ArrayList<app_bo_add>();
			
			try {
				Connection con=App_dao_class.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from add_app");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
				app_bo_add ab=new app_bo_add();
					
					
					
			
					ab.setId(rs.getInt(1));
					ab.setTask(rs.getString(2));
					ab.setStatus(rs.getString(3));
					ab.setName(rs.getString(4));
					
					
					
			
					
					list.add(ab);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return list;
	}

	public static app_bo_add getappid(int tid) {
		
		 app_bo_add ab=new  app_bo_add();
		
	
		try {
			Connection con=App_dao_class.getConnection();
			String query="select * from  add_app where id=? ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, tid);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				
			
			ab.setId(rs.getInt(1));
			ab.setTask(rs.getString(2));
			ab.setStatus(rs.getString(3));
			ab.setName(rs.getString(4));
			
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ab;
		}
	
	public static int Update(app_bo_add  ab)  {
		int status1=0;
		
		try {
			
			Connection con=App_dao_class.getConnection();
			
			String query="update add_app set name=?,Task=?,status=? where id=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,ab.getName());
			ps.setString(2,ab.getTask());
			ps.setString(3,ab.getStatus());
			ps.setInt(4,ab.getId());
	
			status1=ps.executeUpdate();			
	
		}
		catch(Exception e) {
			System.out.println(e);
	
}

		return status1;
		
}
	
public static int delete(int id) {
		
		int status1=0;
		  try {
		
			  Connection con=App_dao_class.getConnection();
			  String query="Delete from  add_app where id=?";
			  PreparedStatement ps=con.prepareStatement(query);
			  ps.setInt(1, id);
			  status1=ps.executeUpdate();
			  
		} catch (Exception e) {
		
			   System.out.println(e);
		}
		
		return status1;
		
	}
}
