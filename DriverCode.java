import myPackage.File;
import myPackage.Management;
import myPackage.Product;

public class DriverCode {
    public static void main(String[] args) throws Exception{
        Product appleWatch = new Product("Apple watch");
        Product appleWatch2 = new Product("Apple watch2");
        File productsFile = new File("AppleProducts22.txt");
        Management productManagement = new Management(productsFile);
        productManagement.add(appleWatch, 10);
        productManagement.add(appleWatch2, 20);
        if (productManagement.isExist("Id_p", "0"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
