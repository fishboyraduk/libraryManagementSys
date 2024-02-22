package Library;

import java.util.Scanner;

public class Exit implements IOOperation {
	
	Scanner s;
	Database database;
	User user;
	
	@Override
	public void oper(Database database, User user) {
		// TODO Auto-generated method stub
		this.database = database;
		this.user = user;
		System.out.println("\nAre you sure that you want to quit?\n"
				+ "1. Yes\n2. Main Meun");
		s = new Scanner(System.in);
		int i = s.nextInt();
		if (i == 1) {
			System.out.println("0.Exit \n1. Login\n2. New User");
			s = new Scanner(System.in);
			int num = s.nextInt();
			
			switch (num) {
				case 1: login(); break;
				case 2: newUser(); break;				
			}
		} else {
			user.menu(database, user);
		}
		
	}
	
	private void login() {
		System.out.println("Enter a phone number: ");
		String phoneNumber = s.next();
		System.out.println("Enter email: ");
		String email = s.next();
		int n = database.login(phoneNumber, email);
		if(n != -1) {
			User user = database.getUser(n);
			user.menu(database, user);
		}
		else {
			System.out.println("User doesn't exist");
		}
	}
	
	private void newUser() {
		// TODO Auto-generated method stub
		System.out.println("Enter a name: ");
		String name = s.next();
		System.out.println("Enter a phone number: ");
		String phoneNumber = s.next();
		System.out.println("Enter email: ");
		String email = s.next();
		System.out.println("1. Admin \n 2. Normal User");
		int n2 = s.nextInt();
		User user;
		
		if (n2 == 1) {
			user = new Admin(name, email, phoneNumber);			
		}
		else {
			user = new NormalUser(name, email, phoneNumber);			
		}
		
		database.AddUser(user);
		user.menu(database, user);
	}

}
