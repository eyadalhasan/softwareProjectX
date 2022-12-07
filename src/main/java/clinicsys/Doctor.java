package clinicsys;

public class Doctor extends Users {
	private boolean isAvailable;

	public Doctor(String userName, String password, String role) {
		super(userName, password, role);
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailability(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
