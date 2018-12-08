package model;
import java.util.ArrayList;
public class Book {
	private String title;
	private String author;
	private String bookID;
	private String genre;
	private String condition;
	private String isbn;
	private String description;
	private double price;
	private ArrayList<String> sellers;
	private ArrayList<String> purchasers;
	public Book(String isbn, String title, String author,String genre, 
			String condition, String description, double price){
		this.title = title;
		this.condition = condition;
		this.description = description;
		this.author = author;
		this.genre = genre;
		this.isbn = isbn;
		this.price = price;
		this.purchasers = new ArrayList<String>();
		this.sellers = new ArrayList<String>();
	}
	public void addToSellersList(String userID) {
		sellers.add(userID);
	}
	public void addToPurchasersList(String userID) {
		purchasers.add(userID);
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public ArrayList<String> getSellers() {
		return sellers;
	}
	public void setSellers(ArrayList<String> sellers) {
		this.sellers = sellers;
	}
	public ArrayList<String> getPurchasers() {
		return purchasers;
	}
	public void setPurchasers(ArrayList<String> purchasers) {
		this.purchasers = purchasers;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}