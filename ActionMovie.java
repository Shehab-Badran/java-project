package movies;

public class ActionMovie extends MovieCategory {
    private int intensity;

    public ActionMovie(int categoryID, String name, String description, int minAge, int intensity,String movieId) {
        super(categoryID, name, description, minAge,movieId);
        this.intensity = intensity;
    }

    public int checkIntensity() {
        return intensity;
    }

    public void displayAdditionalInformation()
    {
        System.out.println("Get ready for action!");
    }
    @Override
    public String toString() {
        return "Category ID: " + categoryId + ", Name: " + name + ", Description: " + description + ", Minimum Age: "
                + minAge + ", Intensity: " + intensity;
    }

}
