package br.com.fiap.entities;

public class Pacote {

    private int id;
    private String name;
    private String destination;
    private String description;
    private double price;
    private String duration;
    private int availableSeats;
    private String imageUrl;

    public Pacote() {
        super();
    }

    public Pacote(int id, String name, String destination, String description,
                  double price, String duration, int availableSeats, String imageUrl) {
        super();
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.availableSeats = availableSeats;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", duration='" + duration + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
