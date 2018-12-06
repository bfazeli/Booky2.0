package Booky;

import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;

@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static Map<String, String> apiDictionary = new HashMap<String, String>();
	private final String app_id = "87370f42";
	private final String api_key = "69daf2ab9761c11273dd3bb264babec9";
       
    public HomePage() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        HomePage.apiDictionary.putIfAbsent("api_key", api_key);
        HomePage.apiDictionary.putIfAbsent("app_id", app_id);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HomePage.getSynonyms("fire");
		
		
		final String text = request.getParameter("search");
		final String id = request.getParameter("id");
		
		System.out.println(id);
		
		
		
		new Thread(() -> {
			try {
				request.setAttribute("book", createBook("e24e0850-f771-11e8-8b08-ad74be2903c1"));
				request.getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		
		
		if (text != null) {
			final String filter = request.getParameter("filter");
			
			// Make this asynch
			new Thread(() -> {
				
				try {
					request.getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();
			
		}
		else if (id != null) {
			
		}
		else {
			request.setAttribute("loading", "true");
			request.getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
		}
		
		
	}

	private StringBuffer createBook(String id) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(id);
		URL url = new URL("http://localhost:3000/book-create");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept", "application/json");
		String line = null;
		String str =  "{"
				+ "\"title\": \"string\","
				+ "\"author\":\"string\","
				+ "\"bookId\":\"string\","
				+ "\"genre\":\"string\","
				+ "\"condition\":\"string\","
				+ "\"isbn\":\"string\","
				+ "\"description\":\"string\""
				+ "}";
		
		con.setDoOutput(true);
		byte[] outputInBytes = str.getBytes("UTF-8");
		OutputStream os = con.getOutputStream();
		os.write( outputInBytes );    
		os.close();
		
		
		
		int responseCode = con.getResponseCode();
		
		if (responseCode == 201) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			System.out.println(in);
			
			
			
			while((line= in.readLine()) != null) {
				System.out.println(line);
				response.append(line);
			} in.close();
			

			try {
				JSONObject jObj = new JSONObject(response.toString());
				JSONArray j = (jObj).names();
				
				System.out.println(j);
				
				for(int i = 0; i < j.length(); i++) {
					
					System.out.println(jObj.get(j.getString(i)));
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				Object obj = parser.parse(response.toString());
//				JSONArray array = (JSONArray) obj;
//				System.out.println(array.get(1));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			System.out.println("hello");
			
			//response.substring(response.indexOf("condition") + 1, response.indexOf("author"))
		}
		else {
			System.out.println("RIP");
		}
		
		return null;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public static void getSynonyms(String syn) throws IOException {
		
		URL url = new URL("https://od-api.oxforddictionaries.com:443/api/v1/entries/en/ace/synonyms");
		String line = null;
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		con.setRequestMethod("GET");
		
//		con.setRequestMethod("GET");
		con.setRequestProperty("Accept","application/json");
		con.setRequestProperty("app_id", "87370f42");
		con.setRequestProperty("app_key", "69daf2ab9761c11273dd3bb264babec9");
		
		int responseCode = con.getResponseCode();
		System.out.println(con.getResponseMessage());
		
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			while((line = in.readLine()) != null) {
				response.append(line);
			} 
			
			in.close();
			
			System.out.println("JSON " + response.toString());
		}
		else {
			// System.out.println("Rip");
		}
		
	}

}
