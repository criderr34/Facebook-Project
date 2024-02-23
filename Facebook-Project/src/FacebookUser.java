
import java.io.Serializable;
import java.util.ArrayList;

public class FacebookUser extends UserAccount implements Comparable<FacebookUser>, Cloneable,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String passwordHint = "";
	ArrayList<FacebookUser> friends;

	public FacebookUser(String username, String password) {
		super(username, password);
		friends = new ArrayList<FacebookUser>();

	}


	// The FacebookUser class should also implement the Comparable interface
	// FacebookUsers should be sorted alphabetically by username, ignoring
	// capitalization.
	// (Hint: notice that the toString method returns the username of the
	// UserAccount.)

	public void friend(FacebookUser newFriend) {


		if (friends.contains(newFriend)) {

			System.out.println("You are already connected with this user");
		} else {

			friends.add(newFriend);
			System.out.println("Friend request has been sent");
		}

	}

	// defriend method should remove the FacebookUser argument from that ArrayList
	// (if that FacebookUser is not in the friends list, display an error message)
	void defriend(FacebookUser formerFriend) {

		if (!friends.contains(formerFriend)) {

			System.out.println("User is not in your friends list");
		} else {

			friends.remove(formerFriend);

			System.out.println("User has been removed" + "\n");
		}

	}

	ArrayList<FacebookUser> getFriends() {

		// The getFriends method should return a copy of this user’s friends – create a
		// new ArrayList
		// with the same FacebookUsers in it as this user’s friends. Do not return the
		// friends ArrayList directly, since this violates the principle of
		// encapsulation.

		ArrayList<FacebookUser> friendsList = new ArrayList<FacebookUser>();
		for (FacebookUser user : this.friends) {
			try {
				friendsList.add((FacebookUser) user.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}

		return friendsList;

	}

	@Override
	public int compareTo(FacebookUser o) {
		return this.toString().toLowerCase().compareTo(o.toString().toLowerCase());
	}
	
	public void setPasswordHint(String passwordHint) {
		
		this.passwordHint = passwordHint;
	}

	@Override
	public void getPasswordHelp() {
		

		System.out.print("Password Hint : " + passwordHint);
		
	

	}

}
