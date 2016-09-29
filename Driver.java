import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{
		//type name = value;
		Scanner input = new Scanner(System.in);
		int[] jersey_numbers = new int[5];
		int[] player_ratings = new int[5];
		for(int i = 0; i < jersey_numbers.length; i++)
		{
			System.out.print("Enter player " + (i + 1) + "'s jersey number:");
			jersey_numbers[i] = input.nextInt();
			System.out.print("Enter player " + (i + 1) + "'s rating:");
			player_ratings[i] = input.nextInt();
		}

		char option;
		do
		{
			option = Driver.showMenu();

			//respond the option here
			if(option == 'u')
			{
				//Added by Van>>>
				player_ratings = UpdatePlayer(input,player_ratings,jersey_numbers);
				//Added by Van<<<

				//Commented out by Van>>>
				//				System.out.print("What player would you like to update? ");
				//				int jersey_number = input.nextInt();
				//				for(int i = 0; i < jersey_numbers.length; i++)
				//				{
				//					if(jersey_number == jersey_numbers[i])
				//					{
				//						//I found the player they want to update
				//						System.out.print("What is the new rating? ");
				//						player_ratings[i] = input.nextInt();
				//						return player_ratings;
				//					}
				//				}
				//Commented out by Van<<<
			}
			else if(option == 'a')
			{
				System.out.print("What is the minimum rating? ");
				int min_rating = input.nextInt();
				for(int i = 0; i < jersey_numbers.length; i++)
				{
					if(player_ratings[i] >= min_rating)
					{
						System.out.println("Jersey Number: " + jersey_numbers[i] + " (" + player_ratings[i] + " rating)");
					}
				}
			}
			else if(option == 'r')
			{
				System.out.print("What player would you like to replace? ");
				int jersey_number = input.nextInt();
				for(int i = 0; i < jersey_numbers.length; i++)
				{
					if(jersey_number == jersey_numbers[i])
					{
						//I found the player they want to replace
						System.out.print("Enter new player's jersey number:");
						jersey_numbers[i] = input.nextInt();
						System.out.print("Enter new player's rating:");
						player_ratings[i] = input.nextInt();
						break;
					}
				}
			}
			else if(option == 'o')
			{
				for(int i = 0; i < jersey_numbers.length; i++)
				{
					System.out.println("Jersey Number: " + jersey_numbers[i] + " (" + player_ratings[i] + " rating)");
				}
			}
		}
		while(option != 'q');

		System.out.println("Get lost!");
		input.close();
	} //end of main method

	//Entire method added by Van>>>
	static int[] UpdatePlayer(Scanner input, int[] player_ratings, int[] jersey_numbers){
		System.out.print("What player would you like to update? ");
		int jersey_number = input.nextInt();
		for(int i = 0; i < jersey_numbers.length; i++)
		{
			if(jersey_number == jersey_numbers[i])
			{
				//I found the player they want to update
				System.out.print("What is the new rating? ");
				player_ratings[i] = input.nextInt();
				return player_ratings;
			}
		}
		return player_ratings;
	}//Entire method added by Van<<<

	static char showMenu()
	{
		Scanner elephant = new Scanner(System.in);
		System.out.println("MENU");
		System.out.println("u - Update player rating");
		System.out.println("a - Output players above a rating");
		System.out.println("r - Replace player");
		System.out.println("o - Output roster");
		System.out.println("q - Quit");
		System.out.print("Choose an option: ");
		char input = elephant.next().charAt(0); 
		elephant.close(); //Scanner close
		return input; 
	}
}
