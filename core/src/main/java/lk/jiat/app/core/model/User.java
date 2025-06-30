package lk.jiat.app.core.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
        //@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email = ?1"),
        @NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email =:email"),
        @NamedQuery(name = "User.findByEmailAndPassword",
                query = "select u from User u where u.email =:email and u.password=:password"),
})
public class User implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.USER;

    public User() {
    }

    public User(String name, String email, String contact, String password) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
