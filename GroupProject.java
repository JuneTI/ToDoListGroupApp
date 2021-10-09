package GroupProject;

import java.util.Scanner;

public class GroupProject {
public static void main(String[] args) {
	
	//IDEAS TO ADD LATER:
	//Unique item ids
	
	//Remove Later
	
	//User Interface
	System.out.println("Enter an option: (1)Insert, (2)Delete, (3)Edit, ADD MORE LATER");
	Scanner userOption = new Scanner(System.in);
	String[] todoList = new String[100];
	int userValue = userOption.nextInt();
	if (userValue == 1)
		todoList = Insert(todoList);
//	if (userValue == 2)
//		todoList = Delete();
//	if (userValue == 3)
//		todoList = Edit();
	
	
	//Prints each items in the list
//	for(int i = 0; i < 100; i++) {
//		if (todoList[i] != null)
//			System.out.println(todoList[i]);
//	}
	
}

public static String[] Insert(String[] Insert_Todo) {
		Scanner userInput = new Scanner(System.in);
		int counter = 0;
		
		//Add a new string until X is entered
		while (true) { 
			System.out.println("Enter an item (Up to 100 items | Type X to exit): ");
			String userString = userInput.nextLine();
			if (userString.equals("X"))
				break;
			else {
				Insert_Todo[counter] = userString;
				counter++;
			}
		}
		
		return Insert_Todo;
	}
}
