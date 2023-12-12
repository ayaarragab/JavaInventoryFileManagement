package myPackage;

public class Product{
    int id;
    int numberOfP = 0;
    String name;
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
        numberOfP++;
    }
    public Product(String name) {
        this.id = numberOfP;
        this.name = name;
        numberOfP++;
    }
    public String getName_p() {
        return this.name;
    }
    public int getId_p() {
        return this.id;
    }
}
