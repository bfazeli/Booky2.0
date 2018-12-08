package Booky;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProfile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/EditProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("imgLink");
		String firstName = request.getParameter("changeFirstName");
		String lastName = request.getParameter("changeLastName");
		String email = request.getParameter("changeEmail");
		String phoneNumber = request.getParameter("changePhoneNumber");
		String address = request.getParameter("changeAddress");
		
		if (link == "") {
			link = (String) getServletContext().getAttribute("link");
		}
		
		getServletContext().setAttribute("link", link);
		getServletContext().setAttribute("firstName", firstName);
		getServletContext().setAttribute("lastName", lastName);
		getServletContext().setAttribute("email", email);
		getServletContext().setAttribute("phoneNumber", phoneNumber);
		getServletContext().setAttribute("address", address);
		
		response.sendRedirect("Profile");
		return;
	}

}
