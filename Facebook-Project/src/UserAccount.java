import java.io.Serializable;

public abstract class UserAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	protected String username;
	protected String password;
	private boolean active;

	// *********Methods

	public abstract void getPasswordHelp();



	// Deactivate Account
	public void deactivateAccount() {
		active = false;

	}



	// initialize userAccount
	public UserAccount(String username, String password) {

		this.username = username;
		this.password = password;
		active = true;
	}

	// Check Password Equals
	public boolean checkPassword(String password) {

		if (this.password.equals(password)) {
			return true;
		} else {
			return false;
		}

	}

	// *******End Of Methods

	// Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	// End of Getters and Setters

	// toString

	@Override
	public String toString() {
		return "UserAccount [username=" + username + ", password=" + password + ", active=" + active + "]";
	}
	// End Of toString

	// HashCode & Equals
	// I excluded active & password from Equals because it shouldn't matter if they
	// are equal because two accounts
	// should be able to have the same password and also both be inactive or active
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	// End of HashCode & Equals
}
