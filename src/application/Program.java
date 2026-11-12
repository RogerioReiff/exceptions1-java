package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		final DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			sc.nextLine();
			LocalDate checkIn = LocalDate.parse(sc.next(), ftm);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			sc.nextLine();
			LocalDate checkOut = LocalDate.parse(sc.next(), ftm);
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			sc.nextLine();
			checkIn = LocalDate.parse(sc.next(), ftm);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			sc.nextLine();
			checkOut = LocalDate.parse(sc.next(), ftm);
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}
}
