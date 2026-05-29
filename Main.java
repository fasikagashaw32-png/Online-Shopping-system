
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Category electronics = new Category("Electronics");
        Category clothing = new Category("Clothing");

        Product[] products = new Product[3];
        products[0] = new Product("P101", "Smartphone", 699.99, 10, electronics);
        products[1] = new Product("P102", "Winter Jacket", 89.50, 15, clothing);
        products[2] = new Product("P103", "Wireless Headphones", 149.99, 5, electronics);

        Customer loggedUser = null;
        Product[] cart = new Product[10];
        int cartCount = 0;

        boolean keepRunning = true;
        System.out.println("=== ONLINE SHOPPING SYSTEM MVP (STUDENT 1 COMPILING MODE) ===");

        while (keepRunning) {
            System.out.println("\nSelect Operational Step:");
            System.out.println("1. Register / Customer Login");
            System.out.println("2. Browse Store Products");
            System.out.println("3. Add Choice Product to Cart");
            System.out.println("4. Checkout & Review Cart Items");
            System.out.println("5. Confirm Payment and Process Order");
            System.out.println("6. Close Application");
            System.out.print("Enter choice option (1-6): ");

            int option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                System.out.println("\n--- Step 1: User Registration ---");
                System.out.print("Enter username: ");
                String u = sc.nextLine();
                System.out.print("Enter password: ");
                String p = sc.nextLine();
                System.out.print("Enter email address: ");
                String e = sc.nextLine();
                System.out.print("Enter delivery address: ");
                String addr = sc.nextLine();

                loggedUser = new Customer(u, p, e, addr);
                System.out.println("\n[Success] Registration Saved! Account details:");
                loggedUser.displayProfile();

            } else if (option == 2) {
                System.out.println("\n--- Step 2: Browsing Inventory ---");
                for (int i = 0; i < products.length; i++) {
                    products[i].displayProductInfo();
                }

            } else if (option == 3) {
                System.out.println("\n--- Step 3: Select Item to Cart ---");
                if (loggedUser == null) {
                    System.out.println("Operation blocked. Please login profile first using step 1.");
                } else {
                    for (int i = 0; i < products.length; i++) {
                        System.out.print((i + 1) + ". ");
                        products[i].displayProductInfo();
                    }
                    System.out.print("Enter number to select item: ");
                    int productSelection = sc.nextInt() - 1;
                    sc.nextLine();

                    if (productSelection >= 0 && productSelection < products.length) {
                        Product chosen = products[productSelection];
                        if (chosen.getStock() > 0) {
                            cart[cartCount] = chosen;
                            cartCount++;
                            System.out.println("Success. " + chosen.getProductName() + " added inside cart.");
                        } else {
                            System.out.println("Selection error. Item out of stock.");
                        }
                    } else {
                        System.out.println("Validation failed. Index integer out of bounds.");
                    }
                }

            } else if (option == 4) {
                System.out.println("\n--- Step 4: Cart Checkout & Review ---");
                if (loggedUser == null || cartCount == 0) {
                    System.out.println("Review error. Either session empty or cart holds no elements.");
                } else {
                    System.out.println("Reviewing selections for user: " + loggedUser.getUsername());
                    double sumTotal = 0;
                    for (int i = 0; i < cartCount; i++) {
                        System.out.println("- " + cart[i].getProductName() + " | Cost: $" + cart[i].getPrice());
                        sumTotal = sumTotal + cart[i].getPrice();
                    }
                    System.out.println("Calculated Total bill price: $" + sumTotal);
                    System.out.println("Target Delivery location: " + loggedUser.getShippingAddress());
                }

            } else if (option == 5) {
                System.out.println("\n--- Step 5 & 6: Payment Selection & Execution ---");
                if (loggedUser == null || cartCount == 0) {
                    System.out.println("Payment block. Ensure user is logged in with active items.");
                } else {
                    double grandAmount = 0;
                    for (int i = 0; i < cartCount; i++) {
                        grandAmount = grandAmount + cart[i].getPrice();
                    }

                    System.out.println("Choose processing payment selection method:");
                    System.out.println("1. Hand-to-Hand Cash payment processing");
                    System.out.println("2. Digital Card verification transaction");
                    System.out.print("Choice index input: ");
                    int choicePay = sc.nextInt();
                    sc.nextLine();

                    if (choicePay == 1) {
                        System.out.println("Receipt: Cash collection processed. Value: $" + grandAmount);
                    } else if (choicePay == 2) {
                        System.out.print("Type card number: ");
                        String cardCode = sc.nextLine();
                        System.out.println("Receipt: Authorization accepted for card " + cardCode + ". Charged: $" + grandAmount);
                    } else {
                        System.out.println("Option sequence broken. Transaction payment aborted.");
                        continue;
                    }


                    for (int i = 0; i < cartCount; i++) {
                        cart[i].setStock(cart[i].getStock() - 1);
                    }

                    System.out.println("\nSUCCESS: Reference ID code confirmed: ORD-" + (int)(Math.random() * 9000 + 1000));
                    System.out.println("Thank you for shopping with us, " + loggedUser.getUsername() + "!");

                    cartCount = 0;
                }

            } else if (option == 6) {
                System.out.println("Exiting application workspace. Goodbye!");
                keepRunning = false;
            } else {
                System.out.println("Unrecognized input indexing. Choose numbers 1 up to 6.");
            }
        }
        sc.close();
    }
}