package nl.novi.sowtheland.Model;

import jakarta.persistence.*;

@Entity
@Table (name = "Users")
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    private String email;
    @OneToOne
    private Garden garden;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
}
