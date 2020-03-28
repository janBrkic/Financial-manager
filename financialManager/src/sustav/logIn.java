package sustav;                                        //basic code for log in option

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;

public class logIn {
	public static void ispis () throws IOException {
		Scanner scan = new Scanner(System.in);
		File file = new File ("F:\\\\eclipse\\\\financialManager\\\\src\\\\financialManager\\\\pass.txt");
		Scanner sc = new Scanner(file); 
		
		String username = null;
		String userCheck;
		String password = null;
		String passCheck;
		boolean valid = false;
		int brojac = 0;
		boolean prolaz = false;
		boolean userExist = false;
		boolean userExist2 = false;
		
		System.out.println("\n					We are glad you are using our application.\nThe fun is about to start!");
		System.out.println("\n\nWe are now about to make your account");
		System.out.printf("\nFirst you need to enter username you want to use > ");
		
		username = scan.nextLine(); //cita username
		while (!prolaz) {
			while (sc.hasNextLine() && !userExist2) { //userExist2 da izadje iz while i ne trosi memoriju
				userCheck = sc.nextLine();
				if (userCheck.equals(username)) {
					userExist = true;
					userExist2 = true;
				}
			}
			if (userExist) { //username postoji, pitamo za novi username
				System.out.println("You entered allready used username!");
				System.out.println("Please enter another username > ");
				username = scan.nextLine(); //cita username
				userExist2 = false;
				userExist = false;
			}else {
				prolaz = true;
			}
		}
		
		
		System.out.printf("Now, enter your username again > ");
		userCheck = scan.nextLine();
		while (!valid) {
			if (userCheck.equals(username)) {    //provera usernama unesenog drugi put
				makingUsername (username);
				valid = true;
			}else {
				System.out.println("Your username does not match with first one. Please enter again > ");  //ne matcha se, ponovo pitaj
				userCheck = scan.nextLine();
				brojac++;
			}
			if (brojac == 3) {
				System.out.println("Fuck off");
				System.exit(0);
			}
		}
		brojac = 0;
		
		System.out.printf("\nNow enter password > ");
		password = scan.nextLine();
		System.out.printf("\nEnter it again > ");
		passCheck = scan.nextLine();
		while (valid) {
			if (passCheck.equals(password)) {
				makingPassword(password);
				valid = false;
			}else if (passCheck.equals(password) == false){
				System.out.printf("\nYour password does not match the first one. \nPlease enter again > ");
				passCheck = scan.nextLine();
				brojac++;
			}
			if (brojac == 3) {  //ako nas zajebava i ne zeli unijet valjano
				System.out.println("Fuck off");
				System.exit(0);
			}
		}
		makingFile (username);  //napravili file za neki username
	}
	public static void makingUsername (String username) throws IOException {
		File file = new File ("F:\\\\eclipse\\\\financialManager\\\\src\\\\financialManager\\\\pass.txt");
		
		FileWriter fStream = new FileWriter(file, true);
		PrintWriter out = new PrintWriter(fStream);
		out.println(username); //pisanje u file
		out.flush();
		out.close();
		fStream.close();
	}
	public static void makingPassword (String password) throws IOException {
		File file = new File ("F:\\\\eclipse\\\\financialManager\\\\src\\\\financialManager\\\\pass.txt");
		
		FileWriter fStream = new FileWriter(file, true);
		PrintWriter out = new PrintWriter(fStream);
		out.println(password);  //pisanje u file
		out.flush();
		out.close();
		fStream.close();
	}
	public static void makingFile (String username) {	//pravljenje pripadne datoteke za podatke
		String path = "F:" + File.separator + "financialManger" + File.separator + username + ".txt";
		try {
		      File file = new File(path);
		      if (file.createNewFile()) {
		        System.out.printf("File created: " + file.getName());
		        System.out.printf(" in " + path);
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
