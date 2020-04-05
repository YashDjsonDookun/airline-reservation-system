/*
 * Name: Yash Djson Dookun
 * Task: Airline reservations system- The program requests the user to type 1 for 'smoking
compartment' or 2 for 'non smoking compartment'.
The flight carries a maximum of 10 passengers. Seats in the range 1 to 5 are for
smoking section and seats in the range 6 to 10 are for non-smoking section. Thus, if
the user types 1, a seat is assigned in the smoking section, and if user types 2, a
seat is booked in the non-smoking section.
As each seat is assigned, you must record that it is no longer available so that a seat
cannot be assigned more than once. If there are no seats available, you may display
appropriate messages to the user. Terminate the program if all seats are booked.
Hint: Declare 2 arrays of 5 elements each to represent smoking and non-smoking.
Use a loop to fill all the 10 seats. The loop exits when all 10 seats are filled. You may
assign a value of 1 as a booked seat, and 0 as an available seat.*/

import java.util.Arrays;
import java.util.Scanner;

public class airline {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String  smoking[] = {"f","f","f","f","f"};  // f = free seat
		String  non_smoking[] = {"f","f","f","f","f"};
		int choice; //either 1 or 2
		int i, counter_s = 0, counter_ns = 0, remaining_s = 5, remaining_ns = 5; // s=smoking  ns=non-smoking

		//Welcome Message
		System.out.println();
		System.out.println("+--------------------------------------------------------------+");
		System.out.println("|               Airline Reservation System                     |");
		System.out.println("+--------------------------------------------------------------+");
		System.out.println("| Kindly choose your seat compartment when prompted below.     |");
		System.out.println("|                                                              |");
		System.out.println("| Enter '1' if you want a seat in the Smoking compartment      |");
		System.out.println("| Enter '2' if you want a seat in the Non-Smoking compartment  |");
		System.out.println("+--------------------------------------------------------------+");
		System.out.println();

		for (i=0; i < 10; i++) {
			//takes user input for the choice
			System.out.print("Enter here: ");
			choice = input.nextInt();
			if (choice == 2){
				System.out.println("Selected Compartment: Non-Smoking");
				for (int j=0; j < non_smoking.length; j++) {
					//verify for free seats in non-smoking compartment
					if (non_smoking[j] == "f") {
						break;
					}
				}
				non_smoking[counter_ns] = "b"; // changes f(free seat) to b(booked seat)
				counter_ns++;
				remaining_ns--;
				System.out.println(Arrays.toString(non_smoking)); //prints the seats of Non-Smoking compartment
				System.out.println("Remaining seats in Non-Smoking Compartment: " + remaining_ns); //states number of free seats
				System.out.println();
				if (remaining_ns == 0 && remaining_s != 0) {
					System.out.println("No more seats available, please choose Smoking Compartment only as from here!");
					System.out.println();					
				}
				else if (remaining_ns == 0 && remaining_s == 0 ) {
					System.out.println("NO MORE FREE SEATS!");
					System.out.println();
				}
			}
			else if (choice == 1) {
				System.out.println("Selected Compartment: Smoking");
				for (int j=0; j < smoking.length; j++) {
					//verify for free seats in smoking compartment
					if (smoking[j] == "f") {
						break;
					}
				}
				smoking[counter_s] = "b"; // changes f(free seat) to b(booked seat)
				counter_s++;
				remaining_s--;
				System.out.println(Arrays.toString(smoking)); //prints the seats of Smoking compartment
				System.out.println("Remaining seats in the Smoking compartment: " + remaining_s); //states number of free seats
				System.out.println();
				if (remaining_s == 0 && remaining_ns !=0) {
					System.out.println("No more seats available, please choose Non-Smoking Compartment only as from here!");
					System.out.println();
				}
				else if (remaining_s == 0 && remaining_ns == 0) {
					System.out.println("NO MORE FREE SEATS!");
					System.out.println();
				}
			}
			else{
				//cater for wrong user choice
				System.out.println("Invalid Choice! Kindly choose between 0 and 1 only!");
				System.out.println();
				i--; //allows for additional user input to make sure all 10 seats are booked
			}
		}
		input.close();
	}
}
