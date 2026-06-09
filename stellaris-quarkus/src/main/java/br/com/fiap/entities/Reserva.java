package br.com.fiap.entities;

public class Reserva {

    private int id;
    private int packageId;
    private String passengerName;
    private String email;
    private int numberOfPeople;
    private String travelDate;
    private String status;

    public Reserva() {
        super();
    }

    public Reserva(int id, int packageId, String passengerName, String email,
                   int numberOfPeople, String travelDate, String status) {
        super();
        this.id = id;
        this.packageId = packageId;
        this.passengerName = passengerName;
        this.email = email;
        this.numberOfPeople = numberOfPeople;
        this.travelDate = travelDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", packageId=" + packageId +
                ", passengerName='" + passengerName + '\'' +
                ", email='" + email + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", travelDate='" + travelDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
