package clinicSys;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

public class adminLogin {

	Admin admin;
	String userName;
	String password;

	public adminLogin() {
		admin = new Admin("adminMNS", "adminclinicMNS");
	}

	@Given("That the Admin is not signed in")
	public void thatTheAdminIsNotSignedIn() {
		admin.signOut();
	}

	@Given("the Username is {string}")
	public void theUsernameIs(String string) {
		this.userName = "adminMNS";
	}

	@Given("the password is {string}")
	public void thePasswordIs(String string) {
		this.password = "adminclinicMNS";		
	}

	@Then("the Admin sign in succeeds")
	public void theAdminSignInSucceeds() {
		assertEquals(admin.signIn(userName, password), true);
	}

	@Then("the Admin is signed in")
	public void theAdminIsSignedIn() {
		assertEquals(admin.isSignedIn(), true);
	}

	@Given("the password is not {string}")
	public void the_password_is_not(String string) {
		this.password = "adminclinicMNS";
	}

	@Then("the Admin sign in fails")
	public void theAdminSignInFails() {
		this.userName = "adminMNSX";
		this.password = "adminclinicMNSX";
		assertEquals(admin.signIn(userName, password), false);
	}

	@Then("the Admin is not signed in")
	public void theAdminIsNotSignedIn() {
		assertEquals(admin.isSignedIn(), false);
	}

	@Given("the Username is not {string}")
	public void the_username_is_not(String string) {
		this.userName = "adminMNS";
	}

}
