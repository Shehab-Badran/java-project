package managing;

import managing.Booking;
import movies.ActionMovie;
import movies.ComedyMovie;
import movies.MovieCategory;
import movies.MovieScreening;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingManager {
    private ArrayList<MovieCategory> movies;
    private ArrayList<MovieScreening> movieScreenings;
    private ArrayList<Booking> bookings;

    private Scanner input = new Scanner(System.in).useDelimiter("\n");


    public BookingManager() {
        movies = new ArrayList<MovieCategory>();
        movieScreenings = new ArrayList<MovieScreening>();
        bookings = new ArrayList<Booking>();

    }

    //reads input from user and creates a movie object
    private MovieCategory createMovie() {
        int categoryID;
        System.out.println("Enter the movie category ID (1: comedy - 2: action): ");
        categoryID = input.nextInt();
        while (categoryID != 1 && categoryID != 2) {
            System.out.println("Error enter correct ID (1,2): ");
            categoryID = input.nextInt();
        }
        System.out.println("Enter the movie id: ");
        String movieId = input.next();
        System.out.println("Enter the movie name: ");
        String name = input.next();
        System.out.println("Enter the movie description: ");
        String description = input.next();
        System.out.println("Enter the movie minimum age: ");
        int minAge = input.nextInt();
        if (categoryID == 1) {
            System.out.println("Enter the movie humor level: ");
            int humorLevel = input.nextInt();
            return new ComedyMovie(categoryID, name, description, minAge, humorLevel,movieId);
        } else {
            System.out.println("Enter the movie intensity: ");
            int intensity = input.nextInt();
            return new ActionMovie(categoryID, name, description, minAge, intensity,movieId);
        }
    }

    private Booking enterBookingDetails(int screenId) {
        Booking booking;
        String movieId = movieScreenings.get(screenId - 1).getMovie().getMovieId();

        System.out.println("Enter customer age:");
        int customerAge = input.nextInt();
        if (customerAge < getMovieById(movieId).getMinaAge()) {
            System.out.println("Customer age is too young for this movie");
            return null;
        }

        System.out.println("Enter amount of tickets:");
        int numberOfTickets = input.nextInt();
        if (!movieScreenings.get(screenId - 1).reserveSeat(numberOfTickets)) {
            System.out.println("sorry this screening is already full!");
            return null;
        }

        System.out.println("Enter customer name:");
        String customerName = input.next();

        booking = new Booking(movieId, customerName, customerAge, numberOfTickets);
        return booking;
    }

    //prints the arrays
    private void printMovies() {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". Movie Id: " +movies.get(i).getMovieId() +
                    " - Movie Name: "+movies.get(i).getName());
        }
    }

    private void printMovieScreenings() {
        for (int i = 0; i < movieScreenings.size(); i++) {
            System.out.println((i + 1) + ". " + movieScreenings.get(i).toString());
        }
    }

    private MovieScreening createMovieScreening() {
        printMovies();
        System.out.println("Enter the movie Id: ");
        String movieId = input.next();
        MovieCategory movie = getMovieById(movieId);
        while (movie == null) {
            System.out.println("Error choose an existing movie! ");
            movieId = input.next();
            movie = getMovieById(movieId);
        }
        System.out.println("Enter the number of seats: ");
        int seats = input.nextInt();
        System.out.println("Enter the screen ID: ");
        int screenId = input.nextInt();
        System.out.println("Enter the time slot: ");
        String timeSlot = input.next();
        return new MovieScreening(seats, screenId, timeSlot, movie);
    }

    private void printMovieSpecifics(String movieId) {
        MovieCategory movie = getMovieById(movieId);
        if (movie != null){
            System.out.println(movie);
            movie.displayAdditionalInformation();
        } else {
            System.out.println("Invalid movie Id.");
        }
    }

    //public functionalities
    public void addMovie() {
        movies.add(createMovie());
    }

    public void addMovieScreening() {
        movieScreenings.add(createMovieScreening());
    }

    public void addBooking(int screenId) {
        Booking booking = enterBookingDetails(screenId);
        if (booking != null) {
            bookings.add(booking);
            MovieCategory movie = getMovieById(booking.getMoveId());
            System.out.println("Tickets booked successfully for " +booking.getCustomerName() + " Movie: "
                    +movie.getName() + " Category: "+getCategoryName(movie.getCategoryId()));
        } else {
            System.out.println("managing.Booking failed.");
        }
    }

    private String getCategoryName(int categoryId){

        if (categoryId == 1){
            return "Comedy";
        } else if (categoryId == 2){
            return "Action";
        } else {
            return "Invalid category number";
        }
    }

    public void bookTicket() {
        printMovieScreenings();
        System.out.println("Enter the movie screening number: ");
        int movieScreeningNumber = input.nextInt();
        while (movieScreeningNumber < 1 || movieScreeningNumber > movieScreenings.size()) {
            System.out.println("Error choose an existing movie Screening! ");
            movieScreeningNumber = input.nextInt();
        }
        addBooking(movieScreeningNumber);
    }

    public void printInfo() {
        System.out.println("Which do you want to print? (1 movies, 2 movie screenings)");
        int choice = input.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Error enter correct choice (1,2): ");
            choice = input.nextInt();
        }
        if (choice == 1) {
            printMovies();
            System.out.println("Enter the movie Id for details: ");
            String movieId = input.next();
            printMovieSpecifics(movieId);
        } else {
            printMovieScreenings();
        }
    }

    private MovieCategory getMovieById(String movieId){
        for (int i=0; i<movies.size(); i++){
            MovieCategory movie = movies.get(i);
            if (movie.getMovieId().equals(movieId)){
                return movie;
            }
        } return null;
    }


}
