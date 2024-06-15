package nl.hu.bep.setup.domein;

public class UserDetails {
    private String username;
    private String email;
    // Add other user details fields as needed

    // Constructors
    public UserDetails() {
        // Default constructor
    }

    public UserDetails(String username, String email) {
        this.username = username;
        this.email = email;
        // Initialize other fields if needed
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Add getters and setters for other fields if necessary

    // Optional: Override toString() method for debugging purposes
    @Override
    public String toString() {
        return "UserDetails{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
