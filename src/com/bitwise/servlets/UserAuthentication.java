package com.bitwise.servlets;



	import java.util.HashMap;
	import java.util.Map;

	import javax.servlet.http.HttpServlet;

	import com.bitwise.validate.Validate;

	public class UserAuthentication{
		public Map<String,String> user = new HashMap<String,String>();
		
		
		public UserAuthentication() {
			if (user.size() == 0) {
				user.put("batman@bitwise.com","1235");
		    	user.put("mike@bitwise.com","1237");
		    	user.put("thor@bitwise.com","1236");
		    	user.put("hulk@bitwise.com","1234");	
			}
		}
		public boolean CheckIfUserIsAvailable(String username, String password){
			
			if (user.containsKey(username) && user.get(username).equals(password)) {
				return true;
			}
			
			return false;		
		}
		
		
	}



