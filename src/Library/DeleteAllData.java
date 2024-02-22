package Library;

import java.util.Scanner;

public class DeleteAllData implements IOOperation {

	@Override
	public void oper(Database database, User user) {
		// TODO Auto-generated method stub
		System.out.println("\nAre you sure that you want to delete all data?\n"
				+ "1. Continue\n 2. Main Meun");
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		if (i == 1) {
			database.DeleteAllData();
		} else {
			user.menu(database, user);
		}
	}

}
