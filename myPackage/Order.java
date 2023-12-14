package myPackage;

public class Order {
    package project;
import project.File;
import project.Management;
import java.util.ArrayList;
import java.util.List;
public class Order {
    private Client client;
    private Product productt;
    private List<String> cart;
    private String invoice_data;
    private static File orderfile;
    private File email;
    private int quantity;
    private static int order_id=1;
    private Management order_manage;
    private Management Product_manage;
    private int p_price;
    public Order(){

    }
    public Order(Client client, int quantity) throws Exception{
        this.client = client;
        this.cart= client.getCart();
        this.orderfile = new File("order.txt");
        this.order_manage =new Management(orderfile);
        this.order_manage.add(this,this.order_id);
        this.quantity = cart.size();
        this.order_id = order_id;
        this.invoice_data = this.generateInvoice();
    }
    public String generateInvoice() throws Exception {
        StringBuffer product_info = new StringBuffer();

        int sum = 0;
        for(int i=0;i<this.quantity;i++) {
            Product product = getProductFromFile(productName);
            sum += p_price;
            String Name= this.Product_manage.retrieve(this.productt.getPId(),"ProdutName");
            String p_price= this.Product_manage.retrieve(this.productt.getPId(),"price");
            String info = "["+ "Name" + ": " + Name + "Price"+ ":" + price + "]" + "\n";
            product_info.append(info);
        }
        return product_info.toString();
    }

    private Product getProductFromFile(String PName) throws Exception {
        File products = new File("products.txt");
        Management productManage = new Management(products);
        Product productM = productManage.getProdutName();
        this.Product_manage.retrieve(this,Product.Id);
        return product;
    }
    /*public void generateInvoice(int price) {

        int sum=0;
        for(int i=0;i<quantity;i++){

        }
        sum=sum+p_price;*/
        /* System.out.println("Generating invoice for " + quantity + " units of " + products.size() + " product(s)");
    */

   /*public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {

        this.products = products;
    }

*/
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
