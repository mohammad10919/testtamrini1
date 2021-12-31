package ir.mohammad.testtamrini.model;

public class Pishnahad {
    String price;
    String place;
    String imagepishnahad;

    public Pishnahad(String price, String place, String imagepishnahad) {
        this.price = price;
        this.place = place;
        this.imagepishnahad = imagepishnahad;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getImagepishnahad() {
        return imagepishnahad;
    }

    public void setImagepishnahad(String imagepishnahad) {
        this.imagepishnahad = imagepishnahad;
    }
}
