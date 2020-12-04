package com.best.mtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.best.mtest.Book;
import com.best.mtest.Category;


public class BookDao {

	public String dbConnection="jdbc:mysql://localhost:3306/library_db";
	public BookDao() {
		
	}
	public List<Category> getBookCategory() throws Exception{
		String sql="select * from book_category";
		List<Category> categoryList=new ArrayList<Category>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				dbConnection,"root","root"); 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Category std=new Category(rs.getInt("id"), rs.getString("name"));
				categoryList.add(std);
			}
			return categoryList;
		}catch(Exception ex) {
			throw ex;
		}
		
	}
	
	public boolean saveBook(Book book) throws Exception {
		String sql="insert into book(name,photo,qty,category_id) values(?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					dbConnection,"root","root");  
				java.sql.PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, book.getName());
				pstmt.setString(2, book.getPhoto());
				pstmt.setInt(3, book.getQty());
				pstmt.setInt(4, book.getCategoryId());
				int status=pstmt.executeUpdate();
				if(status>0)
					return true;
				else
					return false;
		}catch(Exception ex) {
			throw ex;
		}
	}
	public List<Book> getBookList() throws Exception{
		String sql="select b.*,bc.id as categoryId,bc.name as categoryName from book b left join book_category bc on b.category_id=bc.id";
		List<Book> categoryList=new ArrayList<Book>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				dbConnection,"root","root"); 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Book std=new Book(rs.getInt("id"), rs.getString("name"),rs.getString("photo"),rs.getInt("qty"),rs.getInt("categoryId"),rs.getString("categoryName"));
				categoryList.add(std);
			}
			return categoryList;
		}catch(Exception ex) {
			throw ex;
		}
	}
}
