package model;
import java.util.ArrayList;
public class User {
	private String firstName;
	private String lastName;
	private String userID;
	private String username;
	private String password;
	private ArrayList<String> soldBooks;
	private ArrayList<String> purchasedBooks;
	private String email;
	private String address;
	private String phoneNumber;
	public User(ArrayList<String> purchasedBooks, ArrayList<String> soldBooks, String firstName, String lastName,
			String username, String password,String email, String address,
			String phoneNumber, String userID) {
		this.address = address;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.soldBooks = soldBooks;
		this.purchasedBooks = purchasedBooks;
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void addBookToPurchasedList(String bookID) {
		this.purchasedBooks.add(bookID);
	}
	public void addBookToSoldList(String bookID) {
		this.soldBooks.add(bookID);
	}
	public ArrayList<String> getSoldBooks() {
		return soldBooks;
	}
	public void setSoldBooks(ArrayList<String> soldBooks) {
		this.soldBooks = soldBooks;
	}
	public ArrayList<String> getPurchasedBooks() {
		return purchasedBooks;
	}
	public void setPurchasedBooks(ArrayList<String> purchasedBooks) {
		this.purchasedBooks = purchasedBooks;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}