package Booky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		HomePage.getSynonyms("fire");
		
		
		
		request.getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
		
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
			System.out.println("Rip");
		}
		
	}

}
