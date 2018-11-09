package Booky;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		request.getRequestDispatcher("/WEB-INF/Checkout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("upload");
		request.setAttribute("link", link);
		response.sendRedirect("Checkout");
	}
}
