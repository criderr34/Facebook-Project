
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Facebook implements Serializable {

	private static final long serialVersionUID = 1L;
	Scanner scanner = new Scanner(System.in);

	private ArrayList<FacebookUser> users;
	Set<String> posts = new HashSet<String>();

	int postOneCount = 0;
	int postTwoCount = 0;
	int postThreeCount = 0;

	public Facebook() {
		users = new ArrayList<>();

	}

	// Option 1: List Users

	public void listUsers() {

		if (users.isEmpty()) {

			System.out.println("There are no users in this list");
		} else {

			for (FacebookUser users : this.users) {

				System.out.println("Username: " + users.getUsername());
			}
		}
	}

	// Option 2: Add User

	public void addUser() {

		System.out.println("Please enter username of users you would like to add");

		String newUsername = scanner.nextLine();

		System.out.println("Please enter password");
		String newPassword = scanner.nextLine();

		System.out.println("Please enter password hint");
		String passwordHint = scanner.nextLine();

		FacebookUser user1 = new FacebookUser(newUsername, newPassword);

		user1.setPasswordHint(passwordHint);

		if (users.contains(user1)) {

			System.out.println("Username is taken please try another username");

		} else {

			users.add(user1);

		}

	}

	// Option 3: Delete User

	// Talk to the tutor because this does not work properly

	public void deleteUser() {

		System.out.println("Please enter the user you wish to delete");

		String deleteUser = scanner.nextLine();

		System.out.println("Please enter the password:");

		String passwordDelete = scanner.nextLine();

		FacebookUser user1 = new FacebookUser(deleteUser, passwordDelete);

		if (users.contains(user1)) {

			if (user1.password.equals(passwordDelete)) {

				users.remove(user1);

				System.out.println("User:" + deleteUser + "has been removed");

			} else {

				System.out.println("Please verify username or password is correct");
			}
		}

	}

	// Option 4: Show Password Help

	public void getPasswordHelp() {

		System.out.println("Please enter username");

		String hintUsername = scanner.nextLine();

		FacebookUser user1 = new FacebookUser(hintUsername, null);

		if (users.contains(user1)) {

			user1 = users.get(users.indexOf(user1));

			user1.getPasswordHelp();

		} else {

			System.out.println("Username not found");
		}

	}

	public void serialize() {

		try {
			FileOutputStream fos = new FileOutputStream("FacebookUsers.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void deserialize() {

		try {
			FileInputStream fis = new FileInputStream("FacebookUsers.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);

			users = (ArrayList<FacebookUser>) ois.readObject();

			ois.close();
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}

	}

	// Option 5: Add Friend

	public void friending() {

		// Ask for username of friend you wish to add
		// If user does not exist then throw an error

		System.out.println("What is your username?");

		String username = scanner.nextLine();

		FacebookUser user1 = new FacebookUser(username, null);

		if (users.contains(user1)) {

			System.out.println("What is your password?");

			String checkPassword = scanner.nextLine();

			user1.setPassword(checkPassword);

			if (user1.password.equals(checkPassword)) {

				System.out.println("What is the username of the user you would like to friend");

				String friendUsername = scanner.nextLine();

				FacebookUser user2 = new FacebookUser(friendUsername, null);

				if (users.contains(user2)) {

					users.get(users.indexOf(user1)).friend(user2);

				} else {
					System.out.println("This user does exist");

				}

			}

		}

	}

	// Option 6: Defriend

	public void defriending() {

		System.out.println("What is the username of the user you would like to de-friend");

		// Ask for username of friend you wish to add
		// If user does not exist then throw an error
		System.out.println("What is your Username");

		String username = scanner.nextLine();

		FacebookUser user1 = new FacebookUser(username, null);

		if (users.contains(user1)) {

			System.out.println("What is your password");

			String checkPassword = scanner.nextLine();

			user1.setPassword(checkPassword);

			if (user1.password.equals(checkPassword)) {

				System.out.println("What is the username of the user you would like to delete");

				String friendUsername = scanner.nextLine();

				FacebookUser user2 = new FacebookUser(friendUsername, null);

				if (users.contains(user2)) {

					users.get(users.indexOf(user1)).defriend(user2);

				}

				else {

					System.out.println("User does not exist");
				}

			}

		}

	}

	// Option 7: List Users

	public void listing() {

		System.out.println("What is your Username");

		String username = scanner.nextLine();

		FacebookUser user1 = new FacebookUser(username, null);

		if (users.contains(user1)) {

			for (FacebookUser user : users.get(users.indexOf(user1)).getFriends()) {

				System.out.println("Username: " + user.getUsername());
			}

		} else {

			System.out.println("User does not exist");

		}

	}

	public void usernameRecommendations() {

		System.out.println("What is your username");

		String username = scanner.nextLine();

		FacebookUser user1 = new FacebookUser(username, null);

		getRecommendations(users.get(users.indexOf(user1)));
	}

	public void getRecommendations(FacebookUser user1) {

		// Method should return an arraylist of all the friends the
		// Needs to call method from within the method

		for (FacebookUser user : user1.getFriends()) {

			getRecommendations(user);

		}

	}

	public void removeDuplicates() {

		for (FacebookUser user : users) {

			if (users.contains(user)) {

				System.out.println("Duplicate found and removed");
				continue;
			} else {
				users.add(user);
			}

		}

	}

	@SuppressWarnings("unlikely-arg-type")
	public int linearSearch() {

		for (int index = 0; index < users.size(); index++) {
			if (users.get(index).equals(users)) {
				return index;
			}
		}

		return -1;
	}



	public void likePost() {

		String postOne = "1: this is a test";
		String postTwo = "2: Hello World";
		String postThree = "3: What else should I add to this set";

		System.out.println("What is your Username");

		String username = scanner.nextLine();

		FacebookUser user1 = new FacebookUser(username, null);

		System.out.println("What is your password");

		String checkPassword = scanner.nextLine();

		user1.setPassword(checkPassword);

		if (user1.password.equals(checkPassword)) {

			System.out.println(postOne + "\n");
			System.out.println(postTwo + "\n");
			System.out.println(postThree + "\n");

			System.out.println("Which post do you like");

			String like = scanner.nextLine();

			if (like.equals("1")) {
				if (posts.contains(username) && posts.contains(postOne))
				{
					System.out.println("You cannot like this post twice");
				}
				else {
				
					++postOneCount;
					posts.add(postOne + " liked by: " + username + "\n");
					
					System.out.println(username + " likes " + postOne);
				}
			
			

			} else if (like.equals("2")) {
				++postTwoCount;
				posts.add(postTwo + " liked by: " + username + "\n");
				
				System.out.println(username + " likes " + postTwo);

			} else if (like.equals("3")) {
				++postThreeCount;
				posts.add(postThree + " liked by: " + username + "\n");
				System.out.println(username + " likes " + postThree);

			}

		}

	}

	public void showLikes() {

		// Method to show liked tweets

		for (String printPost : posts) {

			System.out.print(printPost);

		}
		
		System.out.println("Total likes for post 1: " + postOneCount);
		System.out.println("Total likes for post 1: " + postTwoCount);
		System.out.println("Total likes for post 1: " + postThreeCount);


	}
	
	//EXPLAINATION :  I chose to go with a hashset because the hashset will not allow for duplicates and will sort 
	// the data in alphabetical order. I think that is the best option since it does the two things that were asked for.
	// It will store data, will not take duplicate data and will sort it alphabetically
}