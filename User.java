
class User {
    private String username;
    private String password;
    private String email;

    // Parent Constructor
    User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Accessor / Mutator blocks for Encapsulation compliance
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Base Profile Print routine
    void displayProfile() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
    }
}