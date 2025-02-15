package movies;

public class MovieCategory {

    protected int categoryId;
    protected String name;
    protected String description;
    protected int minAge;
    protected String movieId;


    public MovieCategory(int categoryId, String name, String description, int minAge, String movieId) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.minAge = minAge;
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getMinaAge() {
        return minAge;
    }

    public String getMovieId() { return movieId; }

    public void displayAdditionalInformation() {
        System.out.println("no additional information available for this movie category");
    }
}


