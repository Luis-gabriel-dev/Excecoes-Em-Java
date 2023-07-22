package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation rvt = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + rvt);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			
			rvt.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + rvt);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException de) {
			System.out.println("Error in reservation: " + de.getMessage());
		}
		catch(RuntimeException re) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}
}