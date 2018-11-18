package Booky;

public class AddBooks {
static int count = 0;
	
	int id;
	String name;
	String author;
	int ISBN;
	String genre;
	String description;
	
	public AddBooks(String name, String author, int ISBN, String genre, String description) {
		super();
		this.name = name;
		this.author = author;
		this.ISBN = ISBN;
		this.genre = genre;
		this.description = description;
		this.id = count++;
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
	
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
}
