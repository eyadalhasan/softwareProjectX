package clinicSys;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import clinicsys.Users;

public class SignOutSteps {

	String role;
	ArrayList<Users> usersList = new ArrayList<Users>();

	@Given("the users credentials")
	public void the_users_credentials(io.cucumber.datatable.DataTable dataTable) {

		List<List<String>> rows = dataTable.asLists(String.class);

		for (int i = 0; i < rows.size(); i++) {
			Users addUser = new Users(rows.get(i).get(0), rows.get(i).get(1), rows.get(i).get(2));
			usersList.add(addUser);
		}
	}

	@Given("that the {string} is signed in")
	public void that_the_is_signed_in(String string) {
		for (int i = 0; i < usersList.size(); i++)
			if (usersList.get(i).checkRole(string))
				assertEquals(usersList.get(i).signIn(usersList.get(i).userName, usersList.get(i).password), true);
	}

	@When("the {string} signs out")
	public void the_signs_out(String string) {
		for (int i = 0; i < usersList.size(); i++)
			if (usersList.get(i).checkRole(string))
				usersList.get(i).signOut();
	}
	
	@Then("the {string} is not signed ins")
	public void the_is_not_signed_ins(String string) {
		for (int i = 0; i < usersList.size(); i++)
			if (usersList.get(i).checkRole(string))
				assertEquals(usersList.get(i).isSignedIn(), false);
	}

}
