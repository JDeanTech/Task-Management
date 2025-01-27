package projectManagement_Dashboard;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	
	public static void main(String[] args) {
		Tasks Calendar_Tasks = new Tasks ("School Calendar Handout", "Pass out company calendar to local schools","To-Do", "John Doe");
		System.out.println("John's Tasks:" + Calendar_Tasks.getAssignee());
		
		//Array to hold tasks created by user
		ArrayList<Tasks> taskList = new ArrayList<>();
		
		//Scanner object created so application can scan user input
		Scanner scanObj = new Scanner(System.in);
		
		//boolean variable used for while loop
		boolean keepGoing = true;
		
		//Welcome Message
		System.out.println("Welcome Habitat for Humanity Tasks Tracker Application");
		System.out.println("Enter New Task Next");
		//While Loop to keep user ability to add tasks in console continuously
		while(keepGoing) {
			System.out.print("	Enter Task TITLE: ");
			String Title = scanObj.nextLine();
			System.out.print("	Enter Task DESCRIPTION: ");
			String Description = scanObj.nextLine();
			System.out.print("	Enter Task ASSIGNEE: ");
			String Assignee = scanObj.nextLine();
			System.out.print("	Enter a Task Status: ");
			String Status = scanObj.nextLine();
			
			//Creation of the Task after user input
			Tasks newTask = new Tasks(Title, Description, Assignee, Status);
			taskList.add(newTask);
			
			//Task creation notification
			System.out.print("Task has been added Successfully!");
			
			System.out.print("Do you want to add another? 	(yes/no)");
			String userResponse = scanObj.nextLine();
			
			if (userResponse.equalsIgnoreCase("no") || userResponse.equalsIgnoreCase("n")) {
				keepGoing = false;
			}// if statement for while loop exit ending braces
			
			
		}//While loop for getting user input ending braces
		
		scanObj.close();
		
	}//public static void main ending braces
}//Main class ending braces
