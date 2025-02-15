package movies;

public class ComedyMovie extends MovieCategory {
    private int humorLevel;
    public ComedyMovie (int categoryID, String name, String description, int minAge,int humorLevel,String movieId) {
        super(categoryID, name, description, minAge,movieId);
        this.humorLevel = humorLevel;
    }

    public int checkHumorLevel(){
        return humorLevel;
    }
    public void displayAdditionalInformation() {
        System.out.println("Get ready to laugh and have a good time!");
    }
    @Override
    public String toString() {
        return "Category ID: " + categoryId + ", Name: " + name + ", Description: " + description + ", Minimum Age: "
                + minAge + ", Humor Level: " + humorLevel;
    }
}
