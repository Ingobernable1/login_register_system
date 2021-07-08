package pl.ingobernable.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserSnapshot implements Serializable {

    @Id
    @Column(name = "email", unique = true)
    private final String email;

    @Column(name = "password", nullable = false)
    private final String password;

    public UserSnapshot(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}