package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Book;
import utils.DbConnction;

public class BookDAO {
	private DbConnction mConnction;
	
	public BookDAO() {
		mConnction=new DbConnction();
	}
	
	public List<Book> getAllBooks(){
		List<Book> books=new ArrayList<>();
		mConnction.getConnection();
		String sql="select * from book";
		ResultSet set=mConnction.executeQuery(sql);
		try {
			while(set.next()) {
				books.add(new Book(set));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mConnction.closeConnection();
		}
		
		return books;
	}
	
	public List<Book> getBooks(int start, int count){
		List<Book> books=new ArrayList<>();
		mConnction.getConnection();
		String sql="select * from book limit "+start+","+count;
		ResultSet set=mConnction.executeQuery(sql);
		try {
			while(set.next()) {
				books.add(new Book(set));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mConnction.closeConnection();
		}
		
		return books;
	}
	
	public int getBookCount() {
		mConnction.getConnection();
		String sql="select count(*) from book";
		ResultSet set=mConnction.executeQuery(sql);
		try {
			if(set.next()) {
				return set.getInt(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public void addBook(Book book) {
		if(book==null) {
			return;
		}
		
		mConnction.getConnection();
		String sql="insert into book values"+book.toValues();
		mConnction.executeOther(sql);
		mConnction.closeConnection();
	}
	
	public void updateBook(Book book) {
		if(book==null) {
			return;
		}
		
		mConnction.getConnection();
		String sql="update book set "+book.toString()+" where id="+book.getId();
		mConnction.executeOther(sql);
		mConnction.closeConnection();
	}
	
	public void deleteBooks(List<Book> books) {
		
	}
	
	public List<Book> queryBy(String name, Object value){
		List<Book> books=new ArrayList<>();
		return books;
	}
	
	public List<Book> queryByRange(String name, Object start, Object end){
		List<Book> books=new ArrayList<>();
		return books;
	}
	
}
