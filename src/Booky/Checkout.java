package Booky;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

@WebServlet("/Checkout")
public class Checkout extends HttpServlet  {
	private static final long serialVersionUID = 1L;
    
    public Checkout() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imgLink = "/Images/mastercard.png";
		String imgLink1 = "/Images/amex.png";
		String imgLink2 = "/Images/visa.png";
		request.setAttribute("link", imgLink);
		request.setAttribute("link", imgLink1);
		request.setAttribute("link", imgLink2);
		
		ArrayList<Book> cart = (ArrayList<Book>) getServletContext().getAttribute("cart");
		int price = 0;
		if (cart != null) {
			for (int i = 0; i < cart.size(); i++) {
				price += cart.get(i).getPrice();
			}
		}
		
		request.setAttribute("total", price);
		request.getRequestDispatcher("/WEB-INF/Checkout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("upload");
		request.setAttribute("link", link);
		String email = request.getParameter("confirmEmail");
		getServletContext().setAttribute("confirmEmail", email);
		
		if (email == "") {
			response.sendRedirect("Checkout");
			return;
		}
		else {
			response.sendRedirect("Confirmation");
			return;
		}
	}
}
