

class Admin extends User {
    private String employeeId;

    Admin(String username, String password, String email, String employeeId) {
        super(username, password, email);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    @Override
    void displayProfile() {
        super.displayProfile();
        System.out.println("Role: Administrator");
        System.out.println("Employee ID: " + employeeId);
    }
}