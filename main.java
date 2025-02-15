import managing.BookingManager;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int choice=0;
        BookingManager bookingManager = new BookingManager();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Cinema managing.Booking System!");
        while(choice!=5){
            System.out.println("------------------------------------");

            System.out.println("1. Add a movie");
            System.out.println("2. Add a movie screening");
            System.out.println("3. Book ticket");
            System.out.println("4. Display info");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch(choice){
                case 1:
                    bookingManager.addMovie();
                    break;
                case 2:
                    bookingManager.addMovieScreening();
                    break;
                case 3:
                    bookingManager.bookTicket();
                    break;
                case 4:
                    bookingManager.printInfo();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Error enter a valid choice!");
                    break;
            }
        }
    }
}