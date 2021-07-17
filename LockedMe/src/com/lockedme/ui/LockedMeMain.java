package com.lockedme.ui; 

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.lockedme.services.LockedMeHandler;


public class LockedMeMain {

	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("--------------------------------------------------------");
		System.out.println("------------ Welcome to LockedMe.com -------------------");
		System.out.println("-----------Developed by Manpreet Kaur Gadh -------------");
		System.out.println("--------------------------------------------------------" + "\n");
				
		int key = 0;
		do {
		
			System.out.println("-------------------- Main Menu -------------------------");
			System.out.println("Enter 1: Get the Files List:  \nEnter 2: File Operations: \nEnter 3: Close the Application: ");
			System.out.println("---------------------------------------------------------");
			System.out.println("Enter Your choice: ");
			try {
				
				key = scan.nextInt();
				
				switch (key) {
				case 1:// get file names
					List<String> fileNames = LockedMeHandler.getInstance().getDao().getAll();
					if (fileNames.isEmpty()) { 
						System.out.println("No files found in the directory!");
					}
					else {
						System.out.println("............... Printing List of files .................");
						fileNames.forEach(System.out::println);
					}
					break;
					
				case 2: // show sub menu
					showSubMenu();
					key = 0;
					break;
					
				case 3: // close the application
					System.out.println("Thank you for using LockedMe.com ! Do visit us again !");
					System.exit(0);
					break;
					
				default: // any other key so display error
					System.err.println("Invalid Input ! Please try again !" + "\n");
				}

				
			} catch (InputMismatchException exp) {
				key = 0;
				System.err.println("Invalid Input ! Please try again !" + "\n");
				scan.nextLine();
			}
			
		} while (key != 3);
			
		scan.close();
	}

	static void showSubMenu() {
		Scanner scan = new Scanner(System.in);
		
		int nextKey = 0;
		do {
			System.out.println("\n------------------- File Operations  --------------------");			
			System.out.println("Enter 1: Add a New File: " + "\n" + "Enter 2: Delete a file from the current List: " + "\n" + "Enter 3: Searching for an existing file: " + "\n" + "Enter 4: Go Back to the Main Menu: ");
			System.out.println("---------------------------------------------------------");			
			try {
				nextKey = scan.nextInt();
			}
			catch (InputMismatchException exp) {
				nextKey = 0;
				
				//System.err.println("Invalid Input ! Please try again !" + "\n");
				scan.nextLine();
			}
			
			String fileName = "";
			
			switch (nextKey) {
			
			case 1: // add a file
				System.out.println("Enter the name of file you wish to add: ");
				fileName = scan.next();
				try {
					boolean created = LockedMeHandler. getInstance().getDao().add(fileName);
					if (created)
						System.out.println("File created successfully !");
					else 
					System.err.println("File could not be created !! Please try again !!\\n");
					
				} catch (FileAlreadyExistsException exp) {
					System.err.println(exp.getMessage());
				} catch (IOException exp) {
					System.err.println("File could not be created !! Please try again !!\n");
				}
				break;
			case 2: // delete a file
				System.out.println("\nEnter the name of file you wish to delete: ");
				fileName = scan.next();
				
				try {
					
					boolean deleted = LockedMeHandler.getInstance().getDao().delete(fileName);
					if (deleted)
						System.out.println("File deleted successfully !");
					else 
					System.err.println("File could not be deleted !! Please try again !!\\n");
					
				} catch (FileNotFoundException e) {
					System.err.println(e.getMessage());
				}
				
				break;
			case 3: // search for a file
				System.out.println("\nEnter the name of file you wish to search for: ");
				fileName = scan.next();
				boolean exists = LockedMeHandler.getInstance().getDao().searchBy(fileName);
				if (exists)
					System.out.println("File exists in the file system !");
				else 
				System.err.println("File does not exist !! Please try again !!\n");
				break;
			case 4: // go back to main menu
				System.out.println("............. Going back to Main Menu ..................\n\n");				
				break;
			default:// any other key so display error
				System.err.println("Invalid Input ! Please try again !" + "\n");
			}
		}while (nextKey != 4);

	}
	
	
}
