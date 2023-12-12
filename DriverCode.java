import myPackage.File;
import myPackage.Management;
import myPackage.Product;

public class DriverCode {
    public static void main(String[] args) throws Exception{
        Product appleWatch = new Product("Apple watch", 13000, "Karen");
        Product appleWatch2 = new Product("Apple watch2", 15000, "Carol");
        File productsFile = new File("AppleProducts22.txt");
        Management productManagement = new Management(productsFile);
        productManagement.add(appleWatch, 10);
        productManagement.add(appleWatch2, 20);
        // productManagement.remove(productsFile, appleWatch, 10);
        // productManagement.delete();
    }
}
