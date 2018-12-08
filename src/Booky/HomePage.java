package Booky;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.API;
import model.Book;

@WebServlet(urlPatterns = "/HomePage", loadOnStartup = 2)
public class HomePage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final API api = new API();
       
    public HomePage() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        // Created a local, empty array list of type Guest Book Entry
        	ArrayList<Book> books = new ArrayList<Book>();
        	ArrayList<Book>	 results = new ArrayList<Book>();
        	
        	// Pre-populate my guest book with some entries
      		books.add( new Book("0810993139", "Diary of a Wimpy Kid", "Jeff Kinney", "fiction", "used",
      				"Diary of a Wimpy Kid is a satirical realistic fiction comedy novel for "
      				+ "children and teenagers written and illustrated by Jeff Kinney. "
      				+ "It is the first book in the Diary of a Wimpy Kid series. "
      				+ "The book is about a boy named Greg Heffley and his struggles to fit in as he begins middle school.", 31.20));
      		books.add( new Book("0590930028", "No, David!", "David Shannon", "fiction", "used", 
      				"Over fifteen years after its initial publication, NO, DAVID! "
      				+ "remains a perennial household favorite, delighting children, parents, and teachers alike. "
      				+ "David is a beloved character, whose unabashed good humor, mischievous smile, and laughter-inducing "
      				+ "antics underline the love parents have for their children--even when they misbehave.", 83.13));
      		books.add( new Book("1328869334", "George Orwell", "Science Fiction", "science-fiction", "used", 
      				"In 1984, London is a grim city in the totalitarian state of Oceania where Big Brother is always "
      				+ "watching you and the Thought Police can practically read your mind. "
      				+ "Winston Smith is a man in grave danger for the simple reason that his memory still functions. "
      				+ "Drawn into a forbidden love affair, Winston finds the courage to join a secret revolutionary "
      				+ "organization called The Brotherhood, dedicated to the destruction of the Party. Together "
      				+ "with his beloved Julia, he hazards his life in a deadly match against the powers that be.", 42.61));
       	books.add( new Book("9780451526342", "Animal Farm", "George Orwell", "Fantasy", "used", "A farm is taken over "
       			+ "by its overworked, mistreated animals. With flaming idealism and stirring slogans, "
       			+ "they set out to create a paradise of progress, justice, and equality. "
       			+ "Thus the stage is set for one of the most telling satiric fables ever penned—a razor-edged "
       			+ "fairy tale for grown-ups that records the evolution from revolution against tyranny "
       			+ "to a totalitarianism just as terrible.", 34.52));
       	
       	for(Book book : books) {
       		try {
				results.add(api.createBook(book, "123"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	}
        	getServletContext().setAttribute("books", books);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = (String) getServletContext().getAttribute("link");
		if (link == null) {
			String imgLink = request.getContextPath() + "/Images/SetProfile.png";
			getServletContext().setAttribute("link", imgLink);
		}
		
		String firstName = (String) getServletContext().getAttribute("firstName");
		String lastName = (String) getServletContext().getAttribute("lastName");
		if (firstName == null || lastName == null) {
			firstName = "John";
			lastName = "Doe";
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			
			getServletContext().setAttribute("firstName", firstName);
			getServletContext().setAttribute("lastName", lastName);
		}
		
		String email = (String) getServletContext().getAttribute("email");
		if (email == null) {
			email = "HelloWorld@gmail.com";
			getServletContext().setAttribute("email", email);
		}
		
		String address = (String) getServletContext().getAttribute("address");
		if (address == null) {
			address = "5151 State University Dr, Los Angeles, CA 90032";
			getServletContext().setAttribute("address", address);
		}
		
		String phoneNumber = (String) getServletContext().getAttribute("phoneNumber");
		if (phoneNumber == null) {
			phoneNumber = "(123) - 456 - 7890";
			getServletContext().setAttribute("phoneNumber", phoneNumber);
		}
		
		if (request.getParameter("filter") != null) {
			String filter = request.getParameter("filter");
			String text = request.getParameter("search").toLowerCase();
			ArrayList<Book> result = new ArrayList<Book>();
			
			System.out.println(filter);
			
			if (text.trim().length() == 0) {
				request.setAttribute("books", api.retrieveAllBooks());
			}
			else {
				switch(filter) {
					case "keyword":
						request.setAttribute("books", api.retrieveBookByKeyword(text));
						break;
					case "title":
						request.setAttribute("books", api.retrieveBookByTitle(text));
						break;
					case "all":
						request.setAttribute("books", api.retrieveBookByTheme(text));
						break;
					case "author":
						request.setAttribute("books", api.retrieveBookByAuthor(text));
						break;
					default:
						request.setAttribute("books", api.retrieveAllBooks());
						break;
				}
			}
			
			if (!result.isEmpty()) {
				getServletContext().setAttribute("books", result);
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getParameter("bookAddedToCart") != null) {
			String bookid = request.getParameter("bookAddedToCart");
			ArrayList<Book> books = (ArrayList<Book>) getServletContext().getAttribute("books");
			int id = 0;
			for (int i = 0; i < books.size(); i++) {
				if (bookid.equals(books.get(i).getBookID())) {
					id = i;
				}
			}
			
			ArrayList<Book> cart = new ArrayList<Book>();
			cart.add(books.get(id));
			
			getServletContext().setAttribute("cart", cart);
		}
		
		
		response.sendRedirect("HomePage");
		return;
	}

}
