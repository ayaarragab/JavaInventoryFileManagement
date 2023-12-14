import myPackage.File;
import myPackage.Management;
import myPackage.Product;

public class DriverCode {
    public static void main(String[] args) throws Exception{
        // Create a Management object with a file (replace "yourFileName.txt" with the actual file name)
        File file = new File("yourFileName.txt");
        Management management = new Management(file);

        // Create a sample product object for testing
        Product sampleProduct = new Product("testProduct");
        int sampleProductId = 0;  // replace with an actual identifier

       management.remove(0);
            // Test the add method
            // management.add(sampleProduct, sampleProductId);

            // // Test the isExist method based on an identifier
            // boolean existsById = management.isExist(sampleProduct, sampleProductId);
            // System.out.println("Product exists by ID: " + existsById);

            // // Test the isExist method without an identifier
            // boolean existsWithoutId = management.isExist(sampleProduct);
            // System.out.println("Product exists without ID: " + existsWithoutId);

            // // Test the retrieve method based on an identifier
            // String retrievedDataById = management.retrieve(sampleProduct, sampleProductId);
            // System.out.println("Retrieved data by ID:\n" + retrievedDataById);

            // // Test the retrieve method without an identifier
            // String retrievedDataWithoutId = management.retrieve(sampleProduct);
            // System.out.println("Retrieved data without ID:\n" + retrievedDataWithoutId);
    }
}
