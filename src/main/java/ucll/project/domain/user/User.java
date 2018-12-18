package ucll.project.domain.user;

import ucll.project.db.DatabaseEntity;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class User extends DatabaseEntity<Integer> {
    private int userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;

    // hashed password
    private transient String hashedPassword;

    public User(Integer primaryKey) {
        super(primaryKey);
    }

    public User(Integer primaryKey, String userName, String firstName, String lastName, String email, Gender gender){
        super(primaryKey);
        setUserName(userName);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setGender(gender);
    }

    public void hashAndSetPassword(String password) {
        if (password.length() < 4) {
            throw new IllegalArgumentException("Too short password!");
        }
        String hashed = getPasswordToHashedPassword(password);
        setHashedPassword(hashed);
    }

    // This function will hash the password
    protected String getPasswordToHashedPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
        digest.update(password.getBytes(StandardCharsets.UTF_8));
        String hash = DatatypeConverter.printHexBinary(digest.digest()).toUpperCase();
        return hash;
    }

    public boolean isValidPassword(String password) {
        if (getHashedPassword() == null) {
            return false;
        }
        return getPasswordToHashedPassword(password).equals(getHashedPassword());
    }

    // Getters and setters and toString
    public int getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String toString() {
        return "User(userId=" + this.getUserId() + ", userName=" + this.getUserName() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", gender=" + this.getGender() + ", hashedPassword=" + this.getHashedPassword() + ")";
    }
}
