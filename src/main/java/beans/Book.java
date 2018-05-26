package beans;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.StringUtils;

public class Book {
	private int id;
	private String isbn;
	private String name;
	private String author;
	private float price;
	private String publishTime;
	private float discount;
	private int stock;
	
	//通过表单提交的数据构建Book
	public Book(HttpServletRequest request) throws UnsupportedEncodingException {  
		name=new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		author=new String(request.getParameter("author").getBytes("iso-8859-1"), "utf-8");
		isbn=request.getParameter("isbn");
		String price=request.getParameter("price");
		if(!StringUtils.isNullOrEmpty(price)) {
			this.price=Float.valueOf(price);
		}
		String discount=request.getParameter("discount");
		if(!StringUtils.isNullOrEmpty(discount)) {
			this.discount=Float.valueOf(discount);
		}
		String publishTime=request.getParameter("publishTime");
		if(!StringUtils.isNullOrEmpty(publishTime)) {
			this.publishTime=publishTime;
		}
		String stock=request.getParameter("stock");
		if(!StringUtils.isNullOrEmpty(stock)) {
			this.stock=Integer.valueOf(stock);
		}
	}
	
	//通过数据库查询结果集构建
	public Book(ResultSet rSet) {
		try {
			id=rSet.getInt("id");
			isbn=rSet.getString("isbn");
			name=rSet.getString("name");
			author=rSet.getString("author");
			price=rSet.getFloat("price");
			Date date=rSet.getDate("publishTime");
			publishTime=date==null?null: date.toString();
			discount=rSet.getFloat("discount");
			stock=rSet.getInt("stock");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toValues() {
		return "(null,"+
				'\''+isbn+"\',"+
				'\''+name+"\',"+
				'\''+author+"\',"+
				price+','+
				(publishTime==null?"null":'\''+publishTime+'\'')+','+
				discount+','+
				stock+")";
	}

	@Override
	public String toString() {
		return "isbn=\'" + isbn + "\', name=\'" + name + "\', author=\'" + author + "\', price=" + price 
				+ (publishTime==null?"": ", publishTime="+"\'"+publishTime+"\'") + ", discount=" + discount + ", stock=" + stock;
	}
	
	
}
