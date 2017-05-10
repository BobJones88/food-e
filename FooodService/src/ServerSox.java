import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerSox {
	private static int port = 10250;
	//TODO Add threading
	//TODO Add JSON Reader
	//TODO Add Maven
	
	
	public static void main(String[] args) throws Throwable {
	
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server established. Listening on port " + port +".");
			ArrayList<String> ar = new ArrayList<String>();
			
			while (true) {
				Socket socket = serverSocket.accept();				

//			    String inStr;
//			    String inStrConcat = null; //Will be used to write a JSON object
			    
//			    BufferedReader in = new BufferedReader(
//			            new InputStreamReader(socket.getInputStream()));
			    
//			    while ((inStr = in.readLine()) != null) {
//			    	System.out.println("From Client: " + inStr.toString());
//			    //	inStrConcat = inStrConcat + "CC: " + inStr + "\n";
//			    }
			    
//				String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + " Welcome to the Server";
//				socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
				
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				
				out.println("HTTP/1.0 200 OK");
				out.println("Content-Type: text/html");
			    out.println("Server: DBservice");

			    out.println(""); //End of Headers

			    out.flush();

				System.out.println("200 Sent to " + socket.getLocalAddress());
				System.out.println("");
			    
//			    while ((inStr = in.readLine()) != null) {
//					ar.add(inStr.toString());
//			    }
			    
				StringToGSON gsonFromServer = new StringToGSON();
				
				Person p = gsonFromServer.gsonWriter(ar);
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
//				System.out.println("Json: " + gson.toJson(p));
//				System.out.println("toString: " + gson.toJson(p).toString());
				
//				socket.getOutputStream().flush();
//				socket.getOutputStream().write(gson.toJson(p).toString().getBytes("UTF-8"));
//				socket.getOutputStream().flush();
//				socket.getOutputStream().write(port);
//				
//				socket.getOutputStream().flush();
				
				out.println("<H1>Bob Jones</H2>");
				
				out.println(gson.toJson(p));
				
				if (port < 100) {
					serverSocket.close();
				}
			}
		}	
		
		catch (IOException e) {
			System.out.println(e);
		}
	}
}
