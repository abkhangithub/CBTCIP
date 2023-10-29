package ATMInterface;

import java.util.Scanner;

class ATMInterface{
	
	float Balance;
	int userId =10012 ;
	int userPin =7634 ;
	
	public void checkPin() {
		System.out.println("Enter yoour userId: ");
		System.out.println("Enter your userPin: ");
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int enteredId =sc.nextInt();
		int enteredPin = sc.nextInt();
		if (enteredId == userId && enteredPin == userPin) {
			main();
		}
		else {
			System.out.println("Enter a valid userId and UserPin: ");
			checkPin();
		}
	}
	public void main() {
		System.out.println("Welcome user : "+userId);
		System.out.println("1. Check A/C Balance : ");
		System.out.println("2. Deposit Money : ");
		System.out.println("3. Withdraw Money : ");
		System.out.println("4. Transfer Money : ");
		System.out.println("5. Exit : ");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if (option == 1) {
			checkBalance();
		}
		else if (option == 2) {
			depositMoney();
		}
		else if (option == 3) {
			withdrawMoney();
		}
		else if (option == 4) {
			transferMoney();
		}
		else if (option == 5) {
			exit();
		}
		else {
			System.out.println("Invalid Option : ");
			main();
		}
	}
	
	public void checkBalance() {
		System.out.println("User : "+ userId);
		System.out.println("Balance : "+Balance);
		main();
	}
	
	public void depositMoney() {
		System.out.println("Enter amount to deposit : ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		System.out.println("User : " + userId);
		Balance = Balance + amount;
		System.out.println("Amount deposit successfully !");
		main();
	}
	
	public void withdrawMoney() {
		System.out.println("Enter amount to withdraw : ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		System.out.println("User : "+ userId);
		if (amount > Balance) {
			System.out.println("Insufficient Balance : ");
		}
		else {
			System.out.println("Money withdrawn successfully !");
			Balance = Balance - amount;
			main();
		}
	}
	
	public void transferMoney() {
		System.out.println("Enter userId to transfer money : ");
		System.out.println("Enter amount to transfer : ");
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int userId = sc.nextInt();
		float amount = sc1.nextFloat();
		if (amount > Balance) {
			System.out.println("Insufficient balance : ");
			transferMoney();
		}
		else {
			System.out.println("Amount amount transfer successfully : ");
			Balance = Balance - amount;
			main();
		}
		
	}
	public void exit() {
		System.out.println("Thanks for banking with us !!");
		System.out.println("Visit again !!");
	}
	
}

public class ATM {

	public static void main(String[] args) {
		ATMInterface obj = new ATMInterface();
		obj.checkPin();

	}

}
