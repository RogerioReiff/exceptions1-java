package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		sc.nextLine();
		LocalDate checkIn = LocalDate.parse(sc.next(), ftm);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		sc.nextLine();
		LocalDate checkOut = LocalDate.parse(sc.next(), ftm);
		
		if(!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
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
			
			LocalDate now = LocalDate.now();
			if(checkIn.isBefore(now) || checkOut.isBefore(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(!checkOut.isAfter(checkIn)){
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();
	}
}
