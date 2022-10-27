package model;

public class LoginLogic {
	
	public boolean execute(User user) {
		
		if (user.getPassword().equals("1234")) {
			return true;
		} 
		return false;	
	}
}
