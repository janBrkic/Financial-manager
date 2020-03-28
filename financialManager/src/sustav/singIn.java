package sustav;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 

public class singIn {
	public static void ispis () {
		Scanner scan = new Scanner(System.in);
		
		
		String username;
		String password = null;
		boolean pomoc = true;
		int odabir = 0;
		int brojac = 0;
		
		System.out.println("You selected Sing in menu.");
		System.out.println("Enter username > ");
		username = scan.nextLine();  //upisan username
		
		while (pomoc == true) {
			if (userCheck (username) == true) {   //provjera dal taj username postoji
				pomoc = false;                //dalje na provjeru passworda
				System.out.printf("Welcome %s\n\nPlease enter password > ", username);     //sljedeci korak upisa sifre
				password = scan.nextLine();     //citanje sifre
				
			}else {
				System.out.println("That username does not exist, please try again > ");
				username = scan.nextLine();  //upisan username
			}
		}
		while (brojac < 4) {
			if (passCheck (password, username) == true) {
				brojac = 4;
				System.out.println("Welcome " + username);
				System.out.println("You can choose between this two options > ");
				System.out.println("1) Balance\n2) Enter transaction");
				odabir = scan.nextInt();
			}else {
				System.out.printf("You entered invalid password. Try again");
				System.out.println("\nPlease enter password > ");     //sljedeci korak upisa sifre
				password = scan.nextLine();     //citanje sifre
				brojac++;
			}
			if (brojac == 3) {
				System.out.println("You bastard. Try again later.\nBye");  //3 puta kriva lozinka
				cekaj.sacekaj();
				System.exit(0);  //prekidaj program
			}
		}
		
	}
	public static boolean userCheck (String ime) {  //provjerava .txt file da li postoji taj username
		boolean postoji = false;
		
		// pass the path to the file as a parameter 
	    File file = 
	      new File("F:\\eclipse\\financialManager\\src\\financialManager\\pass.txt"); 
	    Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //citanje iz fajla
		
		while (sc.hasNextLine()) {
			String linija = sc.nextLine();
			if (ime.equals(linija)) {
				postoji = true;
				return true;
			}
		}
		if (!postoji) {
			return false;
		}
		return false; 
	}
	public static boolean passCheck (String sifra, String username) { //provjera .txt filea da li postoji vazeca sifra
		boolean postoji = false;
		
		// pass the path to the file as a parameter 
	    File file = 
	      new File("F:\\eclipse\\financialManager\\src\\financialManager\\pass.txt"); 
	    Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //citanje iz fajla
		
		while (sc.hasNextLine()) {
			String linija = sc.nextLine();
			/*if (linija.toLowerCase().contains(username)) {
				if(linija.toLowerCase().contains(sifra)) {
					return true;
				}
			}*/
			if (postoji) {
				if(linija.equals(sifra)) {
					return true;
				}
			}
			if (linija.equals(username)) {
				postoji = true;
				//continue;
			}
		}
		return false;
	}
}
