import java.util.*;
import java.lang.*;

public class itemMUW {
	
	ArrayList<String> Type = new ArrayList<String>();
	ArrayList<String> Name = new ArrayList<String>();
	ArrayList<Integer> Price = new ArrayList<Integer>();
	ArrayList<Integer> Quantity = new ArrayList<Integer>();
	ArrayList<Integer> subtotal = new ArrayList<Integer>();
	
	public itemMUW() {
		
		int menu = 0;
		Scanner ac = new Scanner(System.in);
		
			do {
				System.out.println("");
				System.out.println("+==============================+");
				System.out.println("|	      MENU             |");
				System.out.println("+==============================+");
				System.out.println("| 1. Insert Product            |");
				System.out.println("| 2. Buy Product               |");
				System.out.println("| 3. Exit                      |");
				System.out.println("+==============================+");
				System.out.print(">> ");
				menu = ac.nextInt();
				
				switch(menu) {
					case 1:
						insertProduct();
						break;
					case 2:
						buyProduct();
						break;
					case 3:
						System.out.println("-^ Thanks for using this program... ^-");
						System.exit(0);
						break;
				}	
			}while(menu != 3);
		}

	public void insertProduct() {
		
		String name = null, type = null;
		int price = 0, quantity = 0, enter;
		
		Scanner keyIn = new Scanner(System.in);
		Scanner ab = new Scanner(System.in);
		
			System.out.println();
			do {
				System.out.print("Input product name [6-20 characters] : ");
				name = ab.nextLine();
			}while(name.length() < 6 || name.length() > 20);
			Name.add(name);
			
			do {
				System.out.print("Input product type [Currency | Item | Account] : ");
				type = ab.nextLine();
			}while(!type.equals("Currency") && !type.equals("Item") && !type.equals("Account"));
			Type.add(type);
			
			do {
				System.out.print("Input product price [10000 - 1000000] : ");
				price = ab.nextInt();
			}while(price < 10000 || price > 1000000);
			Price.add(price);
			
			do {
				System.out.print("Input product quantity [1 - 50] : ");
				quantity = ab.nextInt();
			}while(quantity < 1 || quantity > 50);
			Quantity.add(quantity);
			
			System.out.println("Product added !! Press enter to continue..");
			keyIn.nextLine();	
	}
		
	public void buyProduct() {	
			
		Scanner ta = new Scanner(System.in);
		Scanner keyIn = new Scanner(System.in);
		int ent, no=0, SubTotal = 0, Total = 0, GrandTotal=0, disc = 0, tax =0;
		String ans=null;

		
			if(Type.isEmpty()) {
				System.out.println("There's no product..\n\n\n\n");
				System.out.println("Press Enter to continue");
				keyIn.nextLine();
				System.exit(0);
				
			}
		
			SubTotal = (Price.get(0))*(Quantity.get(0));
			subtotal.add(SubTotal);
				
					System.out.println("+====+======================+============+==========+=============+");
					System.out.println("| NO | Name                 | Price     | Quantity | Sub Total    |");
					System.out.println("+====+======================+============+==========+=============+");
				for(int i = 1 , k = 0 ; i <= Name.size() ; i++ , k++) {	
					System.out.println("| " + i +" | "+ Name.get(k)+"           | "+ + Price.get(k)+"     | " + Quantity.get(k)+"        | " + subtotal.get(k)+"       |");
				}
					System.out.println("+====+======================+============+==========+=============+");
					
					do {
						System.out.print("Buy All? [ Y/N ] :");
						ans = ta.nextLine();
					}while(ans.equals("Y") && ans.equals("N"));
					
					Total = SubTotal;
					disc = (int) (Total * 0.1);
					tax = (int) (Total * 0.05);
					GrandTotal = (int)(Total - disc + tax);
					
					System.out.println("\n+===============================+");
					System.out.println("|            Receipt            |");
					System.out.println("+===============================+");
					System.out.println("| Total                 : " +Total+" |");
					System.out.println("| Discount [ 10% ]      : "+disc+" |");
					System.out.println("| Tax [ 5% ]            : "+tax+" |");
					System.out.println("| Grand Total           : "+GrandTotal+" |");
					System.out.println("+===============================+");
					System.out.println("|  Thank You for purchasing !!  |");
					System.out.println("+===============================+");
					System.out.println("press enter to continue...");
					keyIn.nextLine();
	}	
	
	public static void main(String[] args) {
		new itemMUW();
	}
}