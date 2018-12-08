package model;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
public class API {
	public User createUser(User user) throws IOException {
		URL newUrl = new URL("http://localhost:3000/user-create");
		HttpURLConnection con = (HttpURLConnection)newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		String line = null;
		String str = "{"
				+ "\"firstName\": \"" + user.getFirstName() + "\","
				+ "\"lastName\": \"" + user.getLastName() + "\","
				+ "\"username\": \"" + user.getUsername() + "\","
				+ "\"password\": \"" + user.getPassword() + "\","
				+ "\"email\": \"" + user.getEmail() + "\","
				+ "\"address\": \"" + user.getAddress() + "\","
				+ "\"phoneNumber\": \"" + user.getPhoneNumber() + "\""
				+ "}";
		con.setDoOutput(true);
		OutputStream stream = con.getOutputStream();
		byte[] outputInBytes = str.getBytes("UTF-8");
		stream.write(outputInBytes);
		stream.close();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if(responseCode == 200) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			while((line = br.readLine()) != null) {
				System.out.println(line);
				response.append(line);
			}
			br.close();
			try {
				JSONObject obj = new JSONObject(response.toString());
				JSONArray arr = (obj).names();
				System.out.println(arr);
				for(int i = 0; i < arr.length(); i++) {
					System.out.println(obj.get(arr.getString(i)));
				}
				System.out.println("This method works");
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("RIP");
		}
		return null;
	}
	public Book createBook(Book book, String userID) throws IOException {
		URL newUrl = new URL("http://localhost:3000/book-create");
		HttpURLConnection con = (HttpURLConnection)newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		String line = null;
		String str = "{"
				+ "\"title\": \"" + book.getTitle() + "\","
				+ "\"author\": \"" + book.getAuthor() + "\","
				+ "\"id\": \"" + book.getBookID() + "\","
				+ "\"genre\": \"" + book.getGenre() + "\","
				+ "\"condition\": \"" + book.getCondition() + "\","
				+ "\"isbn\": \"" + book.getIsbn() + "\","
				+ "\"price\": \"" + String.valueOf(book.getPrice()) + "\","
				+ "\"description\": \"" + book.getDescription() + "\","
				+ "\"sellers\": {\"" + userID + "\":\"1\"}"
				+ "}";
		con.setDoOutput(true);
		OutputStream stream = con.getOutputStream();
		byte[] outputInBytes = str.getBytes("UTF-8");
		stream.write(outputInBytes);
		stream.close();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if(responseCode == 200) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			while((line = br.readLine()) != null) {
				System.out.println(line);
				response.append(line);
			}
			br.close();
			try { 
				JSONObject obj = new JSONObject(response.toString());
				Book result =  new Book (
						obj.getString("isbn"),
						obj.getString("title"), 
						obj.getString("author"),
						obj.getString("genre"),
						obj.getString("condition"),
						obj.getString("description"),
						Double.parseDouble(obj.getString("price"))
						);
				result.setBookID(obj.getString("id"));
				result.addToSellersList(userID);
				return result;
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("RIP");
		}
		return null;
	}
	//Check this method
	public User retrieveUserByID(String id) throws IOException {
		URL newUrl = new URL("http://localhost:3000/user-get");
		HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		String line = null;
		String str = "{"
				+ "\"id\": \"" + id + "\""
				+ "}";
		con.setDoOutput(true);
		OutputStream stream = con.getOutputStream();
		byte[] outputInBytes = str.getBytes("UTF-8");
		stream.write(outputInBytes);
		stream.close();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == 200) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			System.out.println(br);
			StringBuffer response = new StringBuffer();
			while((line = br.readLine()) != null) {
				System.out.println(line);
				response.append(line);
			}
			br.close();
			try {
				JSONObject obj = new JSONObject(response.toString());
				User result = new User(obj.getString("firstName"),
						obj.getString("lastName"), 
						obj.getString("username"),
						obj.getString("password"), 
						obj.getString("email"),
						obj.getString("address"), 
						obj.getString("phoneNumber"));
				return result;
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("RIP");
		}
		return null;
	}
	public Book retrieveBookByID(String id) throws IOException {
		URL newUrl = new URL("http://localhost:3000/book-get/" + id);
		HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == 200) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			String line = null;
			while((line = in.readLine()) != null) {
				response.append(line);
			} 
			in.close();
			try {
				JSONObject obj = new JSONObject(response.toString());
				Book result = new Book(
						obj.getString("isbn"),
						obj.getString("title"),
						obj.getString("author"),
						obj.getString("genre"),
						obj.getString("condition"),
						obj.getString("description"),
						Double.parseDouble(obj.getString("price")));
				return result;
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("RIP");
		}
		return null;
	}
	//Ask Bijan how the JSON object is returned and how to fit it into the return value
	public ArrayList<Book> retrieveBookByTitle(String title) throws IOException {
		System.out.println(title);
		URL newUrl = new URL("http://localhost:3000/book-title");
		HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		String line = null;
		String str = "{"
				+ "\"title\": \"" + title + "\""
				+ "}";
		con.setDoOutput(true);
		byte[] outputInBytes = str.getBytes("UTF-8");
		OutputStream stream = con.getOutputStream();
		stream.write(outputInBytes);
		stream.close();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == 200) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			System.out.println(br);
			StringBuffer response = new StringBuffer();
			while((line = br.readLine()) != null) {
				System.out.println(line);
				response.append(line);
			}
			br.close();
			try {
                JSONArray arr = new JSONObject(response.toString()).getJSONArray("books");
                JSONObject obj;
                ArrayList<Book> result = new ArrayList<Book>();
                for(int i = 0; i < arr.length(); i++) {
                    obj = arr.getJSONObject(i);
                    Book book =  new Book (
                            obj.getString("isbn"),
                            obj.getString("title"), 
                            obj.getString("author"),
                            obj.getString("genre"),
                            obj.getString("condition"),
                            obj.getString("description"),
                            Double.parseDouble(obj.getString("price")));
                    if (obj.getJSONObject("purchasers").length() > 0) {
                        JSONArray p = obj.getJSONObject("purchasers").names();
                        for(int j = 0; j < p.length(); j++) {
                            book.addToPurchasersList(p.getString(j));
                        }
                    }
                    if (obj.getJSONObject("sellers").length() > 0) {
                        JSONArray s = obj.getJSONObject("sellers").names();
                        for(int j = 0; j < s.length(); j++) {
                            book.addToPurchasersList(s.getString(j));
                        }
                    }
                    result.add(book);
                }
                System.out.println(result);
                return result;
            } catch(Exception e) {
                e.printStackTrace();
            }
		} else {
			System.out.println("RIP");
		}
		return null;
	}
	public List<Book> retrieveAllBooks() throws IOException {
		URL newUrl = new URL("http://localhost:3000/book-list");
		HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == 200) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			String line = null;
			while((line = in.readLine()) != null) {
				response.append(line);
			} 
			in.close();
			try {
                JSONArray arr = new JSONObject(response.toString()).getJSONArray("books");
                JSONObject obj;
                ArrayList<Book> result = new ArrayList<Book>();
                
                for(int i = 0; i < arr.length(); i++) {
                    obj = arr.getJSONObject(i);
                    Book book =  new Book (
                            obj.getString("isbn"),
                            obj.getString("title"), 
                            obj.getString("author"),
                            obj.getString("genre"),
                            obj.getString("condition"),
                            obj.getString("description"),
                            Double.parseDouble(obj.getString("price")));
                    if (obj.getJSONObject("purchasers").length() > 0) {
                        JSONArray p = obj.getJSONObject("purchasers").names();
                        for(int j = 0; j < p.length(); j++) {
                            book.addToPurchasersList(p.getString(j));
                        }
                    }
                    if (obj.getJSONObject("sellers").length() > 0) {
                        JSONArray s = obj.getJSONObject("sellers").names();
                        for(int j = 0; j < s.length(); j++) {
                            book.addToPurchasersList(s.getString(j));
                        }
                    }
                    result.add(book);
                }
                System.out.println(result);
                return result;
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
		return null;
	}
	public ArrayList<User> retrieveAllUsers() throws IOException {
		URL newUrl = new URL("http://localhost:3000/user-list");
		HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == 200) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			String line = null;
			while((line = in.readLine()) != null) {
				response.append(line);
			}
			in.close();
			try {
                JSONArray arr = new JSONObject(response.toString()).getJSONArray("users");
                JSONObject obj;
                ArrayList<User> result = new ArrayList<User>();
                for(int i = 0; i < arr.length(); i++) {
                    obj = arr.getJSONObject(i);
                    User user =  new User (
                            obj.getString("firstName"),
                            obj.getString("lastName"), 
                            obj.getString("username"),
                            obj.getString("password"),
                            obj.getString("email"),
                            obj.getString("address"),
                            obj.getString("phoneNumber")
                        );
                    if (obj.getJSONObject("soldBooks").length() > 0) {
                        JSONArray p = obj.getJSONObject("soldBooks").names();
                        for(int j = 0; j < p.length(); j++) {
                            user.addToSoldBooksList(p.getString(j));
                        }
                    }
                    if (obj.getJSONObject("purchasedBooks").length() > 0) {
                        JSONArray s = obj.getJSONObject("purchasedBooks").names();
                        for(int j = 0; j < s.length(); j++) {
                            user.addToPurchasedBooksList(s.getString(j));
                        }
                    }
                    result.add(user);
                }
                System.out.println(result);
                return result;
            } catch(Exception e) {
                e.printStackTrace();
            }
		} else {
			System.out.println("RIP");
		}
		return null;
	}
	/*public void addBookIDToSoldBooks(String bookID, String userID) throws IOException {
		User user = retrieveUserByID(userID);
		user.addBookToSoldList(bookID);
	}
	public void addBookIDToPurchasedBooks(String bookID, String userID) {
		
	}
	public void addUserIDToSellers(String userID, String bookID) {
		
	}
	public void addUserIDToPurchasers(String userID, String bookID) {
		
	}*/
	//Bijan should check this method
	public Book updateBook(Book book) throws IOException {
		URL newUrl = new URL("http://localhost:3000/user-update");
		HttpURLConnection con = (HttpURLConnection)newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		String line = null;
		String purchasers = "{";
		if(book.getPurchasers().size() > 0) {
			ArrayList<String> purchasersList = book.getPurchasers();
			int size = purchasersList.size();
			for(int i = 0; i < purchasersList.size(); i++) {
				if(i == size - 1) {
					purchasers += "\"" + purchasersList.get(i) + "\": \"1\"";
				} else {
					purchasers += "\"" + purchasersList.get(i) + "\": \"1\",";
				}
			}
		}
		purchasers += "}";
		String sellers = "{";
		if(book.getSellers().size() > 0) {
			ArrayList<String> sellersList = book.getSellers();
			int size = sellersList.size();
			for(int i = 0; i < sellersList.size(); i++) {
				if(i == size - 1) {
					sellers += "\"" + sellersList.get(i) + "\": \"1\"";
				} else {
					sellers += "\"" + sellersList.get(i) + "\": \"1\",";
				}
			}
		}
		sellers += "}";
		String str = "{"
				+ "\"title\": \"" + book.getTitle() + "\","
				+ "\"author\": \"" + book.getAuthor() + "\","
				+ "\"id\": \"" + book.getBookID() + "\","
				+ "\"genre\": \"" + book.getGenre() + "\","
				+ "\"condition\": \"" + book.getCondition() + "\","
				+ "\"isbn\": \"" + book.getIsbn() + "\","
				+ "\"price\": \"" + String.valueOf(book.getPrice()) + "\","
				+ "\"description\": \"" + book.getDescription() + "\","
				+ "\"sellers\": " + sellers + ","
				+ "\"purchasers\": " + purchasers
				+ "}";
		con.setDoOutput(true);
		OutputStream stream = con.getOutputStream();
		byte[] outputInBytes = str.getBytes("UTF-8");
		stream.write(outputInBytes);
		stream.close();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if(responseCode == 200) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			while((line = br.readLine()) != null) {
				System.out.println(line);
				response.append(line);
			}
			br.close();
			try {
				JSONObject obj = new JSONObject(response.toString());
				Book result = new Book(
						obj.getString("isbn"),
						obj.getString("title"),
						obj.getString("author"),
						obj.getString("genre"),
						obj.getString("condition"),
						obj.getString("description"),
						Double.parseDouble(obj.getString("price"))
						);
				return result;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public User updateUser(User user) throws IOException {
		URL newUrl = new URL("http://localhost:3000/user-update");
		HttpURLConnection con = (HttpURLConnection)newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		String line = null;
		String soldBooks = "{";
		if(user.getSoldBooks().size() > 0) {
			ArrayList<String> soldBooksList = user.getSoldBooks();
			int size = soldBooksList.size();
			for(int i = 0; i < soldBooksList.size(); i++) {
				if(i == size - 1) {
					soldBooks += "\"" + soldBooksList.get(i) + "\": \"1\"";
				} else {
					soldBooks += "\"" + soldBooksList.get(i) + "\": \"1\",";
				}
			}
		}
		soldBooks += "}";
		String purchasedBooks = "{";
		if(user.getPurchasedBooks().size() > 0) {
			ArrayList<String> purchasedBooksList = user.getPurchasedBooks();
			int size = purchasedBooksList.size();
			for(int i = 0; i < purchasedBooksList.size(); i++) {
				if(i == size - 1) {
					soldBooks += "\"" + purchasedBooksList.get(i) + "\": \"1\"";
				} else {
					soldBooks += "\"" + purchasedBooksList.get(i) + "\": \"1\",";
				}
			}
		}
		soldBooks += "}";
		String str = "{"
				+ "\"firstName\": \"" + user.getFirstName() + "\","
				+ "\"lastName\": \"" + user.getLastName() + "\","
				+ "\"id\": \"" + user.getUserID() + "\","
				+ "\"username\": \"" + user.getUsername() + "\","
				+ "\"password\": \"" + user.getPassword() + "\","
				+ "\"email\": \"" + user.getEmail() + "\","
				+ "\"address\": \"" + user.getAddress() + "\","
				+ "\"phoneNumber\": \"" + user.getPhoneNumber() + "\","
				+ "\"soldBooks\": " + soldBooks + ","
				+ "\"purchasedBooks\": " + purchasedBooks
				+ "}";
		con.setDoOutput(true);
		OutputStream stream = con.getOutputStream();
		byte[] outputInBytes = str.getBytes("UTF-8");
		stream.write(outputInBytes);
		stream.close();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if(responseCode == 200) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			while((line = br.readLine()) != null) {
				System.out.println(line);
				response.append(line);
			}
			br.close();
			try {
				JSONObject obj = new JSONObject(response.toString());
				User result = new User(
						obj.getString("firstName"),
						obj.getString("lastName"),
						obj.getString("username"),
						obj.getString("password"),
						obj.getString("email"),
						obj.getString("address"),
						obj.getString("phoneNumber")
						);
				return result;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public ArrayList<Book> retrieveBookByKeyword(String keyword) throws IOException {
		System.out.println(keyword);
		URL newUrl = new URL("http://localhost:3000/book-keyword");
		HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		String line = null;
		String str = "{"
				+ "\"text\": \"" + keyword + "\""
				+ "}";
		con.setDoOutput(true);
		byte[] outputInBytes = str.getBytes("UTF-8");
		OutputStream stream = con.getOutputStream();
		stream.write(outputInBytes);
		stream.close();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == 200) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			System.out.println(br);
			StringBuffer response = new StringBuffer();
			while((line = br.readLine()) != null) {
				System.out.println(line);
				response.append(line);
			}
			br.close();
			try {
                JSONArray arr = new JSONObject(response.toString()).getJSONArray("books");
                JSONObject obj;
                ArrayList<Book> result = new ArrayList<Book>();
                for(int i = 0; i < arr.length(); i++) {
                    obj = arr.getJSONObject(i);
                    Book book =  new Book (
                            obj.getString("isbn"),
                            obj.getString("title"), 
                            obj.getString("author"),
                            obj.getString("genre"),
                            obj.getString("condition"),
                            obj.getString("description"),
                            Double.parseDouble(obj.getString("price")));
                    if (obj.getJSONObject("purchasers").length() > 0) {
                        JSONArray p = obj.getJSONObject("purchasers").names();
                        for(int j = 0; j < p.length(); j++) {
                            book.addToPurchasersList(p.getString(j));
                        }
                    }
                    if (obj.getJSONObject("sellers").length() > 0) {
                        JSONArray s = obj.getJSONObject("sellers").names();
                        for(int j = 0; j < s.length(); j++) {
                            book.addToPurchasersList(s.getString(j));
                        }
                    }
                    result.add(book);
                }
                System.out.println(result);
                return result;
            } catch(Exception e) {
                e.printStackTrace();
            }
		} else {
			System.out.println("RIP");
		}
		return null;
	}
	public ArrayList<Book> retrieveBookByAuthor(String author) throws IOException {
		System.out.println(author);
		URL newUrl = new URL("http://localhost:3000/book-author");
		HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		String line = null;
		String str = "{"
				+ "\"text\": \"" + author + "\""
				+ "}";
		con.setDoOutput(true);
		byte[] outputInBytes = str.getBytes("UTF-8");
		OutputStream stream = con.getOutputStream();
		stream.write(outputInBytes);
		stream.close();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == 200) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			System.out.println(br);
			StringBuffer response = new StringBuffer();
			while((line = br.readLine()) != null) {
				System.out.println(line);
				response.append(line);
			}
			br.close();
			try {
                JSONArray arr = new JSONObject(response.toString()).getJSONArray("books");
                JSONObject obj;
                ArrayList<Book> result = new ArrayList<Book>();
                for(int i = 0; i < arr.length(); i++) {
                    obj = arr.getJSONObject(i);
                    Book book =  new Book (
                            obj.getString("isbn"),
                            obj.getString("title"), 
                            obj.getString("author"),
                            obj.getString("genre"),
                            obj.getString("condition"),
                            obj.getString("description"),
                            Double.parseDouble(obj.getString("price")));
                    if (obj.getJSONObject("purchasers").length() > 0) {
                        JSONArray p = obj.getJSONObject("purchasers").names();
                        for(int j = 0; j < p.length(); j++) {
                            book.addToPurchasersList(p.getString(j));
                        }
                    }
                    if (obj.getJSONObject("sellers").length() > 0) {
                        JSONArray s = obj.getJSONObject("sellers").names();
                        for(int j = 0; j < s.length(); j++) {
                            book.addToPurchasersList(s.getString(j));
                        }
                    }
                    result.add(book);
                }
                System.out.println(result);
                result.size();
                return result;
            } catch(Exception e) {
                e.printStackTrace();
            }
		} else {
			System.out.println("RIP");
		}
		return null;
	}
	public ArrayList<Book> retrieveBookByTheme(String theme) throws IOException {
		System.out.println(theme);
		URL newUrl = new URL("http://localhost:3000/book-theme");
		HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		String line = null;
		String str = "{"
				+ "\"text\": \"" + theme + "\""
				+ "}";
		con.setDoOutput(true);
		byte[] outputInBytes = str.getBytes("UTF-8");
		OutputStream stream = con.getOutputStream();
		stream.write(outputInBytes);
		stream.close();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		if (responseCode == 200) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			System.out.println(br);
			StringBuffer response = new StringBuffer();
			while((line = br.readLine()) != null) {
				System.out.println(line);
				response.append(line);
			}
			br.close();
			try {
                JSONArray arr = new JSONObject(response.toString()).getJSONArray("books");
                JSONObject obj;
                ArrayList<Book> result = new ArrayList<Book>();
                for(int i = 0; i < arr.length(); i++) {
                    obj = arr.getJSONObject(i);
                    Book book =  new Book (
                            obj.getString("isbn"),
                            obj.getString("title"), 
                            obj.getString("author"),
                            obj.getString("genre"),
                            obj.getString("condition"),
                            obj.getString("description"),
                            Double.parseDouble(obj.getString("price"))
                        );
                    if (obj.getJSONObject("purchasers").length() > 0) {
                        JSONArray p = obj.getJSONObject("purchasers").names();
                        for(int j = 0; j < p.length(); j++) {
                            book.addToPurchasersList(p.getString(j));
                        }
                    }
                    if (obj.getJSONObject("sellers").length() > 0) {
                        JSONArray s = obj.getJSONObject("sellers").names();
                        System.out.println(s.length());
                        for(int j = 0; j < s.length(); j++) {
                        	System.out.println(s.getString(j));
                            book.addToPurchasersList(s.getString(j));
                        }
                    }
                    result.add(book);
                }
                System.out.println(result);
                return result;
            } catch(Exception e) {
                e.printStackTrace();
            }
		} else {
			System.out.println("RIP");
		}
		return null;
	}
}