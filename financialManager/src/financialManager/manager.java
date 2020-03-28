package financialManager;

import java.io.IOException;
import java.util.Scanner;

import sustav.cekaj;
import sustav.logIn;
import sustav.singIn; 

public class manager {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in); 
		int odabir;
		
		System.out.println("                         Welcome to the Financial manager app made by Jan");
		System.out.println("                                                   v1.0");
		System.out.println("");
		System.out.print("Drop-manu coming up");

		for (int i = 0; i<3; i++) {
			System.out.print(".");
			cekaj.sacekaj();
		}
		System.out.println("\n1) Sing in");
		System.out.println("2) Log in");
		System.out.println("3) Instructions");
		
		System.out.println("\nEnter your choose > ");
		odabir = scan.nextInt();
		if (odabir == 1) {
			singIn.ispis();
		}else if (odabir == 2) {
			logIn.ispis();
		}
	}

}
