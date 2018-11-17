package Booky;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;


@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Profile() {
        super();
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = (String) getServletContext().getAttribute("link");
		if (link == null) {
			String imgLink = request.getContextPath() + "/Images/SetProfile.png";
			request.setAttribute("link", imgLink);
		}
		else {
			request.setAttribute("link", link);
		}
		
		request.getRequestDispatcher("/WEB-INF/Profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("imgLink");
		getServletContext().setAttribute("link", link);
		response.sendRedirect("Profile");
		return;
	}

}
