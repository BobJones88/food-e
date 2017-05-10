import java.io.IOException;
import java.util.ArrayList;

public class StringToGSON {

	ArrayList<String> fromServer = new ArrayList<String>();
	private String concatFromServer;
	private String requestedUserEmail;
	private String request;
	private int x = 0;


	public Person gsonWriter(ArrayList<String> fromServer) throws Throwable, IOException {
		
        this.fromServer = fromServer;
        
        //Temporary addition to add the JSONrequest since I'm not getting in anything from Dan ATM
        fromServer.add("email:SOMETHING");
        
        //Returns the String in position x
		concatFromServer = fromServer.get(x);
		
		//Splits the request from the server into a column name and an attribute
		//TODO This really needs to be a ArrayList<string> versus a String Array
		String ar[] = concatFromServer.split(":");
		if (ar[0].equals("email")) {
			requestedUserEmail = ar[1];
			//TODO add in else condition that returns 500 to HTTP server
		}
		
		//This is the SQL query string that is passed to the DB
		request = "SELECT * FROM USER WHERE EMAIL='" + requestedUserEmail + "'";
		
/*		//Some code here to test in case something breaks
  		System.out.println("Request: " + request);
		System.out.println("email variable: " + email);
		System.out.println("concatFromServer variable: " + concatFromServer);
		System.out.println("ar[1] variable: " + ar[1]);
		System.out.println("ar[0] variable: " + ar[0]);		
*/
		//Creates a connection object to the DB
		DBtrial con = new DBtrial();
		
		//Passes in the SQL Query Script to be executed, returns person object
		Person p = con.dbConnection(request);

		//Returns person object to ServerSox
        return p;
	}
}