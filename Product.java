
class Product {
    private String productId;
    private String productName;
    private double price;
    private Category category;


    Product(String productId, String productName, double price, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }


    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }


    void displayProductInfo() {
        String catName;

        if (category != null) {
            catName = category.getCategoryName();
        } else {
            catName = "General";
        }
        System.out.println("[" + productId + "] " + productName + " (" + catName + ") - Price: $" + price );
    }
}