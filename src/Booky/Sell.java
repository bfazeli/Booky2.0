package Booky;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		if (request.getParameter("submitButton") != null) {
			
			String name = request.getParameter("name");
			String author = request.getParameter("author");
			int ISBN = Integer.parseInt(request.getParameter("ISBN"));
			String genre = request.getParameter("genre");
			String description = request.getParameter("description");
			
			boolean isValidName = name != null && name.trim().length() > 0;
			boolean isValidAuthor = author != null && author.trim().length() > 0;
			boolean isValidISBN = ISBN != 0;
			boolean isValidGenre = genre != null && genre.trim().length() > 0;
			boolean isValidDescription = description != null && description.trim().length() > 0;
			
			
			if (isValidName && isValidAuthor && isValidISBN && isValidGenre && isValidDescription) {
				ArrayList<AddBooks> addBooks = (ArrayList<AddBooks>) getServletContext().getAttribute("addBooks");
				
				addBooks.add(new AddBooks(name, author, ISBN, genre, description));
			} 
			else {
				
				// Problem with the name?
				if (!isValidName)
					request.setAttribute("nameError", "Invalid Note");
			
				if (!isValidAuthor)
					request.setAttribute("messageError", "Invalid Message");
				if (!isValidISBN)
					request.setAttribute("messageError", "Invalid ISBN");
				if (!isValidGenre)
					request.setAttribute("messageError", "Invalid Genre");
				if (!isValidDescription)
					request.setAttribute("messageError", "Invalid Description");
				
				//response.sendRedirect("BookListing");
				
				doGet(request, response);
				return;
			}
	
		}

	}
}
	
