package com.bitwise.validate;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 
		    		Pattern.CASE_INSENSITIVE);

	public static boolean isEmpty(String param){
		if(param==null ||param.isEmpty()){
			return true;
		}
		return false;
		
	}
	public static boolean isValidEmail(String username) {
		 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(username);
	     return matcher.find();		
	}
	public static boolean isValidString(String string) {
		String pattern= "^[a-zA-Z0-9]*$";
        if(string.matches(pattern)){
            return true;
        }
        return false;   	
	}
	public static boolean isValidNumber(String string) {
		String pattern= "[0-9]+";
        if(string.matches(pattern)){
            return true;
        }
        return false;   	
	}
 
	

}
