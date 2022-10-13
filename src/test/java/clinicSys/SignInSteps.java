package clinicSys;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import io.cucumber.core.cli.Main;

public class SignInSteps {

	String userName;
	String password;
	String role;
	ArrayList<Users> usersList = new ArrayList<Users>();
	Users user;;

	@Given("the user on the login page")
	public void theUserOnTheLoginPage() {

	}

	@When("the user enter one of the following user name and password regardless his role")
	public void theUserEnterOneOfTheFollowingUserNameAndPasswordRegardlessHisRole(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> rows = dataTable.asLists(String.class);
		user = null;
		for (int i = 0; i < rows.size(); i++) {
			Users addUser = new Users(rows.get(i).get(0), rows.get(i).get(1), rows.get(i).get(2));
			usersList.add(addUser);
		}
	}

	@Given("That the {string} is not signed in")
	public void thatTheIsNotSignedIn(String role) {

		for (int i = 0; i < usersList.size(); i++) {
			usersList.get(i).isSignedIn = false;

		}

	}

	@Given("the {string} username is {string}")
	public void theUsernameIs(String role, String userName) {
		this.userName = userName;
		this.role = role;

	}

	@Given("the {string} password is {string}")
	public void thePasswordIs(String role, String password) {
		this.password = password;
		for (int i = 0; i < usersList.size(); i++) {

			if (usersList.get(i).checkUserName(this.userName) && usersList.get(i).checkRole(role)
					&& usersList.get(i).checkPassword(this.password) && !usersList.get(i).isSignedIn()) {
				this.password = password;
				this.role = role;
				user = usersList.get(i);

			}

		}

	}

	@Then("the {string} sign in succeeds")
	public void theSignInSucceeds(String role) {

	assertEquals(user.signIn(userName, password), true);



	}

	@Then("the {string} is signed in")
	public void theIsSignedIn(String string) {
		if (user != null) {

		assertEquals(user.isSignedIn, true);
		}

	}

	@Then("go to {string} Page")
	public void goToPage(String string) {

	}


	//////////////////////////////////////////////////////////////////////////////////

	@Given("the {string} password is not {string}")
	public void thePasswordIsNot(String role, String password) {
		this.password = password;
		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.get(i).checkUserName(this.userName) && usersList.get(i).checkRole(role)
				&& !usersList.get(i).checkPassword(this.password) && !usersList.get(i).isSignedIn()) {
				this.role = role;
				user = usersList.get(i);

			}

		}

	}

	@Then("the {string} sign in not  succeeds")
	public void theSignInNotSucceeds(String role) {
		assertEquals(user.signIn(userName, password), false);
	}

	@Then("the {string} is not  signed in")
	public void theIsNotSignedIn(String role) {
		if (user != null) {
	
			assertEquals(user.isSignedIn, false);
		}
	}

	

}
