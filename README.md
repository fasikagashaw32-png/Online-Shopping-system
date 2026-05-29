Online Shopping System MVP

A lightweight, console-based Online Shopping System built in Java to demonstrate core Object-Oriented Programming (OOP) concepts. This system simulates an end-to-end e-commerce flow, including user registration, inventory browsing, shopping cart management, stock tracking, and checkout simulation.

👨‍💻 Developed By
Fasika Gashaw — Student ID: 0058
Kelkias Moges
🚀 Features
User Management: Supports a base User blueprint with specialized subclasses for Customer and Admin users.
Dynamic Inventory: Displays items grouped by categories (Electronics, Clothing) with real-time stock levels.
Interactive Shopping Cart: Customers can add items to a cart while checking stock availability.
Dynamic Total Review: Reviews selected items, calculates total bills, and confirms delivery locations.
Payment & Inventory Management: Simulates payment methods (Cash or Digital Card), updates stock, and generates transaction reference IDs.
🛠️ OOP Concepts Used
Encapsulation

Attributes in core classes (User, Product, Category) are private/protected and accessed through getters and setters.

Inheritance

The User class acts as a parent class extended by Customer and Admin.

Polymorphism

Method overriding (@Override displayProfile()) is used to display customized account details for different users.

📂 Project Structure
File Name	Responsibility
Main.java	Main execution flow, menu system, and application logic
User.java	Parent class containing shared user details
Customer.java	Child class with shipping address functionality
Admin.java	Child class with employee/admin details
Product.java	Product information, stock handling, and pricing
Category.java	Product category management
💻 How to Run
Compile
javac *.java
Run
java Main
🕹️ Sample Execution
=== ONLINE SHOPPING SYSTEM MVP ===

1. Register / Customer Login
2. Browse Store Products
3. Add Product to Cart
4. Review Cart & Checkout
5. Payment Processing
6. Exit
