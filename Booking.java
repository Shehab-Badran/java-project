package managing;

public class Booking {
    private String moveId;
    private String customerName;
    private int customerAge;
    private int numberOfTickets;

    public Booking(String moveId, String customerName, int customerAge, int numberOfTickets){
        this.moveId = moveId;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.numberOfTickets = numberOfTickets;
    }

    public String getMoveId() {
        return moveId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    @Override
    public String toString() {
        return "managing.Booking{" +
                "moveId=" + moveId +
                ", customerName='" + customerName + '\'' +
                ", customerAge=" + customerAge +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }
}
