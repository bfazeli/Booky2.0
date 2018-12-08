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

@WebServlet("/Sell")
public class Sell extends HttpServlet  {
	private static final long serialVersionUID = 1L;
    
    public Sell() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Sell.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
		
		String name = request.getParameter("newBookName");
		String author = request.getParameter("authorName");
		String ISBN = request.getParameter("isbnNumber");
		String genre = request.getParameter("genreName");
		String description = request.getParameter("bookDescription");
		String price = request.getParameter("price");
		String condition = request.getParameter("condition");
		
		if (name.isEmpty() || author.isEmpty() || ISBN.isEmpty() || genre.isEmpty() || description.isEmpty() || price.isEmpty()) {
			response.sendRedirect("Sell");
			return;
		} 
			else {
				double p =  Double.parseDouble(price);
				
				ArrayList<Book> myBooks = new ArrayList<Book>();
				ArrayList<Book> books = (ArrayList<Book>) getServletContext().getAttribute("books");
				Book b = new Book(ISBN, name, author, genre, condition, description, p);
				books.add(b);
				myBooks.add(b);
				
				getServletContext().setAttribute("myBooks", myBooks);
				getServletContext().setAttribute("books", books);
				
				response.sendRedirect("HomePage");
				return;
			}

	}
}
	
