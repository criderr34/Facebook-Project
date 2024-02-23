import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Facebook facebookMethod = new Facebook();
		facebookMethod.deserialize();

		while (true) {

			printMenu();

			int choice = input.nextInt();

			switch (choice) {

			case 1:

				// Option 1: List User

				facebookMethod.listUsers();
				break;

			case 2:

				// Option 2: Add User

				facebookMethod.addUser();

				break;

			case 3:

				// Option 3: Delete User

				facebookMethod.deleteUser();

				break;

			case 4:

				// Option 4: Get Password Hint

				facebookMethod.getPasswordHelp();

				break;

			case 5:

				// Friending

				facebookMethod.friending();

				break;

			case 6:

				// De-Friending

				facebookMethod.defriending();

				break;

			case 7:

				// Listing friends

				facebookMethod.listing();

				break;

			case 8:

				// Get Recommendations

				facebookMethod.usernameRecommendations();

				break;

			case 9:
				
				facebookMethod.likePost();

				break;

			case 10:
				
				facebookMethod.showLikes();
				// Like Tweet
				break;

			case 11:
				// Option 5: Quit
				input.close();
				facebookMethod.serialize();

				System.exit(0);
				break;

			default:

				System.out.println("This is not a valid Menu Option! Please Select Another");
				break;

			}
		}

	}

	public static void printMenu() {

		System.out.println("\n");
		System.out.println("Menu" + "\n" + "Option 1: List User: " + "\n" + "Option 2: Add User: " + "\n"
				+ "Option 3: Delete User" + "\n" + "Option 4: Get Password Hint" + "\n" + "Option 5: Add Friend" + "\n"
				+ "Option 6: De-Friend" + "\n" + "Option 7: List Friends " + "\n" + "Option 8: Friend Recommendations"
				+ "\n" + "Option 9: Like Post" + "\n" + "Option 10: Show Liked Posts" + "\n" +"Option 11: Quit");
	}

}
