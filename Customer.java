
class Customer extends User {
    private String shippingAddress;

    Customer(String username, String password, String email, String shippingAddress) {

        super(username, password, email);
        this.shippingAddress = shippingAddress;
    }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }


    @Override
    void displayProfile() {
        super.displayProfile();
        System.out.println("Role: Customer");
        System.out.println("Shipping Address: " + shippingAddress);
    }
}