package clinicSys;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class SignInSteps {

	String userName;
	String password;
	ArrayList<Users> usersList = new ArrayList<Users>();

	@Given("the user on the login page")
	public void theUserOnTheLoginPage() {
		
	}

	@When("the user enter one of the following user name and password regardless his role")
	public void theUserEnterOneOfTheFollowingUserNameAndPasswordRegardlessHisRole(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> rows = dataTable.asLists(String.class);

		for (int i = 0; i < rows.size(); i++) {
			Users addUser = new Users(rows.get(i).get(0), rows.get(i).get(1), rows.get(i).get(2));
			usersList.add(addUser);
		}

	}

	public SignInSteps() {
		
	}

	@Given("That the Admin is not signed in")
	public void thatTheAdminIsNotSignedIn() {
		usersList.get(0).signOut();		
	}
	
	@Given("That the Doctor is not signed in")
	public void thatTheDoctorIsNotSignedIn() {
		usersList.get(1).signOut();	
	}
	
	@Given("That the Patient is not signed in")
	public void thatThePatientIsNotSignedIn() {
		usersList.get(2).signOut();	
	}
	
	@Given("That the Secretary is not signed in")
	public void thatTheSecretaryIsNotSignedIn() {
		usersList.get(3).signOut();	
	}

	@Given("the Username is {string}")
	public void theUsernameIs(String string) {
		this.userName = "adminMNS";
	}

	@Given("the password is {string}")
	public void thePasswordIs(String string) {
		this.password = "adminclinicMNS";
	}
	
	@Given("the Admin username is {string}")
	public void theAdminUsernameIs(String string) {
		this.userName = usersList.get(0).userName;
	}

	@Given("the Admin password is {string}")
	public void theAdminPasswordIs(String string) {
		this.password = usersList.get(0).password;
	}

	@Given("the Doctor username is {string}")
	public void theDoctorUsernameIs(String string) {
		this.userName = usersList.get(1).userName;
	}

	@Given("the Doctor password is {string}")
	public void theDoctorPasswordIs(String string) {
		this.password = usersList.get(1).password;
	}

	@Given("the Patient username is {string}")
	public void thePatientUsernameIs(String string) {
		this.userName = usersList.get(2).userName;
	}

	@Given("the Patient password is {string}")
	public void thePatientPasswordIs(String string) {
		this.password = usersList.get(2).password;
	}

	@Given("the Secretary username is {string}")
	public void theSecretaryUsernameIs(String string) {
		this.userName = usersList.get(3).userName;
	}

	@Given("the Secretary password is {string}")
	public void theSecretaryPasswordIs(String string) {
		this.password = usersList.get(3).password;
	}
	
	@Then("the Admin sign in succeeds")
	public void theAdminSignInSucceeds() {
		assertEquals(usersList.get(0).signIn(userName, password), true);
	}

	@Then("the Admin is signed in")
	public void theAdminIsSignedIn() {
		assertEquals(usersList.get(0).isSignedIn(), true);
	}
	
	@Then("the Doctor sign in succeeds")
	public void theDoctorSignInSucceeds() {
		assertEquals(usersList.get(1).signIn(userName, password), true);
	}

	@Then("the Doctor is signed in")
	public void theDoctorIsSignedIn() {
		assertEquals(usersList.get(1).isSignedIn(), true);
	}
	
	@Then("the Patient sign in succeeds")
	public void thePatientSignInSucceeds() {
		assertEquals(usersList.get(2).signIn(userName, password), true);
	}

	@Then("the Patient is signed in")
	public void thePatientIsSignedIn() {
		assertEquals(usersList.get(2).isSignedIn(), true);
	}
	
	@Then("the Secretary sign in succeeds")
	public void theSecretarySignInSucceeds() {
		assertEquals(usersList.get(3).signIn(userName, password), true);
	}

	@Then("the Secretary is signed in")
	public void theSecretaryIsSignedIn() {
		assertEquals(usersList.get(3).isSignedIn(), true);
	}

	@Given("the Admin password is not {string}")
	public void theAdminPasswordIsNot(String string) {
	    this.password = usersList.get(0).password;
	}

	@Then("the Admin sign in fails")
	public void theAdminSignInFails() {
		this.userName = "EyadX";
		this.password = "eyad123X";
		assertEquals(usersList.get(0).signIn(userName, password), false);
	}

	@Then("the Admin is not signed in")
	public void theAdminIsNotSignedIn() {
	    assertEquals(usersList.get(0).isSignedIn(), false);
	}

	@Given("the Admin username is not {string}")
	public void theAdminUsernameIsNot(String string) {
	    this.userName = usersList.get(0).userName;
	}

	@Given("the Doctor password is not {string}")
	public void theDoctorPasswordIsNot(String string) {
	    this.password = usersList.get(1).password;
	}

	@Then("the Doctor sign in fails")
	public void theDoctorSignInFails() {
		this.userName = "HamzaX";
		this.password = "hamza123X";
		assertEquals(usersList.get(1).signIn(userName, password), false);
	}

	@Then("the Doctor is not signed in")
	public void theDoctorIsNotSignedIn() {
	    assertEquals(usersList.get(1).isSignedIn(), false);
	}

	@Given("the Doctor username is not {string}")
	public void theDoctorUsernameIsNot(String string) {
	    this.userName = usersList.get(1).userName;
	}

	@Given("the Patient password is not {string}")
	public void thePatientPasswordIsNot(String string) {
	    this.password = usersList.get(2).password;
	}

	@Then("the Patient sign in fails")
	public void thePatientSignInFails() {
		this.userName = "MaenX";
		this.password = "maen123X";
		assertEquals(usersList.get(2).signIn(userName, password), false);
	}

	@Then("the Patient is not signed in")
	public void thePatientIsNotSignedIn() {
	    assertEquals(usersList.get(2).isSignedIn(), false);
	}

	@Given("the Patient username is not {string}")
	public void thePatientUsernameIsNot(String string) {
	    this.userName = usersList.get(2).userName;
	}

	@Given("the Secretary password is not {string}")
	public void theSecretaryPasswordIsNot(String string) {
	    this.password = usersList.get(3).password;
	}

	@Then("the Secretary sign in fails")
	public void theSecretarySignInFails() {
		this.userName = "MNSX";
		this.password = "mns123X";
		assertEquals(usersList.get(3).signIn(userName, password), false);
	}

	@Then("the Secretary is not signed in")
	public void theSecretaryIsNotSignedIn() {
	    assertEquals(usersList.get(3).isSignedIn(), false);
	}

	@Given("the Secretary username is not {string}")
	public void theSecretaryUsernameIsNot(String string) {
	    this.userName = usersList.get(3).userName;
	}

}
