package clinic;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import clinic.Users;

public class SignInSteps {

	String userName;
	String password;
	String role;
	ArrayList<Users> usersList = new ArrayList<Users>();
	Users user;


	@Given("the user on the login page")
	public void theUserOnTheLoginPage() {

	}

	@When("the user enter one of the following user name and password regardless his role")
	public void theUserEnterOneOfTheFollowingUserNameAndPasswordRegardlessHisRole(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> rows = dataTable.asLists(String.class);

		for (int i = 0; i < rows.size(); i++) {
			Users addUser;
			if (rows.get(i).get(2).equals("Admin"))
				addUser = new Admin(rows.get(i).get(0), rows.get(i).get(1), rows.get(i).get(2));
			else if (rows.get(i).get(2).equals("Doctor"))
				addUser = new Doctor(rows.get(i).get(0), rows.get(i).get(1), rows.get(i).get(2));
			else if (rows.get(i).get(2).equals("Patient"))
				addUser = new Patient(rows.get(i).get(0), rows.get(i).get(1), rows.get(i).get(2));
			else
				addUser = new Secretary(rows.get(i).get(0), rows.get(i).get(1), rows.get(i).get(2));
			usersList.add(addUser);
		}
	}

	@Given("That the {string} is not signed in")
	public void thatTheIsNotSignedIn(String role) {

		for (int i = 0; i < usersList.size(); i++)
		assertFalse(usersList.get(0).isSignedIn());
	}

	@Given("the {string} username is {string}")
	public void theUsernameIs(String role, String userName) {
		this.userName = userName;
		this.role = role;

	}

	@Given("the {string} password is {string}")
	public void thePasswordIs(String role, String password) {
		this.password = password;

	}

	@Then("the {string} sign in succeeds")
	public void theSignInSucceeds(String role) {

		for (int i = 0; i < usersList.size(); i++)
			if (usersList.get(i).checkRole(role))
			assertTrue(usersList.get(i).signIn(userName, password));

	}

	@Then("the {string} is signed in")
	public void theIsSignedIn(String string) {
				
		for (int i = 0; i < usersList.size(); i++)
			if (usersList.get(i).checkRole(role)) {
				assertTrue(usersList.get(i).isSignedIn());
				if (role.equals("Admin")) {
					user = new Admin(userName, password, role);
					assertEquals(true, usersList.get(i).equals(user));
				}
				else if (role.equals("Doctor")) {
					user = new Doctor(userName, password, role);
					assertEquals(true, usersList.get(i).equals(user));
				}
				else if (role.equals("Secretary")) {
					user = new Secretary(userName, password, role);
					assertEquals(true, usersList.get(i).equals(user));
				}
			}
	}

	@Then("go to {string} page")
	public void goToPage(String string) {

	}

	@Then("the {string} sign in not succeeds")
	public void theSignInNotSucceeds(String string) {
		for (int i = 0; i < usersList.size(); i++)
			if (usersList.get(i).checkRole(role))
				assertFalse(usersList.get(i).signIn(userName, password));
	}
	@Then("the {string} is not signed in")
	public void theIsNotSignedIn(String string) {
		for (int i = 0; i < usersList.size(); i++)
			if (usersList.get(i).checkRole(role)) {
				assertFalse(usersList.get(i).isSignedIn());
				if (role.equals("Admin")) {
					user = new Admin(userName, password, role);
					assertEquals(false, usersList.get(i).equals(user));
				}
				else if (role.equals("Doctor")) {
					user = new Doctor(userName, password, role);
					assertEquals(false, usersList.get(i).equals(user));
				}
				else if (role.equals("Secretary")) {
					user = new Secretary(userName, password, role);
					assertEquals(false, usersList.get(i).equals(user));
				}
			}
	}

}
