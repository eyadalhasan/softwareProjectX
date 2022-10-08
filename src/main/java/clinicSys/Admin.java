package clinicSys;

public class Admin {

	protected String userName;
	protected String password;
	protected boolean isSignedIn;

	public Admin(String userName, String password) {
		this.userName = userName;
		this.password = password;
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
