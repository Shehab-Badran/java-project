package movies;

import movies.MovieCategory;

import java.util.Scanner;

public class MovieScreening {

    private int availableSeats;
    private int reservedSeats;
    private int screenId;
    private String timeSlot;
    private MovieCategory movie; //this is the movie that will be screened

    public MovieScreening(int seats, int screenId, String timeSlot, MovieCategory movie) {
        this.availableSeats = seats;
        this.screenId = screenId;
        this.timeSlot = timeSlot;
        this.movie = movie;
    }

    public boolean reserveSeat(int numOfSeats) {
        if (availableSeats > numOfSeats) {
            availableSeats = availableSeats - numOfSeats;
            reservedSeats = reservedSeats + numOfSeats;
            return true;
        } else {
            System.out.println("No available seats - Available Seats: " + availableSeats);
            return false;
        }
    }

    public MovieCategory getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "Available Seats: " + availableSeats + ", Reserved Seats: " + reservedSeats +
                ", Screen ID: " + screenId + ", Time Slot: " + timeSlot + ", Movie ID: " + movie.getMovieId() + " Movie: " + movie.getName();
    }

}
