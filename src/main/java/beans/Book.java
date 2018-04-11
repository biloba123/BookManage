package beans;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
	private int id;
	private String isbn;
	private String name;
	private String author;
	private float price;
	private Date publishTime;
	private float discount;
	private int stock;
	
	public Book() {
		
	}
	
	public Book(ResultSet rSet) {
		try {
			id=rSet.getInt("id");
			isbn=rSet.getString("isbn");
			name=rSet.getString("name");
			author=rSet.getString("author");
			price=rSet.getFloat("price");
			publishTime=rSet.getDate("publishTime");
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
		return publishTime.toString();
	}
	public void setPublishTime(Date publishTime) {
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
				'\''+getPublishTime()+"\',"+
				discount+','+
				stock+','+")";
	}

	@Override
	public String toString() {
		return "isbn=\'" + isbn + "\', name=\'" + name + "\', author=\'" + author + "\', price=" + price + ", publishTime=\'"
				+ publishTime + "\', discount=" + discount + ", stock=" + stock;
	}
	
	
}
