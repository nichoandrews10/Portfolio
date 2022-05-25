import java.util.*;
import javax.swing.*;
import java.util.Vector;

public class BJHospital {

	public static void main(String[] args) {
	
	int menu = 0, number = 0;
	String name = null, gender = null, roomType = null;
	
	Scanner ac = new Scanner(System.in);
	Scanner bc = new Scanner(System.in);
	Vector<Vector<Object>> data = new Vector<Vector<Object>>();

	do {
		System.out.println("                          ");
		System.out.println("==========================");
		System.out.println("     : BJ Hospital :      ");
		System.out.println("==========================");
		System.out.println("1. Add Patient");
		System.out.println("2. View Patient");
		System.out.println("3. Exit");
		System.out.print("Choose >> ");
		menu = ac.nextInt();
	
		switch(menu) {
		case 1:
			do {
				System.out.print("Input your name [starts with 'Mr.' or 'Mrs'] : ");
				name = bc.nextLine();
			}while(!name.startsWith("Mr.") && !name.startsWith("Mrs."));
			
			do {
				System.out.print("Input your gender ['Male' or 'Female'[Case Insensitive]] : ");
				gender = bc.nextLine();
			}while(!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female"));
			
			do {
				System.out.print("Choose your room type ['VIP' or 'Normal'] : ");
				roomType = bc.nextLine();
				if(roomType.equals("VIP") || roomType.equals("Normal")) {
					System.out.println("Patient has been added!");
				}
			}while(!roomType.equals("VIP") && !roomType.equals("Normal"));
			number++;
			break;
		case 2:
			if(number == 0) {
				System.out.println("No Patient");
			}
			for(int i = 0; i < number; i++) {
				Vector<Object> row = new Vector<Object>();
		        row.add( "1.");
		        row.add( name);
		        row.add( gender);
		        row.add( roomType);
		        data.add(row);
			}
	
	        Vector<String> headers = new Vector<String>();
	        headers.add("No.");
	        headers.add("Name");
	        headers.add("Gender");
	        headers.add("Room Type");


	        JTable table = new JTable( data, headers );

	        JFrame frame = new JFrame();
	        frame.add( new JScrollPane( table ));
	        frame.pack();
	        frame.setVisible( true ); 

			break;
		case 3:
			System.out.println("-^ Thanks for using this program... ^-");
			System.exit(0);
			break;
		}
					
	}while(menu != 3);
	
	}

}
