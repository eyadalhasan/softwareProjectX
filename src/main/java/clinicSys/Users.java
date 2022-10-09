package clinicSys;

public class Users {

	protected String userName;
	protected String password;
	protected String role;
	protected boolean isSignedIn;

	public Users(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.isSignedIn = false;
	}
	
	public boolean checkUserName(String userName) {
		return this.userName.equals(userName);
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);		
	}

	public boolean signIn(String userName, String password) {
		this.isSignedIn = checkUserName(userName) && checkPassword(password);
		return this.isSignedIn;
	}

	public boolean signOut() {
		this.isSignedIn = false;
		return this.isSignedIn;
	}
	
	public boolean isSignedIn() {
		return this.isSignedIn;
	}

}
